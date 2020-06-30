package com.fcfm.ProyectoJavaBack.controller;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.fcfm.ProyectoJavaBack.DTO.Mensaje;
import com.fcfm.ProyectoJavaBack.entity.Materia;
import com.fcfm.ProyectoJavaBack.service.MateriaService;

import java.util.List;

@RestController
@RequestMapping("/api/materia")
public class MateriaController {
	@Autowired
	MateriaService materiaService;
	
	@GetMapping("/lista")
    public ResponseEntity<List<Materia>> getLista(){
        List<Materia> lista = materiaService.obtenerTodos();
        return new ResponseEntity<List<Materia>>(lista, HttpStatus.OK);
    }
	
	@GetMapping("/detalle/{id}")
    public ResponseEntity<Materia> getOne(@PathVariable Long id){
        if(!materiaService.existePorId(id))
            return new ResponseEntity(new Mensaje("no existe ese producto"), HttpStatus.NOT_FOUND);
        Materia materia = materiaService.obtenerPorId(id).get();
        return new ResponseEntity<Materia>(materia, HttpStatus.OK);
    }
	@PostMapping("nuevo")
    public ResponseEntity<?> create(@RequestBody Materia materia){
		if(StringUtils.isBlank(materia.getNombreMateria()))
			return new ResponseEntity(new Mensaje("el nombre de la materia es obligatorio"), HttpStatus.BAD_REQUEST);
		if((Integer)materia.getClave() == null || materia.getClave()==0)
			return new ResponseEntity(new Mensaje("La clave de la materia es obligatoria"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(materia.getEstatus()))
			return new ResponseEntity(new Mensaje("el estatus es obligatorio"), HttpStatus.BAD_REQUEST);
		if(materiaService.existePorNombre(materia.getNombreMateria()))
            return new ResponseEntity(new Mensaje("La materia ya existe"), HttpStatus.BAD_REQUEST);
		if(materiaService.existePorClave(materia.getClave()))
			return new ResponseEntity(new Mensaje("La clave ya esta en uso"), HttpStatus.BAD_REQUEST);
		materiaService.guardar(materia);
		return new ResponseEntity(new Mensaje("Materia creada"), HttpStatus.CREATED);
	}
	@PutMapping("/actualizar/{id}")
    public ResponseEntity<?> update(@RequestBody Materia materia, @PathVariable("id") Long id){
		if(StringUtils.isBlank(materia.getNombreMateria()))
			return new ResponseEntity(new Mensaje("el nombre de la materia es obligatorio"), HttpStatus.BAD_REQUEST);
		if((Integer)materia.getClave() == null || materia.getClave()==0)
			return new ResponseEntity(new Mensaje("La clave de la materia es obligatoria"), HttpStatus.BAD_REQUEST);
		if(StringUtils.isBlank(materia.getEstatus()))
			return new ResponseEntity(new Mensaje("el estatus es obligatorio"), HttpStatus.BAD_REQUEST);
		if(materiaService.existePorNombre(materia.getNombreMateria()))
            return new ResponseEntity(new Mensaje("La materia ya existe"), HttpStatus.BAD_REQUEST);
		 Materia materiaUpdate = materiaService.obtenerPorId(id).get();
		 materiaUpdate.setNombreMateria(materia.getNombreMateria());
		 materiaUpdate.setClave(materia.getClave());
		 materiaUpdate.setEstatus(materia.getEstatus());
		 materiaService.guardar(materiaUpdate);
	     return new ResponseEntity(new Mensaje("materia actualizada"), HttpStatus.CREATED);
	}
	@DeleteMapping("/borrar/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
		if(!materiaService.existePorId(id))
			return new ResponseEntity(new Mensaje("no existe esa materia"), HttpStatus.NOT_FOUND);
		materiaService.borrar(id);
		return new ResponseEntity(new Mensaje("Materia eliminada"), HttpStatus.OK);
	}

}
