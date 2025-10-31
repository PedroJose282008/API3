package lab.crud.api.repository;
 
import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import lab.crud.api.model.Usuario;
 
public interface UsuarioRepository extends CrudRepository<Usuario, Integer>{
 
	List<Usuario> findByNome(String nome);

	List<Usuario> findByNomeLike(String padraoDeNome);
 
	Optional<Usuario> findById(Long id);
 
	

}

 