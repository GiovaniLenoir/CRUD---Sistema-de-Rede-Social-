import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import com.redesocial.modelo.Usuario;
package com.redesocial.gerenciador;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios;
    private int proximoId;

    public GerenciadorUsuarios() {
        this.usuarios = new ArrayList<>();
        this.proximoId = 1;
        }

        public void cadastrar(Usuario usuario) {
            validarUsuario(usuario);
            usuario.setId(proximoId);
            proximoId++;
            usuarios.add(usuario);
        }

        public Usuario buscarPorId(int id) {
            for (Usuario usuario : usuarios) {
                if (usuario.getId() == id) {
                    return usuario;
                }
            }
            return null;
        }

        public Usuario buscarPorUsername(String username) {
            for (Usuario usuario : usuarios) {
                if (usuario.getUsername().equals(username)) {
                    return usuario;
                }
            }
            return null;
        }

        public List<Usuario> buscarPorNome(String nome) {
            List<Usuario> encontrados = new ArrayList<>();
            for (Usuario usuario : usuarios) {
                if (usuario.getNome().toLowerCase().contains(nome.toLowerCase())) {
                    encontrados.add(usuario);
                }
            }
            return encontrados;
        }

        public boolean atualizar(Usuario usuario) {
            Usuario usuarioExistente = buscarPorId(usuario.getId());
            if (usuarioExistente != null) {
                usuarioExistente.setNome(usuario.getNome());
                usuarioExistente.setUsername(usuario.getUsername());
                usuarioExistente.setEmail(usuario.getEmail());
                usuarioExistente.setSenha(usuario.getSenha());
                usuarioExistente.setDataCadastro(usuario.getDataCadastro());
                usuarioExistente.setAmigos(usuario.getAmigos());
                usuarioExistente.setPosts(usuario.getPosts());
                return true;
            }
            return false;
        }

        public boolean deletar(int id) {
            Usuario usuario = buscarPorId(id);
            if (usuario != null) {
                usuarios.remove(usuario);
                return true;
            }
            return false;
        }

        public void adicionarAmizade(int idUsuario1, int idUsuario2) {
            Usuario usuario1 = buscarPorId(idUsuario1);
            Usuario usuario2 = buscarPorId(idUsuario2);

            if (usuario1 != null && usuario2 != null && usuario1 != usuario2) {
                usuario1.adicionarAmigo(usuario2);
                usuario2.adicionarAmigo(usuario1);
            }
        }

        public void removerAmizade(int idUsuario1, int idUsuario2) {
            Usuario usuario1 = buscarPorId(idUsuario1);
            Usuario usuario2 = buscarPorId(idUsuario2);

            if (usuario1 != null && usuario2 != null) {
                usuario1.removerAmigo(usuario2);
                usuario2.removerAmigo(usuario1);
            }
        }

        private void validarUsuario(Usuario usuario) {
            if (usuario.getNome() == null || usuario.getNome().isEmpty()) {
                throw new IllegalArgumentException("Nome do usuário não pode ser vazio");
            }
            if (usuario.getUsername() == null || usuario.getUsername().isEmpty()) {
                throw new IllegalArgumentException("Username não pode ser vazio");
            }
            if (usuario.getEmail() == null || usuario.getEmail().isEmpty()) {
                throw new IllegalArgumentException("Email não pode ser vazio");
            }
            if (usuario.getSenha() == null || usuario.getSenha().isEmpty()) {
                throw new IllegalArgumentException("Senha não pode ser vazia");
            }
        }
    }
    
