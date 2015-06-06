



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

public class LogarithmicAxisDemo2 extends ApplicationFrame
{

    public LogarithmicAxisDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Logarithmic Axis Demo 2", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        LogarithmicAxis logarithmicaxis = new LogarithmicAxis("X");
        logarithmicaxis.setExpTickLabelsFlag(true);
        logarithmicaxis.setStrictValuesFlag(false);
        LogarithmicAxis logarithmicaxis1 = new LogarithmicAxis("Y");
        logarithmicaxis1.setAllowNegativesFlag(true);
        logarithmicaxis1.setLog10TickLabelsFlag(true);
        xyplot.setDomainAxis(logarithmicaxis);
        xyplot.setRangeAxis(logarithmicaxis1);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(-500D, -500D);
        xyseries.add(-50D, -50D);
        xyseries.add(-5D, -5D);
        xyseries.add(0.0D, 0.0D);
        xyseries.add(5D, 5D);
        xyseries.add(50D, 50D);
        xyseries.add(500D, 500D);
        return new XYSeriesCollection(xyseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LogarithmicAxisDemo2 logarithmicaxisdemo2 = new LogarithmicAxisDemo2("Logarithmic Axis Demo 2");
        logarithmicaxisdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(logarithmicaxisdemo2);
        logarithmicaxisdemo2.setVisible(true);
    }
}
