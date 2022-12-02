package com.ejercicio.prueba_back_end.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.prueba_back_end.entity.GENDERENTITY;

@Repository
public interface GENDERSDAO extends JpaRepository<GENDERENTITY,Integer>{

}