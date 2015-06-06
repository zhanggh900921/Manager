



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo10 extends ApplicationFrame
{

    public TimeSeriesDemo10(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Demo 10", "Time", "Value", xydataset, true, true, false);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Per Minute Data", org.jfree.data.time.Minute.class);
        Hour hour = new Hour();
        timeseries.add(new Minute(1, hour), 10.199999999999999D);
        timeseries.add(new Minute(3, hour), 17.300000000000001D);
        timeseries.add(new Minute(9, hour), 14.6D);
        timeseries.add(new Minute(11, hour), 11.9D);
        timeseries.add(new Minute(15, hour), 13.5D);
        timeseries.add(new Minute(19, hour), 10.9D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo10 timeseriesdemo10 = new TimeSeriesDemo10("Time Series Demo 10");
        timeseriesdemo10.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo10);
        timeseriesdemo10.setVisible(true);
    }
}
