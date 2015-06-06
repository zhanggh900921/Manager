



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StackedXYAreaRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class StackedXYAreaChartDemo1 extends ApplicationFrame
{

    public StackedXYAreaChartDemo1(String s)
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
        xyseries.add(5D, 5D);
        xyseries.add(10D, 15.5D);
        xyseries.add(15D, 9.5D);
        xyseries.add(20D, 7.5D);
        defaulttablexydataset.addSeries(xyseries);
        XYSeries xyseries1 = new XYSeries("Series 2", true, false);
        xyseries1.add(5D, 5D);
        xyseries1.add(10D, 15.5D);
        xyseries1.add(15D, 9.5D);
        xyseries1.add(20D, 3.5D);
        defaulttablexydataset.addSeries(xyseries1);
        return defaulttablexydataset;
    }

    private static JFreeChart createChart(TableXYDataset tablexydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedXYAreaChart("Stacked XY Area Chart Demo 1", "X Value", "Y Value", tablexydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        StackedXYAreaRenderer stackedxyarearenderer = new StackedXYAreaRenderer();
        stackedxyarearenderer.setSeriesPaint(0, Color.lightGray);
        stackedxyarearenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xyplot.setRenderer(0, stackedxyarearenderer);
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedXYAreaChartDemo1 stackedxyareachartdemo1 = new StackedXYAreaChartDemo1("Stacked XY Area Chart Demo 1");
        stackedxyareachartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(stackedxyareachartdemo1);
        stackedxyareachartdemo1.setVisible(true);
    }
}
