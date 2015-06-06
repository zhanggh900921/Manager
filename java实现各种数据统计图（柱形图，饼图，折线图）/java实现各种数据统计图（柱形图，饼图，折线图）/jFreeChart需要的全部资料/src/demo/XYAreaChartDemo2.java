



package demo;

import java.awt.Dimension;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYAreaChartDemo2 extends ApplicationFrame
{

    public XYAreaChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Random 1");
        double d = 0.0D;
        Day day = new Day();
        for(int i = 0; i < 200; i++)
        {
            d = (d + Math.random()) - 0.5D;
            timeseries.add(day, d);
            day = (Day)day.next();
        }

        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYAreaChart("XY Area Chart Demo 2", "Time", "Value", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        DateAxis dateaxis = new DateAxis("Time");
        dateaxis.setLowerMargin(0.0D);
        dateaxis.setUpperMargin(0.0D);
        xyplot.setDomainAxis(dateaxis);
        xyplot.setForegroundAlpha(0.5F);
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        xyitemrenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator("{0}: ({1}, {2})", new SimpleDateFormat("d-MMM-yyyy"), new DecimalFormat("#,##0.00")));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYAreaChartDemo2 xyareachartdemo2 = new XYAreaChartDemo2("XY Area Chart Demo 2");
        xyareachartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xyareachartdemo2);
        xyareachartdemo2.setVisible(true);
    }
}
