



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedCategoryPlotDemo2 extends ApplicationFrame
{

    public CombinedCategoryPlotDemo2(String s)
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
        String s2 = "Sector 1";
        String s3 = "Sector 2";
        String s4 = "Sector 3";
        String s5 = "Sector 4";
        defaultcategorydataset.addValue(11D, s, s2);
        defaultcategorydataset.addValue(14D, s, s3);
        defaultcategorydataset.addValue(13D, s, s4);
        defaultcategorydataset.addValue(15D, s, s5);
        defaultcategorydataset.addValue(15D, s1, s2);
        defaultcategorydataset.addValue(17D, s1, s3);
        defaultcategorydataset.addValue(16D, s1, s4);
        defaultcategorydataset.addValue(18D, s1, s5);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart()
    {
        CategoryDataset categorydataset = createDataset1();
        CategoryAxis categoryaxis = new CategoryAxis("Class 1");
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryaxis.setMaximumCategoryLabelWidthRatio(5F);
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        lineandshaperenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis, null, lineandshaperenderer);
        categoryplot.setDomainGridlinesVisible(true);
        CategoryDataset categorydataset1 = createDataset2();
        CategoryAxis categoryaxis1 = new CategoryAxis("Class 2");
        categoryaxis1.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryaxis1.setMaximumCategoryLabelWidthRatio(5F);
        BarRenderer barrenderer = new BarRenderer();
        barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        CategoryPlot categoryplot1 = new CategoryPlot(categorydataset1, categoryaxis1, null, barrenderer);
        categoryplot1.setDomainGridlinesVisible(true);
        NumberAxis numberaxis = new NumberAxis("Value");
        CombinedRangeCategoryPlot combinedrangecategoryplot = new CombinedRangeCategoryPlot(numberaxis);
        combinedrangecategoryplot.add(categoryplot, 3);
        combinedrangecategoryplot.add(categoryplot1, 2);
        combinedrangecategoryplot.setOrientation(PlotOrientation.HORIZONTAL);
        JFreeChart jfreechart = new JFreeChart("Combined Range Category Plot Demo", new Font("SansSerif", 1, 12), combinedrangecategoryplot, true);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        String s = "JFreeChart: Combined Category Plot Demo 2";
        CombinedCategoryPlotDemo2 combinedcategoryplotdemo2 = new CombinedCategoryPlotDemo2(s);
        combinedcategoryplotdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(combinedcategoryplotdemo2);
        combinedcategoryplotdemo2.setVisible(true);
    }
}
