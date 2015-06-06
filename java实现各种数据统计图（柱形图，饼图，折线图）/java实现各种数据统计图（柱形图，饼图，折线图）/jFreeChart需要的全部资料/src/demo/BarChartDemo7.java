



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class BarChartDemo7 extends ApplicationFrame
{
    static class LabelGenerator extends StandardCategoryItemLabelGenerator
    {

        public String generateLabel(CategoryDataset categorydataset, int i, int j)
        {
            return categorydataset.getRowKey(i).toString();
        }

        LabelGenerator()
        {
        }
    }


    public BarChartDemo7(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
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
        defaultcategorydataset.addValue(1.0D, s, s3);
        defaultcategorydataset.addValue(4D, s, s4);
        defaultcategorydataset.addValue(3D, s, s5);
        defaultcategorydataset.addValue(5D, s, s6);
        defaultcategorydataset.addValue(5D, s, s7);
        defaultcategorydataset.addValue(5D, s1, s3);
        defaultcategorydataset.addValue(7D, s1, s4);
        defaultcategorydataset.addValue(6D, s1, s5);
        defaultcategorydataset.addValue(8D, s1, s6);
        defaultcategorydataset.addValue(4D, s1, s7);
        defaultcategorydataset.addValue(4D, s2, s3);
        defaultcategorydataset.addValue(3D, s2, s4);
        defaultcategorydataset.addValue(0.0D, s2, s5);
        defaultcategorydataset.addValue(3D, s2, s6);
        defaultcategorydataset.addValue(6D, s2, s7);
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Bar Chart Demo 7", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinePaint(Color.white);
        IntervalMarker intervalmarker = new IntervalMarker(4.5D, 7.5D);
        intervalmarker.setLabel("Target Range");
        intervalmarker.setLabelFont(new Font("SansSerif", 2, 11));
        intervalmarker.setLabelAnchor(RectangleAnchor.LEFT);
        intervalmarker.setLabelTextAnchor(TextAnchor.CENTER_LEFT);
        intervalmarker.setPaint(new Color(222, 222, 255, 128));
        categoryplot.addRangeMarker(intervalmarker, Layer.BACKGROUND);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        barrenderer.setItemMargin(0.10000000000000001D);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.lightGray);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, Color.lightGray);
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.lightGray);
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, gradientpaint1);
        barrenderer.setSeriesPaint(2, gradientpaint2);
        barrenderer.setBaseItemLabelGenerator(new LabelGenerator());
        barrenderer.setBaseItemLabelsVisible(true);
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.CENTER_RIGHT, TextAnchor.CENTER_RIGHT, -1.5707963267948966D);
        barrenderer.setBasePositiveItemLabelPosition(itemlabelposition);
        ItemLabelPosition itemlabelposition1 = new ItemLabelPosition(ItemLabelAnchor.OUTSIDE12, TextAnchor.CENTER_LEFT, TextAnchor.CENTER_LEFT, -1.5707963267948966D);
        barrenderer.setPositiveItemLabelPositionFallback(itemlabelposition1);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo7 barchartdemo7 = new BarChartDemo7("Bar Chart Demo 7");
        barchartdemo7.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo7);
        barchartdemo7.setVisible(true);
    }
}
