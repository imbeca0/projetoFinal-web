/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.api.ProjetoDindin.repository;

import com.api.ProjetoDindin.model.Dindin;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author rebec
 */
public interface DindinRepository extends JpaRepository<Dindin, Long> {
    

    Dindin findBySabor(String sabor);
}
