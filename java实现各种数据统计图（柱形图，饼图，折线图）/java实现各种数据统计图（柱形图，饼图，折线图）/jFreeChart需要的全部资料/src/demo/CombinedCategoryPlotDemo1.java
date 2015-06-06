



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.CombinedDomainCategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo1 extends ApplicationFrame
{

    public CombinedCategoryPlotDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static CategoryDataset createDataset1()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        String s = "First";
        String s1 = "Second";
        String s2 = "Type 1";
        String s3 = "Type 2";
        String s4 = "Type 3";
        String s5 = "Type 4";
        String s6 = "Type 5";
        String s7 = "Type 6";
        String s8 = "Type 7";
        String s9 = "Type 8";
        defaultcategorydataset.addValue(1.0D, s, s2);
        defaultcategorydataset.addValue(4D, s, s3);
        defaultcategorydataset.addValue(3D, s, s4);
        defaultcategorydataset.addValue(5D, s, s5);
        defaultcategorydataset.addValue(5D, s, s6);
        defaultcategorydataset.addValue(7D, s, s7);
        defaultcategorydataset.addValue(7D, s, s8);
        defaultcategorydataset.addValue(8D, s, s9);
        defaultcategorydataset.addValue(5D, s1, s2);
        defaultcategorydataset.addValue(7D, s1, s3);
        defaultcategorydataset.addValue(6D, s1, s4);
        defaultcategorydataset.addValue(8D, s1, s5);
        defaultcategorydataset.addValue(4D, s1, s6);
        defaultcategorydataset.addValue(4D, s1, s7);
        defaultcategorydataset.addValue(2D, s1, s8);
        defaultcategorydataset.addValue(1.0D, s1, s9);
        return defaultcategorydataset;
    }

    public static CategoryDataset createDataset2()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        String s = "Third";
        String s1 = "Fourth";
        String s2 = "Type 1";
        String s3 = "Type 2";
        String s4 = "Type 3";
        String s5 = "Type 4";
        String s6 = "Type 5";
        String s7 = "Type 6";
        String s8 = "Type 7";
        String s9 = "Type 8";
        defaultcategorydataset.addValue(11D, s, s2);
        defaultcategorydataset.addValue(14D, s, s3);
        defaultcategorydataset.addValue(13D, s, s4);
        defaultcategorydataset.addValue(15D, s, s5);
        defaultcategorydataset.addValue(15D, s, s6);
        defaultcategorydataset.addValue(17D, s, s7);
        defaultcategorydataset.addValue(17D, s, s8);
        defaultcategorydataset.addValue(18D, s, s9);
        defaultcategorydataset.addValue(15D, s1, s2);
        defaultcategorydataset.addValue(17D, s1, s3);
        defaultcategorydataset.addValue(16D, s1, s4);
        defaultcategorydataset.addValue(18D, s1, s5);
        defaultcategorydataset.addValue(14D, s1, s6);
        defaultcategorydataset.addValue(14D, s1, s7);
        defaultcategorydataset.addValue(12D, s1, s8);
        defaultcategorydataset.addValue(11D, s1, s9);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart()
    {
        CategoryDataset categorydataset = createDataset1();
        NumberAxis numberaxis = new NumberAxis("Value");
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot categoryplot = new CategoryPlot(categorydataset, null, numberaxis, lineandshaperenderer);
        categoryplot.setDomainGridlinesVisible(true);
        CategoryDataset categorydataset1 = createDataset2();
        NumberAxis numberaxis1 = new NumberAxis("Value");
        numberaxis1.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = new BarRenderer();
        barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot categoryplot1 = new CategoryPlot(categorydataset1, null, numberaxis1, barrenderer);
        categoryplot1.setDomainGridlinesVisible(true);
        CategoryAxis categoryaxis = new CategoryAxis("Category");
        CombinedDomainCategoryPlot combineddomaincategoryplot = new CombinedDomainCategoryPlot(categoryaxis);
        combineddomaincategoryplot.add(categoryplot, 2);
        combineddomaincategoryplot.add(categoryplot1, 1);
        JFreeChart jfreechart = new JFreeChart("Combined Domain Category Plot Demo", new Font("SansSerif", 1, 12), combineddomaincategoryplot, true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        String s = "Combined Category Plot Demo 1";
        CombinedCategoryPlotDemo1 combinedcategoryplotdemo1 = new CombinedCategoryPlotDemo1(s);
        combinedcategoryplotdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(combinedcategoryplotdemo1);
        combinedcategoryplotdemo1.setVisible(true);
    }
}
