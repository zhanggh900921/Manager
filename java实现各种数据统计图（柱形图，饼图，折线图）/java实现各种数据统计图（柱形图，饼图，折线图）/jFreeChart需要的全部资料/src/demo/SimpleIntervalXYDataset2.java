



package demo;

import org.jfree.data.general.DatasetChangeListener;
import org.jfree.data.xy.AbstractIntervalXYDataset;
import org.jfree.data.xy.IntervalXYDataset;

public class SimpleIntervalXYDataset2 extends AbstractIntervalXYDataset
    implements IntervalXYDataset
{

    public SimpleIntervalXYDataset2(int i)
    {
        yEnd = new Double[3];
        xValues = new Double[3];
        xValues = new Double[i];
        yStart = new Double[i];
        yEnd = new Double[i];
        double d = 100D;
        for(int j = 1; j <= i; j++)
        {
            xValues[j - 1] = new Double(j);
            d *= 1.0D + (Math.random() / 10D - 0.050000000000000003D);
            yStart[j - 1] = new Double(d);
            yEnd[j - 1] = new Double(yStart[j - 1].doubleValue() + Math.random() * 30D);
        }

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
        return xValues.length;
    }

    public Number getX(int i, int j)
    {
        return xValues[j];
    }

    public Number getY(int i, int j)
    {
        return yEnd[j];
    }

    public Number getStartX(int i, int j)
    {
        return xValues[j];
    }

    public Number getEndX(int i, int j)
    {
        return xValues[j];
    }

    public Number getStartY(int i, int j)
    {
        return yStart[j];
    }

    public Number getEndY(int i, int j)
    {
        return yEnd[j];
    }

    public void addChangeListener(DatasetChangeListener datasetchangelistener)
    {
    }

    public void removeChangeListener(DatasetChangeListener datasetchangelistener)
    {
    }

    private Double yStart[];
    private Double yEnd[];
    private Double xValues[];
}
