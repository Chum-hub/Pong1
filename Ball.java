import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class Ball extends JComponent {
    public boolean isOnGame = true;
    public double xSpeed;
    public double ySpeed;
    public int velocity = 5;
    public int x = Consts.WIDTH / 2 ;
    public int y = Consts.HEIGHT / 2;
    public final int size = 20;
    public Color color = Color.RED;

    Timer timer;
    File soundFile;
    Clip bounced;
    AudioInputStream audioFile;
    public Ball() {
        soundFile = new File("./sound.wav");
        System.out.println(soundFile.exists());
        try {
            audioFile = AudioSystem.getAudioInputStream(soundFile);
            bounced = AudioSystem.getClip();
            bounced.open(audioFile);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
        }

    }

    public void start(){
        timer = new Timer(5, new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                if (isOnGame){
                    update();
                    repaint();
                } else {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException ex) {
                        throw new RuntimeException(ex);
                    }
                    isOnGame = true;
                    x = Consts.WIDTH / 2 ;
                    y = Consts.HEIGHT / 2;
                    update();
                }
            }
        });
        timer.start();

        double angle = Math.random() * Math.PI * 2;
        xSpeed = (int) (Math.cos(angle) * velocity);
        ySpeed = (int) (Math.sin(angle) * velocity);
    }
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(color);
        g.fillOval(x, y, size, size);
    }

    public void update() {
        bounced.setMicrosecondPosition(0);
        x += xSpeed;
        y += ySpeed;

        if (x < 0 || x > Consts.WIDTH - size) {
            xSpeed = -xSpeed;
            scoreCounter();
            Consts.p1.y = Consts.HEIGHT/2 - 45;
            Consts.p2.y = Consts.HEIGHT/2 - 45;
        }
        if (((y >= Consts.p1.y && y <= Consts.p1.y + Consts.p1.height) && x <= Consts.p1.x + size) || ((y >= Consts.p2.y && y <= Consts.p2.y + Consts.p2.height) && x >= Consts.p2.x - size)){
            xSpeed = -xSpeed;
            bounced.start();
        }
        if (y < 75 || y > Consts.HEIGHT - size - 110) {
            ySpeed = -ySpeed;
            bounced.start();
        }
    }
    public void scoreCounter(){
        if (x < 0){
            Consts.P1_Score++;
            Consts.game.redraw();
            isOnGame = false;
        } else {
            Consts.P2_Score++;
            Consts.game.redraw();
            isOnGame = false;
        }
    }
}