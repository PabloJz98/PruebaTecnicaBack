package com.ejercicio.prueba_back_end.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ejercicio.prueba_back_end.entity.EMPLOYEENTITY;

@Repository
public interface EMPLOYESSDAO extends JpaRepository<EMPLOYEENTITY,Integer>{
	public EMPLOYEENTITY findByNombreAndApellido(String nombre,String apellido);
	public List<EMPLOYEENTITY> findByJobId(int jobId);
}
