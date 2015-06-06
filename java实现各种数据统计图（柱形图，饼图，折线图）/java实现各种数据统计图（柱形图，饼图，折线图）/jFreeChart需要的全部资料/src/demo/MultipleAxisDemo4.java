



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class MultipleAxisDemo4 extends ApplicationFrame
{

    public MultipleAxisDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(600, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart()
    {
        XYDataset xydataset = createDataset("March 2007", 100D, new Day(1, 3, 2007), 31);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 4", "Date", "Value", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setOrientation(PlotOrientation.VERTICAL);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setDateFormatOverride(new SimpleDateFormat("d-MMM-yyyy"));
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.red);
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setTickLabelPaint(Color.red);
        DateAxis dateaxis1 = new DateAxis("Date");
        dateaxis1.setDateFormatOverride(new SimpleDateFormat("d-MMM-yyyy"));
        xyplot.setDomainAxis(1, dateaxis1);
        xyplot.setDomainAxisLocation(1, AxisLocation.TOP_OR_LEFT);
        NumberAxis numberaxis1 = new NumberAxis("Value");
        numberaxis1.setAutoRangeIncludesZero(false);
        numberaxis1.setTickLabelPaint(Color.blue);
        xyplot.setRangeAxis(1, numberaxis1);
        xyplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        XYDataset xydataset1 = createDataset("July 2007", 1000D, new Day(1, 7, 2007), 31);
        xyplot.setDataset(1, xydataset1);
        xyplot.mapDatasetToDomainAxis(1, 1);
        xyplot.mapDatasetToRangeAxis(1, 1);
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer(true, false);
        xylineandshaperenderer.setSeriesPaint(0, Color.blue);
        xyplot.setRenderer(1, xylineandshaperenderer);
        return jfreechart;
    }

    private static XYDataset createDataset(String s, double d, RegularTimePeriod regulartimeperiod, int i)
    {
        TimeSeries timeseries = new TimeSeries(s, regulartimeperiod.getClass());
        RegularTimePeriod regulartimeperiod1 = regulartimeperiod;
        double d1 = d;
        for(int j = 0; j < i; j++)
        {
            timeseries.add(regulartimeperiod1, d1);
            regulartimeperiod1 = regulartimeperiod1.next();
            d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
        }

        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        MultipleAxisDemo4 multipleaxisdemo4 = new MultipleAxisDemo4("JFreeChart: MultipleAxisDemo4.java");
        multipleaxisdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(multipleaxisdemo4);
        multipleaxisdemo4.setVisible(true);
    }
}
