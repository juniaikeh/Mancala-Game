import javax.swing.*;
import java.awt.*;

class ThemeSelect
{
    private Color theme;
    private int count;
    ThemeSelect()
    {
        Object[] vals = {"Classic", "Cyan", "Yellow", "Red", "Green", "Magenta"};
        String choice = (String)JOptionPane.showInputDialog(null, "Choose Theme", "Theme Chooser", JOptionPane.INFORMATION_MESSAGE, null, vals, vals[0]);
        switch (choice)
        {
            case "Yellow":
                theme = Color.yellow;
                break;

            case "Cyan":
                theme = Color.CYAN;
                break;

            case "Classic":
                theme = Color.lightGray;
                break;

            case "Red":
                theme = Color.red;
                break;

            case "Green":
                theme = Color.GREEN;
                break;

            case "Magenta":
                theme = Color.magenta;
                break;
        }
        Object[] sC = {3,4};
        count = (int)JOptionPane.showInputDialog(null, "Game Customization","Starting Stone Count", JOptionPane.INFORMATION_MESSAGE, null, sC, sC[0]);
    }

    Color getTheme()
    {
        return theme;
    }

    int getCount()
    {
        return count;
    }
}
