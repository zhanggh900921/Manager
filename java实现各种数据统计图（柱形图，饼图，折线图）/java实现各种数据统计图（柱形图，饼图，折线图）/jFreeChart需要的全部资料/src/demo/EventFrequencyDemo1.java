



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.DateFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.DateAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.time.Day;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class EventFrequencyDemo1 extends ApplicationFrame
{

    public EventFrequencyDemo1(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Event Frequency Demo", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(new Color(255, 255, 204));
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.getDomainAxis().setMaximumCategoryLabelWidthRatio(10F);
        categoryplot.setRangeAxis(new DateAxis("Date"));
        StandardCategoryToolTipGenerator standardcategorytooltipgenerator = new StandardCategoryToolTipGenerator("", DateFormat.getDateInstance());
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer(false, true);
        lineandshaperenderer.setBaseToolTipGenerator(standardcategorytooltipgenerator);
        categoryplot.setRenderer(lineandshaperenderer);
        return jfreechart;
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        Day day = new Day(12, 6, 2002);
        Day day1 = new Day(14, 6, 2002);
        Day day2 = new Day(15, 6, 2002);
        Day day3 = new Day(10, 7, 2002);
        Day day4 = new Day(20, 7, 2002);
        Day day5 = new Day(22, 8, 2002);
        defaultcategorydataset.setValue(new Long(day.getMiddleMillisecond()), "Series 1", "Requirement 1");
        defaultcategorydataset.setValue(new Long(day.getMiddleMillisecond()), "Series 1", "Requirement 2");
        defaultcategorydataset.setValue(new Long(day1.getMiddleMillisecond()), "Series 1", "Requirement 3");
        defaultcategorydataset.setValue(new Long(day2.getMiddleMillisecond()), "Series 2", "Requirement 1");
        defaultcategorydataset.setValue(new Long(day3.getMiddleMillisecond()), "Series 2", "Requirement 3");
        defaultcategorydataset.setValue(new Long(day4.getMiddleMillisecond()), "Series 3", "Requirement 2");
        defaultcategorydataset.setValue(new Long(day5.getMiddleMillisecond()), "Series 1", "Requirement 4");
        return defaultcategorydataset;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        EventFrequencyDemo1 eventfrequencydemo1 = new EventFrequencyDemo1("Event Frequency Demo");
        eventfrequencydemo1.pack();
        RefineryUtilities.centerFrameOnScreen(eventfrequencydemo1);
        eventfrequencydemo1.setVisible(true);
    }
}
