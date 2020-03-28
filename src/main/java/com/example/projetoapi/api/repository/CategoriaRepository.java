package com.example.projetoapi.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.projetoapi.api.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
