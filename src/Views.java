import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Views extends JPanel
{
    private static final int BOARD_WIDTH = 700;
    private static final int BOARD_HEIGHT = 300;
    private static final int OFFSET_FROM_BORDER = 30;
    private JPanel player1 = new JPanel();
    private JPanel player2 = new JPanel();

    Views()
    {
        add(player1, "West");
        add(player2, "East");
    }

    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;
        Container parent = getParent();
        int x = (parent.getWidth()-BOARD_WIDTH)/2;
        int y = (parent.getHeight()-BOARD_HEIGHT)/2;
        RoundRectangle2D boundary = new RoundRectangle2D.Double(x, y, BOARD_WIDTH,BOARD_HEIGHT,100,100);
        
        Ellipse2D.Double a1= new Ellipse2D.Double(x+((BOARD_WIDTH/8))+10   , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double a2= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*2)+10 , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double a3= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*3)+10 , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double a4= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*4)+10 , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double a5= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*5)+10 , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double a6= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*6)+10 , y+OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        
        Ellipse2D.Double b1= new Ellipse2D.Double(x+((BOARD_WIDTH/8))+10   , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double b2= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*2)+10 , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double b3= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*3)+10 , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double b4= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*4)+10 , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double b5= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*5)+10 , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        Ellipse2D.Double b6= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*6)+10 , y+((BOARD_HEIGHT*2)/3)-OFFSET_FROM_BORDER , BOARD_WIDTH / 10, BOARD_HEIGHT / 3);
        
        Ellipse2D.Double mancalaA= new Ellipse2D.Double(x+((BOARD_WIDTH/8)*7) , y+ OFFSET_FROM_BORDER/2 , BOARD_WIDTH / 10, BOARD_HEIGHT-OFFSET_FROM_BORDER );
        Ellipse2D.Double mancalaB= new Ellipse2D.Double(x+20 , y+ OFFSET_FROM_BORDER/2, BOARD_WIDTH / 10, BOARD_HEIGHT-OFFSET_FROM_BORDER);
        
        
        g2.draw(a1);
        g2.draw(a2);
        g2.draw(a3);
        g2.draw(a4);
        g2.draw(a5);
        g2.draw(a6);
        g2.draw(b1);
        g2.draw(b2);
        g2.draw(b3);
        g2.draw(b4);
        g2.draw(b5);
        g2.draw(b6);
        g2.draw(mancalaA);
        g2.draw(mancalaB);
        g2.setStroke(new BasicStroke(5));
        g2.draw(boundary);
    }
}
