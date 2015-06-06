



package demo;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.XYPointerAnnotation;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.*;

public class XYPointerAnnotationDemo1 extends ApplicationFrame
{

    public XYPointerAnnotationDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    public static XYDataset createDataset()
    {
        DefaultXYDataset defaultxydataset = new DefaultXYDataset();
        double ad[] = {
            1.7D, 2.2000000000000002D, 2.7000000000000002D, 3D, 3.2000000000000002D
        };
        double ad1[] = {
            4D, 3D, 6D, 1.0D, 9D
        };
        double ad2[][] = {
            ad, ad1
        };
        defaultxydataset.addSeries("Series 1", ad2);
        double ad3[] = {
            2.1000000000000001D, 2.2000000000000002D, 2.3999999999999999D, 2.7000000000000002D, 3.2000000000000002D
        };
        double ad4[] = {
            4.5D, 6D, 4D, 8D, 5.0999999999999996D
        };
        double ad5[][] = {
            ad3, ad4
        };
        defaultxydataset.addSeries("Series 2", ad5);
        return defaultxydataset;
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createScatterPlot("XYPointerAnnotationDemo1", "X", "Y", xydataset, PlotOrientation.HORIZONTAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        xyplot.setBackgroundPaint(Color.lightGray);
        xyplot.setDomainGridlinePaint(Color.white);
        xyplot.setRangeGridlinePaint(Color.white);
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        XYPointerAnnotation xypointerannotation = new XYPointerAnnotation("Special point", 2.2000000000000002D, 6D, 3.9269908169872414D);
        xypointerannotation.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
        xypointerannotation.setToolTipText("The pointer has a tool tip!");
        xylineandshaperenderer.addAnnotation(xypointerannotation, Layer.BACKGROUND);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        XYPointerAnnotationDemo1 xypointerannotationdemo1 = new XYPointerAnnotationDemo1("XYPointerAnnotationDemo1");
        xypointerannotationdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(xypointerannotationdemo1);
        xypointerannotationdemo1.setVisible(true);
    }
}
