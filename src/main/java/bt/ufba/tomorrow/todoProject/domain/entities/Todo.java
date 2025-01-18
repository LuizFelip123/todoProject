package bt.ufba.tomorrow.todoProject.domain.entities;

import java.time.LocalDate;

import bt.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import bt.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_todo")
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="id_usuario")
    private Usuario usuario;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

    public Todo(){

    }
    public Todo(TodoCreateDTO dto){
      this.usuario = new Usuario(dto.getIdUser());
      this.estado = dto.getEstado();
      this.item = dto.getItem();
       this.prazo =dto.getPrazo();
    }
    public Todo(TodoUpdateDTO dto){
        
        this.estado = dto.getEstado();
        this.item = dto.getItem();
        this.prazo = dto.getPrazo();
        this.conclusao = dto.getConclusao();
        this.id =dto.getId();
      }
  

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }

    

}
