



package demo;

import java.io.File;
import java.io.IOException;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;
import org.jfree.ui.RectangleInsets;

public class SparklineDemo1
{

    public SparklineDemo1()
    {
    }

    public static void main(String args[])
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(1.0D, 1.0D);
        xyseries.add(2D, 3D);
        xyseries.add(3D, 2D);
        xyseries.add(4D, 4D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        JFreeChart jfreechart = ChartFactory.createXYLineChart(null, "X", "Y", xyseriescollection, PlotOrientation.VERTICAL, false, false, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setInsets(RectangleInsets.ZERO_INSETS);
        xyplot.setDomainGridlinesVisible(false);
        xyplot.setRangeGridlinesVisible(false);
        xyplot.setOutlinePaint(null);
        xyplot.getDomainAxis().setVisible(false);
        xyplot.getRangeAxis().setVisible(false);
        try
        {
            ChartUtilities.saveChartAsPNG(new File("Sparky.png"), jfreechart, 100, 20);
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
