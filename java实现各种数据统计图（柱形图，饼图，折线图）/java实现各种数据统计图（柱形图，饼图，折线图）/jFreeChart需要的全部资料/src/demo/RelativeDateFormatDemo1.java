



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class RelativeDateFormatDemo1 extends ApplicationFrame
{

    public RelativeDateFormatDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Exercise Chart", "Elapsed Time", "Beats Per Minute", xydataset, true, true, false);
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
        }
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        Minute minute = new Minute(0, 9, 1, 10, 2006);
        RelativeDateFormat relativedateformat = new RelativeDateFormat(minute.getFirstMillisecond());
        relativedateformat.setSecondFormatter(new DecimalFormat("00"));
        dateaxis.setDateFormatOverride(relativedateformat);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Heart Rate", org.jfree.data.time.Second.class);
        timeseries.add(new Second(45, 6, 9, 1, 10, 2006), 143D);
        timeseries.add(new Second(33, 8, 9, 1, 10, 2006), 167D);
        timeseries.add(new Second(10, 10, 9, 1, 10, 2006), 189D);
        timeseries.add(new Second(19, 12, 9, 1, 10, 2006), 156D);
        timeseries.add(new Second(5, 15, 9, 1, 10, 2006), 176D);
        timeseries.add(new Second(12, 16, 9, 1, 10, 2006), 183D);
        timeseries.add(new Second(6, 18, 9, 1, 10, 2006), 138D);
        timeseries.add(new Second(11, 20, 9, 1, 10, 2006), 102D);
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
        RelativeDateFormatDemo1 relativedateformatdemo1 = new RelativeDateFormatDemo1("JFreeChart - RelativeDateFormatDemo1");
        relativedateformatdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(relativedateformatdemo1);
        relativedateformatdemo1.setVisible(true);
    }
}
