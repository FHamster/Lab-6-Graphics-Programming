package test1.getpoints;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GetSinPoints implements GetPoints
{
    @Override
    public ArrayList<Point2D> createPoint()
    {
        ArrayList<Point2D> sinPoints = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            sinPoints.add(new Point2D.Double(4*i, 100 + 50 * Math.sin(i)));
        }
        return sinPoints;
    }
}
