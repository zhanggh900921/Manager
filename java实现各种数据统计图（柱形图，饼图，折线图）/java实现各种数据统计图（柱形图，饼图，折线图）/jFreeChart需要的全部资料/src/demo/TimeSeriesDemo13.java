



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class TimeSeriesDemo13 extends ApplicationFrame
{

    public TimeSeriesDemo13(String s)
    {
        super(s);
        setContentPane(createDemoPanel());
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Weekly Data", "Date", "Value", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        org.jfree.chart.renderer.xy.XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        if(xyitemrenderer instanceof StandardXYItemRenderer)
        {
            StandardXYItemRenderer standardxyitemrenderer = (StandardXYItemRenderer)xyitemrenderer;
            standardxyitemrenderer.setBaseShapesVisible(true);
            standardxyitemrenderer.setShapesFilled(true);
        }
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        TickUnits tickunits = new TickUnits();
        tickunits.add(new DateTickUnit(2, 1, new SimpleDateFormat("MMM dd ''yy")));
        tickunits.add(new DateTickUnit(2, 7, new SimpleDateFormat("MMM dd ''yy")));
        tickunits.add(new DateTickUnit(1, 1, new SimpleDateFormat("MMM ''yy")));
        dateaxis.setStandardTickUnits(tickunits);
        return jfreechart;
    }

    private static XYDataset createDataset(int i)
    {
        TimeSeries timeseries = new TimeSeries("Random Data", org.jfree.data.time.Week.class);
        Object obj = new Week();
        double d = 100D;
        for(int j = 0; j < i; j++)
        {
            timeseries.add(((RegularTimePeriod) (obj)), d);
            d *= 1.0D + (Math.random() - 0.499D) / 100D;
            obj = ((RegularTimePeriod) (obj)).next();
        }

        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        XYDataset xydataset = createDataset(26);
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        XYDataset xydataset1 = createDataset(1);
        JFreeChart jfreechart1 = createChart(xydataset1);
        ChartPanel chartpanel1 = new ChartPanel(jfreechart1);
        JTabbedPane jtabbedpane = new JTabbedPane();
        jtabbedpane.add("Chart 1", chartpanel);
        jtabbedpane.add("Chart 2", chartpanel1);
        JPanel jpanel = new JPanel(new BorderLayout());
        jpanel.setPreferredSize(new Dimension(500, 270));
        jpanel.add(jtabbedpane);
        return jpanel;
    }

    public static void main(String args[])
    {
        TimeSeriesDemo13 timeseriesdemo13 = new TimeSeriesDemo13("Time Series Demo 13");
        timeseriesdemo13.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo13);
        timeseriesdemo13.setVisible(true);
    }
}
