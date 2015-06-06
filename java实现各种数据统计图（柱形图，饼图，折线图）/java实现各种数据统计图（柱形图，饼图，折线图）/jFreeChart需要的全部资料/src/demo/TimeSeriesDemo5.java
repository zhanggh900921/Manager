



package demo;

import java.awt.BasicStroke;
import java.awt.Dimension;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.general.SeriesException;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo5 extends ApplicationFrame
{

    public TimeSeriesDemo5(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Random Data");
        Day day = new Day(1, 1, 1990);
        double d = 100D;
        for(int i = 0; i < 4000; i++)
            try
            {
                d = (d + Math.random()) - 0.5D;
                timeseries.add(day, new Double(d));
                day = (Day)day.next();
            }
            catch(SeriesException seriesexception)
            {
                System.err.println("Error adding to series");
            }

        return new TimeSeriesCollection(timeseries);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Test", "Day", "Value", xydataset, false, false, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYLineAndShapeRenderer xylineandshaperenderer = new XYLineAndShapeRenderer();
        xylineandshaperenderer.setBaseShapesVisible(false);
        xylineandshaperenderer.setSeriesStroke(0, new BasicStroke(0.5F, 1, 1, 5F, new float[] {
            5F, 10F
        }, 0.0F));
        xyplot.setRenderer(xylineandshaperenderer);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        String s = "\u20A2\u20A2\u20A2\u20A3\u20A4\u20A5\u20A6\u20A7\u20A8\u20A9\u20AA";
        TimeSeriesDemo5 timeseriesdemo5 = new TimeSeriesDemo5(s);
        timeseriesdemo5.pack();
        RefineryUtilities.positionFrameRandomly(timeseriesdemo5);
        timeseriesdemo5.setVisible(true);
    }
}
