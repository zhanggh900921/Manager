



package demo;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Collections;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.time.FixedMillisecond;
import org.jfree.data.time.Millisecond;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;

public class PerformanceTest1 extends ApplicationFrame
{

    public PerformanceTest1(String s)
    {
        super(s);
        timings = new TimeSeries("Timings", org.jfree.data.time.Millisecond.class);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timings);
        JFreeChart jfreechart = createChart(timeseriescollection);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Performance Test 1", "Time", "Milliseconds", xydataset, true, true, false);
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
            standardxyitemrenderer.setSeriesStroke(0, new BasicStroke(1.1F));
        }
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(null);
        return new ChartPanel(jfreechart);
    }

    public void addObservation(long l)
    {
        timings.addOrUpdate(new Millisecond(), l);
    }

    public static void main2(String as[])
    {
        PerformanceTest1 performancetest1 = new PerformanceTest1("Performance Test 1");
        performancetest1.pack();
        RefineryUtilities.centerFrameOnScreen(performancetest1);
        performancetest1.setVisible(true);
        TimeSeries timeseries = new TimeSeries("Test", org.jfree.data.time.Millisecond.class);
        timeseries.setMaximumItemAge(200L);
        do
        {
            Millisecond millisecond = new Millisecond();
            long l = System.currentTimeMillis();
            for(int i = 0; i < 200; i++)
            {
                millisecond = (Millisecond)millisecond.next();
                timeseries.addOrUpdate(millisecond, 1.0D);
            }

            long l1 = System.currentTimeMillis();
            performancetest1.addObservation(l1 - l);
        } while(true);
    }

    public static void main4(String as[])
    {
        TimeSeries timeseries = new TimeSeries("Test");
        timeseries.setMaximumItemCount(4000);
        FixedMillisecond fixedmillisecond = new FixedMillisecond();
        for(int i = 0; i < 40000; i++)
        {
            long l = System.currentTimeMillis();
            for(int j = 0; j < 400; j++)
            {
                fixedmillisecond = (FixedMillisecond)fixedmillisecond.next();
                timeseries.add(fixedmillisecond, Math.random());
            }

            long l1 = System.currentTimeMillis();
            System.out.println(i + " --> " + (l1 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }

    }

    public static void main5(String as[])
    {
        XYSeries xyseries = new XYSeries("Test");
        xyseries.setMaximumItemCount(4000);
        int i = 0;
        for(int j = 0; j < 40000; j++)
        {
            long l = System.currentTimeMillis();
            for(int k = 0; k < 4000; k++)
                xyseries.add(i++, Math.random());

            long l1 = System.currentTimeMillis();
            System.out.println(j + " --> " + (l1 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }

    }

    public static void main(String args[])
    {
        ArrayList arraylist = new ArrayList();
        for(int i = 0; i < 4000; i++)
            arraylist.add(new Double(Math.random()));

        int j = 0;
        for(int k = 0; k < 20000; k++)
        {
            long l = System.currentTimeMillis();
            for(int i1 = 0; i1 < 0xf4240; i1++)
                j += i1;

            long l1 = System.currentTimeMillis();
            System.out.println(k + " --> " + (l1 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }

    }

    public static void main3(String as[])
    {
        ArrayList arraylist = new ArrayList();
        Millisecond millisecond = new Millisecond();
        for(int i = 0; i < 200; i++)
        {
            millisecond = (Millisecond)millisecond.next();
            arraylist.add(millisecond);
        }

        for(int j = 0; j < 2000; j++)
        {
            long l = System.currentTimeMillis();
            Collections.binarySearch(arraylist, new Millisecond());
            long l1 = System.currentTimeMillis();
            System.out.println(j + " --> " + (l1 - l) + " (" + Runtime.getRuntime().freeMemory() + " / " + Runtime.getRuntime().totalMemory() + ")");
        }

    }

    private TimeSeries timings;
}
