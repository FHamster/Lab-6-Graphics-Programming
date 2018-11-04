package test1;

import test1.getpoints.*;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.util.*;
import java.util.List;

public class DrawLineFrame extends JFrame
{
    //    add button
    private final JCheckBox SinButton = new JCheckBox("Sin(x)");
    private final JCheckBox CosButton = new JCheckBox("Cos(x)");
    private final JCheckBox ComplexButton = new JCheckBox("Sin(x) + Cos(x)");

    public DrawLineFrame() //throws HeadlessException
    {
//        get screen size
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();

//        setting Frame size
        setSize(screenSize.width / 3, screenSize.height / 3);

//        initialize button Panel
        //    button panel
        //    add panel
        JPanel buttonPanel = new JPanel();

//        add button into Panel
        buttonPanel.add(SinButton);
        buttonPanel.add(CosButton);
        buttonPanel.add(ComplexButton);

//        create button action
        ArrayList<Point2D> points = new ArrayList<>();
        points.add(new Point2D.Double(0, 0));
        points.add(new Point2D.Double(0, 100));
        points.add(new Point2D.Double(100, 100));
        points.add(new Point2D.Double(100, 0));
        points.add(new Point2D.Double(0, 0));
        DrawLineComponent drawLineComponent = new DrawLineComponent(points);

        //initial getPoint interface
//          sin
        DrawLineAction sinAction = new DrawLineAction(new GetSinPoints(), drawLineComponent);
//          cos
        DrawLineAction cosAction = new DrawLineAction(new GetCosPoints(), drawLineComponent);
//          sin + cos
        DrawLineAction complexAction = new DrawLineAction(new GetComplexPoints(), drawLineComponent);

//        associate actions with buttons
        SinButton.addActionListener(sinAction);
        CosButton.addActionListener(cosAction);
        ComplexButton.addActionListener(complexAction);

//        add Panel into Frame
        add(buttonPanel, BorderLayout.NORTH);
        add(drawLineComponent, BorderLayout.CENTER);
    }
}
class DrawLineComponent extends JComponent
{
    private List<Line2D> lines;

    public DrawLineComponent(java.util.List<Point2D> points)
    {
        this.lines = makeLineFromPoint(points);
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (Line2D x : lines)
        {
            g2.draw(x);
        }
    }

    public void repaintComponent(java.util.List<Point2D> points)
    {
        this.lines = makeLineFromPoint(points);
        repaint();
    }

    private java.util.List<Line2D> makeLineFromPoint(java.util.List<Point2D> points)
    {
        if (points.size() < 2)
        {
            throw new IllegalArgumentException("点的数小于2，size=" + points.size());
        }

        List<Line2D> lines = new ArrayList<>();
        Line2D tempLine;
        for (int i = 0; i < points.size() - 1; i++)
        {
            Point2D p1 = points.get(i);
            Point2D p2 = points.get(i + 1);
            tempLine = new Line2D.Double(p1, p2);
            lines.add(tempLine);
        }
        return lines;
    }
}