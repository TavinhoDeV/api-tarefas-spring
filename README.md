# 06 · API REST de Tarefas com Spring Boot  

**Conceitos:** Spring Boot, camadas (Controller → Service → Repository), JPA/Hibernate, DTOs com `record`, Bean Validation, tratamento global de erros (`ProblemDetail`), testes com `MockMvc`.
**Tempo estimado:** 12–20 h

## Passo a passo
1. Gere o projeto (ou use este `pom.xml`): Web, Data JPA, Validation, H2.
2. `Tarefa` (`@Entity`) + `Status` (`enum`).
3. `TarefaRepository extends JpaRepository` — o Spring implementa tudo para você.
4. DTOs `TarefaRequest` (com `@NotBlank`) e `TarefaResponse`: **nunca exponha a entidade na API**.
5. `TarefaService`: regras de negócio e transações.
6. `TarefaController`: `GET/POST/PUT/DELETE` em `/api/tarefas` com códigos HTTP corretos (201, 204, 404, 400).
7. `ApiExceptionHandler`: converte exceções em respostas JSON padronizadas.
8. Testes de integração (`TarefaControllerTest`).
9. Documente com **Swagger/OpenAPI** (`springdoc-openapi-starter-webmvc-ui`).

## Como rodar
```bash
mvn spring-boot:run        # API em http://localhost:8080/api/tarefas
mvn test
```
Exemplo:
```bash
curl -X POST localhost:8080/api/tarefas -H "Content-Type: application/json" \
     -d '{"titulo":"Estudar Spring","descricao":"Capítulo 1"}'
```

## Desafios extras
- Paginação e ordenação (`Pageable`).
- Trocar H2 por PostgreSQL + Flyway para migrations.
- Usuários e tarefas por usuário (relacionamento `@ManyToOne`).
- Dockerfile + GitHub Actions rodando `mvn test`.
