



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;
import org.jfree.util.UnitType;

public class AreaChartDemo1 extends ApplicationFrame
{

    public AreaChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "Series 1", "Type 1");
        defaultcategorydataset.addValue(4D, "Series 1", "Type 2");
        defaultcategorydataset.addValue(3D, "Series 1", "Type 3");
        defaultcategorydataset.addValue(5D, "Series 1", "Type 4");
        defaultcategorydataset.addValue(5D, "Series 1", "Type 5");
        defaultcategorydataset.addValue(7D, "Series 1", "Type 6");
        defaultcategorydataset.addValue(7D, "Series 1", "Type 7");
        defaultcategorydataset.addValue(8D, "Series 1", "Type 8");
        defaultcategorydataset.addValue(5D, "Series 2", "Type 1");
        defaultcategorydataset.addValue(7D, "Series 2", "Type 2");
        defaultcategorydataset.addValue(6D, "Series 2", "Type 3");
        defaultcategorydataset.addValue(8D, "Series 2", "Type 4");
        defaultcategorydataset.addValue(4D, "Series 2", "Type 5");
        defaultcategorydataset.addValue(4D, "Series 2", "Type 6");
        defaultcategorydataset.addValue(2D, "Series 2", "Type 7");
        defaultcategorydataset.addValue(1.0D, "Series 2", "Type 8");
        defaultcategorydataset.addValue(4D, "Series 3", "Type 1");
        defaultcategorydataset.addValue(3D, "Series 3", "Type 2");
        defaultcategorydataset.addValue(2D, "Series 3", "Type 3");
        defaultcategorydataset.addValue(3D, "Series 3", "Type 4");
        defaultcategorydataset.addValue(6D, "Series 3", "Type 5");
        defaultcategorydataset.addValue(3D, "Series 3", "Type 6");
        defaultcategorydataset.addValue(4D, "Series 3", "Type 7");
        defaultcategorydataset.addValue(3D, "Series 3", "Type 8");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createAreaChart("Area Chart", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        TextTitle texttitle = new TextTitle("An area chart demonstration.  We use this subtitle as an example of what happens when you get a really long title or subtitle.");
        texttitle.setFont(new Font("SansSerif", 0, 12));
        texttitle.setPosition(RectangleEdge.TOP);
        texttitle.setPadding(new RectangleInsets(UnitType.RELATIVE, 0.050000000000000003D, 0.050000000000000003D, 0.050000000000000003D, 0.050000000000000003D));
        texttitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        jfreechart.addSubtitle(texttitle);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setForegroundAlpha(0.5F);
        categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryaxis.setLowerMargin(0.0D);
        categoryaxis.setUpperMargin(0.0D);
        categoryaxis.addCategoryLabelToolTip("Type 1", "The first type.");
        categoryaxis.addCategoryLabelToolTip("Type 2", "The second type.");
        categoryaxis.addCategoryLabelToolTip("Type 3", "The third type.");
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLabelAngle(0.0D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        AreaChartDemo1 areachartdemo1 = new AreaChartDemo1("JFreeChart: AreaChartDemo1.java");
        areachartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(areachartdemo1);
        areachartdemo1.setVisible(true);
    }
}
