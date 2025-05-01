package com.salomaotech.gerenciador.controller;

import com.salomaotech.gerenciador.model.TarefaModel;
import com.salomaotech.gerenciador.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public ResponseEntity<TarefaModel> add(@RequestBody TarefaModel tarefaModel) {

        return tarefaService.save(tarefaModel);

    }

    @GetMapping
    public ResponseEntity<List<TarefaModel>> get() {

        return tarefaService.getAll();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getById(@PathVariable("id") UUID id) {

        return tarefaService.getById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> delete(@PathVariable("id") UUID id) {

        return tarefaService.delete(id);

    }

    @PutMapping("{id}")
    public ResponseEntity<Object> update(@RequestBody TarefaModel tarefaModel, @PathVariable("id") UUID id) {

        return tarefaService.update(id, tarefaModel);

    }

}
