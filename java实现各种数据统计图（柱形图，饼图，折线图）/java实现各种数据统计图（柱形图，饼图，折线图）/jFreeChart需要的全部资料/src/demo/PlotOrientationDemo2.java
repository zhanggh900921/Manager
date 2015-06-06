



package demo;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYLineAnnotation;
import org.jfree.chart.annotations.XYShapeAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class PlotOrientationDemo2 extends ApplicationFrame
{
    static class DemoPanel extends JPanel
    {

        private XYDataset datasets[];
        private JFreeChart charts[];
        private ChartPanel panels[];

        public DemoPanel()
        {
            super(new GridLayout(2, 4));
            datasets = new XYDataset[8];
            charts = new JFreeChart[8];
            panels = new ChartPanel[8];
            for(int i = 0; i < 8; i++)
            {
                datasets[i] = PlotOrientationDemo2.createDataset(i);
                charts[i] = PlotOrientationDemo2.createChart(i, datasets[i]);
                XYPlot xyplot1 = (XYPlot)charts[i].getPlot();
                XYShapeAnnotation xyshapeannotation = new XYShapeAnnotation(new java.awt.geom.Rectangle2D.Double(1.0D, 2D, 2D, 3D), new BasicStroke(1.0F), Color.blue);
                XYLineAnnotation xylineannotation = new XYLineAnnotation(0.0D, -5D, 10D, -5D);
                xyplot1.addAnnotation(xyshapeannotation);
                xyplot1.addAnnotation(xylineannotation);
                xyplot1.addDomainMarker(new IntervalMarker(5D, 10D), Layer.BACKGROUND);
                xyplot1.addRangeMarker(new IntervalMarker(-2D, 0.0D), Layer.BACKGROUND);
                panels[i] = new ChartPanel(charts[i]);
            }

            XYPlot xyplot = (XYPlot)charts[1].getPlot();
            XYPlot xyplot2 = (XYPlot)charts[2].getPlot();
            XYPlot xyplot3 = (XYPlot)charts[3].getPlot();
            XYPlot xyplot4 = (XYPlot)charts[4].getPlot();
            XYPlot xyplot5 = (XYPlot)charts[5].getPlot();
            XYPlot xyplot6 = (XYPlot)charts[6].getPlot();
            XYPlot xyplot7 = (XYPlot)charts[7].getPlot();
            xyplot.getDomainAxis().setInverted(true);
            xyplot2.getRangeAxis().setInverted(true);
            xyplot3.getDomainAxis().setInverted(true);
            xyplot3.getRangeAxis().setInverted(true);
            xyplot5.getDomainAxis().setInverted(true);
            xyplot6.getRangeAxis().setInverted(true);
            xyplot4.getDomainAxis().setInverted(true);
            xyplot4.getRangeAxis().setInverted(true);
            xyplot4.setOrientation(PlotOrientation.HORIZONTAL);
            xyplot5.setOrientation(PlotOrientation.HORIZONTAL);
            xyplot6.setOrientation(PlotOrientation.HORIZONTAL);
            xyplot7.setOrientation(PlotOrientation.HORIZONTAL);
            add(panels[0]);
            add(panels[1]);
            add(panels[4]);
            add(panels[5]);
            add(panels[2]);
            add(panels[3]);
            add(panels[6]);
            add(panels[7]);
            setPreferredSize(new Dimension(800, 600));
        }
    }


    public PlotOrientationDemo2(String s)
    {
        super(s);
        setContentPane(new DemoPanel());
    }

    private static XYDataset createDataset(int i)
    {
        XYSeries xyseries = new XYSeries("Series " + (i + 1));
        xyseries.add(-10D, -5D);
        xyseries.add(10D, 5D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        return xyseriescollection;
    }

    private static JFreeChart createChart(int i, XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("Chart " + (i + 1), "X", "Y", xydataset, PlotOrientation.VERTICAL, false, false, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        xylineandshaperenderer.setShapesVisible(true);
        xylineandshaperenderer.setShapesFilled(true);
        ValueAxis valueaxis = xyplot.getDomainAxis();
        valueaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        ValueAxis valueaxis1 = xyplot.getRangeAxis();
        valueaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public static void main(String args[])
    {
        PlotOrientationDemo2 plotorientationdemo2 = new PlotOrientationDemo2("Plot Orientation Demo 2");
        plotorientationdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(plotorientationdemo2);
        plotorientationdemo2.setVisible(true);
    }

    private static final int CHART_COUNT = 8;


}
