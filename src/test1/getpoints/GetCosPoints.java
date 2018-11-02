package test1.getpoints;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GetCosPoints implements GetPoints
{
    @Override
    public ArrayList<Point2D> createPoint()
    {
        ArrayList<Point2D> cosPoints = new ArrayList<>();
        for (int i = 0; i < 1000; i++)
        {
            cosPoints.add(new Point2D.Double(i, 100 + 50 * Math.cos(i)));
        }
        return cosPoints;
    }
}
