



package demo;

import java.awt.Dimension;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.category.*;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class OverlaidBarChartDemo1 extends ApplicationFrame
{

    public OverlaidBarChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static JFreeChart createChart()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "S1", "Category 1");
        defaultcategorydataset.addValue(4D, "S1", "Category 2");
        defaultcategorydataset.addValue(3D, "S1", "Category 3");
        defaultcategorydataset.addValue(5D, "S1", "Category 4");
        defaultcategorydataset.addValue(5D, "S1", "Category 5");
        defaultcategorydataset.addValue(7D, "S1", "Category 6");
        defaultcategorydataset.addValue(7D, "S1", "Category 7");
        defaultcategorydataset.addValue(8D, "S1", "Category 8");
        defaultcategorydataset.addValue(5D, "S2", "Category 1");
        defaultcategorydataset.addValue(7D, "S2", "Category 2");
        defaultcategorydataset.addValue(6D, "S2", "Category 3");
        defaultcategorydataset.addValue(8D, "S2", "Category 4");
        defaultcategorydataset.addValue(4D, "S2", "Category 5");
        defaultcategorydataset.addValue(4D, "S2", "Category 6");
        defaultcategorydataset.addValue(2D, "S2", "Category 7");
        defaultcategorydataset.addValue(1.0D, "S2", "Category 8");
        StandardCategoryItemLabelGenerator standardcategoryitemlabelgenerator = new StandardCategoryItemLabelGenerator();
        BarRenderer barrenderer = new BarRenderer();
        barrenderer.setBaseItemLabelGenerator(standardcategoryitemlabelgenerator);
        barrenderer.setBaseItemLabelsVisible(true);
        CategoryPlot categoryplot = new CategoryPlot();
        categoryplot.setDataset(defaultcategorydataset);
        categoryplot.setRenderer(barrenderer);
        categoryplot.setDomainAxis(new CategoryAxis("Category"));
        categoryplot.setRangeAxis(new NumberAxis("Value"));
        categoryplot.setOrientation(PlotOrientation.VERTICAL);
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setDomainGridlinesVisible(true);
        DefaultCategoryDataset defaultcategorydataset1 = new DefaultCategoryDataset();
        defaultcategorydataset1.addValue(9D, "T1", "Category 1");
        defaultcategorydataset1.addValue(7D, "T1", "Category 2");
        defaultcategorydataset1.addValue(2D, "T1", "Category 3");
        defaultcategorydataset1.addValue(6D, "T1", "Category 4");
        defaultcategorydataset1.addValue(6D, "T1", "Category 5");
        defaultcategorydataset1.addValue(9D, "T1", "Category 6");
        defaultcategorydataset1.addValue(5D, "T1", "Category 7");
        defaultcategorydataset1.addValue(4D, "T1", "Category 8");
        LineAndShapeRenderer lineandshaperenderer = new LineAndShapeRenderer();
        categoryplot.setDataset(1, defaultcategorydataset1);
        categoryplot.setRenderer(1, lineandshaperenderer);
        NumberAxis numberaxis = new NumberAxis("Axis 2");
        categoryplot.setRangeAxis(1, numberaxis);
        DefaultCategoryDataset defaultcategorydataset2 = new DefaultCategoryDataset();
        defaultcategorydataset2.addValue(94D, "R1", "Category 1");
        defaultcategorydataset2.addValue(75D, "R1", "Category 2");
        defaultcategorydataset2.addValue(22D, "R1", "Category 3");
        defaultcategorydataset2.addValue(74D, "R1", "Category 4");
        defaultcategorydataset2.addValue(83D, "R1", "Category 5");
        defaultcategorydataset2.addValue(9D, "R1", "Category 6");
        defaultcategorydataset2.addValue(23D, "R1", "Category 7");
        defaultcategorydataset2.addValue(98D, "R1", "Category 8");
        categoryplot.setDataset(2, defaultcategorydataset2);
        LineAndShapeRenderer lineandshaperenderer1 = new LineAndShapeRenderer();
        categoryplot.setRenderer(2, lineandshaperenderer1);
        categoryplot.mapDatasetToRangeAxis(2, 1);
        categoryplot.setDatasetRenderingOrder(DatasetRenderingOrder.FORWARD);
        categoryplot.getDomainAxis().setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        JFreeChart jfreechart = new JFreeChart(categoryplot);
        jfreechart.setTitle("Overlaid Bar Chart");
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart();
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.addChartMouseListener(new ChartMouseListener() {

            public void chartMouseClicked(ChartMouseEvent chartmouseevent)
            {
                System.out.println(chartmouseevent.getEntity());
            }

            public void chartMouseMoved(ChartMouseEvent chartmouseevent)
            {
            }

        }
);
        return chartpanel;
    }

    public static void main(String args[])
    {
        OverlaidBarChartDemo1 overlaidbarchartdemo1 = new OverlaidBarChartDemo1("JFreeChart: OverlaidBarChartDemo1.java");
        overlaidbarchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(overlaidbarchartdemo1);
        overlaidbarchartdemo1.setVisible(true);
    }
}
