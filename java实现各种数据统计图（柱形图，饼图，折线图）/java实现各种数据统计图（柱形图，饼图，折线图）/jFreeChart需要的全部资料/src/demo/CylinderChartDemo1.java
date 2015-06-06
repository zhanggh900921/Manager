



package demo;

import java.awt.*;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.*;

// Referenced classes of package demo:
//            CylinderRenderer

public class CylinderChartDemo1 extends ApplicationFrame
{
    static class CustomCylinderRenderer extends CylinderRenderer
    {

        public Paint getItemPaint(int i, int j)
        {
            return colors[j % colors.length];
        }

        private Paint colors[];

        public CustomCylinderRenderer(Paint apaint[])
        {
            colors = apaint;
        }
    }


    public CylinderChartDemo1(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(4D, "S1", "Monday");
        defaultcategorydataset.addValue(5D, "S1", "Tuesday");
        defaultcategorydataset.addValue(-7D, "S1", "Wednesday");
        defaultcategorydataset.addValue(6D, "S1", "Thursday");
        defaultcategorydataset.addValue(4D, "S1", "Friday");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createBarChart3D("Cylinder Chart Demo 1", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, false, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        Paint apaint[] = createPaint();
        CustomCylinderRenderer customcylinderrenderer = new CustomCylinderRenderer(apaint);
        customcylinderrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_HORIZONTAL));
        customcylinderrenderer.setBaseOutlinePaint(Color.gray);
        customcylinderrenderer.setBaseOutlineStroke(new BasicStroke(0.3F));
        customcylinderrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        categoryplot.setRenderer(customcylinderrenderer);
        return jfreechart;
    }

    private static Paint[] createPaint()
    {
        Paint apaint[] = new Paint[5];
        apaint[0] = new GradientPaint(0.0F, 0.0F, Color.red, 0.0F, 0.0F, Color.white);
        apaint[1] = new GradientPaint(0.0F, 0.0F, Color.green, 0.0F, 0.0F, Color.white);
        apaint[2] = new GradientPaint(0.0F, 0.0F, Color.blue, 0.0F, 0.0F, Color.white);
        apaint[3] = new GradientPaint(0.0F, 0.0F, Color.orange, 0.0F, 0.0F, Color.white);
        apaint[4] = new GradientPaint(0.0F, 0.0F, Color.magenta, 0.0F, 0.0F, Color.white);
        return apaint;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        CylinderChartDemo1 cylinderchartdemo1 = new CylinderChartDemo1("Cylinder Chart Demo 1");
        cylinderchartdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(cylinderchartdemo1);
        cylinderchartdemo1.setVisible(true);
    }
}
