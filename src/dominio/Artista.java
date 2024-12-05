package dominio;

import java.util.ArrayList;
import java.util.List;

public class Artista {
    private String nome;
    private List<Album> albuns = new ArrayList<>();
    
    public Artista(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public List<Album> getAlbuns() {
        return albuns;
    }

    public List<Musica> getMusicasFromAlbum(Artista artista, int numeroAlbum){
        return artista.getAlbuns().get(numeroAlbum).getMusicas();
    }

    public void addAlbum(Album album) {
        this.albuns.add(album);
    }

    public void addAlbuns(List<Album> albuns){
        this.albuns.addAll(albuns);
    }

    
}