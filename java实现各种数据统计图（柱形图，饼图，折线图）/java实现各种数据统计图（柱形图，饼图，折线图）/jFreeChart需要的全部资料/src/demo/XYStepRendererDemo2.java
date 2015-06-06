



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardXYItemLabelGenerator;
import org.jfree.chart.labels.StandardXYToolTipGenerator;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYStepRenderer;
import org.jfree.data.xy.*;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class XYStepRendererDemo2 extends ApplicationFrame
{

    public XYStepRendererDemo2(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 300));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createXYLineChart("XYStepRenderer Demo 2", "X", "Y", xydataset, PlotOrientation.VERTICAL, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        ValueAxis valueaxis = xyplot.getRangeAxis();
        valueaxis.setUpperMargin(0.14999999999999999D);
        XYStepRenderer xysteprenderer = new XYStepRenderer();
        xysteprenderer.setSeriesStroke(0, new BasicStroke(2.0F));
        xysteprenderer.setSeriesStroke(1, new BasicStroke(2.0F));
        xysteprenderer.setBaseToolTipGenerator(new StandardXYToolTipGenerator());
        xysteprenderer.setDefaultEntityRadius(6);
        xysteprenderer.setBaseItemLabelGenerator(new StandardXYItemLabelGenerator());
        xysteprenderer.setBaseItemLabelsVisible(true);
        xysteprenderer.setBaseItemLabelFont(new Font("Dialog", 1, 14));
        xyplot.setRenderer(xysteprenderer);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        XYSeries xyseries = new XYSeries("Series 1");
        xyseries.add(1.0D, 3D);
        xyseries.add(2D, 4D);
        xyseries.add(3D, 2D);
        xyseries.add(6D, 3D);
        XYSeries xyseries1 = new XYSeries("Series 2");
        xyseries1.add(1.0D, 7D);
        xyseries1.add(2D, 6D);
        xyseries1.add(3D, 9D);
        xyseries1.add(4D, 5D);
        xyseries1.add(6D, 4D);
        XYSeriesCollection xyseriescollection = new XYSeriesCollection();
        xyseriescollection.addSeries(xyseries);
        xyseriescollection.addSeries(xyseries1);
        return xyseriescollection;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYStepRendererDemo2 xysteprendererdemo2 = new XYStepRendererDemo2("XYStepRenderer Demo 2");
        xysteprendererdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(xysteprendererdemo2);
        xysteprendererdemo2.setVisible(true);
    }
}
