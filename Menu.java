import javax.swing.*;
import java.awt.*;

public class Menu extends JPanel {
    JButton startButton = new JButton("Start");
    public Menu() {
        setBackground(Consts.gray);

        JLabel title = new JLabel("Pong Game");
        title.setFont(Consts.fontName);


        startButton.setPreferredSize(new Dimension(100, 70));
        startButton.setFont(Consts.fontName);


        setLayout(new GridBagLayout());
        GridBagConstraints constraints = new GridBagConstraints();

        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.insets = new Insets(0, 0, 20, 0);
        constraints.anchor = GridBagConstraints.CENTER;
        add(title, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.insets = new Insets(0, 0, 0, 0);
        constraints.anchor = GridBagConstraints.CENTER;
        add(startButton, constraints);

    }

    public JButton getStartButton() {
        return startButton;
    }
}
