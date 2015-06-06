



package demo;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.LegendTitle;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class StackedBarChartDemo2 extends ApplicationFrame
{

    public StackedBarChartDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(81D, "Against all torture", "Italy");
        defaultcategorydataset.addValue(72D, "Against all torture", "Great Britain");
        defaultcategorydataset.addValue(58D, "Against all torture", "USA");
        defaultcategorydataset.addValue(48D, "Against all torture", "Israel");
        defaultcategorydataset.addValue(43D, "Against all torture", "Russia");
        defaultcategorydataset.addValue(23D, "Against all torture", "India");
        defaultcategorydataset.addValue(59D, "Against all torture", "Average (*)");
        defaultcategorydataset.addValue(5D, "-", "Italy");
        defaultcategorydataset.addValue(4D, "-", "Great Britain");
        defaultcategorydataset.addValue(6D, "-", "USA");
        defaultcategorydataset.addValue(9D, "-", "Israel");
        defaultcategorydataset.addValue(20D, "-", "Russia");
        defaultcategorydataset.addValue(45D, "-", "India");
        defaultcategorydataset.addValue(12D, "-", "Average (*)");
        defaultcategorydataset.addValue(14D, "Some degree permissible", "Italy");
        defaultcategorydataset.addValue(24D, "Some degree permissible", "Great Britain");
        defaultcategorydataset.addValue(36D, "Some degree permissible", "USA");
        defaultcategorydataset.addValue(43D, "Some degree permissible", "Israel");
        defaultcategorydataset.addValue(37D, "Some degree permissible", "Russia");
        defaultcategorydataset.addValue(32D, "Some degree permissible", "India");
        defaultcategorydataset.addValue(29D, "Some degree permissible", "Average (*)");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createStackedBarChart("Public Opinion : Torture of Prisoners", "Country", "%", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        jfreechart.getTitle().setMargin(2D, 0.0D, 0.0D, 0.0D);
        TextTitle texttitle = new TextTitle("Source: http://news.bbc.co.uk/1/hi/world/6063386.stm", new Font("Dialog", 0, 11));
        texttitle.setPosition(RectangleEdge.BOTTOM);
        texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        texttitle.setMargin(0.0D, 0.0D, 4D, 4D);
        jfreechart.addSubtitle(texttitle);
        TextTitle texttitle1 = new TextTitle("(*) Across 27,000 respondents in 25 countries", new Font("Dialog", 0, 11));
        texttitle1.setPosition(RectangleEdge.BOTTOM);
        texttitle1.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        texttitle1.setMargin(4D, 0.0D, 2D, 4D);
        jfreechart.addSubtitle(texttitle1);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        LegendItemCollection legenditemcollection = new LegendItemCollection();
        legenditemcollection.add(new LegendItem("Against all torture", null, null, null, new java.awt.geom.Rectangle2D.Double(-6D, -3D, 12D, 6D), Color.green));
        legenditemcollection.add(new LegendItem("Some degree permissible", null, null, null, new java.awt.geom.Rectangle2D.Double(-6D, -3D, 12D, 6D), Color.red));
        categoryplot.setFixedLegendItems(legenditemcollection);
        categoryplot.setInsets(new RectangleInsets(5D, 5D, 5D, 20D));
        LegendTitle legendtitle = new LegendTitle(categoryplot);
        legendtitle.setPosition(RectangleEdge.BOTTOM);
        jfreechart.addSubtitle(legendtitle);
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.0D);
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setDrawBarOutline(false);
        GradientPaint gradientpaint = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, new Color(0, 64, 0));
        Color color = new Color(0, 0, 0, 0);
        GradientPaint gradientpaint1 = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, new Color(64, 0, 0));
        barrenderer.setSeriesPaint(0, gradientpaint);
        barrenderer.setSeriesPaint(1, color);
        barrenderer.setSeriesPaint(2, gradientpaint1);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        StackedBarChartDemo2 stackedbarchartdemo2 = new StackedBarChartDemo2("Stacked Bar Chart Demo 2");
        stackedbarchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(stackedbarchartdemo2);
        stackedbarchartdemo2.setVisible(true);
    }
}
