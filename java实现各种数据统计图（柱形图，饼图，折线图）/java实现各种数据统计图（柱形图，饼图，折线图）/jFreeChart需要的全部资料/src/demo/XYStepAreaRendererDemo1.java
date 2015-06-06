



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepAreaRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepAreaRendererDemo1 extends ApplicationFrame
{

    public XYStepAreaRendererDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XYStepAreaRenderer Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYStepAreaRenderer xysteparearenderer = new XYStepAreaRenderer(2);
        xysteparearenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xysteparearenderer.setDefaultEntityRadius(6);
        xyplot.setRenderer(xysteparearenderer);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(1.0D, 3D);
        xyseries.add(2D, 4D);
        xyseries.add(3D, 2D);
        xyseries.add(6D, 3D);
        XYSeries xyseries1 = new XYSeries("Series 2");
        xyseries1.add(1.0D, 7D);
        xyseries1.add(2D, 6D);
        xyseries1.add(3D, 9D);
        xyseries1.add(4D, 5D);
        xyseries1.add(6D, 4D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        return xyseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYStepAreaRendererDemo1 xysteparearendererdemo1 = new XYStepAreaRendererDemo1("XYStepAreaRenderer Demo 1");
        xysteparearendererdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xysteparearendererdemo1);
        xysteparearendererdemo1.setVisible(true);
    }
}
