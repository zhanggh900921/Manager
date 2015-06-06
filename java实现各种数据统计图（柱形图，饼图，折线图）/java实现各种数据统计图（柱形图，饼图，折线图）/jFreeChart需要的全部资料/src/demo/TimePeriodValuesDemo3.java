



package demo;

import java.awt.Dimension;
import java.text.DateFormat;
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

public class TimePeriodValuesDemo3 extends ApplicationFrame
{

    public TimePeriodValuesDemo3(String s)
    {
        super(s);
        XYDataset xydataset = createDataset();
        XYBarRenderer xybarrenderer = new XYBarRenderer();
        xybarrenderer.setDrawBarOutline(false);
        DateAxis dateaxis = new DateAxis("Date");
        NumberAxis numberaxis = new NumberAxis("Value");
        XYPlot xyplot = new XYPlot(xydataset, dateaxis, numberaxis, xybarrenderer);
        JFreeChart jfreechart = new JFreeChart("Time Period Values Demo 3", xyplot);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        chartpanel.setMouseZoomable(true, false);
        setContentPane(chartpanel);
    }

    public XYDataset createDataset()
    {
        TimePeriodValues timeperiodvalues = new TimePeriodValues("Series 1");
        DateFormat dateformat = DateFormat.getInstance();
        try
        {
            java.util.Date date = dateformat.parse("11/5/2003 0:00:00.000");
            java.util.Date date1 = dateformat.parse("11/5/2003 0:15:00.000");
            java.util.Date date2 = dateformat.parse("11/5/2003 0:30:00.000");
            java.util.Date date3 = dateformat.parse("11/5/2003 0:45:00.000");
            java.util.Date date4 = dateformat.parse("11/5/2003 1:00:00.001");
            java.util.Date date5 = dateformat.parse("11/5/2003 1:14:59.999");
            java.util.Date date6 = dateformat.parse("11/5/2003 1:30:00.000");
            java.util.Date date7 = dateformat.parse("11/5/2003 1:45:00.000");
            java.util.Date date8 = dateformat.parse("11/5/2003 2:00:00.000");
            java.util.Date date9 = dateformat.parse("11/5/2003 2:15:00.000");
            timeperiodvalues.add(new SimpleTimePeriod(date, date1), 0.39000000000000001D);
            timeperiodvalues.add(new SimpleTimePeriod(date2, date3), 0.22500000000000001D);
            timeperiodvalues.add(new SimpleTimePeriod(date3, date4), 0.23499999999999999D);
            timeperiodvalues.add(new SimpleTimePeriod(date4, date5), 0.23799999999999999D);
            timeperiodvalues.add(new SimpleTimePeriod(date5, date6), 0.23599999999999999D);
            timeperiodvalues.add(new SimpleTimePeriod(date6, date7), 0.25D);
            timeperiodvalues.add(new SimpleTimePeriod(date7, date8), 0.23799999999999999D);
            timeperiodvalues.add(new SimpleTimePeriod(date8, date9), 0.215D);
        }
        catch(Exception exception)
        {
            exception.printStackTrace();
        }
        TimePeriodValuesCollection timeperiodvaluescollection = new TimePeriodValuesCollection();
        timeperiodvaluescollection.addSeries(timeperiodvalues);
        return timeperiodvaluescollection;
    }

    public static void main(String args[])
    {
        TimePeriodValuesDemo3 timeperiodvaluesdemo3 = new TimePeriodValuesDemo3("JFreeChart: TimePeriodValuesDemo3.java");
        timeperiodvaluesdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(timeperiodvaluesdemo3);
        timeperiodvaluesdemo3.setVisible(true);
    }
}
