package com.ejercicio.prueba_back_end.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.prueba_back_end.entity.JOBENTITY;

@Repository
public interface JOBSDAO extends JpaRepository<JOBENTITY,Integer> {
	
}