



package demo;

import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class Second
{

    public Second()
    {
    }

    public static void main(String args[])
    {
        XYSeries xyseries = new XYSeries("Advisory Range");
        xyseries.add(new Integer(1200), new Integer(1));
        xyseries.add(new Integer(1500), new Integer(1));
        XYSeries xyseries1 = new XYSeries("Normal Range");
        xyseries1.add(new Integer(2000), new Integer(4));
        xyseries1.add(new Integer(2300), new Integer(4));
        XYSeries xyseries2 = new XYSeries("Recommended");
        xyseries2.add(new Integer(2100), new Integer(2));
        XYSeries xyseries3 = new XYSeries("Current");
        xyseries3.add(new Integer(2400), new Integer(3));
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        xyseriescollection.addSeries(xyseries2);
        xyseriescollection.addSeries(xyseries3);
        JFreeChart jfreechart = ChartFactory.createXYLineChart("My Chart", "Calories", "Y", xyseriescollection, PlotOrientation.VERTICAL, true, true, false);
        StandardXYItemRenderer standardxyitemrenderer = new StandardXYItemRenderer(3, null);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setRenderer(standardxyitemrenderer);
        ValueAxis valueaxis = xyplot.getRangeAxis();
        valueaxis.setTickLabelsVisible(false);
        valueaxis.setRange(0.0D, 5D);
        ChartFrame chartframe = new ChartFrame("Test", jfreechart);
        chartframe.pack();
        chartframe.setVisible(true);
    }
}
