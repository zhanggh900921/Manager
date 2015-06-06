



package demo;

import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GanttDemo1 extends ApplicationFrame
{

    public GanttDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static IntervalCategoryDataset createDataset()
    {
        TaskSeries taskseries = new TaskSeries("Scheduled");
        taskseries.add(new Task("Write Proposal", new SimpleTimePeriod(date(1, 3, 2001), date(5, 3, 2001))));
        taskseries.add(new Task("Obtain Approval", new SimpleTimePeriod(date(9, 3, 2001), date(9, 3, 2001))));
        taskseries.add(new Task("Requirements Analysis", new SimpleTimePeriod(date(10, 3, 2001), date(5, 4, 2001))));
        taskseries.add(new Task("Design Phase", new SimpleTimePeriod(date(6, 4, 2001), date(30, 4, 2001))));
        taskseries.add(new Task("Design Signoff", new SimpleTimePeriod(date(2, 5, 2001), date(2, 5, 2001))));
        taskseries.add(new Task("Alpha Implementation", new SimpleTimePeriod(date(3, 5, 2001), date(31, 6, 2001))));
        taskseries.add(new Task("Design Review", new SimpleTimePeriod(date(1, 7, 2001), date(8, 7, 2001))));
        taskseries.add(new Task("Revised Design Signoff", new SimpleTimePeriod(date(10, 7, 2001), date(10, 7, 2001))));
        taskseries.add(new Task("Beta Implementation", new SimpleTimePeriod(date(12, 7, 2001), date(12, 8, 2001))));
        taskseries.add(new Task("Testing", new SimpleTimePeriod(date(13, 8, 2001), date(31, 9, 2001))));
        taskseries.add(new Task("Final Implementation", new SimpleTimePeriod(date(1, 10, 2001), date(15, 10, 2001))));
        taskseries.add(new Task("Signoff", new SimpleTimePeriod(date(28, 10, 2001), date(30, 10, 2001))));
        TaskSeries taskseries1 = new TaskSeries("Actual");
        taskseries1.add(new Task("Write Proposal", new SimpleTimePeriod(date(1, 3, 2001), date(5, 3, 2001))));
        taskseries1.add(new Task("Obtain Approval", new SimpleTimePeriod(date(9, 3, 2001), date(9, 3, 2001))));
        taskseries1.add(new Task("Requirements Analysis", new SimpleTimePeriod(date(10, 3, 2001), date(15, 4, 2001))));
        taskseries1.add(new Task("Design Phase", new SimpleTimePeriod(date(15, 4, 2001), date(17, 5, 2001))));
        taskseries1.add(new Task("Design Signoff", new SimpleTimePeriod(date(30, 5, 2001), date(30, 5, 2001))));
        taskseries1.add(new Task("Alpha Implementation", new SimpleTimePeriod(date(1, 6, 2001), date(12, 8, 2001))));
        taskseries1.add(new Task("Design Review", new SimpleTimePeriod(date(12, 8, 2001), date(22, 8, 2001))));
        taskseries1.add(new Task("Revised Design Signoff", new SimpleTimePeriod(date(25, 8, 2001), date(27, 8, 2001))));
        taskseries1.add(new Task("Beta Implementation", new SimpleTimePeriod(date(27, 8, 2001), date(30, 9, 2001))));
        taskseries1.add(new Task("Testing", new SimpleTimePeriod(date(31, 9, 2001), date(17, 10, 2001))));
        taskseries1.add(new Task("Final Implementation", new SimpleTimePeriod(date(18, 10, 2001), date(5, 11, 2001))));
        taskseries1.add(new Task("Signoff", new SimpleTimePeriod(date(10, 11, 2001), date(11, 11, 2001))));
        TaskSeriesCollection taskseriescollection = new TaskSeriesCollection();
        taskseriescollection.add(taskseries);
        taskseriescollection.add(taskseries1);
        return taskseriescollection;
    }

    private static Date date(int i, int j, int k)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(k, j, i);
        Date date1 = calendar.getTime();
        return date1;
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalcategorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createGanttChart("Gantt Chart Demo", "Task", "Date", intervalcategorydataset, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10F);
        GanttRenderer ganttrenderer = (GanttRenderer)categoryplot.getRenderer();
        ganttrenderer.setDrawBarOutline(false);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        GanttDemo1 ganttdemo1 = new GanttDemo1("Gantt Chart Demo 1");
        ganttdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(ganttdemo1);
        ganttdemo1.setVisible(true);
    }
}
