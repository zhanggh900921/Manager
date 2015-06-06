



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class DeviationRendererDemo1 extends ApplicationFrame
{

    public DeviationRendererDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static XYDataset createDataset()
    {
        YIntervalSeries yintervalseries = new YIntervalSeries("Series 1");
        YIntervalSeries yintervalseries1 = new YIntervalSeries("Series 2");
        double d = 100D;
        double d1 = 100D;
        for(int i = 0; i <= 100; i++)
        {
            d = (d + Math.random()) - 0.47999999999999998D;
            double d2 = 0.050000000000000003D * (double)i;
            yintervalseries.add(i, d, d - d2, d + d2);
            d1 = (d1 + Math.random()) - 0.5D;
            double d3 = 0.070000000000000007D * (double)i;
            yintervalseries1.add(i, d1, d1 - d3, d1 + d3);
        }

        YIntervalSeriesCollection yintervalseriescollection = new YIntervalSeriesCollection();
        yintervalseriescollection.addSeries(yintervalseries);
        yintervalseriescollection.addSeries(yintervalseries1);
        return yintervalseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("DeviationRenderer - Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        DeviationRenderer deviationrenderer = new DeviationRenderer(true, false);
        deviationrenderer.setSeriesStroke(0, new BasicStroke(3F, 1, 1));
        deviationrenderer.setSeriesStroke(0, new BasicStroke(3F, 1, 1));
        deviationrenderer.setSeriesStroke(1, new BasicStroke(3F, 1, 1));
        deviationrenderer.setSeriesFillPaint(0, new Color(255, 200, 200));
        deviationrenderer.setSeriesFillPaint(1, new Color(200, 200, 255));
        xyplot.setRenderer(deviationrenderer);
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        DeviationRendererDemo1 deviationrendererdemo1 = new DeviationRendererDemo1("JFreeChart : DeviationRendererDemo1");
        deviationrendererdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(deviationrendererdemo1);
        deviationrendererdemo1.setVisible(true);
    }
}
