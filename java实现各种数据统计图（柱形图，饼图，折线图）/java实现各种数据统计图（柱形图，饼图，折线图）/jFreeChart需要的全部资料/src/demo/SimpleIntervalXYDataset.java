



package demo;

import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class SimpleIntervalXYDataset extends AbstractIntervalXYDataset
    implements IntervalXYDataset
{

    public SimpleIntervalXYDataset()
    {
        xStart = new Double[3];
        xEnd = new Double[3];
        yValues = new Double[3];
        xStart[0] = new Double(0.0D);
        xStart[1] = new Double(2D);
        xStart[2] = new Double(3.5D);
        xEnd[0] = new Double(2D);
        xEnd[1] = new Double(3.5D);
        xEnd[2] = new Double(4D);
        yValues[0] = new Double(3D);
        yValues[1] = new Double(4.5D);
        yValues[2] = new Double(2.5D);
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
        return 3;
    }

    public Number getX(int i, int j)
    {
        return xStart[j];
    }

    public Number getY(int i, int j)
    {
        return yValues[j];
    }

    public Number getStartX(int i, int j)
    {
        return xStart[j];
    }

    public Number getEndX(int i, int j)
    {
        return xEnd[j];
    }

    public Number getStartY(int i, int j)
    {
        return yValues[j];
    }

    public Number getEndY(int i, int j)
    {
        return yValues[j];
    }

    public void addChangeListener(DatasetChangeListener datasetchangelistener)
    {
    }

    public void removeChangeListener(DatasetChangeListener datasetchangelistener)
    {
    }

    private Double xStart[];
    private Double xEnd[];
    private Double yValues[];
}
