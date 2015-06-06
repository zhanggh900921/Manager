



package demo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class SampleXYZDataset extends AbstractXYZDataset
    implements XYZDataset
{

    public SampleXYZDataset()
    {
    }

    public int getSeriesCount()
    {
        return 1;
    }

    public Comparable getSeriesKey(int i)
    {
        return "Series 1";
    }

    public int getItemCount(int i)
    {
        return xVal.length;
    }

    public Number getX(int i, int j)
    {
        return new Double(xVal[j]);
    }

    public Number getY(int i, int j)
    {
        return new Double(yVal[j]);
    }

    public Number getZ(int i, int j)
    {
        return new Double(zVal[j]);
    }

    private double xVal[] = {
        2.1000000000000001D, 2.3756249999999999D, 2.3756249999999999D, 2.2329287259999999D, 2.2329287259999999D, 1.860415253D, 1.8408426680000001D, 1.9054152529999999D, 2.3360294119999998D, 3.7999999999999998D
    };
    private double yVal[] = {
        14.167999999999999D, 11.156000000000001D, 10.089D, 8.8840000000000003D, 8.7189999999999994D, 8.4659999999999993D, 5.4889999999999999D, 4.1070000000000002D, 4.101D, 25D
    };
    private double zVal[] = {
        2.4500000000000002D, 2.7912857139999998D, 2.7912857139999998D, 2.2124999999999999D, 2.2124999999999999D, 2.2200000000000002D, 2.1000000000000001D, 2.2200000000000002D, 1.6487499999999999D, 4D
    };
}
