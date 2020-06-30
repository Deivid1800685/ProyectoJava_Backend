package com.fcfm.ProyectoJavaBack.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fcfm.ProyectoJavaBack.entity.Materia;
import com.fcfm.ProyectoJavaBack.repository.MateriaRepository;

@Service
@Transactional
public class MateriaService {
	@Autowired
	MateriaRepository materiaRepository;
	
	public List<Materia> obtenerTodos(){
        List<Materia> lista = materiaRepository.findAll();
        return lista;
    }

    public Optional<Materia> obtenerPorId(Long id){
        return materiaRepository.findById(id);
    }

    public Optional<Materia> obtenerPorNombre(String nm){
        return materiaRepository.findByNombreMateria(nm);
    }

    public void guardar(Materia materia){
        materiaRepository.save(materia);
    }

    public void borrar(Long id){
        materiaRepository.deleteById(id);
    }

    public boolean existePorNombre(String nm){
        return materiaRepository.existsByNombreMateria(nm);
    }
    public boolean existePorClave(int clv) {
    	return materiaRepository.existsByClave(clv);
    }

    public boolean existePorId(Long id){
        return materiaRepository.existsById(id);
    }
}
