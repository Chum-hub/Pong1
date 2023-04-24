import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Game extends JPanel {
    public Game(){
        super();
        setLayout(new BorderLayout()); // Установка менеджера компоновки в null
        try {
            BufferedImage image = ImageIO.read(new File("C:\\Users\\kupri\\IdeaProjects\\Pong\\field.jpeg"));
            JLabel label = new JLabel(new ImageIcon(image));
            label.setBounds(0, 0, getWidth(), getHeight());
            add(label);
        } catch (IOException e) {
            e.printStackTrace();
        }
        setVisible(true);
    }
}
