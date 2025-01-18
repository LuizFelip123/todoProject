package bt.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;

public class TodoUpdateDTO {
private long id;
    private String item;
    private LocalDate prazo;
    private Estado estado;
    private LocalDate conclusao;

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

    public LocalDate getConclusao() {
        return conclusao;
    }

    public void setConclusao(LocalDate conclusao) {
        this.conclusao = conclusao;
    }
    

}
