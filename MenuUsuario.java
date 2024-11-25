package com.redesocial.ui;
import com.redesocial.gerenciador.GerenciadorPosts;
import com.redesocial.gerenciador.GerenciadorUsuarios;
import com.redesocial.modelo.Post;
import com.redesocial.modelo.Usuario;

import java.util.List;
import java.util.Scanner;

    public class MenuUsuario {
        private Usuario usuarioLogado;
        private GerenciadorUsuarios gerenciadorUsuarios;
        private GerenciadorPosts gerenciadorPosts;
        private Scanner scanner;

        public MenuUsuario(Usuario usuario) {
            this.usuarioLogado = usuario;
            this.gerenciadorUsuarios = new GerenciadorUsuarios();
            this.gerenciadorPosts = new GerenciadorPosts();
            this.scanner = new Scanner(System.in);
        }
        public void exibirMenu() {
            int opcao;
            do {
                System.out.println("\n=== Menu Usuário ===");
                System.out.println("1. Criar Post");
                System.out.println("2. Ver Perfil");
                System.out.println("3. Buscar Usuários");
                System.out.println("4. Gerenciar Amizades");
                System.out.println("5. Ver Feed de Notícias");
                System.out.println("6. Sair");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        criarPost();
                        break;
                    case 2:
                        verPerfil();
                        break;
                    case 3:
                        buscarUsuarios();
                        break;
                    case 4:
                        gerenciarAmizades();
                        break;
                    case 5:
                        verFeedNoticias();
                        break;
                    case 6:
                        System.out.println("Saindo...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 6);
        }
        private void criarPost() {
            System.out.print("\nDigite o conteúdo do seu post: ");
            String conteudo = scanner.nextLine();
            Post novoPost = new Post(usuarioLogado, conteudo);
            gerenciadorPosts.criar(novoPost);
            System.out.println("Post criado com sucesso!");
        }
        private void verPerfil() {
            System.out.println("\n=== Perfil de " + usuarioLogado.getNome() + " ===");
            System.out.println("Username: " + usuarioLogado.getUsername());
            System.out.println("Email: " + usuarioLogado.getEmail());
            System.out.println("Data de Cadastro: " + usuarioLogado.getDataCadastro());
            System.out.println("Amigos: ");
            for (Usuario amigo : usuarioLogado.getAmigos()) {
                System.out.println("- " + amigo.getNome());
            }
        }
        private void buscarUsuarios() {
            System.out.print("\nDigite o nome ou username para buscar: ");
            String termoBusca = scanner.nextLine();
            List<Usuario> usuariosEncontrados = gerenciadorUsuarios.buscarPorNome(termoBusca);
            if (usuariosEncontrados.isEmpty()) {
                System.out.println("Nenhum usuário encontrado.");
            } else {
                System.out.println("\nUsuários encontrados:");
                for (Usuario u : usuariosEncontrados) {
                    System.out.println("- " + u.getNome() + " (" + u.getUsername() + ")");
                }
            }
        }
        private void gerenciarAmizades() {
            int opcao;
            do {
                System.out.println("\n=== Gerenciamento de Amizades ===");
                System.out.println("1. Adicionar Amigo");
                System.out.println("2. Remover Amigo");
                System.out.println("3. Voltar");
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarAmigo();
                        break;
                    case 2:
                        removerAmigo();
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                        break;
                }
            } while (opcao != 3);
        }
        private void adicionarAmigo() {
            System.out.print("\nDigite o username do amigo que deseja adicionar: ");
            String username = scanner.nextLine();
            Usuario amigo = gerenciadorUsuarios.buscarPorUsername(username);

            if (amigo != null && !usuarioLogado.getAmigos().contains(amigo)) {
                usuarioLogado.adicionarAmigo(amigo);
                amigo.adicionarAmigo(usuarioLogado);
                System.out.println("Amigo adicionado com sucesso!");
            } else if (amigo == null) {
                System.out.println("Usuário não encontrado.");
            } else {
                System.out.println("Você já é amigo desse usuário.");
            }
        }
        private void removerAmigo() {
            System.out.print("\nDigite o username do amigo que deseja remover: ");
            String username = scanner.nextLine();
            Usuario amigo = gerenciadorUsuarios.buscarPorUsername(username);

            if (amigo != null && usuarioLogado.getAmigos().contains(amigo)) {
                usuarioLogado.removerAmigo(amigo);
                amigo.removerAmigo(usuarioLogado);
                System.out.println("Amigo removido com sucesso!");
            } else if (amigo == null) {
                System.out.println("Usuário não encontrado.");
            } else {
                System.out.println("Este usuário não é seu amigo.");
            }
        }
        private void verFeedNoticias() {
            System.out.println("\n=== Feed de Notícias ===");
            List<Post> posts = gerenciadorPosts.listarPorUsuario(usuarioLogado.getId());
            if (posts.isEmpty()) {
                System.out.println("Nenhum post encontrado.");
            } else {
                for (Post post : posts) {
                    System.out.println(post);
                }
            }
        }
    }


