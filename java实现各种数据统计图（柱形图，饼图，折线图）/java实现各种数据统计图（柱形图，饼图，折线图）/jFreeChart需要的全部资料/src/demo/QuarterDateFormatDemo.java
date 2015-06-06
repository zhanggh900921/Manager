



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class QuarterDateFormatDemo extends ApplicationFrame
{

    public QuarterDateFormatDemo(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        PeriodAxis periodaxis = new PeriodAxis("Quarter", new Quarter(), new Quarter());
        periodaxis.setAutoRangeTimePeriodClass(org.jfree.data.time.Quarter.class);
        PeriodAxisLabelInfo aperiodaxislabelinfo[] = new PeriodAxisLabelInfo[1];
        aperiodaxislabelinfo[0] = new PeriodAxisLabelInfo(org.jfree.data.time.Quarter.class, new QuarterDateFormat(TimeZone.getDefault(), QuarterDateFormat.ROMAN_QUARTERS));
        periodaxis.setLabelInfo(aperiodaxislabelinfo);
        xyplot.setDomainAxis(periodaxis);
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
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("L&G European Index Trust", org.jfree.data.time.Month.class);
        timeseries.add(new Month(2, 2001), 181.80000000000001D);
        timeseries.add(new Month(3, 2001), 167.30000000000001D);
        timeseries.add(new Month(4, 2001), 153.80000000000001D);
        timeseries.add(new Month(5, 2001), 167.59999999999999D);
        timeseries.add(new Month(6, 2001), 158.80000000000001D);
        timeseries.add(new Month(7, 2001), 148.30000000000001D);
        timeseries.add(new Month(8, 2001), 153.90000000000001D);
        timeseries.add(new Month(9, 2001), 142.69999999999999D);
        timeseries.add(new Month(10, 2001), 123.2D);
        timeseries.add(new Month(11, 2001), 131.80000000000001D);
        timeseries.add(new Month(12, 2001), 139.59999999999999D);
        timeseries.add(new Month(1, 2002), 142.90000000000001D);
        timeseries.add(new Month(2, 2002), 138.69999999999999D);
        timeseries.add(new Month(3, 2002), 137.30000000000001D);
        timeseries.add(new Month(4, 2002), 143.90000000000001D);
        timeseries.add(new Month(5, 2002), 139.80000000000001D);
        timeseries.add(new Month(6, 2002), 137D);
        timeseries.add(new Month(7, 2002), 132.80000000000001D);
        TimeSeries timeseries1 = new TimeSeries("L&G UK Index Trust", org.jfree.data.time.Month.class);
        timeseries1.add(new Month(2, 2001), 129.59999999999999D);
        timeseries1.add(new Month(3, 2001), 123.2D);
        timeseries1.add(new Month(4, 2001), 117.2D);
        timeseries1.add(new Month(5, 2001), 124.09999999999999D);
        timeseries1.add(new Month(6, 2001), 122.59999999999999D);
        timeseries1.add(new Month(7, 2001), 119.2D);
        timeseries1.add(new Month(8, 2001), 116.5D);
        timeseries1.add(new Month(9, 2001), 112.7D);
        timeseries1.add(new Month(10, 2001), 101.5D);
        timeseries1.add(new Month(11, 2001), 106.09999999999999D);
        timeseries1.add(new Month(12, 2001), 110.3D);
        timeseries1.add(new Month(1, 2002), 111.7D);
        timeseries1.add(new Month(2, 2002), 111D);
        timeseries1.add(new Month(3, 2002), 109.59999999999999D);
        timeseries1.add(new Month(4, 2002), 113.2D);
        timeseries1.add(new Month(5, 2002), 111.59999999999999D);
        timeseries1.add(new Month(6, 2002), 108.8D);
        timeseries1.add(new Month(7, 2002), 101.59999999999999D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
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
        QuarterDateFormatDemo quarterdateformatdemo = new QuarterDateFormatDemo("Quarter Date Format Demo");
        quarterdateformatdemo.pack();
        RefineryUtilities.centerFrameOnScreen(quarterdateformatdemo);
        quarterdateformatdemo.setVisible(true);
    }
}
