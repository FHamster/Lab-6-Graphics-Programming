package test1.getpoints.GetPointsImpl;

import test1.getpoints.GetPoints;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

public class GetCosPoints implements GetPoints
{
    @Override
    public List<Point2D> createPoint(double startX, double startY)
    {
        ArrayList<Point2D> sinPoints = new ArrayList<>();
        double x, y;
        double segment;
        int n = 1000;
        for (int i = 0; i < 4 * n; i++)
        {
            segment = (double) i / n;
            x = 2 * Math.PI * segment;
            y = Math.cos(x);
            sinPoints.add(new Point2D.Double(startX + x * 70, startY + y * 70));
        }
        return sinPoints;
    }
}
