



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.LogarithmicAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class LogarithmicAxisDemo1 extends ApplicationFrame
{

    public LogarithmicAxisDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Logarithmic Axis Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        LogarithmicAxis logarithmicaxis = new LogarithmicAxis("X");
        LogarithmicAxis logarithmicaxis1 = new LogarithmicAxis("Y");
        xyplot.setDomainAxis(logarithmicaxis);
        xyplot.setRangeAxis(logarithmicaxis1);
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
        xyseries.add(21.899999999999999D, 9005.5D);
        xyseries.add(25.600000000000001D, 734.39999999999998D);
        xyseries.add(3000D, 453.19999999999999D);
        return new XYSeriesCollection(xyseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LogarithmicAxisDemo1 logarithmicaxisdemo1 = new LogarithmicAxisDemo1("Logarithmic Axis Demo 1");
        logarithmicaxisdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(logarithmicaxisdemo1);
        logarithmicaxisdemo1.setVisible(true);
    }
}
