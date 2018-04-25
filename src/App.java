import javax.swing.*;

public class App
{
    static final int FRAME_WIDTH = 900;
    static final int FRAME_HEIGHT = 500;
    App()
    {
        ThemeSelect themeSelect = new ThemeSelect();
        Model m = new Model(themeSelect.getCount());
        View v = new View(m, themeSelect.getTheme());
        Controller c = new Controller(m,v);
        JFrame frame = new JFrame("Mancala Game");
        m.attach(v);
        frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
        frame.setResizable(false);
        frame.add(v, "Center");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
