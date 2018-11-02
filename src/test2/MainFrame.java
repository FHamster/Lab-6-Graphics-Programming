package test2;

import javax.swing.*;
import java.awt.*;

import test1.DrawLineFrame;

class MainFrame extends JFrame
{

    //menu bar
    private final JMenuBar menuBar;
    private final JMenu projectMenu;

    //frame
    private DrawLineFrame drawLineFrame;

    public MainFrame()
    {
        setTitle("DialogTest");
        Toolkit toolkit = Toolkit.getDefaultToolkit();
        setSize(toolkit.getScreenSize().width / 2, toolkit.getScreenSize().height / 2);

        //menu bar
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);
        projectMenu = new JMenu("Project");
        menuBar.add(projectMenu);

        //add menu item into menu
        //曲线演示、打开文件、退出
        JMenuItem demonItem = new JMenuItem("Demonstrate...");
        JMenuItem openItem = new JMenuItem("Open...");
        JMenuItem exitItem = new JMenuItem("Exit");
        projectMenu.add(demonItem);
        projectMenu.add(openItem);
        projectMenu.add(exitItem);
        //associate action with menu item
        demonItem.addActionListener(event ->
        {
            if (drawLineFrame == null)
            {
                drawLineFrame = new DrawLineFrame();
                drawLineFrame.setVisible(true);
            }
        });

        exitItem.addActionListener(event -> System.exit(0));
    }
}
