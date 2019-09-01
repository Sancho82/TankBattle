package music;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public class Music extends TimerTask{

    private Date date;
    private Timer timer;
    private Clip clip;
    private File theme;
    private boolean flag;

    public Music() {
        date = new Date();
        timer = new Timer();
        theme = new File("src\\music\\BattleField_1942_theme.wav");
        flag = true;
    }

    public void run() {

        try {

            if (flag) {
                clip = AudioSystem.getClip();
                clip.open(AudioSystem.getAudioInputStream(theme));
                clip.start();

            }

        } catch (LineUnavailableException lue) {
            System.out.println("LineUnavailableException:");
            System.out.println(lue.getMessage());

        } catch (IOException ioe) {
            System.out.println("IOException:");
            System.out.println(ioe.getMessage());

        } catch (UnsupportedAudioFileException usafe) {
            System.out.println("UnsupportedAudioFileException:");
            System.out.println(usafe.getMessage());
        }
    }

    public void stopMusic() {
        flag = false;

        if(clip.isActive()) {
            clip.stop();
            clip.flush();
            clip.close();
            timer.cancel();
        }
    }

    public Date getDate() {
        return date;
    }

    public Timer getTimer() {
        return timer;
    }
}
