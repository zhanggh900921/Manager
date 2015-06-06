



package demo;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.text.TextBlockAnchor;
import org.jfree.ui.*;

public class SurveyResultsDemo3 extends ApplicationFrame
{

    public SurveyResultsDemo3(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(300, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(2.6099999999999999D, "Results", "Sm.");
        defaultcategorydataset.addValue(2.7000000000000002D, "Results", "Med.");
        defaultcategorydataset.addValue(2.8999999999999999D, "Results", "Lg.");
        defaultcategorydataset.addValue(2.7400000000000002D, "Results", "All");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart(null, null, null, categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        jfreechart.getPlot().setOutlinePaint(null);
        TextTitle texttitle = new TextTitle("Figure 6 | Overall SEO Rating");
        texttitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        texttitle.setBackgroundPaint(Color.red);
        texttitle.setPaint(Color.white);
        jfreechart.setTitle(texttitle);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        ValueAxis valueaxis = categoryplot.getRangeAxis();
        valueaxis.setRange(0.0D, 4D);
        valueaxis.setVisible(false);
        ExtendedCategoryAxis extendedcategoryaxis = new ExtendedCategoryAxis(null);
        extendedcategoryaxis.setTickLabelFont(new Font("SansSerif", 1, 12));
        extendedcategoryaxis.setCategoryMargin(0.29999999999999999D);
        extendedcategoryaxis.addSubLabel("Sm.", "(10)");
        extendedcategoryaxis.addSubLabel("Med.", "(10)");
        extendedcategoryaxis.addSubLabel("Lg.", "(10)");
        extendedcategoryaxis.addSubLabel("All", "(10)");
        CategoryLabelPositions categorylabelpositions = extendedcategoryaxis.getCategoryLabelPositions();
        CategoryLabelPosition categorylabelposition = new CategoryLabelPosition(RectangleAnchor.LEFT, TextBlockAnchor.CENTER_LEFT);
        extendedcategoryaxis.setCategoryLabelPositions(CategoryLabelPositions.replaceLeftPosition(categorylabelpositions, categorylabelposition));
        categoryplot.setDomainAxis(extendedcategoryaxis);
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setSeriesPaint(0, new Color(156, 164, 74));
        barrenderer.setDrawBarOutline(false);
        StandardCategoryItemLabelGenerator standardcategoryitemlabelgenerator = new StandardCategoryItemLabelGenerator("{2}", new DecimalFormat("0.00"));
        barrenderer.setBaseItemLabelGenerator(standardcategoryitemlabelgenerator);
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelFont(new Font("SansSerif", 0, 18));
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT);
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
        SurveyResultsDemo3 surveyresultsdemo3 = new SurveyResultsDemo3("Survey Results Demo 3");
        surveyresultsdemo3.pack();
        RefineryUtilities.centerFrameOnScreen(surveyresultsdemo3);
        surveyresultsdemo3.setVisible(true);
    }
}
