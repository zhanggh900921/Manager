



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class GanttDemo2 extends ApplicationFrame
{

    public GanttDemo2(String s)
    {
        super(s);
        IntervalCategoryDataset intervalcategorydataset = createDataset();
        JFreeChart jfreechart = createChart(intervalcategorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(IntervalCategoryDataset intervalcategorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createGanttChart("Gantt Chart Demo", "Task", "Date", intervalcategorydataset, true, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10F);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setSeriesPaint(0, Color.blue);
        return jfreechart;
    }

    private static IntervalCategoryDataset createDataset()
    {
        TaskSeries taskseries = new TaskSeries("Scheduled");
        Task task = new Task("Write Proposal", date(1, 3, 2001), date(5, 3, 2001));
        task.setPercentComplete(1.0D);
        taskseries.add(task);
        Task task1 = new Task("Obtain Approval", date(9, 3, 2001), date(9, 3, 2001));
        task1.setPercentComplete(1.0D);
        taskseries.add(task1);
        Task task2 = new Task("Requirements Analysis", date(10, 3, 2001), date(5, 4, 2001));
        Task task3 = new Task("Requirements 1", date(10, 3, 2001), date(25, 3, 2001));
        task3.setPercentComplete(1.0D);
        Task task4 = new Task("Requirements 2", date(1, 4, 2001), date(5, 4, 2001));
        task4.setPercentComplete(1.0D);
        task2.addSubtask(task3);
        task2.addSubtask(task4);
        taskseries.add(task2);
        Task task5 = new Task("Design Phase", date(6, 4, 2001), date(30, 4, 2001));
        Task task6 = new Task("Design 1", date(6, 4, 2001), date(10, 4, 2001));
        task6.setPercentComplete(1.0D);
        Task task7 = new Task("Design 2", date(15, 4, 2001), date(20, 4, 2001));
        task7.setPercentComplete(1.0D);
        Task task8 = new Task("Design 3", date(23, 4, 2001), date(30, 4, 2001));
        task8.setPercentComplete(0.5D);
        task5.addSubtask(task6);
        task5.addSubtask(task7);
        task5.addSubtask(task8);
        taskseries.add(task5);
        Task task9 = new Task("Design Signoff", date(2, 5, 2001), date(2, 5, 2001));
        taskseries.add(task9);
        Task task10 = new Task("Alpha Implementation", date(3, 5, 2001), date(31, 6, 2001));
        task10.setPercentComplete(0.59999999999999998D);
        taskseries.add(task10);
        Task task11 = new Task("Design Review", date(1, 7, 2001), date(8, 7, 2001));
        task11.setPercentComplete(0.0D);
        taskseries.add(task11);
        Task task12 = new Task("Revised Design Signoff", date(10, 7, 2001), date(10, 7, 2001));
        task12.setPercentComplete(0.0D);
        taskseries.add(task12);
        Task task13 = new Task("Beta Implementation", date(12, 7, 2001), date(12, 8, 2001));
        task13.setPercentComplete(0.0D);
        taskseries.add(task13);
        Task task14 = new Task("Testing", date(13, 8, 2001), date(31, 9, 2001));
        task14.setPercentComplete(0.0D);
        taskseries.add(task14);
        Task task15 = new Task("Final Implementation", date(1, 10, 2001), date(15, 10, 2001));
        task15.setPercentComplete(0.0D);
        taskseries.add(task15);
        Task task16 = new Task("Signoff", date(28, 10, 2001), date(30, 10, 2001));
        task16.setPercentComplete(0.0D);
        taskseries.add(task16);
        TaskSeriesCollection taskseriescollection = new TaskSeriesCollection();
        taskseriescollection.add(taskseries);
        return taskseriescollection;
    }

    private static Date date(int i, int j, int k)
    {
        Calendar calendar = Calendar.getInstance();
        calendar.set(k, j, i);
        Date date1 = calendar.getTime();
        return date1;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        GanttDemo2 ganttdemo2 = new GanttDemo2("Gantt Chart Demo 2");
        ganttdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(ganttdemo2);
        ganttdemo2.setVisible(true);
    }
}
