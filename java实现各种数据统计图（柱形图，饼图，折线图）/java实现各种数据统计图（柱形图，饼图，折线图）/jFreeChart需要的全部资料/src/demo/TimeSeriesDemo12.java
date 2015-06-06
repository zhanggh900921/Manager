



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class TimeSeriesDemo12 extends ApplicationFrame
{

    public TimeSeriesDemo12(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Sample Chart", "Date", "Value", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(false);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        if(xyitemrenderer instanceof StandardXYItemRenderer)
        {
            StandardXYItemRenderer standardxyitemrenderer = (StandardXYItemRenderer)xyitemrenderer;
            standardxyitemrenderer.setBaseShapesVisible(true);
            standardxyitemrenderer.setShapesFilled(true);
            xyitemrenderer.setSeriesStroke(0, new BasicStroke(2.0F));
            xyitemrenderer.setSeriesStroke(1, new BasicStroke(2.0F));
        }
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("hh:mma"));
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        TimeSeries timeseries = new TimeSeries("Series 1", org.jfree.data.time.Minute.class);
        timeseries.add(new Minute(0, 0, 7, 12, 2003), 1.2D);
        timeseries.add(new Minute(30, 12, 7, 12, 2003), 3D);
        timeseries.add(new Minute(15, 14, 7, 12, 2003), 8D);
        TimeSeries timeseries1 = new TimeSeries("Series 2", org.jfree.data.time.Minute.class);
        timeseries1.add(new Minute(0, 3, 7, 12, 2003), 0.0D);
        timeseries1.add(new Minute(30, 9, 7, 12, 2003), 0.0D);
        timeseries1.add(new Minute(15, 10, 7, 12, 2003), 0.0D);
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.addSeries(timeseries1);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo12 timeseriesdemo12 = new TimeSeriesDemo12("Time Series Demo 12");
        timeseriesdemo12.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo12);
        timeseriesdemo12.setVisible(true);
    }
}
