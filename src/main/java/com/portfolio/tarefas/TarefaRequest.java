package com.portfolio.tarefas;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record TarefaRequest(
        @NotBlank(message = "o título é obrigatório") @Size(max = 120) String titulo,
        @Size(max = 500) String descricao,
        Status status) {
}
