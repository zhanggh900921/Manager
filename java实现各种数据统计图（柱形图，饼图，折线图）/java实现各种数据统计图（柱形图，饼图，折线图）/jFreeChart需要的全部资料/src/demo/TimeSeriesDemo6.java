



package demo;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo6 extends ApplicationFrame
{

    public TimeSeriesDemo6(String s)
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
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Demo 6", "Date", "Value", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        ValueAxis valueaxis = xyplot.getRangeAxis();
        valueaxis.setAutoRangeMinimumSize(1.0D);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        double d = 0.0D;
        TimeSeries timeseries = new TimeSeries("Series 1", org.jfree.data.time.Month.class);
        timeseries.add(new Month(2, 2001), d);
        timeseries.add(new Month(3, 2001), d);
        timeseries.add(new Month(4, 2001), d);
        timeseries.add(new Month(5, 2001), d);
        timeseries.add(new Month(6, 2001), d);
        timeseries.add(new Month(7, 2001), d);
        timeseries.add(new Month(8, 2001), d);
        timeseries.add(new Month(9, 2001), d);
        timeseries.add(new Month(10, 2001), d);
        timeseries.add(new Month(11, 2001), d);
        timeseries.add(new Month(12, 2001), d);
        timeseries.add(new Month(1, 2002), d);
        timeseries.add(new Month(2, 2002), d);
        timeseries.add(new Month(3, 2002), d);
        timeseries.add(new Month(4, 2002), d);
        timeseries.add(new Month(5, 2002), d);
        timeseries.add(new Month(6, 2002), d);
        timeseries.add(new Month(7, 2002), d);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo6 timeseriesdemo6 = new TimeSeriesDemo6("Time Series Demo 6");
        timeseriesdemo6.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo6);
        timeseriesdemo6.setVisible(true);
    }
}
