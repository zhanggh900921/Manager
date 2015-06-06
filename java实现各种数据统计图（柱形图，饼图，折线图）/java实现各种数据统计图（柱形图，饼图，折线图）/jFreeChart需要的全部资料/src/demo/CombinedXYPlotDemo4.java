



package demo;

import java.awt.Dimension;
import java.awt.Font;
import javax.swing.JPanel;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.annotations.XYTextAnnotation;
import org.jfree.chart.axis.AxisLocation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.*;
import org.jfree.chart.renderer.xy.StandardXYItemRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class CombinedXYPlotDemo4 extends ApplicationFrame
{

    public CombinedXYPlotDemo4(String s)
    {
        super(s);
        JFreeChart jfreechart = createCombinedChart();
        ChartPanel chartpanel = new ChartPanel(jfreechart, true, true, true, false, true);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    private static JFreeChart createCombinedChart()
    {
        XYDataset xydataset = createDataset1();
        StandardXYItemRenderer standardxyitemrenderer = new StandardXYItemRenderer();
        NumberAxis numberaxis = new NumberAxis("Range 1");
        XYPlot xyplot = new XYPlot(xydataset, null, numberaxis, standardxyitemrenderer);
        xyplot.setRangeAxisLocation(AxisLocation.BOTTOM_OR_LEFT);
        xyplot.setDataset(1, createDataset2());
        NumberAxis numberaxis1 = new NumberAxis("Range Axis 2");
        numberaxis1.setAutoRangeIncludesZero(false);
        xyplot.setRangeAxis(1, numberaxis1);
        xyplot.setRangeAxisLocation(1, AxisLocation.BOTTOM_OR_RIGHT);
        xyplot.setRenderer(1, new StandardXYItemRenderer());
        xyplot.mapDatasetToRangeAxis(1, 1);
        XYTextAnnotation xytextannotation = new XYTextAnnotation("Hello!", 50D, 10000D);
        xytextannotation.setFont(new Font("SansSerif", 0, 9));
        xytextannotation.setRotationAngle(0.78539816339744828D);
        xyplot.addAnnotation(xytextannotation);
        XYDataset xydataset1 = createDataset2();
        StandardXYItemRenderer standardxyitemrenderer1 = new StandardXYItemRenderer();
        NumberAxis numberaxis2 = new NumberAxis("Range 2");
        numberaxis2.setAutoRangeIncludesZero(false);
        XYPlot xyplot1 = new XYPlot(xydataset1, null, numberaxis2, standardxyitemrenderer1);
        xyplot1.setRangeAxisLocation(AxisLocation.TOP_OR_LEFT);
        CombinedDomainXYPlot combineddomainxyplot = new CombinedDomainXYPlot(new NumberAxis("Domain"));
        combineddomainxyplot.setGap(10D);
        combineddomainxyplot.add(xyplot, 1);
        combineddomainxyplot.add(xyplot1, 1);
        combineddomainxyplot.setOrientation(PlotOrientation.VERTICAL);
        return new JFreeChart("CombinedDomainXYPlot Demo", JFreeChart.DEFAULT_TITLE_FONT, combineddomainxyplot, true);
    }

    private static XYDataset createDataset1()
    {
        XYSeries xyseries = new XYSeries("Series 1a");
        xyseries.add(10D, 12353.299999999999D);
        xyseries.add(20D, 13734.4D);
        xyseries.add(30D, 14525.299999999999D);
        xyseries.add(40D, 13984.299999999999D);
        xyseries.add(50D, 12999.4D);
        xyseries.add(60D, 14274.299999999999D);
        xyseries.add(70D, 15943.5D);
        xyseries.add(80D, 14845.299999999999D);
        xyseries.add(90D, 14645.4D);
        xyseries.add(100D, 16234.6D);
        xyseries.add(110D, 17232.299999999999D);
        xyseries.add(120D, 14232.200000000001D);
        xyseries.add(130D, 13102.200000000001D);
        xyseries.add(140D, 14230.200000000001D);
        xyseries.add(150D, 11235.200000000001D);
        XYSeries xyseries1 = new XYSeries("Series 1b");
        xyseries1.add(10D, 15000.299999999999D);
        xyseries1.add(20D, 11000.4D);
        xyseries1.add(30D, 17000.299999999999D);
        xyseries1.add(40D, 15000.299999999999D);
        xyseries1.add(50D, 14000.4D);
        xyseries1.add(60D, 12000.299999999999D);
        xyseries1.add(70D, 11000.5D);
        xyseries1.add(80D, 12000.299999999999D);
        xyseries1.add(90D, 13000.4D);
        xyseries1.add(100D, 12000.6D);
        xyseries1.add(110D, 13000.299999999999D);
        xyseries1.add(120D, 17000.200000000001D);
        xyseries1.add(130D, 18000.200000000001D);
        xyseries1.add(140D, 16000.200000000001D);
        xyseries1.add(150D, 17000.200000000001D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        return xyseriescollection;
    }

    private static XYDataset createDataset2()
    {
        XYSeries xyseries = new XYSeries("Series 2");
        xyseries.add(10D, 6853.1999999999998D);
        xyseries.add(20D, 9642.2999999999993D);
        xyseries.add(30D, 8253.5D);
        xyseries.add(40D, 5352.3000000000002D);
        xyseries.add(50D, 3532D);
        xyseries.add(60D, 2635.3000000000002D);
        xyseries.add(70D, 3998.1999999999998D);
        xyseries.add(80D, 1943.2D);
        xyseries.add(90D, 6943.8999999999996D);
        xyseries.add(100D, 7843.1999999999998D);
        xyseries.add(105D, 6495.3000000000002D);
        xyseries.add(110D, 7943.6000000000004D);
        xyseries.add(115D, 8500.7000000000007D);
        xyseries.add(120D, 9595.8999999999996D);
        return new XYSeriesCollection(xyseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createCombinedChart();
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        CombinedXYPlotDemo4 combinedxyplotdemo4 = new CombinedXYPlotDemo4("CombinedDomainXYPlot Demo");
        combinedxyplotdemo4.pack();
        RefineryUtilities.centerFrameOnScreen(combinedxyplotdemo4);
        combinedxyplotdemo4.setVisible(true);
    }
}
