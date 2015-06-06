



package demo;

import java.awt.Dimension;
import java.awt.geom.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo9 extends ApplicationFrame
{

    public TimeSeriesDemo9(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        JFreeChart jfreechart = createChart(xydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Demo 9", "Date", "Price Per Unit", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setSeriesVisibleInLegend(3, Boolean.FALSE);
        if(xyitemrenderer instanceof XYLineAndShapeRenderer)
        {
            XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyitemrenderer;
            xylineandshaperenderer.setShapesVisible(true);
            xylineandshaperenderer.setShapesFilled(true);
            xylineandshaperenderer.setSeriesShape(0, new java.awt.geom.Ellipse2D.Double(-3D, -3D, 6D, 6D));
            xylineandshaperenderer.setSeriesShape(1, new java.awt.geom.Rectangle2D.Double(-3D, -3D, 6D, 6D));
            GeneralPath generalpath = new GeneralPath();
            generalpath.moveTo(0.0F, -3F);
            generalpath.lineTo(3F, 3F);
            generalpath.lineTo(-3F, 3F);
            generalpath.closePath();
            xylineandshaperenderer.setSeriesShape(2, generalpath);
            GeneralPath generalpath1 = new GeneralPath();
            generalpath1.moveTo(-1F, -3F);
            generalpath1.lineTo(1.0F, -3F);
            generalpath1.lineTo(1.0F, -1F);
            generalpath1.lineTo(3F, -1F);
            generalpath1.lineTo(3F, 1.0F);
            generalpath1.lineTo(1.0F, 1.0F);
            generalpath1.lineTo(1.0F, 3F);
            generalpath1.lineTo(-1F, 3F);
            generalpath1.lineTo(-1F, 1.0F);
            generalpath1.lineTo(-3F, 1.0F);
            generalpath1.lineTo(-3F, -1F);
            generalpath1.lineTo(-1F, -1F);
            generalpath1.closePath();
            xylineandshaperenderer.setSeriesShape(3, generalpath1);
        }
        xyplot.getDomainAxis().setVisible(false);
        xyplot.getRangeAxis().setVisible(false);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        for(int i = 0; i < 4; i++)
            timeseriescollection.addSeries(createTimeSeries(i, 10));

        return timeseriescollection;
    }

    private static TimeSeries createTimeSeries(int i, int j)
    {
        TimeSeries timeseries = new TimeSeries("Series " + i, org.jfree.data.time.Day.class);
        Day day = new Day();
        for(int k = 0; k < j; k++)
        {
            timeseries.add(day, Math.random());
            day = (Day)day.next();
        }

        return timeseries;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo9 timeseriesdemo9 = new TimeSeriesDemo9("Time Series Demo 9");
        timeseriesdemo9.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo9);
        timeseriesdemo9.setVisible(true);
    }
}
