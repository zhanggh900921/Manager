



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XIntervalSeriesCollectionDemo1 extends ApplicationFrame
{

    public XIntervalSeriesCollectionDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static IntervalXYDataset createDataset()
    {
        XIntervalSeriesCollection xintervalseriescollection = new XIntervalSeriesCollection();
        XIntervalSeries xintervalseries = new XIntervalSeries("S1");
        return xintervalseriescollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        DateAxis dateaxis = new DateAxis("Date");
        NumberAxis numberaxis = new NumberAxis("Y");
        XYBarRenderer xybarrenderer = new XYBarRenderer();
        xybarrenderer.setUseYInterval(true);
        XYPlot xyplot = new XYPlot(intervalxydataset, dateaxis, numberaxis, xybarrenderer);
        JFreeChart jfreechart = new JFreeChart(xyplot);
        jfreechart.setBackgroundPaint(Color.white);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setDomainGridlinesVisible(true);
        xyplot.setRangeGridlinePaint(Color.white);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XIntervalSeriesCollectionDemo1 xintervalseriescollectiondemo1 = new XIntervalSeriesCollectionDemo1("Demo 1");
        xintervalseriescollectiondemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xintervalseriescollectiondemo1);
        xintervalseriescollectiondemo1.setVisible(true);
    }
}
