package com.sesi.aula04.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @ManyToOne
    private Usuario usuario; // Relacionamento com a entidade Usuario

    // Construtor padrão
    public Tarefa() {
        // Construtor vazio
    }

    // Construtor com parâmetros
    public Tarefa(Long id, String descricao, Usuario usuario) {
        this.id = id;
        this.descricao = descricao;
        this.usuario = usuario;
    }

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    // Método toString para facilitar a visualização da tarefa
    @Override
    public String toString() {
        return "Tarefa{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", usuario=" + (usuario != null ? usuario.getId() : "null") +
                '}';
    }

    // Implementação de equals e hashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Tarefa)) return false;
        Tarefa tarefa = (Tarefa) o;
        return id != null && id.equals(tarefa.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
