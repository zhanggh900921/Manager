



package demo;

import java.awt.Color;
import java.io.*;
import org.jfree.chart.*;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.entity.StandardEntityCollection;
import org.jfree.chart.imagemap.ImageMapUtilities;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;

// Referenced classes of package demo:
//            SampleXYDataset2

public class ImageMapDemo5
{

    public ImageMapDemo5()
    {
    }

    public static void main(String args[])
    {
        SampleXYDataset2 samplexydataset2 = new SampleXYDataset2();
        JFreeChart jfreechart = ChartFactory.createScatterPlot("Scatter Plot Demo", "X", "Y", samplexydataset2, PlotOrientation.VERTICAL, true, true, false);
        jfreechart.setBackgroundPaint(Color.white);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        NumberAxis numberaxis = (NumberAxis)xyplot.getDomainAxis();
        numberaxis.setAutoRangeIncludesZero(false);
        try
        {
            ChartRenderingInfo chartrenderinginfo = new ChartRenderingInfo(new StandardEntityCollection());
            File file = new File("scatter100.png");
            ChartUtilities.saveChartAsPNG(file, jfreechart, 600, 400, chartrenderinginfo);
            File file1 = new File("scatter100.html");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file1));
            PrintWriter printwriter = new PrintWriter(bufferedoutputstream);
            printwriter.println("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Strict//EN\"");
            printwriter.println("\"http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd\">");
            printwriter.println("<html xmlns=\"http://www.w3.org/1999/xhtml\" lang=\"en\" xml:lang=\"en\">");
            printwriter.println("<head><title>JFreeChart Image Map Demo</title></head>");
            printwriter.println("<body><p>");
            ImageMapUtilities.writeImageMap(printwriter, "chart", chartrenderinginfo);
            printwriter.println("<img src=\"scatter100.png\" width=\"600\" height=\"400\" usemap=\"#chart\" alt=\"scatter100.png\"/>");
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
