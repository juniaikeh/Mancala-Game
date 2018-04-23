import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller
{
    private View v;
    private Model m;

    Controller(Model mo, View vi)
    {
        m = mo;
        v = vi;
        v.attachMouseListener(new mouseListener());
    }

    private class mouseListener extends MouseAdapter
    {
        public void mousePressed(MouseEvent e)
        {
            int result = v.insideShape(e.getPoint());
            if (result != -1)
            {
                System.out.println(result);
            }
        }
    }
}
