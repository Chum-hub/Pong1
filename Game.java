import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends JPanel {
    JLabel score = new JLabel(Consts.P1_Score + " : " + Consts.P2_Score);
    private BufferedImage image;
    public Game() {
        add(score);
        score.setFont(Consts.fontScore);
        try {
            image = ImageIO.read(new File("./field.jpeg"));
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error loading image: " + e.getMessage());
        }
    }

    public void redraw(){
        score.setText(Consts.P1_Score + " : " + Consts.P2_Score);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }
}
