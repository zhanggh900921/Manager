



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYErrorRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYErrorRendererDemo2 extends ApplicationFrame
{

    public XYErrorRendererDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        NumberAxis numberaxis = new NumberAxis("X");
        NumberAxis numberaxis1 = new NumberAxis("Y");
        XYErrorRenderer xyerrorrenderer = new XYErrorRenderer();
        xyerrorrenderer.setBaseLinesVisible(true);
        xyerrorrenderer.setBaseShapesVisible(false);
        XYPlot xyplot = new XYPlot(intervalxydataset, numberaxis, numberaxis1, xyerrorrenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        JFreeChart jfreechart = new JFreeChart("XYErrorRenderer Demo 2", xyplot);
        jfreechart.setBackgroundPaint(Color.white);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        YIntervalSeriesCollection yintervalseriescollection = new YIntervalSeriesCollection();
        YIntervalSeries yintervalseries = new YIntervalSeries("Series 1");
        yintervalseries.add(1.0D, 10D, 9D, 11D);
        yintervalseries.add(10D, 6.0999999999999996D, 4.3399999999999999D, 7.54D);
        yintervalseries.add(17.800000000000001D, 4.5D, 3.1000000000000001D, 5.7999999999999998D);
        YIntervalSeries yintervalseries1 = new YIntervalSeries("Series 2");
        yintervalseries1.add(3D, 7D, 6D, 8D);
        yintervalseries1.add(13D, 13D, 11.5D, 14.5D);
        yintervalseries1.add(24D, 16.100000000000001D, 14.34D, 17.539999999999999D);
        yintervalseriescollection.addSeries(yintervalseries);
        yintervalseriescollection.addSeries(yintervalseries1);
        return yintervalseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYErrorRendererDemo2 xyerrorrendererdemo2 = new XYErrorRendererDemo2("JFreeChart: XYErrorRendererDemo2");
        xyerrorrendererdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xyerrorrendererdemo2);
        xyerrorrendererdemo2.setVisible(true);
    }
}
