package dominio;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

public class Album {
    private String nome;
    private int ano;
    private List<Musica> musicas = new ArrayList<>();
    private ImageIcon capa;

    public Album(String nome, int ano, List<Musica> musicas, String capa) {
        this.nome = nome;
        this.ano = ano;
        this.musicas = musicas;
        this.capa = new ImageIcon(capa);
    }

    public ImageIcon getCapa() {
        return this.capa;
    }

    public void setCapa(String filePath) {
        this.capa = new ImageIcon(filePath);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public List<Musica> getMusicas() {
        return musicas;
    }

    public void addMusica(Musica musica) {
        this.musicas.add(musica);
    }

    public void addMusicas(List<Musica> musicas) {
        this.musicas.addAll(musicas);
    }
}
