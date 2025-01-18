package bt.ufba.tomorrow.todoProject.api.dto;

import java.time.LocalDate;

import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;

public class TodoCreateDTO {
    private long idUser;
    private String item;
    private LocalDate prazo;
    private Estado estado;

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
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
