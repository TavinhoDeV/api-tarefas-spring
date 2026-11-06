package com.portfolio.tarefas;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Tarefa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 120)
    private String titulo;

    @Column(length = 500)
    private String descricao;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Status status = Status.PENDENTE;

    @Column(nullable = false, updatable = false)
    private LocalDateTime criadaEm = LocalDateTime.now();

    protected Tarefa() {} // exigido pelo JPA

    public Tarefa(String titulo, String descricao, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        if (status != null) this.status = status;
    }

    public void atualizar(String titulo, String descricao, Status status) {
        this.titulo = titulo;
        this.descricao = descricao;
        if (status != null) this.status = status;
    }

    public Long getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public Status getStatus() { return status; }
    public LocalDateTime getCriadaEm() { return criadaEm; }
}
