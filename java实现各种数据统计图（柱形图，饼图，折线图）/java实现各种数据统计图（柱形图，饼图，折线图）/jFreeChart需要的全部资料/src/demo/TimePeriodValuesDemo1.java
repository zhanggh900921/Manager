



package demo;

import java.awt.Dimension;
import java.text.SimpleDateFormat;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo1 extends ApplicationFrame
{

    public TimePeriodValuesDemo1(String s)
    {
        super(s);
        XYDataset xydataset = createDataset1();
        XYBarRenderer xybarrenderer = new XYBarRenderer();
        DateAxis dateaxis = new DateAxis("Date");
        dateaxis.setVerticalTickLabels(true);
        dateaxis.setTickUnit(new DateTickUnit(3, 1));
        dateaxis.setDateFormatOverride(new SimpleDateFormat("hh:mm"));
        dateaxis.setLowerMargin(0.01D);
        dateaxis.setUpperMargin(0.01D);
        NumberAxis numberaxis = new NumberAxis("Value");
        XYPlot xyplot = new XYPlot(xydataset, dateaxis, numberaxis, xybarrenderer);
        XYDataset xydataset1 = createDataset2();
        StandardXYItemRenderer standardxyitemrenderer = new StandardXYItemRenderer(3);
        standardxyitemrenderer.setShapesFilled(true);
        xyplot.setDataset(1, xydataset1);
        xyplot.setRenderer(1, standardxyitemrenderer);
        JFreeChart jfreechart = new JFreeChart("Supply and Demand", xyplot);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    public XYDataset createDataset1()
    {
        TimePeriodValues timeperiodvalues = new TimePeriodValues("Supply");
        TimePeriodValues timeperiodvalues1 = new TimePeriodValues("Demand");
        Day day = new Day();
        for(int i = 0; i < 24; i++)
        {
            Minute minute = new Minute(0, new Hour(i, day));
            Minute minute1 = new Minute(15, new Hour(i, day));
            Minute minute2 = new Minute(30, new Hour(i, day));
            Minute minute3 = new Minute(45, new Hour(i, day));
            Minute minute4 = new Minute(0, new Hour(i + 1, day));
            timeperiodvalues.add(new SimpleTimePeriod(minute.getStart(), minute1.getStart()), Math.random());
            timeperiodvalues1.add(new SimpleTimePeriod(minute1.getStart(), minute2.getStart()), Math.random());
            timeperiodvalues.add(new SimpleTimePeriod(minute2.getStart(), minute3.getStart()), Math.random());
            timeperiodvalues1.add(new SimpleTimePeriod(minute3.getStart(), minute4.getStart()), Math.random());
        }

        TimePeriodValuesCollection timeperiodvaluescollection = new TimePeriodValuesCollection();
        timeperiodvaluescollection.addSeries(timeperiodvalues);
        timeperiodvaluescollection.addSeries(timeperiodvalues1);
        return timeperiodvaluescollection;
    }

    public XYDataset createDataset2()
    {
        TimePeriodValues timeperiodvalues = new TimePeriodValues("WebCOINS");
        Day day = new Day();
        for(int i = 0; i < 24; i++)
        {
            Minute minute = new Minute(0, new Hour(i, day));
            Minute minute1 = new Minute(30, new Hour(i, day));
            Minute minute2 = new Minute(0, new Hour(i + 1, day));
            timeperiodvalues.add(new SimpleTimePeriod(minute.getStart(), minute1.getStart()), Math.random() * 2D);
            timeperiodvalues.add(new SimpleTimePeriod(minute1.getStart(), minute2.getStart()), Math.random() * 2D);
        }

        TimePeriodValuesCollection timeperiodvaluescollection = new TimePeriodValuesCollection();
        timeperiodvaluescollection.addSeries(timeperiodvalues);
        return timeperiodvaluescollection;
    }

    public static void main(String args[])
    {
        TimePeriodValuesDemo1 timeperiodvaluesdemo1 = new TimePeriodValuesDemo1("Time Period Values Demo 1");
        timeperiodvaluesdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(timeperiodvaluesdemo1);
        timeperiodvaluesdemo1.setVisible(true);
    }
}
