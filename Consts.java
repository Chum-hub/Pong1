import java.awt.*;

public class Consts {
    public static int P1_Score = 0;
    public static int P2_Score = 0;
    public static int WIDTH = 1060;
    public static int HEIGHT = 706;

    public static Color gray = new Color(94, 109, 112);
    public static Color blue = new Color(94, 109, 255);
    public static Color white = new Color(155, 155, 112);
    public static Font fontName = new Font("Arial", Font.BOLD, 20);
    public static Font fontScore = new Font("Arial", Font.BOLD, 40);

    public static Game game = new Game();
    public static Menu menu = new Menu();
    public static Paddle p1 = new Paddle(80, Consts.HEIGHT/2 - 45, "p1", Consts.HEIGHT - 160, 75, Consts.blue);
    public static Paddle p2 = new Paddle(Consts.WIDTH - 120, Consts.HEIGHT/2 - 45, "p2", Consts.HEIGHT - 160, 75, Consts.white);
}
