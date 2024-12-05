// import java.util.Scanner;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import dominio.Album;
import dominio.Artista;
import dominio.Musica;

public class App {
    public static void main(String[] args) {
        Musica musica1 = new Musica("You Say", "Gospel", "./assets/musicas/audio2.wav", 237);
        Musica musica2 = new Musica("Dandelions", "Pop", "./assets/musicas/audio4 (2).wav", 188);
        Musica musica3 = new Musica("Beautiful Things", "Pop", "./assets/musicas/audio3.wav", 192);

        List<Musica> musicas1 = new ArrayList<>();
        musicas1.add(musica1);
        musicas1.add(musica2);
        musicas1.add(musica3);

        Album album1 = new Album("Internacionais", 2024,  musicas1, "./assets/imagem/images.png");

        Artista artista = new Artista("");
        artista.addAlbum(album1);

        AudioPlayer player = new AudioPlayer();

        JButton playStopButton = new JButton("Play");

        player.loadAudios(artista.getAlbuns().get(0).getMusicas());
        
        playStopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                if (!player.getIsPlaying()) {
                    player.playAudio();
                    playStopButton.setText("Stop");
                } else {
                    player.stopAudio();
                    playStopButton.setText("Play");
                }
            }
        });

        JButton nextButton = new JButton("Next");
        nextButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                player.nextAudio();
                playStopButton.setText("Stop");
            }
        });

        JButton previousButton = new JButton("voltar");
        previousButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                player.previousAudio();
                playStopButton.setText("Stop");
            }
        });

        JOptionPane.showOptionDialog(
                null,
                "Você está ouvindo músicas internacionais",
                "PlayMusic",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                artista.getAlbuns().get(0).getCapa(),
                new Object[] { previousButton, playStopButton, nextButton },
                playStopButton);

        if (player.getAudioClip() != null) {
            player.getAudioClip().close();
        }
    }
}
