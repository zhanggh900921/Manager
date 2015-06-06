



package demo;

import java.awt.Color;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.CategorySeriesLabelGenerator;
import org.jfree.chart.labels.StandardCategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.urls.StandardCategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;

public class ImageMapDemo1
{

    public ImageMapDemo1()
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
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Series ", "Type ", ad);
        JFreeChart jfreechart = null;
        boolean flag = true;
        if(flag)
        {
            CategoryAxis categoryaxis = new CategoryAxis("Category");
            NumberAxis numberaxis = new NumberAxis("Value");
            BarRenderer barrenderer = new BarRenderer();
            barrenderer.setBaseToolTipGenerator(new StandardCategoryToolTipGenerator());
            barrenderer.setBaseItemURLGenerator(new StandardCategoryURLGenerator("bar_chart_detail.jsp"));
            barrenderer.setLegendItemURLGenerator(new CategorySeriesLabelGenerator() {

                public String generateLabel(CategoryDataset categorydataset1, int i)
                {
                    return "series.html?series=" + (i + 1);
                }

            }
);
            barrenderer.setLegendItemToolTipGenerator(new CategorySeriesLabelGenerator() {

                public String generateLabel(CategoryDataset categorydataset1, int i)
                {
                    return "Tool tip for series " + (i + 1);
                }

            }
);
            CategoryPlot categoryplot = new CategoryPlot(categorydataset, categoryaxis, numberaxis, barrenderer);
            categoryplot.setOrientation(PlotOrientation.VERTICAL);
            jfreechart = new JFreeChart("Bar Chart", JFreeChart.DEFAULT_TITLE_FONT, categoryplot, true);
        } else
        {
            jfreechart = ChartFactory.createBarChart("Vertical Bar Chart", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, false);
        }
        jfreechart.setBackgroundPaint(Color.white);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("barchart100.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("barchart100.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"barchart100.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"barchart100.png\"/>");
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
