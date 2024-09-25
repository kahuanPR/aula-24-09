package com.sesi.aula04.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sesi.aula04.model.Tarefa;
import com.sesi.aula04.model.Usuario;

public interface TarefaRepository extends JpaRepository<Usuario, Long>{

	void save(Tarefa tarefa);
}

