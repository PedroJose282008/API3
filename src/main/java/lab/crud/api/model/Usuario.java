package lab.crud.api.model;
 
import java.time.LocalDate;

import java.util.Objects;
 
import jakarta.persistence.Entity;

import jakarta.persistence.GeneratedValue;

import jakarta.persistence.GenerationType;

import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
 
@Table(name = "TB_USUAR")
 
public class Usuario {
 
	@Id

	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;

	private String nome;

	private LocalDate dataNascimento;

	private int tipoUsuario;
 
	public Usuario() {
 
	}
 
	//Alt + SHIFT + S(Source/Fonte/Código Fonte)

	public Long getId() {

		return id;

	}
 
	public void setId(Long id) {

		this.id = id;

	}
 
	public String getNome() {

		return nome;

	}
 
	public void setNome(String nome) {

		this.nome = nome;

	}
 
	public LocalDate getDataNascimento() {

		return dataNascimento;

	}
 
	public void setDataNascimento(LocalDate dataNascimento) {

		this.dataNascimento = dataNascimento;

	}
 
	public int getTipoUsuario() {

		return tipoUsuario;

	}

	public void setTipoUsuario(int tipoUsuario) {

		this.tipoUsuario = tipoUsuario;

	}
 
	@Override

	public int hashCode() {

		return Objects.hash(dataNascimento, id, nome, tipoUsuario);

	}
 
	@Override

	public boolean equals(Object obj) {

		if (this == obj)

			return true;

		if (obj == null)

			return false;

		if (getClass() != obj.getClass())

			return false;

		Usuario other = (Usuario) obj;

		return Objects.equals(dataNascimento, other.dataNascimento) && Objects.equals(id, other.id)
&& Objects.equals(nome, other.nome) && tipoUsuario == other.tipoUsuario;

	}
 
}
 
 