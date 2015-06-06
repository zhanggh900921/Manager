



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.ExtendedCategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class SurveyResultsDemo2 extends ApplicationFrame
{

    public SurveyResultsDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(300, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.3200000000000001D, "Results", "Sm.");
        defaultcategorydataset.addValue(0.40000000000000002D, "Results", "Med.");
        defaultcategorydataset.addValue(2.6200000000000001D, "Results", "Lg.");
        defaultcategorydataset.addValue(1.4399999999999999D, "Results", "All");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart(null, null, null, categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        jfreechart.getPlot().setOutlinePaint(null);
        TextTitle texttitle = new TextTitle("Figure 8.5 - Case studies are available");
        texttitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        texttitle.setBackgroundPaint(Color.red);
        texttitle.setPaint(Color.white);
        jfreechart.setTitle(texttitle);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        ValueAxis valueaxis = categoryplot.getRangeAxis();
        valueaxis.setRange(0.0D, 5D);
        valueaxis.setVisible(false);
        ExtendedCategoryAxis extendedcategoryaxis = new ExtendedCategoryAxis(null);
        extendedcategoryaxis.setTickLabelFont(new Font("SansSerif", 1, 12));
        extendedcategoryaxis.setCategoryMargin(0.29999999999999999D);
        extendedcategoryaxis.addSubLabel("Sm.", "(10)");
        extendedcategoryaxis.addSubLabel("Med.", "(10)");
        extendedcategoryaxis.addSubLabel("Lg.", "(10)");
        extendedcategoryaxis.addSubLabel("All", "(10)");
        categoryplot.setDomainAxis(extendedcategoryaxis);
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setSeriesPaint(0, new Color(156, 164, 74));
        barrenderer.setDrawBarOutline(false);
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelFont(new Font("SansSerif", 0, 18));
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.INSIDE12, TextAnchor.TOP_CENTER);
        barrenderer.setBasePositiveItemLabelPosition(itemlabelposition);
        barrenderer.setPositiveItemLabelPositionFallback(new ItemLabelPosition());
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        SurveyResultsDemo2 surveyresultsdemo2 = new SurveyResultsDemo2("Survey Results Demo 2");
        surveyresultsdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(surveyresultsdemo2);
        surveyresultsdemo2.setVisible(true);
    }
}
