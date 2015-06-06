



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.chart.util.RelativeDateFormat;
import org.jfree.data.time.*;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.*;

public class RelativeDateFormatDemo2 extends ApplicationFrame
{

    public RelativeDateFormatDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("RelativeDateFormat Demo 2", "Date ", true, "Time To Complete", intervalxydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        xyplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        xyplot.setDomainCrosshairVisible(true);
        xyplot.setRangeCrosshairVisible(true);
        XYBarRenderer xybarrenderer = (XYBarRenderer)xyplot.getRenderer();
        xybarrenderer.setDrawBarOutline(false);
        DateAxis dateaxis = new DateAxis();
        RelativeDateFormat relativedateformat = new RelativeDateFormat();
        relativedateformat.setShowZeroDays(false);
        relativedateformat.setSecondFormatter(new DecimalFormat("00"));
        dateaxis.setDateFormatOverride(relativedateformat);
        xyplot.setRangeAxis(dateaxis);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Completion");
        timeseries.add(new Day(19, 1, 2007), 3343000D);
        timeseries.add(new Day(20, 1, 2007), 3420000D);
        timeseries.add(new Day(21, 1, 2007), 3515000D);
        timeseries.add(new Day(22, 1, 2007), 3315000D);
        timeseries.add(new Day(23, 1, 2007), 3490000D);
        timeseries.add(new Day(24, 1, 2007), 3556000D);
        timeseries.add(new Day(25, 1, 2007), 3383000D);
        timeseries.add(new Day(26, 1, 2007), 3575000D);
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
        RelativeDateFormatDemo2 relativedateformatdemo2 = new RelativeDateFormatDemo2("JFreeChart - RelativeDateFormatDemo2");
        relativedateformatdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(relativedateformatdemo2);
        relativedateformatdemo2.setVisible(true);
    }
}
