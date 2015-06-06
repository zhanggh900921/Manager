



package demo;

import java.awt.Dimension;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.GanttRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.data.time.SimpleTimePeriod;
import org.jfree.ui.*;

public class GanttDemo3 extends ApplicationFrame
{
    static class MyLabelGenerator
        implements CategoryItemLabelGenerator
    {

        public String generateLabel(CategoryDataset categorydataset, int i, int j)
        {
            Number number = null;
            if(categorydataset instanceof IntervalCategoryDataset)
            {
                IntervalCategoryDataset intervalcategorydataset = (IntervalCategoryDataset)categorydataset;
                number = intervalcategorydataset.getEndValue(i, j);
            } else
            {
                number = categorydataset.getValue(i, j);
            }
            if(number == null)
            {
                return "null";
            } else
            {
                long l = number.longValue();
                Date date1 = new Date(l);
                return df.format(date1);
            }
        }

        public String generateColumnLabel(CategoryDataset categorydataset, int i)
        {
            return categorydataset.getColumnKey(i).toString();
        }

        public String generateRowLabel(CategoryDataset categorydataset, int i)
        {
            return categorydataset.getRowKey(i).toString();
        }

        DateFormat df;

        public MyLabelGenerator(DateFormat dateformat)
        {
            df = dateformat;
        }
    }


    public GanttDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 370));
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
        DateAxis dateaxis = (DateAxis)categoryplot.getRangeAxis();
        dateaxis.setUpperMargin(0.20000000000000001D);
        GanttRenderer ganttrenderer = (GanttRenderer)categoryplot.getRenderer();
        ganttrenderer.setDrawBarOutline(false);
        ganttrenderer.setBaseItemLabelGenerator(new MyLabelGenerator(new SimpleDateFormat("d-MMM")));
        ganttrenderer.setBaseItemLabelsVisible(true);
        ganttrenderer.setBasePositiveItemLabelPosition(new ItemLabelPosition(ItemLabelAnchor.OUTSIDE3, TextAnchor.CENTER_LEFT));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        GanttDemo3 ganttdemo3 = new GanttDemo3("Gantt Chart Demo 3");
        ganttdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(ganttdemo3);
        ganttdemo3.setVisible(true);
    }
}
