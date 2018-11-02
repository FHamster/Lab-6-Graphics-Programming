package test1.getpoints;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GetComplexPoints implements GetPoints
{
    @Override
    public ArrayList<Point2D> createPoint()
    {
        ArrayList<Point2D> complexPoints = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            complexPoints.add(new Point2D.Double(i, 100 + 50 * (Math.sin(i) + Math.cos(i))));
        }
        return complexPoints;
    }
}
