package com.lucas.bookstore.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lucas.bookstore.domain.Categoria;
import com.lucas.bookstore.domain.Livro;
import com.lucas.bookstore.repositories.CategoriaRepository;
import com.lucas.bookstore.repositories.LivroRepository;

@Service
public class DBService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private LivroRepository livroRepository;

	public void instanciaBaseDados() {
		Categoria cat1 = new Categoria(null, "Informática", "Livro de TI");
		Categoria cat2 = new Categoria(null, "Ficção Científica", "Ficção teste");
		Categoria cat3 = new Categoria(null, "Biografias", "Livros de biografias");
		
		Livro l1 = new Livro(null, "Clean code", "Robert Martin", "Loren Ipsum", cat1);
		Livro l2 = new Livro(null, "Engenharia de Software", "Louis", "Loren Ipsum", cat1);
		Livro l3 = new Livro(null, "The time machine", "Wells", "Loren Ipsum", cat2);
		Livro l4 = new Livro(null, "The war of the world", "Wells", "Loren Ipsum", cat2);
		Livro l5 = new Livro(null, "I, Robot", "Isaac Asimov", "Loren Ipsum", cat2);
		
		
		cat1.getLivros().addAll(Arrays.asList(l1,l2));
		cat2.getLivros().addAll(Arrays.asList(l3,l4,l5));
		
		this.categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		this.livroRepository.saveAll(Arrays.asList(l1, l2, l3, l4, l5));
		
	}
	
}
