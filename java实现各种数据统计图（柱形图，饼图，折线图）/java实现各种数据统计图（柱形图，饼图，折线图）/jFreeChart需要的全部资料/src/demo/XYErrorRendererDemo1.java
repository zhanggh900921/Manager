



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

public class XYErrorRendererDemo1 extends ApplicationFrame
{

    public XYErrorRendererDemo1(String s)
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
        XYPlot xyplot = new XYPlot(intervalxydataset, numberaxis, numberaxis1, xyerrorrenderer);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        JFreeChart jfreechart = new JFreeChart("XYErrorRenderer Demo 1", xyplot);
        jfreechart.setBackgroundPaint(Color.white);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        XYIntervalSeriesCollection xyintervalseriescollection = new XYIntervalSeriesCollection();
        XYIntervalSeries xyintervalseries = new XYIntervalSeries("Series 1");
        xyintervalseries.add(1.0D, 0.5D, 1.5D, 10D, 9D, 11D);
        xyintervalseries.add(10D, 8.6999999999999993D, 11.210000000000001D, 6.0999999999999996D, 4.3399999999999999D, 7.54D);
        xyintervalseries.add(17.800000000000001D, 16D, 18.899999999999999D, 4.5D, 3.1000000000000001D, 5.7999999999999998D);
        XYIntervalSeries xyintervalseries1 = new XYIntervalSeries("Series 2");
        xyintervalseries1.add(3D, 2.5D, 3.5D, 7D, 6D, 8D);
        xyintervalseries1.add(13D, 11.5D, 14.5D, 13D, 11.5D, 14.5D);
        xyintervalseries1.add(24D, 22.699999999999999D, 25.210000000000001D, 16.100000000000001D, 14.34D, 17.539999999999999D);
        xyintervalseriescollection.addSeries(xyintervalseries);
        xyintervalseriescollection.addSeries(xyintervalseries1);
        return xyintervalseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYErrorRendererDemo1 xyerrorrendererdemo1 = new XYErrorRendererDemo1("XYErrorRenderer Example");
        xyerrorrendererdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xyerrorrendererdemo1);
        xyerrorrendererdemo1.setVisible(true);
    }
}
