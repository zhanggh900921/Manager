



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYAreaRenderer;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CompassFormatDemo1 extends ApplicationFrame
{

    public CompassFormatDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static XYDataset createDirectionDataset(int i)
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        TimeSeries timeseries = new TimeSeries("Wind Direction", org.jfree.data.time.Minute.class);
        Object obj = new Minute();
        double d = 180D;
        for(int j = 0; j < i; j++)
        {
            timeseries.add(((RegularTimePeriod) (obj)), d);
            obj = ((RegularTimePeriod) (obj)).next();
            d += (Math.random() - 0.5D) * 15D;
            if(d < 0.0D)
            {
                d += 360D;
                continue;
            }
            if(d > 360D)
                d -= 360D;
        }

        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    private static XYDataset createForceDataset(int i)
    {
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        TimeSeries timeseries = new TimeSeries("Wind Force", org.jfree.data.time.Minute.class);
        Object obj = new Minute();
        double d = 3D;
        for(int j = 0; j < i; j++)
        {
            timeseries.add(((RegularTimePeriod) (obj)), d);
            obj = ((RegularTimePeriod) (obj)).next();
            d = Math.max(0.5D, d + (Math.random() - 0.5D) * 0.5D);
        }

        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    private static JFreeChart createChart()
    {
        XYDataset xydataset = createDirectionDataset(600);
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time", "Date", "Direction", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.getDomainAxis().setLowerMargin(0.0D);
        xyplot.getDomainAxis().setUpperMargin(0.0D);
        NumberAxis numberaxis = (NumberAxis)xyplot.getRangeAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        TickUnits tickunits = new TickUnits();
        tickunits.add(new NumberTickUnit(180D, new CompassFormat()));
        tickunits.add(new NumberTickUnit(90D, new CompassFormat()));
        tickunits.add(new NumberTickUnit(45D, new CompassFormat()));
        tickunits.add(new NumberTickUnit(22.5D, new CompassFormat()));
        numberaxis.setStandardTickUnits(tickunits);
        xyplot.setRangeAxis(numberaxis);
        XYAreaRenderer xyarearenderer = new XYAreaRenderer();
        NumberAxis numberaxis1 = new NumberAxis("Force");
        numberaxis1.setRange(0.0D, 12D);
        xyarearenderer.setSeriesPaint(0, new Color(0, 0, 255, 128));
        xyplot.setDataset(1, createForceDataset(600));
        xyplot.setRenderer(1, xyarearenderer);
        xyplot.setRangeAxis(1, numberaxis1);
        xyplot.mapDatasetToRangeAxis(1, 1);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        CompassFormatDemo1 compassformatdemo1 = new CompassFormatDemo1("Compass Format Demo");
        compassformatdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(compassformatdemo1);
        compassformatdemo1.setVisible(true);
    }
}
