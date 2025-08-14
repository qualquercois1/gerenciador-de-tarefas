package br.com.qualquercois1.backend.repository;

import br.com.qualquercois1.backend.model.Tarefa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa,Long> {
    List<Tarefa> findByTituloContainingIgnoreCaseAndUsuarioId(String titulo, Long usuarioId);
}
