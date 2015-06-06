



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.SymbolAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.ShapeUtilities;

public class LineChartDemo8 extends ApplicationFrame
{

    public LineChartDemo8(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(0.0D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(2D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(1.0D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(3D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(5D, "Series 1", "Category 5");
        defaultcategorydataset.addValue(2D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(4D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(4D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(5D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(2D, "Series 2", "Category 5");
        defaultcategorydataset.addValue(1.0D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(3D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(5D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(2D, "Series 3", "Category 4");
        defaultcategorydataset.addValue(0.0D, "Series 3", "Category 5");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart("Line Chart Demo 8", "Category", "Count", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        SymbolAxis symbolaxis = new SymbolAxis("Group", new String[] {
            "A", "B", "C", "D", "E", "F"
        });
        categoryplot.setRangeAxis(symbolaxis);
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setSeriesShapesVisible(0, true);
        lineandshaperenderer.setSeriesShapesVisible(1, false);
        lineandshaperenderer.setSeriesShapesVisible(2, true);
        lineandshaperenderer.setSeriesLinesVisible(2, false);
        lineandshaperenderer.setSeriesShape(2, ShapeUtilities.createDiamond(4F));
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseFillPaint(Color.white);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        LineChartDemo8 linechartdemo8 = new LineChartDemo8("Line Chart Demo 8");
        linechartdemo8.pack();
        RefineryUtilities.centerFrameOnScreen(linechartdemo8);
        linechartdemo8.setVisible(true);
    }
}
