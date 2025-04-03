/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ProjetoDindin.controller;

import com.api.ProjetoDindin.model.dindin;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author rebec
 */

@Controller
public class MiscController {
    private List<dindin> dindins = new ArrayList();

    public MiscController() {
        dindins.add(new dindin("uva",1,10));
        dindins.add(new dindin("morango",1,10));
        
    }
    
    
    
    @GetMapping("/index")
    public String mostraPaginaInicial(){
        return "index";
    }
    @GetMapping("/encomenda")
    public String mostraEncomenda(Model model){
        
        model.addAttribute("dindins", dindins);
        
        return "encomenda";
    }
    
}
