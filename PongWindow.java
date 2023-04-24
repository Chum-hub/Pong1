import javax.swing.*;

public class PongWindow extends JFrame {
    Menu menu = new Menu();
    Game game = new Game();

    public PongWindow() {
        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, Consts.WIDTH / 2, Consts.HEIGHT / 2);
        setResizable(false);
        setVisible(true);
        setLocationRelativeTo(null);

        add(game);

        add(menu);
        menu.setVisible(true);

    }

    public void startGame() {
        menu.setVisible(false);
        game.setVisible(true);
    }
}
