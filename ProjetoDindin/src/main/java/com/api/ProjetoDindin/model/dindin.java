/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.api.ProjetoDindin.model;

/**
 *
 * @author rebec
 */
public class dindin {
    private String sabor_nome;
    private double valor_unitario;
    private int quantidade_estoque;
    
    public dindin(){
        
    }

    public dindin(String sabor_nome, double valor_unitario, int quantidade_estoque) {
        this.sabor_nome = sabor_nome;
        this.valor_unitario = valor_unitario;
        this.quantidade_estoque = quantidade_estoque;
    }

    public String getSabor_nome() {
        return sabor_nome;
    }

    public void setSabor_nome(String sabor_nome) {
        this.sabor_nome = sabor_nome;
    }

    public double getValor_unitario() {
        return valor_unitario;
    }

    public void setValor_unitario(double valor_unitario) {
        this.valor_unitario = valor_unitario;
    }

    public int getQuantidade_estoque() {
        return quantidade_estoque;
    }

    public void setQuantidade_estoque(int quantidade_estoque) {
        this.quantidade_estoque = quantidade_estoque;
    }
    
}
