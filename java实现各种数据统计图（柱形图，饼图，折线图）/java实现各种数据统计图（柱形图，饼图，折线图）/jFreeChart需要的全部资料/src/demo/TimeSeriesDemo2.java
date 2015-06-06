



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.ValueMarker;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo2 extends ApplicationFrame
{

    public TimeSeriesDemo2(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Quarterly Data", org.jfree.data.time.Quarter.class);
        timeseries.add(new Quarter(1, 2001), 500.19999999999999D);
        timeseries.add(new Quarter(2, 2001), 694.10000000000002D);
        timeseries.add(new Quarter(3, 2001), 734.39999999999998D);
        timeseries.add(new Quarter(4, 2001), 453.19999999999999D);
        timeseries.add(new Quarter(1, 2002), 500.19999999999999D);
        timeseries.add(new Quarter(2, 2002), null);
        timeseries.add(new Quarter(3, 2002), 734.39999999999998D);
        timeseries.add(new Quarter(4, 2002), 453.19999999999999D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Demo 2", "Time", "Value", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.addRangeMarker(new ValueMarker(550D));
        Quarter quarter = new Quarter(2, 2002);
        xyplot.addDomainMarker(new ValueMarker(quarter.getMiddleMillisecond()));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo2 timeseriesdemo2 = new TimeSeriesDemo2("Time Series Demo 2");
        timeseriesdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo2);
        timeseriesdemo2.setVisible(true);
    }
}
