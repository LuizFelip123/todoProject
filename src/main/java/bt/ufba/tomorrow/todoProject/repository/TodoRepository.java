package bt.ufba.tomorrow.todoProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bt.ufba.tomorrow.todoProject.domain.entities.Todo;
import bt.ufba.tomorrow.todoProject.domain.entities.Usuario;
import bt.ufba.tomorrow.todoProject.domain.entities.enums.Estado;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long>{
    public Todo save(Todo t);
    public List<Todo> findByUsuario(Usuario usuario);
    public List<Todo> findByUsuarioAndEstado(Usuario usuario, Estado estado);
}
