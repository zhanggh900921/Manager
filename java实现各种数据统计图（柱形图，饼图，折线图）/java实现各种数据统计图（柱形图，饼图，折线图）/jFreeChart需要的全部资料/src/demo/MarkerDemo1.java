



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYDrawableAnnotation;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

// Referenced classes of package demo:
//            CircleDrawer

public class MarkerDemo1 extends ApplicationFrame
{

    public MarkerDemo1(String s)
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
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Marker Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        LegendTitle legendtitle = (LegendTitle)jfreechart.getSubtitle(0);
        legendtitle.setPosition(RectangleEdge.RIGHT);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.getRenderer().setBaseToolTipGenerator(StandardXYToolTipGenerator.getTimeSeriesInstance());
        DateAxis dateaxis = new DateAxis("Time");
        dateaxis.setUpperMargin(0.5D);
        xyplot.setDomainAxis(dateaxis);
        ValueAxis valueaxis = xyplot.getRangeAxis();
        valueaxis.setUpperMargin(0.29999999999999999D);
        valueaxis.setLowerMargin(0.5D);
        ValueMarker valuemarker = new ValueMarker(200D);
        valuemarker.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valuemarker.setPaint(Color.green);
        valuemarker.setLabel("Bid Start Price");
        valuemarker.setLabelAnchor(RectangleAnchor.BOTTOM_RIGHT);
        valuemarker.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xyplot.addRangeMarker(valuemarker);
        ValueMarker valuemarker1 = new ValueMarker(175D);
        valuemarker1.setLabelOffsetType(LengthAdjustmentType.EXPAND);
        valuemarker1.setPaint(Color.red);
        valuemarker1.setLabel("Target Price");
        valuemarker1.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        valuemarker1.setLabelTextAnchor(TextAnchor.BOTTOM_RIGHT);
        xyplot.addRangeMarker(valuemarker1);
        Hour hour = new Hour(2, new Day(22, 5, 2003));
        double d = hour.getFirstMillisecond();
        ValueMarker valuemarker2 = new ValueMarker(d);
        valuemarker2.setPaint(Color.orange);
        valuemarker2.setLabel("Original Close (02:00)");
        valuemarker2.setLabelAnchor(RectangleAnchor.TOP_LEFT);
        valuemarker2.setLabelTextAnchor(TextAnchor.TOP_RIGHT);
        xyplot.addDomainMarker(valuemarker2);
        Minute minute = new Minute(15, hour);
        d = minute.getFirstMillisecond();
        ValueMarker valuemarker3 = new ValueMarker(d);
        valuemarker3.setPaint(Color.red);
        valuemarker3.setLabel("Close Date (02:15)");
        valuemarker3.setLabelAnchor(RectangleAnchor.TOP_RIGHT);
        valuemarker3.setLabelTextAnchor(TextAnchor.TOP_LEFT);
        xyplot.addDomainMarker(valuemarker3);
        Hour hour1 = new Hour(2, new Day(22, 5, 2003));
        Minute minute1 = new Minute(10, hour1);
        d = minute1.getFirstMillisecond();
        CircleDrawer circledrawer = new CircleDrawer(Color.red, new BasicStroke(1.0F), null);
        XYDrawableAnnotation xydrawableannotation = new XYDrawableAnnotation(d, 163D, 11D, 11D, circledrawer);
        xyplot.addAnnotation(xydrawableannotation);
        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Best Bid", d, 163D, 2.3561944901923448D);
        xypointerannotation.setBaseRadius(35D);
        xypointerannotation.setTipRadius(10D);
        xypointerannotation.setFont(new Font("SansSerif", 0, 9));
        xypointerannotation.setPaint(Color.blue);
        xypointerannotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xyplot.addAnnotation(xypointerannotation);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(createSupplier1Bids());
        timeseriescollection.addSeries(createSupplier2Bids());
        return timeseriescollection;
    }

    private static TimeSeries createSupplier1Bids()
    {
        Hour hour = new Hour(1, new Day(22, 5, 2003));
        TimeSeries timeseries = new TimeSeries("Supplier 1", org.jfree.data.time.Minute.class);
        timeseries.add(new Minute(13, hour), 200D);
        timeseries.add(new Minute(14, hour), 195D);
        timeseries.add(new Minute(45, hour), 190D);
        timeseries.add(new Minute(46, hour), 188D);
        timeseries.add(new Minute(47, hour), 185D);
        timeseries.add(new Minute(52, hour), 180D);
        return timeseries;
    }

    private static TimeSeries createSupplier2Bids()
    {
        Hour hour = new Hour(1, new Day(22, 5, 2003));
        Hour hour1 = (Hour)hour.next();
        TimeSeries timeseries = new TimeSeries("Supplier 2", org.jfree.data.time.Minute.class);
        timeseries.add(new Minute(25, hour), 185D);
        timeseries.add(new Minute(0, hour1), 175D);
        timeseries.add(new Minute(5, hour1), 170D);
        timeseries.add(new Minute(6, hour1), 168D);
        timeseries.add(new Minute(9, hour1), 165D);
        timeseries.add(new Minute(10, hour1), 163D);
        return timeseries;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        MarkerDemo1 markerdemo1 = new MarkerDemo1("Marker Demo 1");
        markerdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(markerdemo1);
        markerdemo1.setVisible(true);
    }
}
