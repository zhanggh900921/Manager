



package demo;

import java.awt.Color;
import java.awt.Font;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.*;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.general.DatasetUtilities;
import org.jfree.ui.*;
import org.jfree.util.UnitType;

public class ImageMapDemo3
{

    public ImageMapDemo3()
    {
    }

    public void saveImageAndHTML()
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
        JFreeChart jfreechart = createChart(categorydataset);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("areachart100.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("areachart100.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"areachart100.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"areachart100.png\"/>");
            printwriter.println("</p></body>");
            printwriter.println("</html>");
            printwriter.close();
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.toString());
        }
    }

    private JFreeChart createChart(CategoryDataset categorydataset)
    {
        JFreeChart jfreechart = ChartFactory.createAreaChart("Area Chart", "Category", "Value", categorydataset, PlotOrientation.VERTICAL, true, true, true);
        jfreechart.setBackgroundPaint(Color.white);
        TextTitle texttitle = new TextTitle("An area chart demonstration.  We use this subtitle  as an example of what happens when you get a really long title or subtitle.");
        texttitle.setFont(new Font("SansSerif", 0, 12));
        texttitle.setPosition(RectangleEdge.TOP);
        texttitle.setPadding(new RectangleInsets(UnitType.RELATIVE, 0.050000000000000003D, 0.050000000000000003D, 0.050000000000000003D, 0.050000000000000003D));
        texttitle.setVerticalAlignment(VerticalAlignment.BOTTOM);
        jfreechart.addSubtitle(texttitle);
        CategoryPlot categoryplot = (CategoryPlot)jfreechart.getPlot();
        categoryplot.setForegroundAlpha(0.5F);
        categoryplot.setAxisOffset(new RectangleInsets(5D, 5D, 5D, 5D));
        categoryplot.setBackgroundPaint(Color.lightGray);
        categoryplot.setDomainGridlinesVisible(true);
        categoryplot.setDomainGridlinePaint(Color.white);
        categoryplot.setRangeGridlinesVisible(true);
        categoryplot.setRangeGridlinePaint(Color.white);
        CategoryAxis categoryaxis = categoryplot.getDomainAxis();
        categoryaxis.setCategoryLabelPositions(CategoryLabelPositions.UP_45);
        categoryaxis.setLowerMargin(0.0D);
        categoryaxis.setUpperMargin(0.0D);
        NumberAxis numberaxis = (NumberAxis)categoryplot.getRangeAxis();
        numberaxis.setStandardTickUnits(NumberAxis.createIntegerTickUnits());
        numberaxis.setLabelAngle(0.0D);
        return jfreechart;
    }

    public static void main(String args[])
    {
        ImageMapDemo3 imagemapdemo3 = new ImageMapDemo3();
        imagemapdemo3.saveImageAndHTML();
    }
}
