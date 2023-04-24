import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PongWindow extends JFrame implements ActionListener {
    public PongWindow() {
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, Consts.WIDTH / 2, Consts.HEIGHT / 2);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);
        Menu menu = new Menu();
        Game game = new Game();
        add(game);
        game.setVisible(true);
        //add(menu);

    }
    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
