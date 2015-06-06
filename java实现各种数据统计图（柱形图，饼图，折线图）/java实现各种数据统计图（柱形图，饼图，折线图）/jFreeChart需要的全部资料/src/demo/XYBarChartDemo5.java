



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
import org.jfree.ui.*;

public class XYBarChartDemo5 extends ApplicationFrame
{

    public XYBarChartDemo5(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(IntervalXYDataset intervalxydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYBarChart("US Budget Deficit", "Year", true, "$ Billion", intervalxydataset, PlotOrientation.VERTICAL, false, false, false);
        TextTitle texttitle = new TextTitle("Source: http://www.cbo.gov/showdoc.cfm?index=1821&sequence=0#table12");
        texttitle.setFont(new Font("Dialog", 0, 8));
        texttitle.setPosition(RectangleEdge.BOTTOM);
        texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jfreechart.addSubtitle(texttitle);
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
        TimeSeries timeseries = new TimeSeries("Budget", "Year", "$ Million", org.jfree.data.time.Year.class);
        try
        {
            timeseries.add(new Year(1980), -74D);
            timeseries.add(new Year(1981), -79D);
            timeseries.add(new Year(1982), -128D);
            timeseries.add(new Year(1983), -208D);
            timeseries.add(new Year(1984), -185D);
            timeseries.add(new Year(1985), -212D);
            timeseries.add(new Year(1986), -221D);
            timeseries.add(new Year(1987), -150D);
            timeseries.add(new Year(1988), -155D);
            timeseries.add(new Year(1989), -153D);
            timeseries.add(new Year(1990), -221D);
            timeseries.add(new Year(1991), -269D);
            timeseries.add(new Year(1992), -290D);
            timeseries.add(new Year(1993), -255D);
            timeseries.add(new Year(1994), -203D);
            timeseries.add(new Year(1995), -164D);
            timeseries.add(new Year(1996), -107D);
            timeseries.add(new Year(1997), -22D);
            timeseries.add(new Year(1998), 69D);
            timeseries.add(new Year(1999), 126D);
            timeseries.add(new Year(2000), 236D);
            timeseries.add(new Year(2001), 128D);
            timeseries.add(new Year(2002), -158D);
            timeseries.add(new Year(2003), -378D);
            timeseries.add(new Year(2004), -412D);
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
        XYBarChartDemo5 xybarchartdemo5 = new XYBarChartDemo5("US Budget Deficit");
        xybarchartdemo5.pack();
        RefineryUtilities.centerFrameOnScreen(xybarchartdemo5);
        xybarchartdemo5.setVisible(true);
    }
}
