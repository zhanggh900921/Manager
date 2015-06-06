



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class TimeSeriesDemo14 extends ApplicationFrame
{

    public TimeSeriesDemo14(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Bug Report Submissions for Java", "Date", "Evaluation ID", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        if(xyitemrenderer instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyitemrenderer;
            xylineandshaperenderer.setBaseShapesVisible(true);
            xylineandshaperenderer.setBaseShapesFilled(true);
            xylineandshaperenderer.setUseFillPaint(true);
            xylineandshaperenderer.setBaseFillPaint(Color.white);
        }
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Bugs");
        timeseries.add(new Day(27, 6, 2005), 478474D);
        timeseries.add(new Day(24, 1, 2006), 633804D);
        timeseries.add(new Day(28, 4, 2006), 694096D);
        timeseries.add(new Day(12, 5, 2006), 704680D);
        timeseries.add(new Day(16, 5, 2006), 709599D);
        timeseries.add(new Day(21, 6, 2006), 734754D);
        timeseries.add(new Day(27, 7, 2006), 760008D);
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
        TimeSeriesDemo14 timeseriesdemo14 = new TimeSeriesDemo14("Time Series Demo 14");
        timeseriesdemo14.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo14);
        timeseriesdemo14.setVisible(true);
    }
}
