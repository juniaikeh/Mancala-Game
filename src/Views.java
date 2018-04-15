import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Views extends JPanel
{
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 300;
    private JPanel player1 = new JPanel();
    private JPanel player2 = new JPanel();

    Views()
    {
        add(player1, "West");
        add(player2, "East");
    }

//    public void paintComponent(Graphics g)
//    {
//        Graphics2D g2 = (Graphics2D)g;
//        Container parent = getParent();
//        int x = (parent.getWidth()-BOARD_WIDTH)/2;
//        int y = (parent.getHeight()-BOARD_HEIGHT)/2;
//        RoundRectangle2D boundary = new RoundRectangle2D.Double(x, y, BOARD_WIDTH,BOARD_HEIGHT,100,100);
//        g2.setStroke(new BasicStroke(5));
//        g2.draw(boundary);
//    }
}
