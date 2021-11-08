package cadastro;

public class CadastrarUsuario {

	private int qtd;
	private Usuario array[];

	public CadastrarUsuario(int qtd) {

		this.qtd = qtd;

		array = new Usuario[qtd];

		for(int i = 0; i < array.length; i++){

			array[i] = new Usuario(i, "default", "default", "default", null);//criando instanciado usuario default pra popular array

		}

	}

	public void setUsuario(Usuario user []){

		for(int i = 0; i < array.length; i++){

			this.array[i]= user[i];

		}

	}

	//por código, login ou parte do nome

	public Usuario consultarUsuarioC (int codigo){

		for(int i = 0; i < array.length; i++){

			if(codigo == (array[i].getCodigo()) == true){

				return array[i];

			}

		}

		return null;
	}

	public Usuario consultarUsuario (String email){

		for(int i = 0; i < array.length; i++){

			if(email.equals(array[i].getEmail()) == true){

				return array[i];

			}

		}

		return null;
	}

	public Usuario consultarUsuarioNome (String nome){

		for(int i=0; i < array.length; i++){

			if(nome.equals(array[i].getNome()) == true){

				return array[i];

			}

		}

		return null;
	
	}

	public boolean ValidarUsuario (String email){

		for(int i = 0; i < array.length; i++){

			if(email.equals(array[i].getEmail()) == true){

				return true;

			}

		}

		return false;
	
	}
	
	public boolean consultarSenha (String senha){

		for(int i = 0; i < array.length; i++){

			if(senha.equals(array[i].getSenha()) == true){

				return true;

			}

		}

		return false;
		
	}

	public boolean consultarSenhaUsuario (String email, String senha){

		for(int i = 0; i < array.length; i++){

			if(email.equals(array[i].getEmail())){

				if (senha.equals(array[i].getSenha()))
						return true;
			}

		}

		return false;
		
	}
		
	public Usuario consultarUsuarioPNome (String pNome){
		
		int tam = pNome.length();

		for(int i = 0; i < array.length; i++){

			if(pNome.equals(this.array[i].getNome().substring(0, tam)) == true){

				return array[i];

			}

		}

		return null;
	
	}

	public void listarDadosC(int codigo){

		for(int i = 0; i < array.length; i++){

			if(codigo == (this.array[i].getCodigo())){

				System.out.println(this.array[i]);

			}
		}

	}

	public void listarDados(String email){

		for(int i = 0; i < array.length; i++){

			if(email.equals(this.array[i].getEmail())){

				System.out.println(this.array[i]);

			}
		}

	}

	public void listarDadosPNomes(String pNome){

		int tam = pNome.length();

		for(int i = 0; i < array.length; i++){
					
			if(pNome.equals(this.array[i].getNome().substring(0, tam))){

				System.out.println(this.array[i]);
				
			}
		
		}

	}

	public void listarNomesPNomes(String pNome){

		int tam = pNome.length();

		for(int i = 0; i < array.length; i++){

			if(pNome.equals(this.array[i].getNome().substring(0, tam))){

				System.out.println(this.array[i].getNome());

			}
		
		}

	}

	
	public void listarTodos(){ 

		for(int i = 0; i < array.length; i++){

			System.out.println(this.array[i]);

		}

	}

	public void listarNomes(){ 

		for(int i = 0; i < array.length; i++){

			System.out.println(this.array[i].getNome());

		}

	}
	
	public void removerUsuario(int codigo){

		if(consultarUsuarioC(codigo) != null) {

			Usuario delete = consultarUsuarioC(codigo);

			for (int i = 0; i < array.length; i++) {

				//Verificando se o usuário que eu quero deletar por código, está contido no array de usuários
				if(array[i].getCodigo() == delete.getCodigo()) {

					array[i] = null;

				}

			}

		}

	}
	
}