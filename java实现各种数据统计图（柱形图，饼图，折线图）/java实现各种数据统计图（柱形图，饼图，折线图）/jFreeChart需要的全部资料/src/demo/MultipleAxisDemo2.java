



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class MultipleAxisDemo2 extends ApplicationFrame
{

    public MultipleAxisDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(600, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart()
    {
        XYDataset xydataset = createDataset("Series 1", 100D, new Minute(), 200);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Multiple Axis Demo 2", "Time of Day", "Primary Range Axis", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setOrientation(PlotOrientation.VERTICAL);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesPaint(0, Color.black);
        xyitemrenderer.setSeriesPaint(1, Color.black);
        NumberAxis numberaxis = new NumberAxis("Domain Axis 2");
        numberaxis.setAutoRangeIncludesZero(false);
        xyplot.setDomainAxis(1, numberaxis);
        NumberAxis numberaxis1 = new NumberAxis("Range Axis 2");
        xyplot.setRangeAxis(1, numberaxis1);
        xyplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        XYDataset xydataset1 = createDataset("Series 2", 1000D, new Minute(), 170);
        xyplot.setDataset(1, xydataset1);
        xyplot.mapDatasetToDomainAxis(1, 1);
        xyplot.mapDatasetToRangeAxis(1, 1);
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
        MultipleAxisDemo2 multipleaxisdemo2 = new MultipleAxisDemo2("Multiple Axis Demo 2");
        multipleaxisdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(multipleaxisdemo2);
        multipleaxisdemo2.setVisible(true);
    }
}
