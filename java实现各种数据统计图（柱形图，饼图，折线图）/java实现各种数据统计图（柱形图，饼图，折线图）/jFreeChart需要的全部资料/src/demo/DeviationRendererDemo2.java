



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.DeviationRenderer;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.time.Week;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class DeviationRendererDemo2 extends ApplicationFrame
{

    public DeviationRendererDemo2(String s)
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
        Object obj = new Week();
        double d = 100D;
        double d1 = 100D;
        for(int i = 0; i <= 52; i++)
        {
            double d2 = 0.050000000000000003D * (double)i;
            yintervalseries.add(((RegularTimePeriod) (obj)).getFirstMillisecond(), d, d - d2, d + d2);
            d = (d + Math.random()) - 0.45000000000000001D;
            double d3 = 0.070000000000000007D * (double)i;
            yintervalseries1.add(((RegularTimePeriod) (obj)).getFirstMillisecond(), d1, d1 - d3, d1 + d3);
            d1 = (d1 + Math.random()) - 0.55000000000000004D;
            obj = ((RegularTimePeriod) (obj)).next();
        }

        YIntervalSeriesCollection yintervalseriescollection = new YIntervalSeriesCollection();
        yintervalseriescollection.addSeries(yintervalseries);
        yintervalseriescollection.addSeries(yintervalseries1);
        return yintervalseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Projected Values - Test", "Date", "Index Projection", xydataset, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setInsets(new RectangleInsets(5D, 5D, 5D, 20D));
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
        DeviationRendererDemo2 deviationrendererdemo2 = new DeviationRendererDemo2("JFreeChart : DeviationRendererDemo2");
        deviationrendererdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(deviationrendererdemo2);
        deviationrendererdemo2.setVisible(true);
    }
}
