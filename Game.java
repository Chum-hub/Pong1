import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends JPanel {
    public Game(){
        super(new GridBagLayout());
        setVisible(false);
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\kupri\\IdeaProjects\\Pong\\field.jpeg"));
            JLabel label = new JLabel(new ImageIcon(image));
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.weightx = 1.0;
            gbc.weighty = 1.0;
            gbc.anchor = GridBagConstraints.CENTER;
            add(label, gbc);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
