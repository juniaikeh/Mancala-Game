import javax.swing.*;

public class MancalaTest
{
    public static void main(String[] args)
    {
        Model m = new Model();
        m.setAll(4);
        JFrame frame = new JFrame("Mancala Game");
        frame.setSize(800,400);
        frame.setResizable(false);
        frame.add(new BoardLayout(m), "Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
