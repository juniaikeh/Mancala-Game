import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class BoardLayout extends JPanel
{
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 300;
    private static final int OFFSET_FROM_BORDER = 30;
    private ArrayList<Ellipse2D.Double> pits;
    private Model model;

    BoardLayout(Model m)
    {
        pits = new ArrayList<>();
        model = m;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Container parent = getParent();
        int x = (parent.getWidth()-BOARD_WIDTH)/2;
        int y = (parent.getHeight()-BOARD_HEIGHT)/2;
        RoundRectangle2D boundary = new RoundRectangle2D.Double(x, y, BOARD_WIDTH,BOARD_HEIGHT,100,100);
        double topX = BOARD_WIDTH/8;
        double baseY = y + OFFSET_FROM_BORDER;
        double pitWidth = BOARD_WIDTH / 10;
        double pitHeight = BOARD_HEIGHT / 3;
        pits.add(new Ellipse2D.Double(x+(topX*7) , y+ OFFSET_FROM_BORDER/2 , pitWidth, BOARD_HEIGHT-OFFSET_FROM_BORDER ));       // Add Player 1 Mancala at index 0

        for (int i = 1; i < 7; i++)                                                 // Top Row Pits
            pits.add(new Ellipse2D.Double(x+(topX*i)+10, baseY, pitWidth, pitHeight));

        baseY = y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER;                          // Change y for bottom pits.

        for (int i = 1; i < 7; i++)                                                 // Bottom Row Row Pits
            pits.add(new Ellipse2D.Double(x+(topX*i)+10, baseY, pitWidth, pitHeight));

        pits.add(new Ellipse2D.Double(x+20 , y+OFFSET_FROM_BORDER/2, pitWidth, BOARD_HEIGHT-OFFSET_FROM_BORDER));               // Add Player 2 Mancala at index 13.

        g2.setStroke(new BasicStroke(3));
        for (Ellipse2D e: pits)
            g2.draw(e);
        
        g2.setStroke(new BasicStroke(5));
        setBackground(Color.CYAN);
        g2.draw(boundary);
    }
}
