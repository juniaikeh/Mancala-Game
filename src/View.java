import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.MouseListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import java.util.ArrayList;

public class View extends JPanel implements ChangeListener
{
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 300;
    private static final int OFFSET_FROM_BORDER = 30;
    private static final double pitWidth = BOARD_WIDTH / 10;
    private static final double pitHeight = BOARD_HEIGHT / 3;
    private int x = (App.FRAME_WIDTH-BOARD_WIDTH)/2;
    private int y = (App.FRAME_HEIGHT-BOARD_HEIGHT)/2;
    private ArrayList<Shape> pits;
    private Color backgroundColor;
    private ArrayList<Integer> stoneCount;
    private Model model;

    View(Model m, Color col)
    {
        model = m;
        stoneCount = m.getStoneCount();
        pits = new ArrayList<>();
        backgroundColor = col;
        double topX = BOARD_WIDTH/8;
        double baseY = y + OFFSET_FROM_BORDER;

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
        g2.setFont(new Font("default", Font.BOLD, 20));
        for (int i = 0; i < pits.size(); i++)
        {
            Shape e = pits.get(i);
            Rectangle bound = e.getBounds();
            g2.draw(e);
            if (i != 0 && i != 7)
            {
                String s = (i < 7 ? "A":"B") + String.valueOf(i%7);
                int sy = (int)(bound.getCenterY() + (i < 7 ? pitHeight/2+20 : -(pitHeight/2+5)));
                g2.drawString(s, (int)bound.getCenterX()-10, sy);
            }
            int count = stoneCount.get(i);
            Ellipse2D stone;
            double row = bound.getCenterX()-12;
            double col = bound.getCenterY()-(count/2.5)*12;
            int colCount = 0;
            int rowCount = 0;
            for (int j = 0; j < count; j++)
            {
                col += colCount++ % 2 == 0 ? 14 : 0;
                double x = rowCount++ % 2 == 0 ? row + 14 : row;
                stone = new Ellipse2D.Double(x, col, 10,10);
                g2.fill(stone);
            }
        }
        String[] s1 = {"M","A","N","C","A","L","A"," ", "A"};
        int sx = x-30;
        for (int i = 1; i <= s1.length; i++)
            g2.drawString(s1[i-1], sx, y + 32*i);
        s1[s1.length-1] = "B";
        sx = x + BOARD_WIDTH + 20;
        for (int i = 1; i <= s1.length; i++)
            g2.drawString(s1[i-1], sx, y + 32*i);
        RoundRectangle2D boundary = new RoundRectangle2D.Double(x, y, BOARD_WIDTH,BOARD_HEIGHT,100,100);
        g2.setStroke(new BasicStroke(5));
        setBackground(backgroundColor);
        g2.draw(boundary);
    }

    public void stateChanged(ChangeEvent e)
    {
        stoneCount = model.getStoneCount();
        repaint();
    }
}
