



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class BarChartDemo5 extends ApplicationFrame
{

    public BarChartDemo5(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        String s = "Prison Population Rates";
        defaultcategorydataset.addValue(59D, s, "Norway");
        defaultcategorydataset.addValue(69D, s, "Switzerland");
        defaultcategorydataset.addValue(85D, s, "France");
        defaultcategorydataset.addValue(93D, s, "Syria");
        defaultcategorydataset.addValue(96D, s, "Germany");
        defaultcategorydataset.addValue(111D, s, "China");
        defaultcategorydataset.addValue(116D, s, "Australia");
        defaultcategorydataset.addValue(121D, s, "Egypt");
        defaultcategorydataset.addValue(129D, s, "England & Wales");
        defaultcategorydataset.addValue(157D, s, "New Zealand");
        defaultcategorydataset.addValue(205D, s, "Chile");
        defaultcategorydataset.addValue(229D, s, "Iran");
        defaultcategorydataset.addValue(359D, s, "Singapore");
        defaultcategorydataset.addValue(404D, s, "South Africa");
        defaultcategorydataset.addValue(406D, s, "Ukraine");
        defaultcategorydataset.addValue(686D, s, "USA");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart("Prison Population Rates - Selected Countries", "Country", "Prisoners Per 100,000 National Population", categorydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.addSubtitle(new TextTitle("Source: http://www.homeoffice.gov.uk/rds/pdfs2/r188.pdf", new Font("Dialog", 2, 10)));
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        categoryplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        BarRenderer barrenderer = (BarRenderer)categoryplot.getRenderer();
        barrenderer.setBaseItemLabelsVisible(true);
        barrenderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryMargin(0.0D);
        categoryaxis.setUpperMargin(0.02D);
        categoryaxis.setLowerMargin(0.02D);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setUpperMargin(0.10000000000000001D);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        BarChartDemo5 barchartdemo5 = new BarChartDemo5("Bar Chart Demo 5");
        barchartdemo5.pack();
        RefineryUtilities.centerFrameOnScreen(barchartdemo5);
        barchartdemo5.setVisible(true);
    }
}
