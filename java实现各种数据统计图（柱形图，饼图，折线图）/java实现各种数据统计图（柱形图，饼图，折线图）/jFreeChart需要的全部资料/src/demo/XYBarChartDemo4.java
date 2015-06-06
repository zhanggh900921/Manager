



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo4 extends ApplicationFrame
{

    public XYBarChartDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("XYBarChartDemo4", "X", false, "Y", intervalxydataset, PlotOrientation.VERTICAL, true, false, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)xyplot.getDomainAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        xyplot.setRangeAxis(new LogarithmicAxis("Log(y)"));
        XYBarRenderer xybarrenderer = (XYBarRenderer)xyplot.getRenderer();
        xybarrenderer.setDrawBarOutline(false);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(1.0D, 5D);
        xyseries.add(2D, 70.799999999999997D);
        xyseries.add(3D, 900.29999999999995D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        return new XYBarDataset(xyseriescollection, 0.90000000000000002D);
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBarChartDemo4 xybarchartdemo4 = new XYBarChartDemo4("XY Bar Chart Demo 4");
        xybarchartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo4);
        xybarchartdemo4.setVisible(true);
    }
}
