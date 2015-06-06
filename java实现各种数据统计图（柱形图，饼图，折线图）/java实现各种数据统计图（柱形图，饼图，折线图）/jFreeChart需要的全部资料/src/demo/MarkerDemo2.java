



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class MarkerDemo2 extends ApplicationFrame
{

    public MarkerDemo2(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setDomainZoomable(true);
        chartpanel.setRangeZoomable(true);
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Marker Demo 2", "X", "Temperature", xydataset, PlotOrientation.VERTICAL, false, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setDomainGridlinePaint(Color.lightGray);
        xyplot.setDomainGridlineStroke(new BasicStroke(1.0F));
        xyplot.setRangeGridlinePaint(Color.lightGray);
        xyplot.setRangeGridlineStroke(new BasicStroke(1.0F));
        xyplot.setRangeTickBandPaint(new Color(240, 240, 240));
        PeriodAxis periodaxis = new PeriodAxis(null, new Hour(0, 30, 6, 2005), new Hour(23, 30, 6, 2005));
        PeriodAxisLabelInfo aperiodaxislabelinfo[] = new PeriodAxisLabelInfo[2];
        aperiodaxislabelinfo[0] = new PeriodAxisLabelInfo(org.jfree.data.time.Hour.class, new SimpleDateFormat("HH"));
        aperiodaxislabelinfo[1] = new PeriodAxisLabelInfo(org.jfree.data.time.Day.class, new SimpleDateFormat("dd-MMM"));
        periodaxis.setLabelInfo(aperiodaxislabelinfo);
        xyplot.setDomainAxis(periodaxis);
        ValueAxis valueaxis = xyplot.getRangeAxis();
        valueaxis.setRange(0.0D, 100D);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.green);
        xyitemrenderer.setSeriesStroke(0, new BasicStroke(2.0F));
        ValueMarker valuemarker = new ValueMarker(80D);
        valuemarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valuemarker.setPaint(Color.red);
        valuemarker.setStroke(new BasicStroke(2.0F));
        valuemarker.setLabel("Temperature Threshold");
        valuemarker.setLabelFont(new Font("SansSerif", 0, 11));
        valuemarker.setLabelPaint(Color.red);
        valuemarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        valuemarker.setLabelTextAnchor(TextAnchor.BOTTOM_LEFT);
        xyplot.addRangeMarker(valuemarker);
        Hour hour = new Hour(18, 30, 6, 2005);
        Hour hour1 = new Hour(20, 30, 6, 2005);
        double d = hour.getFirstMillisecond();
        double d1 = hour1.getFirstMillisecond();
        IntervalMarker intervalmarker = new IntervalMarker(d, d1);
        intervalmarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        intervalmarker.setPaint(new Color(150, 150, 255));
        intervalmarker.setLabel("Automatic Cooling");
        intervalmarker.setLabelFont(new Font("SansSerif", 0, 11));
        intervalmarker.setLabelPaint(Color.blue);
        intervalmarker.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        intervalmarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xyplot.addDomainMarker(intervalmarker, Layer.BACKGROUND);
        ValueMarker valuemarker1 = new ValueMarker(d, Color.blue, new BasicStroke(2.0F));
        ValueMarker valuemarker2 = new ValueMarker(d1, Color.blue, new BasicStroke(2.0F));
        xyplot.addDomainMarker(valuemarker1, Layer.BACKGROUND);
        xyplot.addDomainMarker(valuemarker2, Layer.BACKGROUND);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        TimeSeries timeseries = new TimeSeries("Temperature", org.jfree.data.time.Hour.class);
        timeseries.add(new Hour(0, 30, 6, 2005), 45.299999999999997D);
        timeseries.add(new Hour(1, 30, 6, 2005), 48.899999999999999D);
        timeseries.add(new Hour(2, 30, 6, 2005), 52.100000000000001D);
        timeseries.add(new Hour(3, 30, 6, 2005), 44.799999999999997D);
        timeseries.add(new Hour(4, 30, 6, 2005), 49.899999999999999D);
        timeseries.add(new Hour(5, 30, 6, 2005), 55.5D);
        timeseries.add(new Hour(6, 30, 6, 2005), 58.200000000000003D);
        timeseries.add(new Hour(7, 30, 6, 2005), 58.100000000000001D);
        timeseries.add(new Hour(8, 30, 6, 2005), 63.700000000000003D);
        timeseries.add(new Hour(9, 30, 6, 2005), 66.299999999999997D);
        timeseries.add(new Hour(10, 30, 6, 2005), 69.799999999999997D);
        timeseries.add(new Hour(11, 30, 6, 2005), 70.099999999999994D);
        timeseries.add(new Hour(12, 30, 6, 2005), 72.400000000000006D);
        timeseries.add(new Hour(13, 30, 6, 2005), 69.700000000000003D);
        timeseries.add(new Hour(14, 30, 6, 2005), 68.599999999999994D);
        timeseries.add(new Hour(15, 30, 6, 2005), 70.900000000000006D);
        timeseries.add(new Hour(16, 30, 6, 2005), 73.400000000000006D);
        timeseries.add(new Hour(17, 30, 6, 2005), 77.5D);
        timeseries.add(new Hour(18, 30, 6, 2005), 82.900000000000006D);
        timeseries.add(new Hour(19, 30, 6, 2005), 62.100000000000001D);
        timeseries.add(new Hour(20, 30, 6, 2005), 37.299999999999997D);
        timeseries.add(new Hour(21, 30, 6, 2005), 40.700000000000003D);
        timeseries.add(new Hour(22, 30, 6, 2005), 44.200000000000003D);
        timeseries.add(new Hour(23, 30, 6, 2005), 49.799999999999997D);
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
        MarkerDemo2 markerdemo2 = new MarkerDemo2("Marker Demo 2");
        markerdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(markerdemo2);
        markerdemo2.setVisible(true);
    }
}
