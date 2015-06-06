



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.annotations.CategoryPointerAnnotation;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

public class CategoryPointerAnnotationDemo1 extends ApplicationFrame
{

    public CategoryPointerAnnotationDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(212D, "Classes", "JDK 1.0");
        defaultcategorydataset.addValue(504D, "Classes", "JDK 1.1");
        defaultcategorydataset.addValue(1520D, "Classes", "JDK 1.2");
        defaultcategorydataset.addValue(1842D, "Classes", "JDK 1.3");
        defaultcategorydataset.addValue(2991D, "Classes", "JDK 1.4");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart("Java Standard Class Library", "Release", "Class Count", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        jfreechart.addSubtitle(new TextTitle("Number of Classes By Release"));
        TextTitle texttitle = new TextTitle("Source: Java In A Nutshell (4th Edition) by David Flanagan (O'Reilly)");
        texttitle.setFont(new Font("SansSerif", 0, 10));
        texttitle.setPosition(RectangleEdge.BOTTOM);
        texttitle.setHorizontalAlignment(HorizontalAlignment.RIGHT);
        jfreechart.addSubtitle(texttitle);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setShapesVisible(true);
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseFillPaint(Color.white);
        CategoryPointerAnnotation categorypointerannotation = new CategoryPointerAnnotation("Released 4-Dec-1998", "JDK 1.2", 1530D, -2.3561944901923448D);
        categorypointerannotation.setTextAnchor(TextAnchor.BOTTOM_RIGHT);
        categoryplot.addAnnotation(categorypointerannotation);
        return jfreechart;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        CategoryPointerAnnotationDemo1 categorypointerannotationdemo1 = new CategoryPointerAnnotationDemo1("Category Pointer Annotation Demo 1");
        categorypointerannotationdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(categorypointerannotationdemo1);
        categorypointerannotationdemo1.setVisible(true);
    }
}
