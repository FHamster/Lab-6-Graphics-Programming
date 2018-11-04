package test1;

import test1.getpoints.GetPoints;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.List;

class DrawLineAction implements ActionListener
{
    private final List<Point2D> points;
    private final DrawLineComponent component;


    public DrawLineAction(GetPoints getPoints, DrawLineComponent component)
    {
        this.points = getPoints.createPoint(0, 200);
        this.component = component;
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        component.repaintComponent(points);
    }
}
