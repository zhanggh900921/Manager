



package demo;

import java.awt.*;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.PeriodAxis;
import org.jfree.chart.axis.PeriodAxisLabelInfo;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.data.time.*;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.*;

public class PeriodAxisDemo3 extends ApplicationFrame
{

    public PeriodAxisDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("Maximum Temperature", "Day", true, "Temperature", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        PeriodAxis periodaxis = new PeriodAxis("Day");
        periodaxis.setAutoRangeTimePeriodClass(org.jfree.data.time.Day.class);
        PeriodAxisLabelInfo aperiodaxislabelinfo[] = new PeriodAxisLabelInfo[3];
        aperiodaxislabelinfo[0] = new PeriodAxisLabelInfo(org.jfree.data.time.Day.class, new SimpleDateFormat("d"));
        aperiodaxislabelinfo[1] = new PeriodAxisLabelInfo(org.jfree.data.time.Day.class, new SimpleDateFormat("E"), new RectangleInsets(2D, 2D, 2D, 2D), new Font("SansSerif", 1, 10), Color.blue, false, new BasicStroke(0.0F), Color.lightGray);
        aperiodaxislabelinfo[2] = new PeriodAxisLabelInfo(org.jfree.data.time.Month.class, new SimpleDateFormat("MMM"));
        periodaxis.setLabelInfo(aperiodaxislabelinfo);
        xyplot.setDomainAxis(periodaxis);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Temperature");
        timeseries.add(new Day(1, 4, 2006), 14.5D);
        timeseries.add(new Day(2, 4, 2006), 11.5D);
        timeseries.add(new Day(3, 4, 2006), 13.699999999999999D);
        timeseries.add(new Day(4, 4, 2006), 10.5D);
        timeseries.add(new Day(5, 4, 2006), 14.9D);
        timeseries.add(new Day(6, 4, 2006), 15.699999999999999D);
        timeseries.add(new Day(7, 4, 2006), 11.5D);
        timeseries.add(new Day(8, 4, 2006), 9.5D);
        timeseries.add(new Day(9, 4, 2006), 10.9D);
        timeseries.add(new Day(10, 4, 2006), 14.1D);
        timeseries.add(new Day(11, 4, 2006), 12.300000000000001D);
        timeseries.add(new Day(12, 4, 2006), 14.300000000000001D);
        timeseries.add(new Day(13, 4, 2006), 19D);
        timeseries.add(new Day(14, 4, 2006), 17.899999999999999D);
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        PeriodAxisDemo3 periodaxisdemo3 = new PeriodAxisDemo3("Period Axis Demo 3");
        periodaxisdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(periodaxisdemo3);
        periodaxisdemo3.setVisible(true);
    }
}
