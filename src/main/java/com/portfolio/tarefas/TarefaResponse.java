package com.portfolio.tarefas;

import java.time.LocalDateTime;

public record TarefaResponse(Long id, String titulo, String descricao, Status status, LocalDateTime criadaEm) {

    public static TarefaResponse de(Tarefa t) {
        return new TarefaResponse(t.getId(), t.getTitulo(), t.getDescricao(), t.getStatus(), t.getCriadaEm());
    }
}
