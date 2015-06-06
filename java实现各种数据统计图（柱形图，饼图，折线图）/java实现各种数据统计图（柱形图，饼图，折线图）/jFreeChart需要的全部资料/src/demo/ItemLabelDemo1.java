



package demo;

import java.awt.*;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
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

public class ItemLabelDemo1 extends ApplicationFrame
{
    static class LabelGenerator extends AbstractCategoryItemLabelGenerator
        implements CategoryItemLabelGenerator
    {

        public String generateLabel(CategoryDataset categorydataset, int i, int j)
        {
            String s = null;
            Number number = categorydataset.getValue(i, j);
            if(number != null)
            {
                double d = number.doubleValue();
                if(d > threshold)
                    s = number.toString();
            }
            return s;
        }

        private double threshold;

        public LabelGenerator(double d)
        {
            super("", NumberFormat.getInstance());
            threshold = d;
        }
    }


    public ItemLabelDemo1(String s)
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
        defaultcategorydataset.addValue(11D, "S1", "C1");
        defaultcategorydataset.addValue(44.299999999999997D, "S1", "C2");
        defaultcategorydataset.addValue(93D, "S1", "C3");
        defaultcategorydataset.addValue(35.600000000000001D, "S1", "C4");
        defaultcategorydataset.addValue(75.099999999999994D, "S1", "C5");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Item Label Demo 1", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setUpperMargin(0.14999999999999999D);
        CategoryItemRenderer categoryitemrenderer = categoryplot.getRenderer();
        categoryitemrenderer.setBaseItemLabelGenerator(new LabelGenerator(50D));
        categoryitemrenderer.setBaseItemLabelFont(new Font("Serif", 0, 20));
        categoryitemrenderer.setBaseItemLabelsVisible(true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        ItemLabelDemo1 itemlabeldemo1 = new ItemLabelDemo1("Item Label Demo 1");
        itemlabeldemo1.pack();
        RefineryUtilities.centerFrameOnScreen(itemlabeldemo1);
        itemlabeldemo1.setVisible(true);
    }
}
