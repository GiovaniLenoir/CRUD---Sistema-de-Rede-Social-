package com.redesocial.gerenciador;

import com.redesocial.modelo.Post;
import com.redesocial.modelo.Comentario;
import com.redesocial.modelo.Usuario;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

public class GerenciadorPosts {
        private List<Post> posts;
        private int proximoId;

        public GerenciadorPosts() {
            this.posts = new ArrayList<>();
            this.proximoId = 1;
        }

        public void criar(Post post) {
            validarPost(post);
            post.setId(proximoId);
            proximoId++;
            posts.add(post);
        }
        public Post buscarPorId(int id) {
            for (Post post : posts) {
                if (post.getId() == id) {
                    return post;
                }
            }
            return null;
        }
        public List<Post> listarPorUsuario(int idUsuario) {
            List<Post> postsUsuario = new ArrayList<>();
            for (Post post : posts) {
                if (post.getAutor().getId() == idUsuario) {
                    postsUsuario.add(post);
                }
            }
            return postsUsuario;
        }
        public void curtir(int idPost, int idUsuario) {
            Post post = buscarPorId(idPost);
            Usuario usuario = new GerenciadorUsuarios().buscarPorId(idUsuario);
            if (post != null && usuario != null) {
                post.adicionarCurtida(usuario);
            }
        }
        public void descurtir(int idPost, int idUsuario) {
            Post post = buscarPorId(idPost);
            Usuario usuario = new GerenciadorUsuarios().buscarPorId(idUsuario);
            if (post != null && usuario != null) {
                post.removerCurtida(usuario);
            }
        }
        public void comentar(int idpost, Comentario comentario) {
            Post post = buscarPorId(idpost);
            if (post != null) {
                System.out.println("Comentario adicionado" + comentario.getConteudo());
            }else {
                System.out.println("Poste não encontrado");
            }
        }

    public boolean deletar(int id) {
            Post post = buscarPorId(id);
            if (post != null) {
                posts.remove(post);
                return true;
            }
            return false;
        }
        private void validarPost(Post post) {
            if (post.getConteudo() == null || post.getConteudo().isEmpty()) {
                throw new IllegalArgumentException("Conteúdo do post não pode ser vazio");
            }
            if (post.getAutor() == null) {
                throw new IllegalArgumentException("Autor do post não pode ser nulo");
            }
            if (post.getDataPublicacao() == null) {
                throw new IllegalArgumentException("Data de publicação do post não pode ser nula");
            }
        }
    }


