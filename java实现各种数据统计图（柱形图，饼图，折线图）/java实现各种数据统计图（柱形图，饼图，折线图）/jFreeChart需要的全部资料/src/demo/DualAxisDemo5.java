



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.renderer.category.CategoryItemRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class DualAxisDemo5 extends ApplicationFrame
{

    public DualAxisDemo5(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset1();
        CategoryDataset categorydataset1 = createDataset2();
        JFreeChart jfreechart = createChart(categorydataset, categorydataset1);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static CategoryDataset createDataset1()
    {
        String s = "Series 1";
        String s1 = "Dummy 1";
        String s2 = "Category 1";
        String s3 = "Category 2";
        String s4 = "Category 3";
        String s5 = "Category 4";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, s, s2);
        defaultcategorydataset.addValue(4D, s, s3);
        defaultcategorydataset.addValue(3D, s, s4);
        defaultcategorydataset.addValue(5D, s, s5);
        defaultcategorydataset.addValue(null, s1, s2);
        defaultcategorydataset.addValue(null, s1, s3);
        defaultcategorydataset.addValue(null, s1, s4);
        defaultcategorydataset.addValue(null, s1, s5);
        return defaultcategorydataset;
    }

    private static CategoryDataset createDataset2()
    {
        String s = "Dummy 2";
        String s1 = "Series 2";
        String s2 = "Category 1";
        String s3 = "Category 2";
        String s4 = "Category 3";
        String s5 = "Category 4";
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(null, s, s2);
        defaultcategorydataset.addValue(null, s, s3);
        defaultcategorydataset.addValue(null, s, s4);
        defaultcategorydataset.addValue(null, s, s5);
        defaultcategorydataset.addValue(75D, s1, s2);
        defaultcategorydataset.addValue(87D, s1, s3);
        defaultcategorydataset.addValue(96D, s1, s4);
        defaultcategorydataset.addValue(68D, s1, s5);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset, CategoryDataset categorydataset1)
    {
        CategoryAxis categoryaxis = new CategoryAxis("Category");
        NumberAxis numberaxis = new NumberAxis("Value");
        BarRenderer barrenderer = new BarRenderer();
        CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis, numberaxis, barrenderer) {

            public LegendItemCollection getLegendItems()
            {
                LegendItemCollection legenditemcollection = new LegendItemCollection();
                CategoryDataset categorydataset2 = getDataset();
                if(categorydataset2 != null)
                {
                    CategoryItemRenderer categoryitemrenderer = getRenderer();
                    if(categoryitemrenderer != null)
                    {
                        org.jfree.chart.LegendItem legenditem = categoryitemrenderer.getLegendItem(0, 0);
                        legenditemcollection.add(legenditem);
                    }
                }
                CategoryDataset categorydataset3 = getDataset(1);
                if(categorydataset3 != null)
                {
                    CategoryItemRenderer categoryitemrenderer1 = getRenderer(1);
                    if(categoryitemrenderer1 != null)
                    {
                        org.jfree.chart.LegendItem legenditem1 = categoryitemrenderer1.getLegendItem(1, 1);
                        legenditemcollection.add(legenditem1);
                    }
                }
                return legenditemcollection;
            }

        }
;
        JFreeChart jfreechart = new JFreeChart("Dual Axis Bar Chart", categoryplot);
        jfreechart.setBackgroundPaint(Color.white);
        categoryplot.setBackgroundPaint(new Color(238, 238, 255));
        categoryplot.setDomainAxisLocation(AxisLocation.BOTTOM_OR_RIGHT);
        categoryplot.setDataset(1, categorydataset1);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        NumberAxis numberaxis1 = new NumberAxis("Secondary");
        categoryplot.setRangeAxis(1, numberaxis1);
        categoryplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        BarRenderer barrenderer1 = new BarRenderer();
        categoryplot.setRenderer(1, barrenderer1);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset1(), createDataset2());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        DualAxisDemo5 dualaxisdemo5 = new DualAxisDemo5("Dual Axis Demo 5");
        dualaxisdemo5.pack();
        RefineryUtilities.centerFrameOnScreen(dualaxisdemo5);
        dualaxisdemo5.setVisible(true);
    }
}
