package com.redesocial.modelo;

import com.redesocial.gerenciador.GerenciadorPosts;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Post {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataPublicacao;
    private List<Usuario> curtidas;
    private List<Comentario> comentarios;

    public Post(Integer id, Usuario autor, String conteudo, LocalDateTime dataPublicacao,
                List<Usuario> curtidas, List<Comentario> comentarios) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataPublicacao = LocalDateTime.now();
        this.curtidas = new ArrayList<>();
        this.comentarios = new ArrayList<>();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getAutor() {
        return autor;
    }

    public void setAutor(Usuario autor) {
        this.autor = autor;
    }

    public String getConteudo() {
        return conteudo;
    }

    public void setConteudo(String conteudo) {
        this.conteudo = conteudo;
    }

    public LocalDateTime getDataPublicacao() {
        return dataPublicacao;
    }

    public void setDataPublicacao(LocalDateTime dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }

    public List<Usuario> getCurtidas() {
        return curtidas;
    }

    public void setCurtidas(List<Usuario> curtidas) {
        this.curtidas = curtidas;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }
    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", autor=" + autor +
                ", conteudo='" + conteudo + '\'' +
                ", dataPublicacao=" + dataPublicacao +
                ", curtidas=" + curtidas +
                ", comentarios=" + comentarios +
                '}';
    }

    public void adicionarCurtida(Usuario usuario) {
        if (!this.curtidas.contains(usuario)){
            this.curtidas.add(usuario);
        }
    }
    public void removerCurtida(Usuario usuario) {
        if (this.curtidas.remove(usuario)) {
            this.curtidas.add(usuario);
        }
    }
    public void adicionarComentario(Comentario comentario) {
        if (comentario != null) {
            this.comentarios.add(comentario);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Post post = (Post) o;
        return Objects.equals(id, post.id) && Objects.equals(autor, post.autor)
                && Objects.equals(conteudo, post.conteudo)
                && Objects.equals(dataPublicacao, post.dataPublicacao)
                && Objects.equals(curtidas, post.curtidas)
                && Objects.equals(comentarios, post.comentarios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, conteudo, dataPublicacao, curtidas, comentarios);
    }

    }

