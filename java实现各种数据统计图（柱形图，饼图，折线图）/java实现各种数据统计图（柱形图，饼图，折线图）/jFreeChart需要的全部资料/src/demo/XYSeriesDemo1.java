



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYSeriesDemo1 extends ApplicationFrame
{

    public XYSeriesDemo1(String s)
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
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XY Series Demo", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Random Data");
        xyseries.add(1.0D, 500.19999999999999D);
        xyseries.add(5D, 694.10000000000002D);
        xyseries.add(4D, 100D);
        xyseries.add(12.5D, 734.39999999999998D);
        xyseries.add(17.300000000000001D, 453.19999999999999D);
        xyseries.add(21.199999999999999D, 500.19999999999999D);
        xyseries.add(21.899999999999999D, null);
        xyseries.add(25.600000000000001D, 734.39999999999998D);
        xyseries.add(30D, 453.19999999999999D);
        return new XYSeriesCollection(xyseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYSeriesDemo1 xyseriesdemo1 = new XYSeriesDemo1("XY Series Demo");
        xyseriesdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xyseriesdemo1);
        xyseriesdemo1.setVisible(true);
    }
}
