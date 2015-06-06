



package demo;

import org.jfree.data.xy.AbstractXYZDataset;
import org.jfree.data.xy.XYZDataset;

public class SampleXYZDataset2 extends AbstractXYZDataset
    implements XYZDataset
{

    public SampleXYZDataset2()
    {
    }

    public int getSeriesCount()
    {
        return xVal.length;
    }

    public Comparable getSeriesKey(int i)
    {
        return "Series " + i;
    }

    public int getItemCount(int i)
    {
        return xVal[0].length;
    }

    public Number getX(int i, int j)
    {
        return new Double(xVal[i][j]);
    }

    public Number getY(int i, int j)
    {
        return new Double(yVal[i][j]);
    }

    public Number getZ(int i, int j)
    {
        return new Double(zVal[i][j]);
    }

    private double xVal[][] = {
        {
            1.0D, 2D, 3D
        }, {
            4D, 5D, 6D
        }
    };
    private double yVal[][] = {
        {
            1.0D, 2D, 3D
        }, {
            4D, 5D, 6D
        }
    };
    private double zVal[][] = {
        {
            1.1000000000000001D, 2.2000000000000002D, 3.2999999999999998D
        }, {
            4.4000000000000004D, 5.5D, 6.5999999999999996D
        }
    };
}
