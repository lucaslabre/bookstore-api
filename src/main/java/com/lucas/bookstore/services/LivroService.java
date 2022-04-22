package com.lucas.bookstore.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositories.LivroRepository;
import com.lucas.bookstore.services.exception.ObjectNotFoundException;

@Service
public class LivroService {
	
	@Autowired
	private LivroRepository livroRepository;
	@Autowired
	private CategoriaService categoriaService;
	
	public Livro findById(Integer id) {
		Optional<Livro> obj = livroRepository.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado! ID: "+id+", Tipo: "+Livro.class.getName()));
	}
	
	public List<Livro> findAll(Integer id) {
		categoriaService.findById(id);
		return livroRepository.findAllByCategoria(id);
	}

}
