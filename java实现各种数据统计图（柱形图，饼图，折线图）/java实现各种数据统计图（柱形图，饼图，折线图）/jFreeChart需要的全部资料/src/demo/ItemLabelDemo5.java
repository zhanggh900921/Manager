



package demo;

import java.awt.*;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.StackedBarRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class ItemLabelDemo5 extends ApplicationFrame
{
    private static class MyStackedBarRenderer extends StackedBarRenderer
    {

        public Paint getItemPaint(int i, int j)
        {
            if(oldColumn != j)
            {
                count = 0;
                oldColumn = j;
            } else
            {
                count++;
            }
            return list[count];
        }

        int oldColumn;
        int count;
        Paint list[];

        private MyStackedBarRenderer()
        {
            oldColumn = -99;
            count = 0;
            list = DefaultDrawingSupplier.DEFAULT_PAINT_SEQUENCE;
        }

    }


    public ItemLabelDemo5(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(52.829999999999998D, "Germany", "Western EU");
        defaultcategorydataset.addValue(20.829999999999998D, "France", "Western EU");
        defaultcategorydataset.addValue(10.83D, "Great Britain", "Western EU");
        defaultcategorydataset.addValue(7.3300000000000001D, "Netherlands", "Western EU");
        defaultcategorydataset.addValue(4.6600000000000001D, "Belgium", "Western EU");
        defaultcategorydataset.addValue(57.140000000000001D, "Spain", "Southern EU");
        defaultcategorydataset.addValue(14.279999999999999D, "Greece", "Southern EU");
        defaultcategorydataset.addValue(14.279999999999999D, "Italy", "Southern EU");
        defaultcategorydataset.addValue(14.279999999999999D, "Portugal", "Southern EU");
        defaultcategorydataset.addValue(100D, "Czech Republic", "Eastern EU");
        defaultcategorydataset.addValue(66.659999999999997D, "Denmark", "Scandinavia");
        defaultcategorydataset.addValue(33.329999999999998D, "Finland", "Scandinavia");
        defaultcategorydataset.addValue(0.0D, "", "Africa");
        defaultcategorydataset.addValue(100D, "Israel", "Asia");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Item Label Demo 5", null, null, categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(new Color(255, 255, 255));
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        MyStackedBarRenderer mystackedbarrenderer = new MyStackedBarRenderer();
        categoryplot.setRenderer(mystackedbarrenderer);
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.CENTER, TextAnchor.CENTER, TextAnchor.CENTER, 0.0D);
        mystackedbarrenderer.setPositiveItemLabelPositionFallback(itemlabelposition);
        mystackedbarrenderer.setNegativeItemLabelPositionFallback(itemlabelposition);
        StandardCategoryItemLabelGenerator standardcategoryitemlabelgenerator = new StandardCategoryItemLabelGenerator("{0}", NumberFormat.getInstance());
        mystackedbarrenderer.setBaseItemLabelGenerator(standardcategoryitemlabelgenerator);
        mystackedbarrenderer.setBaseItemLabelsVisible(true);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setUpperBound(100D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        ItemLabelDemo5 itemlabeldemo5 = new ItemLabelDemo5("Item Label Demo 5");
        itemlabeldemo5.pack();
        RefineryUtilities.centerFrameOnScreen(itemlabeldemo5);
        itemlabeldemo5.setVisible(true);
    }
}
