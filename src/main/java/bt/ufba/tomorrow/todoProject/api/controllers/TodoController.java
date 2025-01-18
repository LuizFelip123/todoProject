package bt.ufba.tomorrow.todoProject.api.controllers;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bt.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import bt.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import bt.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;
import bt.ufba.tomorrow.todoProject.domain.services.TodoService;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final  TodoService todoService;

    public TodoController(TodoService todoService){
        this.todoService = todoService;
    }

    @GetMapping
    public ResponseEntity<List<TodoDTO>> list(){
        return new ResponseEntity<>(this.todoService.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDTO>> listByUsuario(@PathVariable long userId){
        return new ResponseEntity<>(this.todoService.findByUsuario(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<TodoDTO> save(@RequestBody TodoCreateDTO dto){
  
        return new ResponseEntity<>(this.todoService.save(dto), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<TodoDTO> alterar(@RequestBody TodoUpdateDTO todo) throws Exception{
        return new ResponseEntity<>(this.todoService.update(todo), HttpStatus.OK);
    }

    @GetMapping("/{userId}/{estado}")
    public ResponseEntity<List<TodoDTO>> listByUsuarioAndEstado(@PathVariable long userId, Estado estado){

        return new ResponseEntity<>(this.todoService.findByUsuarioAndEstado(userId, estado),HttpStatus.OK);
    }

    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> removerUsuario(@PathVariable long todoId){
        this.todoService.delete(todoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<TodoDTO> concluir(@PathVariable long id) throws  Exception{ 
        return new ResponseEntity<>( this.todoService.concluir(id) ,HttpStatus.OK);
    }

}

