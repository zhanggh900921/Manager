



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.PolarPlot;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class PolarChartDemo1 extends ApplicationFrame
{

    public PolarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static XYDataset createDataset()
    {
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(0.0D, 2D);
        xyseries.add(90D, 13D);
        xyseries.add(180D, 9D);
        xyseries.add(270D, 8D);
        xyseriescollection.addSeries(xyseries);
        XYSeries xyseries1 = new XYSeries("Series 2");
        xyseries1.add(90D, -11.199999999999999D);
        xyseries1.add(180D, 21.399999999999999D);
        xyseries1.add(250D, 17.300000000000001D);
        xyseries1.add(355D, 10.9D);
        xyseriescollection.addSeries(xyseries1);
        return xyseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createPolarChart("Polar Chart Demo 1", xydataset, true, false, false);
        jfreechart.setBackgroundPaint(Color.white);
        PolarPlot polarplot = (PolarPlot)jfreechart.getPlot();
        polarplot.setBackgroundPaint(Color.lightGray);
        polarplot.addCornerTextItem("Corner Item 1");
        polarplot.addCornerTextItem("Corner Item 2");
        polarplot.setAngleGridlinePaint(Color.white);
        polarplot.setRadiusGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)polarplot.getAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setMouseZoomable(false);
        return chartpanel;
    }

    public static void main(String args[])
    {
        PolarChartDemo1 polarchartdemo1 = new PolarChartDemo1("Polar Chart Demo");
        polarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(polarchartdemo1);
        polarchartdemo1.setVisible(true);
    }
}
