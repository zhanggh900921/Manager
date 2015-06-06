



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.TimeZone;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class PeriodAxisDemo2 extends ApplicationFrame
{

    public PeriodAxisDemo2(String s)
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
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Legal & General Unit Trust Prices", "Date", "Price Per Unit", xydataset, true, true, false);
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
            xylineandshaperenderer.setShapesVisible(true);
            xylineandshaperenderer.setShapesFilled(true);
            xylineandshaperenderer.setBaseItemLabelsVisible(true);
        }
        PeriodAxis periodaxis = new PeriodAxis("Date");
        periodaxis.setTimeZone(TimeZone.getTimeZone("Pacific/Auckland"));
        periodaxis.setAutoRangeTimePeriodClass(org.jfree.data.time.Day.class);
        PeriodAxisLabelInfo aperiodaxislabelinfo[] = new PeriodAxisLabelInfo[3];
        aperiodaxislabelinfo[0] = new PeriodAxisLabelInfo(org.jfree.data.time.Day.class, new SimpleDateFormat("d"));
        aperiodaxislabelinfo[1] = new PeriodAxisLabelInfo(org.jfree.data.time.Month.class, new SimpleDateFormat("MMM"), new RectangleInsets(2D, 2D, 2D, 2D), new Font("SansSerif", 1, 10), Color.blue, false, new BasicStroke(0.0F), Color.lightGray);
        aperiodaxislabelinfo[2] = new PeriodAxisLabelInfo(org.jfree.data.time.Year.class, new SimpleDateFormat("yyyy"));
        periodaxis.setLabelInfo(aperiodaxislabelinfo);
        xyplot.setDomainAxis(periodaxis);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("L&G European Index Trust");
        timeseries.add(new Day(24, 1, 2004), 181.80000000000001D);
        timeseries.add(new Day(25, 1, 2004), 167.30000000000001D);
        timeseries.add(new Day(26, 1, 2004), 153.80000000000001D);
        timeseries.add(new Day(27, 1, 2004), 167.59999999999999D);
        timeseries.add(new Day(28, 1, 2004), 158.80000000000001D);
        timeseries.add(new Day(29, 1, 2004), 148.30000000000001D);
        timeseries.add(new Day(30, 1, 2004), 153.90000000000001D);
        timeseries.add(new Day(31, 1, 2004), 142.69999999999999D);
        timeseries.add(new Day(1, 2, 2004), 123.2D);
        timeseries.add(new Day(2, 2, 2004), 131.80000000000001D);
        timeseries.add(new Day(3, 2, 2004), 139.59999999999999D);
        timeseries.add(new Day(4, 2, 2004), 142.90000000000001D);
        timeseries.add(new Day(5, 2, 2004), 138.69999999999999D);
        timeseries.add(new Day(6, 2, 2004), 137.30000000000001D);
        timeseries.add(new Day(7, 2, 2004), 143.90000000000001D);
        timeseries.add(new Day(8, 2, 2004), 139.80000000000001D);
        timeseries.add(new Day(9, 2, 2004), 137D);
        timeseries.add(new Day(10, 2, 2004), 132.80000000000001D);
        TimeZone timezone = TimeZone.getTimeZone("Pacific/Auckland");
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timezone);
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.setXPosition(TimePeriodAnchor.MIDDLE);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PeriodAxisDemo2 periodaxisdemo2 = new PeriodAxisDemo2("Period Axis Demo 2");
        periodaxisdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(periodaxisdemo2);
        periodaxisdemo2.setVisible(true);
    }
}
