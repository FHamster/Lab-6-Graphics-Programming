package test1.getpoints;

import java.awt.geom.Point2D;
import java.util.ArrayList;

public class GetSinPoints implements GetPoints
{
    @Override
    public ArrayList<Point2D> createPoint(double startX, double startY)
    {
        ArrayList<Point2D> sinPoints = new ArrayList<>();
        double x, y;
        double segment;
        int n = 1000;
        for (int i = 0; i < 8 * n; i++)
        {
            segment = (double) i / n;
            x = 2 * Math.PI * segment;
            y = Math.sin(x);
            sinPoints.add(new Point2D.Double(startX + x * 70, startY + y * 70));
        }
        return sinPoints;
    }
}
