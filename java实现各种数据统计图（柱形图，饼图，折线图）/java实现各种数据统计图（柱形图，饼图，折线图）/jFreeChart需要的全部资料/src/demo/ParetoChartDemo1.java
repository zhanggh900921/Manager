



package demo;

import java.awt.Color;
import java.awt.Dimension;
import java.text.NumberFormat;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.DataUtilities;
import org.jfree.data.DefaultKeyedValues;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.SortOrder;

public class ParetoChartDemo1 extends ApplicationFrame
{

    public ParetoChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(550, 270));
        setContentPane(jpanel);
    }

    public static JFreeChart createChart(CategoryDataset acategorydataset[])
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Freshmeat Software Projects", "Language", "Projects", acategorydataset[0], PlotOrientation.VERTICAL, true, true, false);
        jfreechart.addSubtitle(new TextTitle("By Programming Language"));
        jfreechart.addSubtitle(new TextTitle("As at 5 March 2003"));
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setLowerMargin(0.02D);
        categoryaxis.setUpperMargin(0.02D);
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_90);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        NumberAxis numberaxis1 = new NumberAxis("Percent");
        numberaxis1.setNumberFormatOverride(NumberFormat.getPercentInstance());
        categoryplot.setRangeAxis(1, numberaxis1);
        categoryplot.setDataset(1, acategorydataset[1]);
        categoryplot.setRenderer(1, lineandshaperenderer);
        categoryplot.mapDatasetToRangeAxis(1, 1);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        return jfreechart;
    }

    public static CategoryDataset[] createDatasets()
    {
        DefaultKeyedValues defaultkeyedvalues = new DefaultKeyedValues();
        defaultkeyedvalues.addValue("C", new Integer(4843));
        defaultkeyedvalues.addValue("C++", new Integer(2098));
        defaultkeyedvalues.addValue("C#", new Integer(26));
        defaultkeyedvalues.addValue("Java", new Integer(1901));
        defaultkeyedvalues.addValue("Perl", new Integer(2507));
        defaultkeyedvalues.addValue("PHP", new Integer(1689));
        defaultkeyedvalues.addValue("Python", new Integer(948));
        defaultkeyedvalues.addValue("Ruby", new Integer(100));
        defaultkeyedvalues.addValue("SQL", new Integer(263));
        defaultkeyedvalues.addValue("Unix Shell", new Integer(485));
        defaultkeyedvalues.sortByValues(SortOrder.DESCENDING);
        org.jfree.data.KeyedValues keyedvalues = DataUtilities.getCumulativePercentages(defaultkeyedvalues);
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Languages", defaultkeyedvalues);
        CategoryDataset categorydataset1 = DatasetUtilities.createCategoryDataset("Cumulative", keyedvalues);
        return (new CategoryDataset[] {
            categorydataset, categorydataset1
        });
    }

    public static JPanel createDemoPanel()
    {
        CategoryDataset acategorydataset[] = createDatasets();
        JFreeChart jfreechart = createChart(acategorydataset);
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        ParetoChartDemo1 paretochartdemo1 = new ParetoChartDemo1("Pareto Chart Demo 1");
        paretochartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(paretochartdemo1);
        paretochartdemo1.setVisible(true);
    }
}
