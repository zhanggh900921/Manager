



package demo;

import java.awt.*;
import java.io.PrintStream;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.DateTickMarkPosition;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYItemRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.time.*;
import org.jfree.data.xy.IntervalXYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYBarChartDemo1 extends ApplicationFrame
{

    public XYBarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("State Executions - USA", "Year", true, "Number of People", intervalxydataset, PlotOrientation.VERTICAL, true, false, false);
        jfreechart.addSubtitle(new TextTitle("Source: http://www.amnestyusa.org/abolish/listbyyear.do", new Font("Dialog", 2, 10)));
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYItemRenderer xyitemrenderer = xyplot.getRenderer();
        StandardXYToolTipGenerator standardxytooltipgenerator = new StandardXYToolTipGenerator("{1} = {2}", new SimpleDateFormat("yyyy"), new DecimalFormat("0"));
        xyitemrenderer.setBaseToolTipGenerator(standardxytooltipgenerator);
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setRangeGridlinePaint(Color.white);
        DateAxis dateaxis = (DateAxis)xyplot.getDomainAxis();
        dateaxis.setTickMarkPosition(DateTickMarkPosition.MIDDLE);
        dateaxis.setLowerMargin(0.01D);
        dateaxis.setUpperMargin(0.01D);
        return jfreechart;
    }

    private static IntervalXYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("Executions", "Year", "Count", org.jfree.data.time.Year.class);
        try
        {
            timeseries.add(new Year(1976), new Integer(0));
            timeseries.add(new Year(1977), new Integer(1));
            timeseries.add(new Year(1978), new Integer(0));
            timeseries.add(new Year(1979), new Integer(2));
            timeseries.add(new Year(1980), new Integer(0));
            timeseries.add(new Year(1981), new Integer(1));
            timeseries.add(new Year(1982), new Integer(2));
            timeseries.add(new Year(1983), new Integer(5));
            timeseries.add(new Year(1984), new Integer(21));
            timeseries.add(new Year(1985), new Integer(18));
            timeseries.add(new Year(1986), new Integer(18));
            timeseries.add(new Year(1987), new Integer(25));
            timeseries.add(new Year(1988), new Integer(11));
            timeseries.add(new Year(1989), new Integer(16));
            timeseries.add(new Year(1990), new Integer(23));
            timeseries.add(new Year(1991), new Integer(14));
            timeseries.add(new Year(1992), new Integer(31));
            timeseries.add(new Year(1993), new Integer(38));
            timeseries.add(new Year(1994), new Integer(31));
            timeseries.add(new Year(1995), new Integer(56));
            timeseries.add(new Year(1996), new Integer(45));
            timeseries.add(new Year(1997), new Integer(74));
            timeseries.add(new Year(1998), new Integer(68));
            timeseries.add(new Year(1999), new Integer(98));
            timeseries.add(new Year(2000), new Integer(85));
            timeseries.add(new Year(2001), new Integer(66));
            timeseries.add(new Year(2002), new Integer(71));
            timeseries.add(new Year(2003), new Integer(65));
            timeseries.add(new Year(2004), new Integer(59));
            timeseries.add(new Year(2005), new Integer(60));
        }
        catch(Exception exception)
        {
            System.err.println(exception.getMessage());
        }
        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection(timeseries);
        return timeseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        return new ChartPanel(createChart(createDataset()));
    }

    public static void main(String args[])
    {
        XYBarChartDemo1 xybarchartdemo1 = new XYBarChartDemo1("State Executions - USA");
        xybarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo1);
        xybarchartdemo1.setVisible(true);
    }
}
