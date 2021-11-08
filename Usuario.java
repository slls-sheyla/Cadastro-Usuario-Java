package cadastro;

import java.util.List;

public class Usuario {

	private int codigo; // autoincremento
	private String nome;
	private String email;
	private String senha;
	private List telefone;

	public Usuario(int codigo, String nome, String email, String senha, List telefone) {

		this.codigo = codigo;
		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;

	}

	public Usuario(String nome, String email, String senha, List telefone) {

		this.nome = nome;
		this.email = email;
		this.senha = senha;
		this.telefone = telefone;

	}

	public Usuario() {

		this.nome = "nomedefault";
		this.email = "logindefault";
		this.senha = "senhadefault";
		
	}

	public int getCodigo() {

		return codigo;

	}

	public void setCodigo(int codigo) {

		this.codigo = codigo;

	}

	public String getNome() {

		return nome;

	}

	public void setNome(String nome) {

		this.nome = nome;

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

	@Override
	public String toString() {

		return "Código: " + this.codigo + "\nNome: " + this.nome + "\nEmail: " + this.email + "\nTelefone: " + this.telefone;

	}

}