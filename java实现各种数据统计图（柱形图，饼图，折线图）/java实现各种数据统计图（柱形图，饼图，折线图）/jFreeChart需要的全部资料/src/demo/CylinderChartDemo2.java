



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

public class CylinderChartDemo2 extends ApplicationFrame
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


    public CylinderChartDemo2(String s)
    {
        super(s);
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
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
        JFreeChart jfreechart = ChartFactory.createBarChart3D("Cylinder Chart Demo 2", "Category", "Value", categorydataset, PlotOrientation.HORIZONTAL, false, true, false);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        Paint apaint[] = createPaint();
        CustomCylinderRenderer customcylinderrenderer = new CustomCylinderRenderer(apaint);
        customcylinderrenderer.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.CENTER_VERTICAL));
        customcylinderrenderer.setBaseOutlinePaint(Color.gray);
        customcylinderrenderer.setBaseOutlineStroke(new BasicStroke(0.3F));
        customcylinderrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
        categoryplot.setRenderer(customcylinderrenderer);
        return jfreechart;
    }

    private static Paint[] createPaint()
    {
        Paint apaint[] = new Paint[5];
        apaint[0] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.red);
        apaint[1] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.green);
        apaint[2] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.blue);
        apaint[3] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.orange);
        apaint[4] = new GradientPaint(0.0F, 0.0F, Color.white, 0.0F, 0.0F, Color.magenta);
        return apaint;
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        CylinderChartDemo2 cylinderchartdemo2 = new CylinderChartDemo2("Cylinder Chart Demo 2");
        cylinderchartdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(cylinderchartdemo2);
        cylinderchartdemo2.setVisible(true);
    }
}
