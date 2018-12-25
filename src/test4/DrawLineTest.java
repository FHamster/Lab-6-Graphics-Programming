package test4;

import javax.swing.*;
import java.awt.*;

class DrawPanelTest
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            DrawPanelFrame frame = new DrawPanelFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
