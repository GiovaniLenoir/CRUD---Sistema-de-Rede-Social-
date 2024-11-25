package ui;

import gerenciador.GerenciadorUsuarios;
import modelo.Usuario;

import java.util.Scanner;

    public class MenuPrincipal {
        private GerenciadorUsuarios gerenciadorUsuarios;
        private Scanner scanner;

        public MenuPrincipal() {
            this.gerenciadorUsuarios = new GerenciadorUsuarios();
            this.scanner = new Scanner(System.in);
        }
        public void exibirMenu() {
            int opcao;
            do {
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Fazer Login");
                System.out.println("2. Cadastrar Usuário");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        fazerLogin();
                        break;
                    case 2:
                        cadastrarUsuario();
                        break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 3);
        }
        private void fazerLogin() {
            System.out.print("\nDigite o username: ");
            String username = scanner.nextLine();
            System.out.print("Digite a senha: ");
            String senha = scanner.nextLine();
            Usuario usuario = gerenciadorUsuarios.buscarPorUsername(username);
            if (usuario != null && usuario.getSenha().equals(senha)) {
                System.out.println("\nLogin bem-sucedido!");
                exibirMenuLogado(usuario);
            } else {
                System.out.println("\nUsuário ou senha inválidos. Tente novamente.");
            }
        }
        private void cadastrarUsuario() {
            System.out.println("\n=== Cadastro de Usuário ===");
            System.out.print("Nome: ");
            String nome = scanner.nextLine();
            System.out.print("Username: ");
            String username = scanner.nextLine();
            System.out.print("Email: ");
            String email = scanner.nextLine();
            System.out.print("Senha: ");
            String senha = scanner.nextLine();

            Usuario novoUsuario = new Usuario(nome, username, email, senha);
            gerenciadorUsuarios.cadastrar(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }
        private void exibirMenuLogado(Usuario usuario) {
            int opcao;
            do {
                System.out.println("\n=== Menu Logado ===");
                System.out.println("1. Criar Post");
                System.out.println("2. Ver Meus Posts");
                System.out.println("3. Visualizar Amigos");
                System.out.println("4. Adicionar Amigo");
                System.out.println("5. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 5);
        }
    }


