package lab.crud.api.controller;
 
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import lab.crud.api.model.Usuario;
import lab.crud.api.repository.UsuarioRepository;

 
@RestController
public class UsuarioController {
 
	@Autowired
	private UsuarioRepository repository;
	//POST
		@PostMapping("/usuarios")
		public ResponseEntity<Usuario> novo(
				@RequestBody Usuario usuario) {
			usuario.getDataNascimento();
			repository.save(usuario);
			System.out.println(usuario.toString());
			return ResponseEntity
					.status(HttpStatus.CREATED)
					.body(usuario);
		}
		//POST
		//GET(All)
		@GetMapping("/usuarios")
		public ResponseEntity<Iterable<Usuario>> obterTodos() { 
			repository.findByNomeLike("%Usuario%");
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(repository.findAll());
		}
		//GET(All)
		//GET(ID)
		@GetMapping("/usuarios/{id}")
		public ResponseEntity<Object> buscarPorId(
				@PathVariable Long id) {
			//Alt + L
			Optional<Usuario> usuarioEncontrado = repository.findById(id);
			//Empty = Vazio
			if (usuarioEncontrado.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("Usuario não encontrado");
			}
			return ResponseEntity
					.status(HttpStatus.OK)
					.body(usuarioEncontrado.get());
		}
		//GET(ID)
		//PUT
		@PutMapping("/usuarios/{id}")
		public ResponseEntity<Object> atualizarUsuario(
				@PathVariable Long id,
				@RequestBody Usuario usr) {
			Optional<Usuario> usuario = repository.findById(id);
		if(usuario.isEmpty()) {
			return ResponseEntity
					.status(HttpStatus.NOT_FOUND)
					.body("Produto não encontrado");
		}
		usr.setId(id);
		usr.setDataNascimento(usuario.get().getDataNascimento());
		repository.save(usr);
		return ResponseEntity
				.status(HttpStatus.OK)
				.body("Produto atualizado com sucesso!");
		}
		//PUT
		//DELETE
		//curl -X DELETE http://localhost:8081/usuarios/1
		@DeleteMapping("/usuarios/{id}")
		public ResponseEntity<Object> apagarUsuario(
				@PathVariable Long id) {
			Optional<Usuario> usuario = repository.findById(id);
			if (usuario.isEmpty()) {
				return ResponseEntity
						.status(HttpStatus.NOT_FOUND)
						.body("Usuario não encontrado!");
			}
			Usuario usr = usuario.get();
			repository.delete(usr);
			return ResponseEntity
					.status(HttpStatus.OK)
					.body("Usuario apagado com sucesso!");
		}
	}
		//DELETE
 
//Para testar pesquisar localhost:8081/usuarios/1
//curl -X PUT http://localhost:8081/usuarios/1 -H "Content-Type: application/json; Charset=utf-8" -d @usuario2.json
 
//curl -X POST http://localhost:8081/usuarios -H "Content-Type: application/json; Charset=utf-8" -d @usuario1.json

//curl -X POST http://localhost:8081/usuarios -H "Content-Type: application/json; Charset=utf-8" -d @Usuario-cabeçudo.json
