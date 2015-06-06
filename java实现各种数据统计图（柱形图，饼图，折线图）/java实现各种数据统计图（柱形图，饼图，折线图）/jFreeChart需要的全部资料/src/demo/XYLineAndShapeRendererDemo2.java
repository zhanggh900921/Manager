



package demo;

import java.awt.*;
import java.awt.geom.Ellipse2D;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYLineAndShapeRendererDemo2 extends ApplicationFrame
{

    public XYLineAndShapeRendererDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart()
    {
        XYDataset xydataset = createDataset(1, 1.0D);
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XYLineAndShapeRenderer Demo 2", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        TextTitle texttitle = new TextTitle("This chart shows various combinations of the useFillPaint and useOutlinePaint flags.");
        texttitle.setFont(new Font("Dialog", 0, 10));
        jfreechart.addSubtitle(texttitle);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        java.awt.geom.Ellipse2D.Double double1 = new java.awt.geom.Ellipse2D.Double(-4D, -4D, 8D, 8D);
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylineandshaperenderer.setBaseShapesVisible(true);
        xylineandshaperenderer.setSeriesShape(0, double1);
        xylineandshaperenderer.setSeriesPaint(0, Color.red);
        xylineandshaperenderer.setSeriesFillPaint(0, Color.yellow);
        xylineandshaperenderer.setSeriesOutlinePaint(0, Color.gray);
        XYDataset xydataset1 = createDataset(2, 2D);
        XYLineAndShapeRenderer xylineandshaperenderer1 = new XYLineAndShapeRenderer();
        xyplot.setDataset(1, xydataset1);
        xyplot.setRenderer(1, xylineandshaperenderer1);
        xylineandshaperenderer1.setSeriesShape(0, double1);
        xylineandshaperenderer1.setSeriesPaint(0, Color.red);
        xylineandshaperenderer1.setSeriesFillPaint(0, Color.yellow);
        xylineandshaperenderer1.setSeriesOutlinePaint(0, Color.gray);
        xylineandshaperenderer1.setUseFillPaint(true);
        XYDataset xydataset2 = createDataset(3, 3D);
        XYLineAndShapeRenderer xylineandshaperenderer2 = new XYLineAndShapeRenderer();
        xyplot.setDataset(2, xydataset2);
        xyplot.setRenderer(2, xylineandshaperenderer2);
        xylineandshaperenderer2.setSeriesShape(0, double1);
        xylineandshaperenderer2.setSeriesPaint(0, Color.red);
        xylineandshaperenderer2.setSeriesFillPaint(0, Color.yellow);
        xylineandshaperenderer2.setSeriesOutlinePaint(0, Color.gray);
        xylineandshaperenderer2.setUseOutlinePaint(true);
        XYDataset xydataset3 = createDataset(4, 4D);
        XYLineAndShapeRenderer xylineandshaperenderer3 = new XYLineAndShapeRenderer();
        xyplot.setDataset(3, xydataset3);
        xyplot.setRenderer(3, xylineandshaperenderer3);
        xylineandshaperenderer3.setSeriesShape(0, double1);
        xylineandshaperenderer3.setSeriesPaint(0, Color.red);
        xylineandshaperenderer3.setSeriesFillPaint(0, Color.yellow);
        xylineandshaperenderer3.setSeriesOutlinePaint(0, Color.gray);
        xylineandshaperenderer3.setUseOutlinePaint(true);
        xylineandshaperenderer3.setUseFillPaint(true);
        XYDataset xydataset4 = createDataset(5, 5D);
        XYLineAndShapeRenderer xylineandshaperenderer4 = new XYLineAndShapeRenderer();
        xyplot.setDataset(4, xydataset4);
        xyplot.setRenderer(4, xylineandshaperenderer4);
        xylineandshaperenderer4.setSeriesShape(0, double1);
        xylineandshaperenderer4.setSeriesPaint(0, Color.red);
        xylineandshaperenderer4.setSeriesFillPaint(0, Color.yellow);
        xylineandshaperenderer4.setSeriesOutlinePaint(0, Color.gray);
        xylineandshaperenderer4.setUseOutlinePaint(true);
        xylineandshaperenderer4.setUseFillPaint(true);
        xylineandshaperenderer4.setDrawOutlines(false);
        return jfreechart;
    }

    private static XYDataset createDataset(int i, double d)
    {
        XYSeries xyseries = new XYSeries("Series " + i);
        xyseries.add(1.0D, d);
        xyseries.add(2D, d);
        xyseries.add(3D, d);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        return xyseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYLineAndShapeRendererDemo2 xylineandshaperendererdemo2 = new XYLineAndShapeRendererDemo2("JFreeChart: XYLineAndShapeRendererDemo2");
        xylineandshaperendererdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xylineandshaperendererdemo2);
        xylineandshaperendererdemo2.setVisible(true);
    }
}
