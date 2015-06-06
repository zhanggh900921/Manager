



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.AbstractCategoryItemLabelGenerator;
import org.jfree.chart.labels.CategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class ItemLabelDemo2 extends ApplicationFrame
{
    static class LabelGenerator extends AbstractCategoryItemLabelGenerator
        implements CategoryItemLabelGenerator
    {

        public String generateLabel(CategoryDataset categorydataset, int i, int j)
        {
            String s = null;
            double d = 0.0D;
            if(category != null)
            {
                Number number = categorydataset.getValue(i, category.intValue());
                d = number.doubleValue();
            } else
            {
                d = calculateSeriesTotal(categorydataset, i);
            }
            Number number1 = categorydataset.getValue(i, j);
            if(number1 != null)
            {
                double d1 = number1.doubleValue();
                s = number1.toString() + " (" + formatter.format(d1 / d) + ")";
            }
            return s;
        }

        private double calculateSeriesTotal(CategoryDataset categorydataset, int i)
        {
            double d = 0.0D;
            for(int j = 0; j < categorydataset.getColumnCount(); j++)
            {
                Number number = categorydataset.getValue(i, j);
                if(number != null)
                    d += number.doubleValue();
            }

            return d;
        }

        private Integer category;
        private NumberFormat formatter;

        public LabelGenerator(int i)
        {
            this(new Integer(i));
        }

        public LabelGenerator(Integer integer)
        {
            super("", NumberFormat.getInstance());
            formatter = NumberFormat.getPercentInstance();
            category = integer;
        }
    }


    public ItemLabelDemo2(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(100D, "S1", "C1");
        defaultcategorydataset.addValue(44.299999999999997D, "S1", "C2");
        defaultcategorydataset.addValue(93D, "S1", "C3");
        defaultcategorydataset.addValue(80D, "S2", "C1");
        defaultcategorydataset.addValue(75.099999999999994D, "S2", "C2");
        defaultcategorydataset.addValue(15.1D, "S2", "C3");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Item Label Demo 2", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setUpperMargin(0.25D);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setBaseItemLabelsVisible(true);
        categoryitemrenderer.setBaseItemLabelGenerator(new LabelGenerator(null));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        ItemLabelDemo2 itemlabeldemo2 = new ItemLabelDemo2("Item Label Demo 2");
        itemlabeldemo2.pack();
        RefineryUtilities.centerFrameOnScreen(itemlabeldemo2);
        itemlabeldemo2.setVisible(true);
    }
}
