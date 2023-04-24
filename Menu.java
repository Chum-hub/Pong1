import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Menu extends JPanel {
    public Menu(){
        Game game = new Game();

        setBackground(Consts.gray);
        setVisible(true);
        setPreferredSize(new Dimension(300, 200));

        JLabel title = new JLabel("Pong Game");
        title.setFont(Consts.font);

        JButton startButton = new JButton("Start");
        startButton.setPreferredSize(new Dimension(100, 70));
        startButton.setFont(Consts.font);
        startButton.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                setVisible(false);
            }
        });

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
}
