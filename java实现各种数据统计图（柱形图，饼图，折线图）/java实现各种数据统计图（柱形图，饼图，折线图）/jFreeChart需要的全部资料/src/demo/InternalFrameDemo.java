



package demo;

import java.awt.Container;
import java.awt.Dimension;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class InternalFrameDemo extends ApplicationFrame
{

    public InternalFrameDemo(String s)
    {
        super(s);
        JDesktopPane jdesktoppane = new JDesktopPane();
        jdesktoppane.setPreferredSize(new Dimension(600, 400));
        JInternalFrame jinternalframe = createFrame1();
        jdesktoppane.add(jinternalframe);
        jinternalframe.pack();
        jinternalframe.setVisible(true);
        JInternalFrame jinternalframe1 = createFrame2();
        jdesktoppane.add(jinternalframe1);
        jinternalframe1.pack();
        jinternalframe1.setLocation(100, 200);
        jinternalframe1.setVisible(true);
        getContentPane().add(jdesktoppane);
    }

    private JInternalFrame createFrame1()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(34D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(23D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(54D, "Series 1", "Category 3");
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart", "Category", "Series", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(200, 100));
        JInternalFrame jinternalframe = new JInternalFrame("Frame 1", true);
        jinternalframe.getContentPane().add(chartpanel);
        return jinternalframe;
    }

    private JInternalFrame createFrame2()
    {
        XYDataset xydataset = createDataset("Series 1", 100D, new Minute(), 200);
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Chart", "Time of Day", "Value", xydataset, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(200, 100));
        JInternalFrame jinternalframe = new JInternalFrame("Frame 2", true);
        jinternalframe.getContentPane().add(chartpanel);
        return jinternalframe;
    }

    private XYDataset createDataset(String s, double d, RegularTimePeriod regulartimeperiod, int i)
    {
        TimeSeries timeseries = new TimeSeries(s, regulartimeperiod.getClass());
        RegularTimePeriod regulartimeperiod1 = regulartimeperiod;
        double d1 = d;
        for(int j = 0; j < i; j++)
        {
            timeseries.add(regulartimeperiod1, d1);
            regulartimeperiod1 = regulartimeperiod1.next();
            d1 *= 1.0D + (Math.random() - 0.495D) / 10D;
        }

        TimeSeriesCollection timeseriescollection = new TimeSeriesCollection();
        timeseriescollection.addSeries(timeseries);
        return timeseriescollection;
    }

    public static void main(String args[])
    {
        InternalFrameDemo internalframedemo = new InternalFrameDemo("Internal Frame Demo");
        internalframedemo.pack();
        RefineryUtilities.centerFrameOnScreen(internalframedemo);
        internalframedemo.setVisible(true);
    }
}
