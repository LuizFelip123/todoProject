package bt.ufba.tomorrow.todoProject.api.dto;

import bt.ufba.tomorrow.todoProject.domain.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCreateDTO {

    @Email(message="O email não é válido")
    @NotBlank(message="O email não pode ser vazio")
    private String email;
    @NotBlank(message="O email não pode ser vazio")
    @Size(min=5, max=100, message = "A senha deve ter entre 5 e 20 caracteres")
    private String senha;
    public UsuarioCreateDTO(){
        
    }
    public UsuarioCreateDTO(Usuario usuario){
        this.email = usuario.getEmail();
        this.senha = usuario.getSenha();
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }


}
