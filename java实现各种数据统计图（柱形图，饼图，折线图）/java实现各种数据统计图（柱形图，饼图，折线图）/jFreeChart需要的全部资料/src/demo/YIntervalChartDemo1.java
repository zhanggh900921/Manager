



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.YIntervalRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class YIntervalChartDemo1 extends ApplicationFrame
{

    public YIntervalChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Y Interval Chart Demo", "X", "Y", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(4D, 4D, 4D, 4D));
        xyplot.setRenderer(new YIntervalRenderer());
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        double d = 100D;
        YIntervalSeries yintervalseries = new YIntervalSeries("Series 1");
        for(int i = 0; i < 100; i++)
        {
            d += Math.random() - 0.48999999999999999D;
            yintervalseries.add(i, d, d - 3D, d + 3D);
        }

        YIntervalSeriesCollection yintervalseriescollection = new YIntervalSeriesCollection();
        yintervalseriescollection.addSeries(yintervalseries);
        return yintervalseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        YIntervalChartDemo1 yintervalchartdemo1 = new YIntervalChartDemo1("Y Interval Chart Demo");
        yintervalchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(yintervalchartdemo1);
        yintervalchartdemo1.setVisible(true);
    }
}
