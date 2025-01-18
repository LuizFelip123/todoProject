package bt.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import bt.ufba.tomorrow.todoProject.domain.entities.Todo;
import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;

public class TodoDTO {
    private long id;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public TodoDTO(Todo todo){
        this.id = todo.getId();
        this.item = todo.getItem();
        this.prazo = todo.getPrazo();
        this.estado = todo.getEstado();
    }
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public LocalDate getPrazo() {
        return prazo;
    }

    public void setPrazo(LocalDate prazo) {
        this.prazo = prazo;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    
}
