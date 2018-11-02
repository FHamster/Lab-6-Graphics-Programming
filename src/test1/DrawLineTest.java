package test1;

import javax.swing.*;
import java.awt.*;

class DrawLineTest
{

    public static void main(String[] args)
    {
        EventQueue.invokeLater(() ->
        {
            DrawLineFrame frame = new DrawLineFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}
