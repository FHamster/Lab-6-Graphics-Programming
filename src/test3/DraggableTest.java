package test3;

import test1.DrawLineFrame;

import javax.swing.*;
import java.awt.*;

public class DraggableTest
{
    public static void main(String[] args)
    {
        EventQueue.invokeLater(()->{
            DraggableFrame frame = new DraggableFrame();
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            frame.setVisible(true);
        });
    }
}

class DraggableFrame extends DrawLineFrame
{

}
