/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ProjetoDindin.controller;

import com.api.ProjetoDindin.model.Dindin;
import com.api.ProjetoDindin.model.Venda;
import com.api.ProjetoDindin.repository.DindinRepository;
import com.api.ProjetoDindin.repository.VendaRepository;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rebec
 */

@RestController
@RequestMapping("/api")
public class ApiController {

    @Autowired
    private DindinRepository dindinRepo;

    @Autowired
    private VendaRepository vendaRepo;

    @GetMapping("/dindins")
    public List<Dindin> getDindins() {
        return dindinRepo.findAll();
    }

    @PostMapping("/dindin")
public Dindin cadastrarDindin(@RequestBody Dindin d) {
    Dindin existente = dindinRepo.findBySabor(d.getSabor());
    if (existente != null) {
        existente.setEstoque(existente.getEstoque() + d.getEstoque());
        return dindinRepo.save(existente);
    }
    d.setSabor(d.getSabor().trim().toLowerCase());

    return dindinRepo.save(d);
}


    @PostMapping("/venda")
    public Venda registrarVenda(@RequestBody Map<String, Object> payload) {
        String cliente = (String) payload.get("cliente");
        Map<String, Integer> carrinho = (Map<String, Integer>) payload.get("carrinho");
        int total = carrinho.values().stream().mapToInt(i -> i).sum();
        double valor = total;

        carrinho.forEach((sabor, qtd) -> {
            Dindin d = dindinRepo.findBySabor(sabor);
            d.setEstoque(d.getEstoque() - qtd);
            dindinRepo.save(d);
        });

        Venda venda = new Venda();
        venda.setCliente(cliente);
        venda.setQuantidade(total);
        venda.setValor(valor);
        venda.setData(LocalDateTime.now());
        return vendaRepo.save(venda);
    }

    @GetMapping("/vendas")
    public List<Venda> listarVendas() {
        return vendaRepo.findAll();
    }
}


