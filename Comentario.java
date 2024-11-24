import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Comentario {
    private Integer id;
    private Usuario autor;
    private String conteudo;
    private LocalDateTime dataComentario;
    private List<Post> Post;

    public Comentario(Integer id, Usuario autor, String conteudo,
                      LocalDateTime dataComentario, List<Post> post) {
        this.id = id;
        this.autor = autor;
        this.conteudo = conteudo;
        this.dataComentario = dataComentario;
        this.Post = post;
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

    public LocalDateTime getDataComentario() {
        return dataComentario;
    }

    public void setDataComentario(LocalDateTime dataComentario) {
        this.dataComentario = dataComentario;
    }

    public List<Post> getPost() {
        return Post;
    }

    public void setPost(List<Post> post) {
        Post = post;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "id=" + id +
                ", autor=" + autor +
                ", conteudo='" + conteudo + '\'' +
                ", dataComentario=" + dataComentario +
                ", Post=" + Post +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Comentario that = (Comentario) o;
        return Objects.equals(id, that.id) && Objects.equals(autor, that.autor)
                && Objects.equals(conteudo, that.conteudo)
                && Objects.equals(dataComentario, that.dataComentario)
                && Objects.equals(Post, that.Post);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, autor, conteudo, dataComentario, Post);
    }
    
}
