package br.unigran.trabalho.model;

import androidx.annotation.NonNull;

public class Dados {
    private  Integer id;
    private String titulo;
    private String descricao;
    private String ctarefa;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCtarefa() {
        return ctarefa;
    }

    public void setCtarefa(String ctarefa) {
        this.ctarefa = ctarefa;
    }

    @NonNull
    @Override
    public String toString() {
        return titulo + " " + descricao;
    }
}
