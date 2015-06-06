



package demo;

import java.awt.Color;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.util.ShapeUtilities;

public class ImageMapDemo7
{
    static class MyCategorySeriesLabelGenerator
        implements CategorySeriesLabelGenerator
    {

        public String generateLabel(CategoryDataset categorydataset, int i)
        {
            return "series-" + i + ".html";
        }

        MyCategorySeriesLabelGenerator()
        {
        }
    }


    public ImageMapDemo7()
    {
    }

    private static CategoryDataset createDataset()
    {
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(21D, "Series 1", "Category 1");
        defaultcategorydataset.addValue(50D, "Series 1", "Category 2");
        defaultcategorydataset.addValue(152D, "Series 1", "Category 3");
        defaultcategorydataset.addValue(184D, "Series 1", "Category 4");
        defaultcategorydataset.addValue(299D, "Series 1", "Category 5");
        defaultcategorydataset.addValue(275D, "Series 2", "Category 1");
        defaultcategorydataset.addValue(121D, "Series 2", "Category 2");
        defaultcategorydataset.addValue(98D, "Series 2", "Category 3");
        defaultcategorydataset.addValue(103D, "Series 2", "Category 4");
        defaultcategorydataset.addValue(210D, "Series 2", "Category 5");
        defaultcategorydataset.addValue(198D, "Series 3", "Category 1");
        defaultcategorydataset.addValue(165D, "Series 3", "Category 2");
        defaultcategorydataset.addValue(55D, "Series 3", "Category 3");
        defaultcategorydataset.addValue(34D, "Series 3", "Category 4");
        defaultcategorydataset.addValue(77D, "Series 3", "Category 5");
        return defaultcategorydataset;
    }

    private static JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createLineChart("Line Chart Demo 7", "Category", "Count", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setRangeGridlinePaint(Color.white);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        LineAndShapeRenderer lineandshaperenderer = (LineAndShapeRenderer)categoryplot.getRenderer();
        lineandshaperenderer.setSeriesShapesVisible(0, true);
        lineandshaperenderer.setSeriesShapesVisible(1, false);
        lineandshaperenderer.setSeriesShapesVisible(2, true);
        lineandshaperenderer.setSeriesLinesVisible(2, false);
        lineandshaperenderer.setSeriesShape(2, ShapeUtilities.createDiamond(4F));
        lineandshaperenderer.setDrawOutlines(true);
        lineandshaperenderer.setUseFillPaint(true);
        lineandshaperenderer.setBaseFillPaint(Color.white);
        MyCategorySeriesLabelGenerator mycategoryserieslabelgenerator = new MyCategorySeriesLabelGenerator();
        lineandshaperenderer.setLegendItemURLGenerator(mycategoryserieslabelgenerator);
        lineandshaperenderer.setLegendItemToolTipGenerator(mycategoryserieslabelgenerator);
        return jfreechart;
    }

    public static void main(String args[])
    {
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("ImageMapDemo7.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("ImageMapDemo7.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo 7</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"ImageMapDemo7.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"ImageMapDemo7.png\"/>");
            printwriter.println("</p></body>");
            printwriter.println("</html>");
            printwriter.close();
        }
        catch(IOException ioexception)
        {
            ioexception.printStackTrace();
        }
    }
}
