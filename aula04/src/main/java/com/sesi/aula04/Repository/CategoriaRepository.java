package com.sesi.aula04.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.aula04.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long>{

}
