



package demo;

import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo1 extends ApplicationFrame
{

    public XYLineAndShapeRendererDemo1(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XYLineAndShapeRenderer Demo 1", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();
        xylineandshaperenderer.setSeriesLinesVisible(0, true);
        xylineandshaperenderer.setSeriesShapesVisible(0, false);
        xylineandshaperenderer.setSeriesLinesVisible(1, false);
        xylineandshaperenderer.setSeriesShapesVisible(1, true);
        xylineandshaperenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xylineandshaperenderer.setDefaultEntityRadius(6);
        xyplot.setRenderer(xylineandshaperenderer);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(1.0D, 3.2999999999999998D);
        xyseries.add(2D, 4.4000000000000004D);
        xyseries.add(3D, 1.7D);
        XYSeries xyseries1 = new XYSeries("Series 2");
        xyseries1.add(1.0D, 7.2999999999999998D);
        xyseries1.add(2D, 6.7999999999999998D);
        xyseries1.add(3D, 9.5999999999999996D);
        xyseries1.add(4D, 5.5999999999999996D);
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
        XYLineAndShapeRendererDemo1 xylineandshaperendererdemo1 = new XYLineAndShapeRendererDemo1("XYLineAndShapeRenderer Demo");
        xylineandshaperendererdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xylineandshaperendererdemo1);
        xylineandshaperendererdemo1.setVisible(true);
    }
}
