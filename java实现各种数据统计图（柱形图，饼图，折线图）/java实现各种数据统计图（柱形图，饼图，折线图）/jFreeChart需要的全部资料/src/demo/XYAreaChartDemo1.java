



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.*;
import org.jfree.ui.*;

public class XYAreaChartDemo1 extends ApplicationFrame
{

    public XYAreaChartDemo1(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Random 1");
        xyseries.add(new Integer(1), new Double(500.19999999999999D));
        xyseries.add(new Integer(2), new Double(694.10000000000002D));
        xyseries.add(new Integer(3), new Double(-734.39999999999998D));
        xyseries.add(new Integer(4), new Double(453.19999999999999D));
        xyseries.add(new Integer(5), new Double(500.19999999999999D));
        xyseries.add(new Integer(6), new Double(300.69999999999999D));
        xyseries.add(new Integer(7), new Double(734.39999999999998D));
        xyseries.add(new Integer(8), new Double(453.19999999999999D));
        XYSeries xyseries1 = new XYSeries("Random 2");
        xyseries1.add(new Integer(1), new Double(700.20000000000005D));
        xyseries1.add(new Integer(2), new Double(534.10000000000002D));
        xyseries1.add(new Integer(3), new Double(323.39999999999998D));
        xyseries1.add(new Integer(4), new Double(125.2D));
        xyseries1.add(new Integer(5), new Double(653.20000000000005D));
        xyseries1.add(new Integer(6), new Double(432.69999999999999D));
        xyseries1.add(new Integer(7), new Double(564.39999999999998D));
        xyseries1.add(new Integer(8), new Double(322.19999999999999D));
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.setIntervalWidth(0.0D);
        return xyseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYAreaChart("XY Area Chart Demo", "Domain (X)", "Range (Y)", xydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setForegroundAlpha(0.65F);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        ValueAxis valueaxis = xyplot.getDomainAxis();
        valueaxis.setTickMarkPaint(Color.black);
        valueaxis.setLowerMargin(0.0D);
        valueaxis.setUpperMargin(0.0D);
        ValueAxis valueaxis1 = xyplot.getRangeAxis();
        valueaxis1.setTickMarkPaint(Color.black);
        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Test", 5D, -500D, 2.3561944901923448D);
        xypointerannotation.setTipRadius(0.0D);
        xypointerannotation.setBaseRadius(35D);
        xypointerannotation.setFont(new Font("SansSerif", 0, 9));
        xypointerannotation.setPaint(Color.blue);
        xypointerannotation.setTextAnchor(TextAnchor.HALF_ASCENT_RIGHT);
        xyplot.addAnnotation(xypointerannotation);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYAreaChartDemo1 xyareachartdemo1 = new XYAreaChartDemo1("XY Area Chart Demo");
        xyareachartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xyareachartdemo1);
        xyareachartdemo1.setVisible(true);
    }
}
