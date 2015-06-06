



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.CategoryTextAnnotation;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.ItemLabelAnchor;
import org.jfree.chart.labels.ItemLabelPosition;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class SurveyResultsDemo1 extends ApplicationFrame
{

    public SurveyResultsDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(700, 600));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(2.0099999999999998D, "Results", "Category 1");
        defaultcategorydataset.addValue(2.02D, "Results", "Category 2");
        defaultcategorydataset.addValue(2D, "Results", "Category 3");
        defaultcategorydataset.addValue(1.97D, "Results", "Category 4");
        defaultcategorydataset.addValue(1.4399999999999999D, "Results", "Category 5");
        defaultcategorydataset.addValue(1.49D, "Results", "Category 6");
        defaultcategorydataset.addValue(1.49D, "Results", "Category 7");
        defaultcategorydataset.addValue(1.48D, "Results", "Category 8");
        defaultcategorydataset.addValue(4.2599999999999998D, "Results", "Category 9");
        defaultcategorydataset.addValue(4.0800000000000001D, "Results", "Category 10");
        defaultcategorydataset.addValue(4.0300000000000002D, "Results", "Category 11");
        defaultcategorydataset.addValue(3.9199999999999999D, "Results", "Category 12");
        defaultcategorydataset.addValue(3.9900000000000002D, "Results", "Category 13");
        defaultcategorydataset.addValue(2.23D, "Results", "Category 14");
        defaultcategorydataset.addValue(2.6000000000000001D, "Results", "Overall");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart(null, null, null, categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        TextTitle texttitle = new TextTitle("Figure 7 | I. Resources - The site offers users relevant, informative and educational resources");
        texttitle.setHorizontalAlignment(HorizontalAlignment.LEFT);
        texttitle.setBackgroundPaint(Color.red);
        texttitle.setPaint(Color.white);
        jfreechart.setTitle(texttitle);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setOutlinePaint(null);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setDomainGridlinePosition(CategoryAnchor.END);
        categoryplot.setDomainGridlineStroke(new BasicStroke(0.5F));
        categoryplot.setDomainGridlinePaint(Color.black);
        categoryplot.setRangeGridlinesVisible(false);
        categoryplot.clearRangeMarkers();
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setVisible(false);
        categoryaxis.setCategoryMargin(0.5D);
        categoryplot.getRangeAxis().setVisible(false);
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setSeriesPaint(0, new Color(156, 164, 74));
        barrenderer.setDrawBarOutline(false);
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelFont(new Font("SansSerif", 1, 10));
        ItemLabelPosition itemlabelposition = new ItemLabelPosition(ItemLabelAnchor.INSIDE3, TextAnchor.CENTER_RIGHT);
        barrenderer.setBasePositiveItemLabelPosition(itemlabelposition);
        CategoryTextAnnotation categorytextannotation = new CategoryTextAnnotation("1. White papers are available.", "Category 1", 0.0D);
        categorytextannotation.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation);
        CategoryTextAnnotation categorytextannotation1 = new CategoryTextAnnotation("2. White papers enhance users understanding of the firm and its expertise.", "Category 2", 0.0D);
        categorytextannotation1.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation1.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation1.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation1);
        CategoryTextAnnotation categorytextannotation2 = new CategoryTextAnnotation("3. White papers are relevant to the firm's prospects and clients.", "Category 3", 0.0D);
        categorytextannotation2.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation2.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation2.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation2);
        CategoryTextAnnotation categorytextannotation3 = new CategoryTextAnnotation("4. White papers are relevant to the firm's positioning.", "Category 4", 0.0D);
        categorytextannotation3.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation3.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation3.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation3);
        CategoryTextAnnotation categorytextannotation4 = new CategoryTextAnnotation("5. Case studies are available.", "Category 5", 0.0D);
        categorytextannotation4.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation4.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation4.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation4);
        CategoryTextAnnotation categorytextannotation5 = new CategoryTextAnnotation("6. Case studies enhance users understanding of the firm and its expertise.", "Category 6", 0.0D);
        categorytextannotation5.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation5.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation5.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation5);
        CategoryTextAnnotation categorytextannotation6 = new CategoryTextAnnotation("7. Case studies are relevant to the firm's prospects and clients.", "Category 7", 0.0D);
        categorytextannotation6.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation6.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation6.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation6);
        CategoryTextAnnotation categorytextannotation7 = new CategoryTextAnnotation("8. White papers are relevant to the firm's positioning.", "Category 8", 0.0D);
        categorytextannotation7.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation7.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation7.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation7);
        CategoryTextAnnotation categorytextannotation8 = new CategoryTextAnnotation("9. Case studies are available.", "Category 9", 0.0D);
        categorytextannotation8.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation8.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation8.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation8);
        CategoryTextAnnotation categorytextannotation9 = new CategoryTextAnnotation("10. Case studies enhance users understanding of the firm and its expertise.", "Category 10", 0.0D);
        categorytextannotation9.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation9.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation9.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation9);
        CategoryTextAnnotation categorytextannotation10 = new CategoryTextAnnotation("11. Case studies are relevant to the firm's prospects and clients.", "Category 11", 0.0D);
        categorytextannotation10.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation10.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation10.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation10);
        CategoryTextAnnotation categorytextannotation11 = new CategoryTextAnnotation("12. White papers are relevant to the firm's positioning.", "Category 12", 0.0D);
        categorytextannotation11.setFont(new Font("SansSerif", 0, 12));
        categorytextannotation11.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation11.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation11);
        CategoryTextAnnotation categorytextannotation12 = new CategoryTextAnnotation("13. Users can easily access resources based on viewer interest.", "Category 13", 0.0D);
        categorytextannotation12.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation12.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation12.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation12);
        CategoryTextAnnotation categorytextannotation13 = new CategoryTextAnnotation("14. Access to additional hyperlinks enhances users's ability to find relevant information.", "Category 14", 0.0D);
        categorytextannotation13.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation13.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation13.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation13);
        CategoryTextAnnotation categorytextannotation14 = new CategoryTextAnnotation("15. OVERALL EFFECTIVENESS.", "Overall", 0.0D);
        categorytextannotation14.setFont(new Font("SansSerif", 1, 12));
        categorytextannotation14.setTextAnchor(TextAnchor.BOTTOM_LEFT);
        categorytextannotation14.setCategoryAnchor(CategoryAnchor.START);
        categoryplot.addAnnotation(categorytextannotation14);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        SurveyResultsDemo1 surveyresultsdemo1 = new SurveyResultsDemo1("Survey Results Demo 1");
        surveyresultsdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(surveyresultsdemo1);
        surveyresultsdemo1.setVisible(true);
    }
}
