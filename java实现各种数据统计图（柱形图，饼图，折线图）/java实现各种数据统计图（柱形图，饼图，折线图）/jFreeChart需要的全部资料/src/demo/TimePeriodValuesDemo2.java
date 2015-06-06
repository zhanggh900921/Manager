



package demo;

import java.awt.Dimension;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYBarRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimePeriodValuesDemo2 extends ApplicationFrame
{

    public TimePeriodValuesDemo2(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        XYBarRenderer xybarrenderer = new XYBarRenderer();
        DateAxis dateaxis = new DateAxis("Date");
        NumberAxis numberaxis = new NumberAxis("Value");
        XYPlot xyplot = new XYPlot(xydataset, dateaxis, numberaxis, xybarrenderer);
        JFreeChart jfreechart = new JFreeChart("Time Period Values Demo", xyplot);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    public XYDataset createDataset()
    {
        TimePeriodValues timeperiodvalues = new TimePeriodValues("Series 1");
        Day day = new Day();
        Day day1 = (Day)day.next();
        Day day2 = (Day)day1.next();
        Day day3 = (Day)day2.next();
        Day day4 = (Day)day3.next();
        Day day5 = (Day)day4.next();
        Day day6 = (Day)day5.next();
        timeperiodvalues.add(new SimpleTimePeriod(day5.getStart(), day5.getEnd()), 74.950000000000003D);
        timeperiodvalues.add(new SimpleTimePeriod(day.getStart(), day1.getEnd()), 55.75D);
        timeperiodvalues.add(new SimpleTimePeriod(day6.getStart(), day6.getEnd()), 90.450000000000003D);
        timeperiodvalues.add(new SimpleTimePeriod(day2.getStart(), day4.getEnd()), 105.75D);
        TimePeriodValuesCollection timeperiodvaluescollection = new TimePeriodValuesCollection();
        timeperiodvaluescollection.addSeries(timeperiodvalues);
        return timeperiodvaluescollection;
    }

    public static void main(String args[])
    {
        TimePeriodValuesDemo2 timeperiodvaluesdemo2 = new TimePeriodValuesDemo2("Time Period Values Demo 2");
        timeperiodvaluesdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(timeperiodvaluesdemo2);
        timeperiodvaluesdemo2.setVisible(true);
    }
}
