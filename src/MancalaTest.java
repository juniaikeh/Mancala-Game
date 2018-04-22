import javax.swing.*;

public class MancalaTest
{
    public static void main(String[] args)
    {
        Model m = new Model();
        View v = new View();
        Controller c = new Controller(m,v);
        JFrame frame = new JFrame("Mancala Game");
        frame.setSize(800,400);
        frame.setResizable(false);
        frame.add(v, "Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
