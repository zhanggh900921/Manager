



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo2 extends ApplicationFrame
{

    public XYSeriesDemo2(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XY Series Demo 2", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        numberaxis.setAutoRangeMinimumSize(1.0D);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Flat Data");
        xyseries.add(1.0D, 100D);
        xyseries.add(5D, 100D);
        xyseries.add(4D, 100D);
        xyseries.add(12.5D, 100D);
        xyseries.add(17.300000000000001D, 100D);
        xyseries.add(21.199999999999999D, 100D);
        xyseries.add(21.899999999999999D, 100D);
        xyseries.add(25.600000000000001D, 100D);
        xyseries.add(30D, 100D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection(xyseries);
        return xyseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYSeriesDemo2 xyseriesdemo2 = new XYSeriesDemo2("XY Series Demo 2");
        xyseriesdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xyseriesdemo2);
        xyseriesdemo2.setVisible(true);
    }
}
