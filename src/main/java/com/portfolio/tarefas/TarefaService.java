package com.portfolio.tarefas;

import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class TarefaService {

    private final TarefaRepository repository;

    public TarefaService(TarefaRepository repository) {
        this.repository = repository;
    }

    @Transactional(readOnly = true)
    public List<TarefaResponse> listar(Status status) {
        List<Tarefa> tarefas = status == null ? repository.findAll() : repository.findByStatus(status);
        return tarefas.stream().map(TarefaResponse::de).toList();
    }

    @Transactional(readOnly = true)
    public TarefaResponse buscar(Long id) {
        return TarefaResponse.de(obter(id));
    }

    public TarefaResponse criar(TarefaRequest req) {
        return TarefaResponse.de(repository.save(new Tarefa(req.titulo(), req.descricao(), req.status())));
    }

    public TarefaResponse atualizar(Long id, TarefaRequest req) {
        Tarefa tarefa = obter(id);
        tarefa.atualizar(req.titulo(), req.descricao(), req.status());
        return TarefaResponse.de(tarefa);
    }

    public void remover(Long id) {
        repository.delete(obter(id));
    }

    private Tarefa obter(Long id) {
        return repository.findById(id).orElseThrow(() -> new TarefaNaoEncontradaException(id));
    }
}
