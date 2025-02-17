package com.redesocial.uiMenuPrincipal;

import com.redesocial.exception.UsuarioException;
import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.modelo.Usuario;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



    public class MenuPrincipal {
        private GerenciadorUsuarios gerenciadorUsuarios;
        private Scanner scanner;

        public MenuPrincipal() {
            this.gerenciadorUsuarios = new GerenciadorUsuarios();
            this.scanner = new Scanner(System.in);
        }
        public void exibirMenu() throws UsuarioException {
            while (true) {
                System.out.println("\n=== Menu Principal ===");
                System.out.println("1. Login");
                System.out.println("2. Cadastrar novo usuário");
                System.out.println("3. Sair");
                System.out.print("Escolha uma opção: ");
                int opcao = scanner.nextInt();
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
                        return;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }
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
        private void cadastrarUsuario() throws UsuarioException {
            System.out.println("\n=== Cadastro de Usuário ===");
            System.out.print("Digite seu nome: ");
            String nome = scanner.nextLine();
            System.out.print("Digite seu username: ");
            String username = scanner.nextLine();
            System.out.print("Digite seu email: ");
            String email = scanner.nextLine();
            System.out.print("Digite sua senha (mínimo 6 caracteres): ");
            String senha = scanner.nextLine();

            if (!validarEmail(email)) {
                System.out.println("Email inválido! Tente novamente.");
                return;
            }

            if (senha.length() < 6) {
                System.out.println("Senha muito curta! A senha deve ter no mínimo 6 caracteres.");
                return;
            }

            Usuario novoUsuario = new Usuario(nome, username, email, senha);

            gerenciadorUsuarios.cadastrar(novoUsuario);
            System.out.println("Usuário cadastrado com sucesso!");
        }
        private boolean validarEmail(String email) {
            String regex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(email);
            return matcher.matches();
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


