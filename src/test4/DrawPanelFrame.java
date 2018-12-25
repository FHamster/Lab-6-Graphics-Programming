package test4;

import test1.getpoints.GetPoints;
import test1.getpoints.GetPointsImpl.GetComplexPoints;
import test1.getpoints.GetPointsImpl.GetCosPoints;
import test1.getpoints.GetPointsImpl.GetSinPoints;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DrawPanelFrame extends JFrame
{
    //    add button
    private final JCheckBox SinCheckBox = new JCheckBox("Sin(x)", false);
    private final JCheckBox CosCheckBox = new JCheckBox("Cos(x)", false);
    private final JCheckBox ComplexCheckBox = new JCheckBox("Sin(x) + Cos(x)", false);

    public DrawPanelFrame() //throws HeadlessException
    {
//        get screen size
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();

//        setting Frame size
        setSize(screenSize.width / 3, screenSize.height / 3);

//        initialize component
        DrawLineComponent drawLineComponent = new DrawLineComponent();

        add(drawLineComponent, BorderLayout.CENTER);
    }
}

class DrawLineComponent extends JComponent
{
    private HashMap<String, List<Point2D>> graphs;//save graph
    private Point2D curPoint;
    private int TotalGraph = 0;

//    private HashMap<String, List<Line2D>> graphs;

    public DrawLineComponent()
    {
        graphs = new HashMap<>();
        /* add component mouse event */
        MouseHandler handler = new MouseHandler();
        addMouseListener(handler);
        addMouseMotionListener(handler);
    }

    @Override
    public void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (List<Point2D> x : graphs.values())
        {
            for (Line2D it : makeLineFromPoint(x))
            {
                g2.draw(it);
            }
        }
    }

    public void addGraph(String gName, List<Point2D> points)
    {
        graphs.put(gName, points);
        repaint();
    }

    private List<Line2D> makeLineFromPoint(List<Point2D> points)
    {
       /* if (points.size() < 2)
        {
            throw new IllegalArgumentException("点的数小于2，size=" + points.size());
        }*/

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



    //    private class MouseMotionHandler extends MouseAdapter implements MouseMotionListener
    private class MouseHandler extends MouseAdapter implements MouseMotionListener
    {

        List<Point2D> curList;
        @Override
        public void mousePressed(MouseEvent e)
        {
            curList = new ArrayList<>();

            curList.add(e.getPoint());
            repaint();

            graphs.put(Integer.toString(TotalGraph++), curList);
        }

        @Override
        public void mouseDragged(MouseEvent e)
        {
            curList.add(e.getPoint());
            repaint();
        }

        @Override
        public void mouseReleased(MouseEvent e)
        {
            curList = null;

        }
    }
}