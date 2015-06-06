



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYBarRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYBarChartDemo1 extends ApplicationFrame
{

    public StackedXYBarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static TableXYDataset createDataset()
    {
        DefaultTableXYDataset defaulttablexydataset = new DefaultTableXYDataset();
        XYSeries xyseries = new XYSeries("Series 1", true, false);
        xyseries.add(1.0D, 5D);
        xyseries.add(2D, 15.5D);
        xyseries.add(3D, 9.5D);
        xyseries.add(4D, 7.5D);
        defaulttablexydataset.addSeries(xyseries);
        XYSeries xyseries1 = new XYSeries("Series 2", true, false);
        xyseries1.add(1.0D, 5D);
        xyseries1.add(2D, 15.5D);
        xyseries1.add(3D, 9.5D);
        xyseries1.add(4D, 3.5D);
        defaulttablexydataset.addSeries(xyseries1);
        return defaulttablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        NumberAxis numberaxis = new NumberAxis("X");
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        NumberAxis numberaxis1 = new NumberAxis("Y");
        StackedXYBarRenderer stackedxybarrenderer = new StackedXYBarRenderer(0.10000000000000001D);
        stackedxybarrenderer.setDrawBarOutline(false);
        XYPlot xyplot = new XYPlot(tablexydataset, numberaxis, numberaxis1, stackedxybarrenderer);
        JFreeChart jfreechart = new JFreeChart("Stacked XY Bar Chart Demo 1", xyplot);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYBarChartDemo1 stackedxybarchartdemo1 = new StackedXYBarChartDemo1("Stacked XY Bar Chart Demo 1");
        stackedxybarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxybarchartdemo1);
        stackedxybarchartdemo1.setVisible(true);
    }
}
