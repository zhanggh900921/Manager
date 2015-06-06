



package demo;

import org.jfree.data.*;
import org.jfree.data.xy.AbstractXYDataset;
import org.jfree.data.xy.XYDataset;

public class SampleXYDataset2 extends AbstractXYDataset
    implements XYDataset, DomainInfo, RangeInfo
{

    public SampleXYDataset2()
    {
        this(4, 40);
    }

    public SampleXYDataset2(int i, int j)
    {
        xValues = new Double[i][j];
        yValues = new Double[i][j];
        seriesCount = i;
        itemCount = j;
        double d = (1.0D / 0.0D);
        double d1 = (-1.0D / 0.0D);
        double d2 = (1.0D / 0.0D);
        double d3 = (-1.0D / 0.0D);
        for(int k = 0; k < i; k++)
        {
            for(int l = 0; l < j; l++)
            {
                double d4 = (Math.random() - 0.5D) * 200D;
                xValues[k][l] = new Double(d4);
                if(d4 < d)
                    d = d4;
                if(d4 > d1)
                    d1 = d4;
                double d5 = (Math.random() + 0.5D) * 6D * d4 + d4;
                yValues[k][l] = new Double(d5);
                if(d5 < d2)
                    d2 = d5;
                if(d5 > d3)
                    d3 = d5;
            }

        }

        domainMin = new Double(d);
        domainMax = new Double(d1);
        domainRange = new Range(d, d1);
        rangeMin = new Double(d2);
        rangeMax = new Double(d3);
        range = new Range(d2, d3);
    }

    public Number getX(int i, int j)
    {
        return xValues[i][j];
    }

    public Number getY(int i, int j)
    {
        return yValues[i][j];
    }

    public int getSeriesCount()
    {
        return seriesCount;
    }

    public Comparable getSeriesKey(int i)
    {
        return "Sample " + i;
    }

    public int getItemCount(int i)
    {
        return itemCount;
    }

    public double getDomainLowerBound()
    {
        return domainMin.doubleValue();
    }

    public double getDomainLowerBound(boolean flag)
    {
        return domainMin.doubleValue();
    }

    public double getDomainUpperBound()
    {
        return domainMax.doubleValue();
    }

    public double getDomainUpperBound(boolean flag)
    {
        return domainMax.doubleValue();
    }

    public Range getDomainBounds()
    {
        return domainRange;
    }

    public Range getDomainBounds(boolean flag)
    {
        return domainRange;
    }

    public Range getDomainRange()
    {
        return domainRange;
    }

    public double getRangeLowerBound()
    {
        return rangeMin.doubleValue();
    }

    public double getRangeLowerBound(boolean flag)
    {
        return rangeMin.doubleValue();
    }

    public double getRangeUpperBound()
    {
        return rangeMax.doubleValue();
    }

    public double getRangeUpperBound(boolean flag)
    {
        return rangeMax.doubleValue();
    }

    public Range getRangeBounds(boolean flag)
    {
        return range;
    }

    public Range getValueRange()
    {
        return range;
    }

    public Number getMinimumDomainValue()
    {
        return domainMin;
    }

    public Number getMaximumDomainValue()
    {
        return domainMax;
    }

    public Number getMinimumRangeValue()
    {
        return domainMin;
    }

    public Number getMaximumRangeValue()
    {
        return domainMax;
    }

    private static final int DEFAULT_SERIES_COUNT = 4;
    private static final int DEFAULT_ITEM_COUNT = 40;
    private static final double DEFAULT_RANGE = 200D;
    private Double xValues[][];
    private Double yValues[][];
    private int seriesCount;
    private int itemCount;
    private Number domainMin;
    private Number domainMax;
    private Number rangeMin;
    private Number rangeMax;
    private Range domainRange;
    private Range range;
}
