package br.com.qualquercois1.backend.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;


@Entity
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String senha;

    @OneToMany(mappedBy = "usuario")
    private List<Tarefa> tarefas = new ArrayList<>();

    public Usuario(Long id, String nome, String email, String senha) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void addTarefa(Tarefa tarefa) {
        this.tarefas.add(tarefa);
        tarefa.setUsuario(this);
    }

    public void removeTarefa(Tarefa tarefa) {
        this.tarefas.remove(tarefa);
        tarefa.setUsuario(null);
    }

    public List<Tarefa> getTarefas() {
        return tarefas;
    }

    
}
