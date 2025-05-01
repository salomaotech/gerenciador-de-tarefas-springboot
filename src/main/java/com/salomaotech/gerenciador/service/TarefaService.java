package com.salomaotech.gerenciador.service;

import com.salomaotech.gerenciador.model.TarefaModel;
import com.salomaotech.gerenciador.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TarefaService {

    @Autowired
    private TarefaRepository tarefaRepository;

    public ResponseEntity<TarefaModel> save(TarefaModel tarefaModel) {

        return ResponseEntity.status(HttpStatus.CREATED).body(tarefaRepository.save(tarefaModel));

    }

    public ResponseEntity<List<TarefaModel>> getAll() {

        return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.findAll());

    }

    public ResponseEntity<Object> getById(UUID id) {

        Optional<TarefaModel> tarefaModel = tarefaRepository.findById(id);

        if (tarefaModel.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado :-(");

        } else {

            return ResponseEntity.status(HttpStatus.OK).body(tarefaModel.get());

        }

    }

    public ResponseEntity<Object> delete(UUID id) {

        Optional<TarefaModel> tarefaModel = tarefaRepository.findById(id);

        if (tarefaModel.isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado :-(");

        } else {

            return ResponseEntity.status(HttpStatus.OK).body("Removido!");

        }

    }

    public ResponseEntity<Object> update(UUID id, TarefaModel tarefaModel) {

        if (tarefaRepository.findById(id).isEmpty()) {

            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não encontrado :-(");

        } else {

            return ResponseEntity.status(HttpStatus.OK).body(tarefaRepository.save(tarefaModel));

        }

    }

}
