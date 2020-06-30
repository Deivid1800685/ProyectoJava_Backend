package com.fcfm.ProyectoJavaBack.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fcfm.ProyectoJavaBack.entity.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long> {
	Optional<Materia> findByNombreMateria(String nm);
	boolean existsByNombreMateria(String nm);
	boolean existsByClave(int clv);
}
