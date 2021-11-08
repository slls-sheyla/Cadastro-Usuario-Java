package cadastro;

import java.util.Scanner;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

public class Main {

	public static String tela_senha() {

		String senha1, messagem = "Digite sua senha";

		if (System.console() == null) {

			JPasswordField pf = new JPasswordField();

			senha1 = JOptionPane.showConfirmDialog(null, pf, messagem, JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.QUESTION_MESSAGE) == JOptionPane.OK_OPTION ? new String(pf.getPassword()) : "";
		} else {

			senha1 = new String(System.console().readPassword("%s> ", messagem));

		}

		return senha1;

	}

	public static void main(String[] args) {

		Scanner in = new Scanner(System.in);

		String opcao, senha, adm = "adm123", consulta;

		Usuario usuario = new Usuario();

		CadastrarUsuario cadastro_user = new CadastrarUsuario(6);
		Usuario array[] = new Usuario[6];
		array[0] = new Usuario(1, "sheyla", "she@gmail.com", "123", null);
		array[1] = new Usuario(2, "hugo", "hu@gmail.com", "hugo123", null);
		array[2] = new Usuario(3, "sara", "sa@gmail.com", "sara123", null);
		array[3] = new Usuario(4, "poliane", "poli@gmail.com", "poli123", null);
		array[4] = new Usuario(5, "daniele", "dani@gmail.com", "dani123", null);
		array[5] = new Usuario(6, "poliana", "mi@gmail.com", "mi123", null);
		cadastro_user.setUsuario(array);

		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println("\nDigite qual a opção que você deseja logar: \n\n1- Administrador \n2- Usuário");
		System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

		opcao = in.nextLine();

		if (opcao.equals("1")) {

			// Login Administrador
			do {

				senha = tela_senha();

				// Senha correta
				if (senha.equals(adm)) {

					System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
					System.out.println("\nEscolha uma das opções:\n");
					System.out.println("1  - Listar usuários");
					System.out.println("2  - Consultar usuário");
					System.out.println("3  - Alterar senha de um usuário");
					System.out.println("4  - Alterar dados de usuários");
					System.out.println("5  - Excluir usuários cadastrados");
					System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

					String op = in.nextLine();

					switch (op) {

					// 1 - Listar usuários
					case "1":

						cadastro_user.listarTodos();

						break;

					// 2 - Consultar usuário
					case "2":

						System.out.println("Você desejar consultar o usuário através do:");
						System.out.println("1 - código");
						System.out.println("2 - email");
						System.out.println("3 - parte do nome");

						// oii
						consulta = in.nextLine();

						if (consulta.equals("1")) {

							// Buscando por código
							System.out.println("Digite o código:");
							String codigo = in.nextLine();
							int cast2 = Integer.parseInt(codigo);

							if (cadastro_user.consultarUsuarioC(cast2) != null) {

								cadastro_user.listarDadosC(cast2);

							}

						} else if (consulta.equals("2")) {

							// Buscando por email
							System.out.println("Digite o email:");
							String email = in.nextLine();

							if (cadastro_user.consultarUsuario(email) != null) {

								cadastro_user.listarDados(email);

							}

						} else {

							// Buscando por parte do nome
							System.out.println("Digite parte do nome:");
							String pNome = in.nextLine();

							if (cadastro_user.consultarUsuarioPNome(pNome) != null) {

								cadastro_user.listarDadosPNomes(pNome);

							}

						}

						break;

					// 3 - Alterar senha de um usuário
					case "3":

						String nova, nova1, codigo;
						int cast;
						// Buscando usuário por código
						System.out.println("Digite o código:");
						codigo = in.nextLine();
						cast = Integer.parseInt(codigo);
						usuario = cadastro_user.consultarUsuarioC(cast);

						do {

							System.out.println("Digite a nova senha:");
							nova = in.nextLine();

							System.out.println("Confirme a nova senha:");
							nova1 = in.nextLine();

							if (nova.equals(nova1)) {

								// System.out.println("Senha antiga: " + usuario.getSenha());
								usuario.setSenha(nova);
								System.out.println("Sua senha foi alterada com sucesso!");
								// System.out.println("Senha nova: " + usuario.getSenha());

							} else {

								System.out.println("Confirmação de senha incorreta!");

							}

							System.out.println();

						} while (!nova.equals(nova1));

						break;

					// 4 - Alterar dados de usuários cadastrados
					case "4":

						// Buscando usuário por código
						System.out.println("Digite o código:");
						codigo = in.nextLine();
						cast = Integer.parseInt(codigo);
						usuario = cadastro_user.consultarUsuarioC(cast);

						System.out.println("Altere o nome do usuário:");
						String novoN = in.nextLine();
						usuario.setNome(novoN);

						System.out.println("Altere o email do usuário:");
						String novoE = in.nextLine();
						usuario.setEmail(novoE);

						System.out.println("Dados alterados com sucesso!");

						break;

					// 5 - Excluir usuário cadastrado
					case "5":

						// Buscando usuário por código
						System.out.println("Digite o código do usuário que você deseja excluir:");
						codigo = in.nextLine();
						cast = Integer.parseInt(codigo);
						usuario = cadastro_user.consultarUsuarioC(cast);

						cadastro_user.removerUsuario(cast);
						cadastro_user.listarTodos();
						

						break;

					}

				} else {

					System.out.println("Senha incorreta. Digite novamente!");

				}

			} while (!senha.equals(adm));

			// Login usuário
		} else if (opcao.equals("2")) {

			boolean voltar = false;

			do {

				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("\n                       Digite o email:");
				System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

				String email, senha2;
				int flag1 = 0;

				email = in.nextLine();

				// Usuário cadastrado
				if (cadastro_user.ValidarUsuario(email) == true) {

					do {

						// É usado para verificar se a senha corresponde a determinado login
						do {

							senha2 = tela_senha();

							// Senha correta
							if (cadastro_user.consultarSenhaUsuario(email, senha2)) {

								flag1 = 1;

								System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								System.out.println("\nEscolha uma das opções:\n");
								System.out.println("1  - Listar dados do usuário");
								System.out.println("2  - Alterar o nome do usuário");
								System.out.println("3  - Alterar o email do usuário");
								System.out.println("4  - Alterar a senha do usuário");
								System.out.println("5  - Listar usuários");
								System.out.println("6  - Consultar usuários por parte do nome");
								System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
								String op1 = in.nextLine();

								switch (op1) {

								// 1 - Listar dados do usuário
								case "1":

									cadastro_user.listarDados(email);
									break;

								// 2 - Alterar o nome do usuário
								case "2":

									String sen;
									System.out.println("Digite o nome do usuário que você deseja alterar:");
									String novoU = in.nextLine();

									if (cadastro_user.consultarUsuarioNome(novoU) != null) {

										int flag = 0;

										do {

											System.out.println("Digite a senha:");
											sen = tela_senha();

											if (cadastro_user.consultarSenhaUsuario(
													cadastro_user.consultarUsuarioNome(novoU).getEmail(), sen)) {

												usuario = cadastro_user.consultarUsuarioNome(novoU);

												System.out.println("Digite o novo nome:");
												novoU = in.nextLine();
												System.out.println("Nome antigo: " + usuario.getNome());
												usuario.setNome(novoU);
												System.out.println("Novo nome: " + usuario.getNome());
												System.out.println("Nome alterado com sucesso!");
												flag = 1;

											} else {

												System.out.println("Senha incorreta!");
												flag = 0;

											}

										} while (flag == 0);

									}

									break;

								// 3 - Alterar o email do usuário
								case "3":

									String sen1;
									System.out.println("Digite o email do usuário que você deseja alterar:");
									String emailU = in.nextLine();

									if (cadastro_user.consultarUsuario(emailU) != null) {

										int flag = 0;

										do {

											System.out.println("Digite a senha:");
											sen1 = tela_senha();

											if (cadastro_user.consultarSenhaUsuario(
													cadastro_user.consultarUsuario(emailU).getEmail(), sen1)) {

												usuario = cadastro_user.consultarUsuario(emailU);

												System.out.println("Digite o novo email:");
												emailU = in.nextLine();
												System.out.println("Email antigo: " + usuario.getEmail());
												usuario.setEmail(emailU);
												System.out.println("Novo email: " + usuario.getEmail());
												System.out.println("Email alterado com sucesso!");
												flag = 1;

											} else {

												System.out.println("Senha incorreta!");
												flag = 0;

											}

										} while (flag == 0);

									}

									break;

								// 4 - Alterar a senha do usuário
								case "4":

									String sen2, sen3;
									System.out.println("Digite o email do usuário que você deseja alterar a senha:");
									String email1 = in.nextLine();

									if (cadastro_user.consultarUsuario(email1) != null) {

										int flag = 0;

										do {

											sen2 = tela_senha();

											if (cadastro_user.consultarSenhaUsuario(email1, sen2)) {

												usuario = cadastro_user.consultarUsuario(email1);

												do {

													System.out.println("Digite a nova senha:");
													sen2 = in.nextLine();

													System.out.println("Confirme a nova senha:");
													sen3 = in.nextLine();

													if (sen2.equals(sen3)) {

														System.out.println("Senha antiga: " + usuario.getSenha());
														usuario.setSenha(sen2);
														System.out.println("Senha nova: " + usuario.getSenha());
														System.out.println("Sua senha foi alterada com sucesso!");
														senha2 = sen2;
														flag = 1;

													} else {

														System.out.println("Confirmação de senha incorreta!");

													}

													System.out.println();

												} while (!sen2.equals(sen3));

											} else {

												System.out.println("Senha incorreta!");
												flag = 0;

											}

										} while (flag == 0);
									}

									break;

								// 5 - Listar usuários
								case "5":

									cadastro_user.listarNomes();
									break;

								// 6 - Consultar usuários por parte do nome
								case "6":

									// Buscando usuários por parte do nome
									System.out.println("Digite parte do nome:");
									String pNome = in.nextLine();

									if (cadastro_user.consultarUsuarioPNome(pNome) != null) {

										cadastro_user.listarNomesPNomes(pNome);

									}

									break;

								}

							} else {

								System.out.println("Senha incorreta! Digite novamente");
								flag1 = 0;

							}

							// Verifica se a senha de determinado email está certa.
						} while (flag1 == 0);

						// enquanto senha não existe
					} while (cadastro_user.consultarSenha(senha2) == false);

				} else {

					System.out.println("Usuário não cadastrado.");

					// Cadastrar usuário
					String nome, email_1, senha_1 = null, senha_2 = null;
					System.out.println("Digite o nome do usuário que você deseja cadastrar:");
					nome = in.nextLine();

					System.out.println("Digite o email:");
					email_1 = in.nextLine();

					do {

						System.out.println("Digite a senha:");
						senha_1 = in.nextLine();

						System.out.println("Confirme a senha:");
						senha_2 = in.nextLine();

						if (senha_1.equals(senha_2)) {

							String opc;

							Usuario array2[] = { new Usuario(nome, email_1, senha_1, null) };
							System.out.println("Usuário cadastrado com sucesso!\n");

							System.out.println("1- Voltar para o login\n2- Sair");
							opc = in.nextLine();

							switch (opc) {

							case "1":

								voltar = true;
								break;

							case "2":

								voltar = false;
								System.out.println("Fim");
								break;

							}

						} else {

							System.out.println("Senhas diferentes!");

						}

					} while (!senha_1.equals(senha_2));

				}

			} while (voltar);

		}

	}

}