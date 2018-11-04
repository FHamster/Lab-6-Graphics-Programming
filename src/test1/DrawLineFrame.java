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
    private final JCheckBox SinCheckBox = new JCheckBox("Sin(x)", false);
    private final JCheckBox CosCheckBox = new JCheckBox("Cos(x)", false);
    private final JCheckBox ComplexCheckBox = new JCheckBox("Sin(x) + Cos(x)", false);

    public DrawLineFrame() //throws HeadlessException
    {
//        get screen size
        Toolkit toolKit = Toolkit.getDefaultToolkit();
        Dimension screenSize = toolKit.getScreenSize();

//        setting Frame size
        setSize(screenSize.width / 3, screenSize.height / 3);

//        initialize CheckBox Panel
        JPanel checkBoxPanel = new JPanel();

//        add CheckBox into Panel
        checkBoxPanel.add(SinCheckBox);
        checkBoxPanel.add(CosCheckBox);
        checkBoxPanel.add(ComplexCheckBox);

//        initialize component
        DrawLineComponent drawLineComponent = new DrawLineComponent();

//        associate actions with buttons
        SinCheckBox.addItemListener(e ->
        {
            String gName = "Sin";
            if (((JCheckBox) e.getItem()).isSelected())
            {
                drawLineComponent.addGraph(gName, new GetSinPoints());
            } else
            {
                drawLineComponent.subGraph(gName);
            }
        });
        CosCheckBox.addItemListener(e ->
        {
            String gName = "Cos";
            if (((JCheckBox) e.getItem()).isSelected())
            {
                drawLineComponent.addGraph(gName, new GetCosPoints());
            } else
            {
                drawLineComponent.subGraph(gName);
            }
        });
        ComplexCheckBox.addItemListener(e ->
        {
            String gName = "Sin+Cos";
            if (((JCheckBox) e.getItem()).isSelected())
            {
                drawLineComponent.addGraph(gName, new GetComplexPoints());
            } else
            {
                drawLineComponent.subGraph(gName);
            }
        });

//        add Panel into Frame
        add(checkBoxPanel, BorderLayout.NORTH);
        add(drawLineComponent, BorderLayout.CENTER);
    }
}

class DrawLineComponent extends JComponent
{
    private HashMap<String, List<Line2D>> graphs;

    public DrawLineComponent()
    {
        graphs = new HashMap<>();
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        Graphics2D g2 = (Graphics2D) g;
        for (List<Line2D> x : graphs.values())
        {
            for (Line2D it : x)
            {
                g2.draw(it);
            }
        }
    }

    public void subGraph(String gName)
    {
        graphs.remove(gName);
        repaint();
    }

    public void addGraph(String gName, GetPoints getPoints)
    {
        List<Point2D> points = getPoints.createPoint(100, 200);
        graphs.put(gName, makeLineFromPoint(points));
        repaint();
    }

    private List<Line2D> makeLineFromPoint(List<Point2D> points)
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