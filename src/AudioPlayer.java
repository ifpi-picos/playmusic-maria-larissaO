import java.io.File;
import java.io.IOException;
import java.util.List;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import dominio.Musica;

public class AudioPlayer {
    private Clip audioClip;
    private boolean isPlaying = false;
    private List<Musica> listReproduction;
    private int iterador = 0;

public Clip getAudioClip() {
    return this.audioClip;
}

public boolean getIsPlaying() {
    return this.isPlaying;
}

public void isPlaying() {
    this.isPlaying = !isPlaying;
}

public void loadAudio(String filepath) {
    System.out.println("Carregando " + filepath);
    try {
        File audioFile = new File(filepath);      
        AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);        
        AudioFormat format = audioStream.getFormat();      
        DataLine.Info info = new DataLine.Info(Clip.class, format);      
        audioClip = (Clip) AudioSystem.getLine(info);
        audioClip.open(audioStream);       
    } catch (UnsupportedAudioFileException | LineUnavailableException | IOException exception) {
        System.out.println("Erro ao carregar o áudio: " + exception.getMessage());
        exception.printStackTrace();
    }
}

public void loadAudios(List<Musica> musicas){
    this.listReproduction = musicas;
    this.iterador = 0;
    loadAudio(musicas.get(iterador).getArquivoAudio());
}

   
public void playAudio() {
    System.out.println("PlayAudio");
    if (audioClip != null && !isPlaying) {
    System.out.println("PlayAudio Start");
    audioClip.start();
    this.isPlaying = true;
    }
}

  
public void stopAudio() {
    if (audioClip != null && isPlaying) {
    System.out.println("StopAudio");
    audioClip.stop();
    this.isPlaying = false;
    }
}

   
public void nextAudio() {
    if (listReproduction != null) {     
    System.out.println("Próxima música");
    stopAudio();
    if (iterador < (listReproduction.size() - 1)) {
    iterador++;
    loadAudio(listReproduction.get(iterador).getArquivoAudio());
    playAudio();
    } else if (iterador >= (listReproduction.size() - 1)) {
    iterador = 0;
    loadAudio(listReproduction.get(iterador).getArquivoAudio());
    playAudio();
}
    } else {
     System.out.println("Adicione um Albúm ou Playlist para tocar!");
 }
}

    
public void previousAudio() {
    if (listReproduction != null) {     
        System.out.println("Música anterior");
        stopAudio();
    if (iterador > 0 && iterador <= (listReproduction.size() - 1)) {
        iterador--;
        loadAudio(listReproduction.get(iterador).getArquivoAudio());
        playAudio();
    } else if (iterador == 0) {
        iterador = listReproduction.size() - 1;
        loadAudio(listReproduction.get(iterador).getArquivoAudio());
        playAudio();
    }
    } else{
        System.out.println("Adicione um Albúm ou Playlist para tocar!");
        }
    }
}
