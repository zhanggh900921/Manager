



package demo;

import java.awt.Color;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis3D;
import org.jfree.chart.axis.NumberAxis3D;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.general.DatasetUtilities;

public class ImageMapDemo2
{

    public ImageMapDemo2()
    {
    }

    public static void main(String args[])
    {
        double ad[][] = {
            {
                56D, -12D, 34D, 76D, 56D, 100D, 67D, 45D
            }, {
                37D, 45D, 67D, 25D, 34D, 34D, 100D, 53D
            }, {
                43D, 54D, 34D, 34D, 87D, 64D, 73D, 12D
            }
        };
        org.jfree.data.category.CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Series ", "Type ", ad);
        JFreeChart jfreechart = null;
        boolean flag = true;
        if(flag)
        {
            CategoryAxis3D categoryaxis3d = new CategoryAxis3D("Category");
            NumberAxis3D numberaxis3d = new NumberAxis3D("Value");
            BarRenderer3D barrenderer3d = new BarRenderer3D();
            barrenderer3d.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
            barrenderer3d.setBaseItemURLGenerator(new StandardCategoryURLGenerator("bar_chart_detail.jsp"));
            CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis3d, numberaxis3d, barrenderer3d);
            categoryplot.setOrientation(PlotOrientation.VERTICAL);
            jfreechart = new JFreeChart("Bar Chart", JFreeChart.DEFAULT_TITLE_FONT, categoryplot, true);
        } else
        {
            jfreechart = ChartFactory.createBarChart3D("Bar Chart", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        }
        jfreechart.setBackgroundPaint(Color.white);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("barchart101.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("barchart101.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"barchart101.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"barchart101.png\"/>");
            printwriter.println("</p></body>");
            printwriter.println("</html>");
            printwriter.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.toString());
        }
    }
}
