import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class View extends JPanel
{
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 300;
    private static final int OFFSET_FROM_BORDER = 30;
    private int x = 40;
    private int y = 40;
    private ArrayList<Shape> pits;
    private Color backgroundColor;

    View()
    {
        pits = new ArrayList<>();
        backgroundColor = Color.CYAN;
        double topX = BOARD_WIDTH/8;
        double baseY = y + OFFSET_FROM_BORDER;
        double pitWidth = BOARD_WIDTH / 10;
        double pitHeight = BOARD_HEIGHT / 3;

        pits.add(new RoundRectangle2D.Double(x+20, y+OFFSET_FROM_BORDER/2, pitWidth, BOARD_HEIGHT-OFFSET_FROM_BORDER, 60, 60));// Add Player 2 Mancala at index 13.

        int topY = y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER;

        for (int i = 1; i < 7; i++)                                                 // Top Row Pits
            pits.add(new Ellipse2D.Double(x+(topX*i)+10, topY, pitWidth, pitHeight));

        pits.add(new RoundRectangle2D.Double(x+(topX*7), y+ OFFSET_FROM_BORDER/2, pitWidth, BOARD_HEIGHT-OFFSET_FROM_BORDER, 60, 60));// Add Player 1 Mancala at index 0

        for (int i = 6; i > 0; i--)                                                 // Bottom Row Row Pits
            pits.add(new Ellipse2D.Double(x+(topX*i)+10, baseY, pitWidth, pitHeight));

    }

    void attachMouseListener(MouseListener l)
    {
        addMouseListener(l);
    }

    int insideShape(Point2D p)
    {
        int result = -1;
        for (int i = 0; i < pits.size(); i++)
            if (pits.get(i).contains(p))
                return i;
        return result;
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        g2.setStroke(new BasicStroke(3));
        for (Shape e: pits)
            g2.draw(e);
        RoundRectangle2D boundary = new RoundRectangle2D.Double(x, y, BOARD_WIDTH,BOARD_HEIGHT,100,100);
        g2.setStroke(new BasicStroke(5));
        setBackground(backgroundColor);
        g2.draw(boundary);
    }
}
