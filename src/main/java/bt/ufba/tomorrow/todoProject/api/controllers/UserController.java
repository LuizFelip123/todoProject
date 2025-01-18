package bt.ufba.tomorrow.todoProject.api.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bt.ufba.tomorrow.todoProject.api.dto.UsuarioCreateDTO;
import bt.ufba.tomorrow.todoProject.api.dto.UsuarioDTO;
import bt.ufba.tomorrow.todoProject.domain.services.UsuarioService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/v1/usuarios")
public class UserController {

    private final UsuarioService usuarioService;
    public UserController(UsuarioService usuarioService){
        this.usuarioService = usuarioService;
    }

    @PostMapping
    public ResponseEntity<UsuarioDTO> save(@Valid @RequestBody UsuarioCreateDTO dto){
        return new ResponseEntity<>(this.usuarioService.save(dto), HttpStatus.OK);

    }
}
