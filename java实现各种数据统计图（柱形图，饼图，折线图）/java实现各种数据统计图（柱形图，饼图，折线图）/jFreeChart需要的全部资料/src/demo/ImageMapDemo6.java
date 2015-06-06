



package demo;

import java.io.*;
import java.util.Calendar;
import java.util.Date;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.data.category.IntervalCategoryDataset;
import org.jfree.data.gantt.*;
import org.jfree.data.time.SimpleTimePeriod;

public class ImageMapDemo6
{

    public ImageMapDemo6()
    {
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
        JFreeChart jfreechart = ChartFactory.createGanttChart("Gantt Chart Demo", "Task", "Date", intervalcategorydataset, true, true, true);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setMaximumCategoryLabelWidthRatio(10F);
        categoryaxis.addCategoryLabelToolTip("Obtain Approval", "Testing 123");
        return jfreechart;
    }

    public static void main(String args[])
    {
        JFreeChart jfreechart = createChart(createDataset());
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("ImageMapDemo8.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("ImageMapDemo8.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo 8</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"ImageMapDemo8.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"ImageMapDemo8.png\"/>");
            printwriter.println("</p></body>");
            printwriter.println("</html>");
            printwriter.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.toString());
        }
    }
}
