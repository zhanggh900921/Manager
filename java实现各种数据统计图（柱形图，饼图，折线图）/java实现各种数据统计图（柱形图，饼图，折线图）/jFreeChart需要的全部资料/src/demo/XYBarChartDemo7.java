



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.Day;
import org.jfree.data.time.RegularTimePeriod;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo7 extends ApplicationFrame
{

    public XYBarChartDemo7(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("XYBarChartDemo7", "Date", true, "Y", intervalxydataset, PlotOrientation.VERTICAL, true, false, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setDomainAxis(new DateAxis("Date"));
        SymbolAxis symbolaxis = new SymbolAxis("Series", new String[] {
            "S1", "S2", "S3"
        });
        symbolaxis.setGridBandsVisible(false);
        xyplot.setRangeAxis(symbolaxis);
        XYBarRenderer xybarrenderer = (XYBarRenderer)xyplot.getRenderer();
        xybarrenderer.setUseYInterval(true);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        Day day = new Day(12, 6, 2007);
        Day day1 = new Day(13, 6, 2007);
        Day day2 = new Day(14, 6, 2007);
        Day day3 = new Day(15, 6, 2007);
        Day day4 = new Day(16, 6, 2007);
        Day day5 = new Day(17, 6, 2007);
        XYIntervalSeriesCollection xyintervalseriescollection = new XYIntervalSeriesCollection();
        XYIntervalSeries xyintervalseries = new XYIntervalSeries("S1");
        XYIntervalSeries xyintervalseries1 = new XYIntervalSeries("S2");
        XYIntervalSeries xyintervalseries2 = new XYIntervalSeries("S3");
        addItem(xyintervalseries, day, day1, 0);
        addItem(xyintervalseries, day3, day3, 0);
        addItem(xyintervalseries1, day, day5, 1);
        addItem(xyintervalseries2, day2, day4, 2);
        xyintervalseriescollection.addSeries(xyintervalseries);
        xyintervalseriescollection.addSeries(xyintervalseries1);
        xyintervalseriescollection.addSeries(xyintervalseries2);
        return xyintervalseriescollection;
    }

    private static void addItem(XYIntervalSeries xyintervalseries, RegularTimePeriod regulartimeperiod, RegularTimePeriod regulartimeperiod1, int i)
    {
        xyintervalseries.add(regulartimeperiod.getFirstMillisecond(), regulartimeperiod.getFirstMillisecond(), regulartimeperiod1.getLastMillisecond(), i, (double)i - 0.45000000000000001D, (double)i + 0.45000000000000001D);
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBarChartDemo7 xybarchartdemo7 = new XYBarChartDemo7("JFreeChart : XYBarChartDemo7.java");
        xybarchartdemo7.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo7);
        xybarchartdemo7.setVisible(true);
    }
}
