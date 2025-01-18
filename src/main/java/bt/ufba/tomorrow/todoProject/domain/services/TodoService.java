package bt.ufba.tomorrow.todoProject.domain.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;


import bt.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import bt.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import bt.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import bt.ufba.tomorrow.todoProject.domain.entities.Todo;
import bt.ufba.tomorrow.todoProject.domain.entities.Usuario;
import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;
import bt.ufba.tomorrow.todoProject.repository.TodoRepository;

@Service
public class TodoService {

    private final TodoRepository todoRepository;
    public TodoService(TodoRepository todoRepository){
        this.todoRepository = todoRepository;
    }
    public TodoDTO save(TodoCreateDTO todoCreateDTO){
        return new TodoDTO(this.todoRepository.save(new Todo(todoCreateDTO))); 
    }

    public List<TodoDTO> findByUsuario(long id){
        return this.todoRepository.findByUsuario(new Usuario(id))
              .stream()
              .map(TodoDTO::new)
              .collect(Collectors.toList());
    }

    public List<TodoDTO> findByUsuarioAndEstado(long userId, Estado estado){
        return this.todoRepository.findByUsuarioAndEstado(new Usuario(userId), estado)
                .stream()
                 .map(TodoDTO::new)
                 .collect(Collectors.toList());
    }
    public List<TodoDTO> findAll(){
        return this.todoRepository.findAll()
              .stream()
              .map(TodoDTO::new)
              .collect(Collectors.toList()); 
    }
    public void delete(long id){
        this.todoRepository.deleteById(id);
    }
    public TodoDTO update(TodoUpdateDTO dto) throws Exception{
        Optional<Todo> exist = this.todoRepository.findById(dto.getId());
        if(exist.isPresent()){
            Todo insert = new Todo(dto);
            insert.setUsuario(exist.get().getUsuario());
            return new TodoDTO(this.todoRepository.save(insert));
        }   

        throw new Exception("Objeto não encontrado com id: "+ dto.getId());
    }

    public TodoDTO concluir(long id) throws Exception{
        Optional<Todo> exist = this.todoRepository.findById(id);
        if(exist.isPresent()){
          Todo todo = exist.get();
          todo.setConclusao(LocalDate.now());
         todo.setEstado(Estado.CONCLUIDO);
        return new TodoDTO(this.todoRepository.save(todo));
        }   
        throw new Exception("Objeto não encontrado com id:"+ id);
    }
}
