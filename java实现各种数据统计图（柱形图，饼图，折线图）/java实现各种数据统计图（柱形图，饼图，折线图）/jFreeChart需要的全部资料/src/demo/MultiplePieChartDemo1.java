



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;
import org.jfree.util.TableOrder;

public class MultiplePieChartDemo1 extends ApplicationFrame
{

    public MultiplePieChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(600, 380));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        double ad[][] = {
            {
                3D, 4D, 3D, 5D
            }, {
                5D, 7D, 6D, 8D
            }, {
                5D, 7D, (0.0D / 0.0D), 3D
            }, {
                1.0D, 2D, 3D, 4D
            }, {
                2D, 3D, 2D, 3D
            }
        };
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Region ", "Sales/Q", ad);
        return categorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createMultiplePieChart("Multiple Pie Chart", categorydataset, TableOrder.BY_ROW, true, true, false);
        MultiplePiePlot multiplepieplot = (MultiplePiePlot)jfreechart.getPlot();
        JFreeChart jfreechart1 = multiplepieplot.getPieChart();
        PiePlot pieplot = (PiePlot)jfreechart1.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        pieplot.setLabelFont(new Font("SansSerif", 0, 8));
        pieplot.setInteriorGap(0.29999999999999999D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        MultiplePieChartDemo1 multiplepiechartdemo1 = new MultiplePieChartDemo1("Multiple Pie Chart Demo 1");
        multiplepiechartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(multiplepiechartdemo1);
        multiplepiechartdemo1.setVisible(true);
    }
}
