



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.AxisState;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTick;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.Day;
import org.jfree.data.time.TimeSeries;
import org.jfree.data.time.TimeSeriesCollection;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.HorizontalAlignment;
import org.jfree.ui.RectangleEdge;
import org.jfree.ui.RectangleInsets;
import org.jfree.ui.RefineryUtilities;
import org.jfree.ui.TextAnchor;

public class YieldCurveDemo extends ApplicationFrame
{
    static class CustomDateAxis extends DateAxis
    {

        public java.util.List refreshTicks(Graphics2D graphics2d, AxisState axisstate, Rectangle2D rectangle2d, RectangleEdge rectangleedge)
        {
            ArrayList arraylist = new ArrayList();
            GregorianCalendar gregoriancalendar = new GregorianCalendar();
            gregoriancalendar.setTime(base);
            gregoriancalendar.add(2, 1);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "1M", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(2, 5);
            gregoriancalendar.add(2, 6);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "1Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(1, 1);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "2Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(1, 1);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "3Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(1, 2);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "5Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(1, 5);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "10Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            gregoriancalendar.add(1, 10);
            arraylist.add(new DateTick(gregoriancalendar.getTime(), "20Y", TextAnchor.TOP_CENTER, TextAnchor.CENTER, 0.0D));
            return arraylist;
        }

        private Date base;

        public CustomDateAxis(String s, Date date)
        {
            super(s);
            base = date;
        }
    }


    public YieldCurveDemo(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("US$ Treasury Yields", "Date", "Yield", xydataset, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        GregorianCalendar gregoriancalendar = new GregorianCalendar(2005, 10, 15);
        xyplot.setDomainAxis(new CustomDateAxis("Date", gregoriancalendar.getTime()));
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
        dateaxis.setDateFormatOverride(new SimpleDateFormat("MMM-yyyy"));
        jfreechart.addSubtitle(new TextTitle("November 2005"));
        TextTitle texttitle = new TextTitle("Source: http://www.econstats.com/r/r_am1.htm");
        texttitle.setFont(new Font("Dialog", 0, 9));
        texttitle.setPosition(RectangleEdge.BOTTOM);
        texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jfreechart.addSubtitle(texttitle);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("US$ Treasury Yields");
        Day day = new Day(1, 12, 2005);
        Day day1 = new Day(1, 2, 2006);
        Day day2 = new Day(1, 5, 2006);
        Day day3 = new Day(1, 12, 2006);
        Day day4 = new Day(1, 12, 2007);
        Day day5 = new Day(1, 12, 2008);
        Day day6 = new Day(1, 12, 2010);
        Day day7 = new Day(1, 12, 2012);
        Day day8 = new Day(1, 12, 2015);
        Day day9 = new Day(1, 12, 2025);
        timeseries.add(day, 3.79D);
        timeseries.add(day1, 3.9950000000000001D);
        timeseries.add(day2, 4.2599999999999998D);
        timeseries.add(day3, 4.3224999999999998D);
        timeseries.add(day4, 4.4474999999999998D);
        timeseries.add(day5, 4.4749999999999996D);
        timeseries.add(day6, 4.5199999999999996D);
        timeseries.add(day7, 4.5599999999999996D);
        timeseries.add(day8, 4.625D);
        timeseries.add(day9, 4.9050000000000002D);
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
        YieldCurveDemo yieldcurvedemo = new YieldCurveDemo("Yield Curve Demo");
        yieldcurvedemo.pack();
        RefineryUtilities.centerFrameOnScreen(yieldcurvedemo);
        yieldcurvedemo.setVisible(true);
    }
}
