



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.SubCategoryAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.GroupedStackedBarRenderer;
import org.jfree.data.KeyToGroupMap;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChartDemo4 extends ApplicationFrame
{

    public StackedBarChartDemo4(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(590, 350));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(20.300000000000001D, "Product 1 (US)", "Jan 04");
        defaultcategorydataset.addValue(27.199999999999999D, "Product 1 (US)", "Feb 04");
        defaultcategorydataset.addValue(19.699999999999999D, "Product 1 (US)", "Mar 04");
        defaultcategorydataset.addValue(19.399999999999999D, "Product 1 (Europe)", "Jan 04");
        defaultcategorydataset.addValue(10.9D, "Product 1 (Europe)", "Feb 04");
        defaultcategorydataset.addValue(18.399999999999999D, "Product 1 (Europe)", "Mar 04");
        defaultcategorydataset.addValue(16.5D, "Product 1 (Asia)", "Jan 04");
        defaultcategorydataset.addValue(15.9D, "Product 1 (Asia)", "Feb 04");
        defaultcategorydataset.addValue(16.100000000000001D, "Product 1 (Asia)", "Mar 04");
        defaultcategorydataset.addValue(13.199999999999999D, "Product 1 (Middle East)", "Jan 04");
        defaultcategorydataset.addValue(14.4D, "Product 1 (Middle East)", "Feb 04");
        defaultcategorydataset.addValue(13.699999999999999D, "Product 1 (Middle East)", "Mar 04");
        defaultcategorydataset.addValue(23.300000000000001D, "Product 2 (US)", "Jan 04");
        defaultcategorydataset.addValue(16.199999999999999D, "Product 2 (US)", "Feb 04");
        defaultcategorydataset.addValue(28.699999999999999D, "Product 2 (US)", "Mar 04");
        defaultcategorydataset.addValue(12.699999999999999D, "Product 2 (Europe)", "Jan 04");
        defaultcategorydataset.addValue(17.899999999999999D, "Product 2 (Europe)", "Feb 04");
        defaultcategorydataset.addValue(12.6D, "Product 2 (Europe)", "Mar 04");
        defaultcategorydataset.addValue(15.4D, "Product 2 (Asia)", "Jan 04");
        defaultcategorydataset.addValue(21D, "Product 2 (Asia)", "Feb 04");
        defaultcategorydataset.addValue(11.1D, "Product 2 (Asia)", "Mar 04");
        defaultcategorydataset.addValue(23.800000000000001D, "Product 2 (Middle East)", "Jan 04");
        defaultcategorydataset.addValue(23.399999999999999D, "Product 2 (Middle East)", "Feb 04");
        defaultcategorydataset.addValue(19.300000000000001D, "Product 2 (Middle East)", "Mar 04");
        defaultcategorydataset.addValue(11.9D, "Product 3 (US)", "Jan 04");
        defaultcategorydataset.addValue(31D, "Product 3 (US)", "Feb 04");
        defaultcategorydataset.addValue(22.699999999999999D, "Product 3 (US)", "Mar 04");
        defaultcategorydataset.addValue(15.300000000000001D, "Product 3 (Europe)", "Jan 04");
        defaultcategorydataset.addValue(14.4D, "Product 3 (Europe)", "Feb 04");
        defaultcategorydataset.addValue(25.300000000000001D, "Product 3 (Europe)", "Mar 04");
        defaultcategorydataset.addValue(23.899999999999999D, "Product 3 (Asia)", "Jan 04");
        defaultcategorydataset.addValue(19D, "Product 3 (Asia)", "Feb 04");
        defaultcategorydataset.addValue(10.1D, "Product 3 (Asia)", "Mar 04");
        defaultcategorydataset.addValue(13.199999999999999D, "Product 3 (Middle East)", "Jan 04");
        defaultcategorydataset.addValue(15.5D, "Product 3 (Middle East)", "Feb 04");
        defaultcategorydataset.addValue(10.1D, "Product 3 (Middle East)", "Mar 04");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Stacked Bar Chart Demo 4", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        GroupedStackedBarRenderer groupedstackedbarrenderer = new GroupedStackedBarRenderer();
        KeyToGroupMap keytogroupmap = new KeyToGroupMap("G1");
        keytogroupmap.mapKeyToGroup("Product 1 (US)", "G1");
        keytogroupmap.mapKeyToGroup("Product 1 (Europe)", "G1");
        keytogroupmap.mapKeyToGroup("Product 1 (Asia)", "G1");
        keytogroupmap.mapKeyToGroup("Product 1 (Middle East)", "G1");
        keytogroupmap.mapKeyToGroup("Product 2 (US)", "G2");
        keytogroupmap.mapKeyToGroup("Product 2 (Europe)", "G2");
        keytogroupmap.mapKeyToGroup("Product 2 (Asia)", "G2");
        keytogroupmap.mapKeyToGroup("Product 2 (Middle East)", "G2");
        keytogroupmap.mapKeyToGroup("Product 3 (US)", "G3");
        keytogroupmap.mapKeyToGroup("Product 3 (Europe)", "G3");
        keytogroupmap.mapKeyToGroup("Product 3 (Asia)", "G3");
        keytogroupmap.mapKeyToGroup("Product 3 (Middle East)", "G3");
        groupedstackedbarrenderer.setSeriesToGroupMap(keytogroupmap);
        groupedstackedbarrenderer.setItemMargin(0.10000000000000001D);
        groupedstackedbarrenderer.setDrawBarOutline(false);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, new Color(34, 34, 255), 0.0F, 0.0F, new Color(136, 136, 255));
        groupedstackedbarrenderer.setSeriesPaint(0, gradientpaint);
        groupedstackedbarrenderer.setSeriesPaint(4, gradientpaint);
        groupedstackedbarrenderer.setSeriesPaint(8, gradientpaint);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, new Color(34, 255, 34), 0.0F, 0.0F, new Color(136, 255, 136));
        groupedstackedbarrenderer.setSeriesPaint(1, gradientpaint1);
        groupedstackedbarrenderer.setSeriesPaint(5, gradientpaint1);
        groupedstackedbarrenderer.setSeriesPaint(9, gradientpaint1);
        GradientPaint gradientpaint2 = new GradientPaint(0.0F, 0.0F, new Color(255, 34, 34), 0.0F, 0.0F, new Color(255, 136, 136));
        groupedstackedbarrenderer.setSeriesPaint(2, gradientpaint2);
        groupedstackedbarrenderer.setSeriesPaint(6, gradientpaint2);
        groupedstackedbarrenderer.setSeriesPaint(10, gradientpaint2);
        GradientPaint gradientpaint3 = new GradientPaint(0.0F, 0.0F, new Color(255, 255, 34), 0.0F, 0.0F, new Color(255, 255, 136));
        groupedstackedbarrenderer.setSeriesPaint(3, gradientpaint3);
        groupedstackedbarrenderer.setSeriesPaint(7, gradientpaint3);
        groupedstackedbarrenderer.setSeriesPaint(11, gradientpaint3);
        groupedstackedbarrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.HORIZONTAL));
        SubCategoryAxis subcategoryaxis = new SubCategoryAxis("Product / Month");
        subcategoryaxis.setCategoryMargin(0.050000000000000003D);
        subcategoryaxis.addSubCategory("Product 1");
        subcategoryaxis.addSubCategory("Product 2");
        subcategoryaxis.addSubCategory("Product 3");
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setDomainAxis(subcategoryaxis);
        categoryplot.setRenderer(groupedstackedbarrenderer);
        categoryplot.setFixedLegendItems(createLegendItems());
        return jfreechart;
    }

    private static LegendItemCollection createLegendItems()
    {
        LegendItemCollection legenditemcollection = new LegendItemCollection();
        LegendItem legenditem = new LegendItem("US", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(34, 34, 255));
        LegendItem legenditem1 = new LegendItem("Europe", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(34, 255, 34));
        LegendItem legenditem2 = new LegendItem("Asia", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(255, 34, 34));
        LegendItem legenditem3 = new LegendItem("Middle East", "-", null, null, Plot.DEFAULT_LEGEND_ITEM_BOX, new Color(255, 255, 34));
        legenditemcollection.add(legenditem);
        legenditemcollection.add(legenditem1);
        legenditemcollection.add(legenditem2);
        legenditemcollection.add(legenditem3);
        return legenditemcollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo4 stackedbarchartdemo4 = new StackedBarChartDemo4("Stacked Bar Chart Demo 4");
        stackedbarchartdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo4);
        stackedbarchartdemo4.setVisible(true);
    }
}
