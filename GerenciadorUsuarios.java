package com.redesocial.gerenciador;

import com.redesocial.modelo.Usuario;
import com.redesocial.exception.UsuarioException;

import java.util.ArrayList;
import java.util.List;

public class GerenciadorUsuarios {
    private List<Usuario> usuarios;
    private int proximoId;

    public GerenciadorUsuarios() {
        this.usuarios = new ArrayList<>();
        this.proximoId = 1;
        }

    public void cadastrar(Usuario usuario) {
        validarUsuario(usuario);
        usuario.setId(proximoId++);
        usuarios.add(usuario);
    }

    public Usuario buscarPorId(int id) {
        return usuarios.stream()
                .filter(usuario -> usuario.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public Usuario buscarPorUsername(String username) {
        return usuarios.stream()
                .filter(usuario -> usuario.getUsername().equals(username))
                .findFirst()
                .orElse(null);
    }

    public List<Usuario> buscarPorNome(String nome) {
        List<Usuario> encontrados = new ArrayList<>();
        for (Usuario usuario : usuarios) {
            if (usuario.getNome().contains(nome)) {
                encontrados.add(usuario);
            }
        }
        return encontrados;
    }

    public boolean atualizar(Usuario usuario) {
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId().equals(usuario.getId())) {
                usuarios.set(i, usuario);
                return true;
            }
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
        if (usuario1 != null && usuario2 != null) {
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
        if (buscarPorUsername(usuario.getUsername()) != null) {
            throw new UsuarioException("Username já existe.");
        }
        if (usuario.getEmail().isEmpty() || !usuario.getEmail().contains("@")) {
            throw new UsuarioException("Email inválido.");
        }
        if (usuario.getSenha().length() < 6) {
            throw new UsuarioException("Senha deve ter pelo menos 6 caracteres.");
        }
    }
}

