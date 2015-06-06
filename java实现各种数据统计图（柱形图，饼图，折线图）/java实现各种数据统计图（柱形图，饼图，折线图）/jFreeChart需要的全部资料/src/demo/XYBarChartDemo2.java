



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.ClusteredXYBarRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo2 extends ApplicationFrame
{

    public XYBarChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static IntervalXYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Series 1", org.jfree.data.time.Day.class);
        timeseries.add(new Day(1, 1, 2003), 54.299999999999997D);
        timeseries.add(new Day(2, 1, 2003), 20.300000000000001D);
        timeseries.add(new Day(3, 1, 2003), 43.399999999999999D);
        timeseries.add(new Day(4, 1, 2003), -12D);
        TimeSeries timeseries1 = new TimeSeries("Series 2", org.jfree.data.time.Day.class);
        timeseries1.add(new Day(1, 1, 2003), 8D);
        timeseries1.add(new Day(2, 1, 2003), 16D);
        timeseries1.add(new Day(3, 1, 2003), 21D);
        timeseries1.add(new Day(4, 1, 2003), 5D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        timeseriescollection.addSeries(timeseries1);
        return timeseriescollection;
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("XY Bar Chart Demo 2", "Date", true, "Y", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        ClusteredXYBarRenderer clusteredxybarrenderer = new ClusteredXYBarRenderer(0.0D, false);
        xyplot.setRenderer(clusteredxybarrenderer);
        clusteredxybarrenderer.setDrawBarOutline(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBarChartDemo2 xybarchartdemo2 = new XYBarChartDemo2("XY Bar Chart Demo 2");
        xybarchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo2);
        xybarchartdemo2.setVisible(true);
    }
}
