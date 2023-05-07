import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class PongWindow extends JFrame implements ActionListener {

    CardLayout cardLayout;
    Ball ball;
    Paddle p1;
    Paddle p2;
    Container contentPane;

    public PongWindow() {
        ball = new Ball();
        p1 = Consts.p1;
        p2 = Consts.p2;


        setTitle("Pong");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setBounds(300, 200, Consts.WIDTH, Consts.HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);

        cardLayout = new CardLayout();

        contentPane = getContentPane();
        contentPane.setLayout(cardLayout);
        contentPane.add(p1, "p1");
        contentPane.add(p2, "p2");
        contentPane.add(ball, "ball");
        contentPane.add(Consts.game, "game");
        contentPane.add(Consts.menu, "menu");

        cardLayout.show(contentPane, "menu");

        Consts.menu.getStartButton().addActionListener(this);
//        Consts.game.addKeyListener(new KeyAdapter() {
//            @Override
//            public void keyPressed(KeyEvent e) {
//                if (e.getKeyCode() == KeyEvent.VK_W) {
//                    if (!p1.timer.isRunning()) {
//                        p1.move("Up");
//                    }
//                    System.out.println("Pressed : W");
//                } else if (e.getKeyCode() == KeyEvent.VK_S) {
//                    if (!p1.timer.isRunning()) {
//                        p1.move("Down");
//                    }
//                    System.out.println("Pressed : S");
//                }
//            }
//
//            @Override
//            public void keyReleased(KeyEvent e) {
//                p1.stop();
//                System.out.println("Released");
//            }
//        });
        Consts.game.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_W -> {
                        if (!p1.timer.isRunning()) {
                            p1.move("Up");
                        }
                    }
                    case KeyEvent.VK_S -> {
                        if (!p1.timer.isRunning()) {
                            p1.move("Down");
                        }
                    }
                    case KeyEvent.VK_UP -> {
                        if (!p2.timer.isRunning()) {
                            p2.move("Up");
                        }
                    }
                    case KeyEvent.VK_DOWN -> {
                        if (!p2.timer.isRunning()) {
                            p2.move("Down");
                        }
                    }
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_W) {
                    p1.stop();
                }
                if (e.getKeyCode() == KeyEvent.VK_S) {
                    p1.stop();
                }
                if (e.getKeyCode() == KeyEvent.VK_UP) {
                    p2.stop();
                }
                if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                    p2.stop();
                }
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == Consts.menu.getStartButton()) {
            cardLayout.show(contentPane, "game");
            Consts.game.requestFocus();

            p1.setVisible(true);
            p2.setVisible(true);

            ball.start();
            ball.setVisible(true);
        }
    }
}
