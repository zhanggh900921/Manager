



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

// Referenced classes of package demo:
//            Animator

public class BarChartDemo10 extends ApplicationFrame
{

    public BarChartDemo10(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static DefaultCategoryDataset createDataset()
    {
        String s = "First";
        String s1 = "Second";
        String s2 = "Third";
        String s3 = "Category 1";
        String s4 = "Category 2";
        String s5 = "Category 3";
        String s6 = "Category 4";
        String s7 = "Category 5";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(31D, s, s3);
        defaultcategorydataset.addValue(44D, s, s4);
        defaultcategorydataset.addValue(33D, s, s5);
        defaultcategorydataset.addValue(45D, s, s6);
        defaultcategorydataset.addValue(35D, s, s7);
        defaultcategorydataset.addValue(45D, s1, s3);
        defaultcategorydataset.addValue(37D, s1, s4);
        defaultcategorydataset.addValue(46D, s1, s5);
        defaultcategorydataset.addValue(38D, s1, s6);
        defaultcategorydataset.addValue(44D, s1, s7);
        defaultcategorydataset.addValue(34D, s2, s3);
        defaultcategorydataset.addValue(43D, s2, s4);
        defaultcategorydataset.addValue(32D, s2, s5);
        defaultcategorydataset.addValue(43D, s2, s6);
        defaultcategorydataset.addValue(36D, s2, s7);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, new Color(0, 0, 64));
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, gradientpaint1);
        barrenderer.setSeriesPaint(2, gradientpaint2);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.createUpRotationLabelPositions(0.52359877559829882D));
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        DefaultCategoryDataset defaultcategorydataset = createDataset();
        JFreeChart jfreechart = createChart(defaultcategorydataset);
        Animator animator = new Animator(defaultcategorydataset);
        animator.start();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo10 barchartdemo10 = new BarChartDemo10("Bar Chart Demo 10");
        barchartdemo10.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo10);
        barchartdemo10.setVisible(true);
    }
}
