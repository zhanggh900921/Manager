



package demo;

import java.awt.Font;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.MultiplePiePlot;
import org.jfree.chart.plot.PiePlot;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.util.TableOrder;

public class ImageMapDemo4
{

    public ImageMapDemo4()
    {
    }

    public void saveImageAndHTML()
    {
        CategoryDataset categorydataset = createDataset();
        JFreeChart jfreechart = createChart(categorydataset);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("multipiechart100.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("multipiechart100.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"multipiechart100.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"multipiechart100.png\"/>");
            printwriter.println("</p></body>");
            printwriter.println("</html>");
            printwriter.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.toString());
        }
    }

    private CategoryDataset createDataset()
    {
        double ad[][] = {
            {
                3D, 4D, 3D, 5D
            }, {
                5D, 7D, 6D, 8D
            }, {
                5D, 7D, 3D, 8D
            }, {
                1.0D, 2D, 3D, 4D
            }, {
                2D, 3D, 2D, 3D
            }
        };
        CategoryDataset categorydataset = DatasetUtilities.createCategoryDataset("Region ", "Sales/Q", ad);
        return categorydataset;
    }

    private JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createMultiplePieChart("Multiple Pie Chart", categorydataset, TableOrder.BY_ROW, true, true, true);
        MultiplePiePlot multiplepieplot = (MultiplePiePlot)jfreechart.getPlot();
        JFreeChart jfreechart1 = multiplepieplot.getPieChart();
        PiePlot pieplot = (PiePlot)jfreechart1.getPlot();
        pieplot.setLabelGenerator(new StandardPieSectionLabelGenerator("{0}"));
        pieplot.setLabelFont(new Font("SansSerif", 0, 8));
        pieplot.setInteriorGap(0.29999999999999999D);
        return jfreechart;
    }

    public static void main(String args[])
    {
        ImageMapDemo4 imagemapdemo4 = new ImageMapDemo4();
        imagemapdemo4.saveImageAndHTML();
    }
}
