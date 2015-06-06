



package demo;

import java.io.*;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.MeterPlot;
import org.jfree.data.general.DefaultValueDataset;

public class MeterChartDemo4
{

    public MeterChartDemo4()
    {
    }

    public static void main(String args[])
    {
        DefaultValueDataset defaultvaluedataset = new DefaultValueDataset(75D);
        MeterPlot meterplot = new MeterPlot(defaultvaluedataset);
        JFreeChart jfreechart = new JFreeChart("Scaled Image Test", meterplot);
        try
        {
            File file = new File("meterchart100.png");
            BufferedOutputStream bufferedoutputstream = new BufferedOutputStream(new FileOutputStream(file));
            java.awt.image.BufferedImage bufferedimage = jfreechart.createBufferedImage(200, 200, 400D, 400D, null);
            ChartUtilities.writeBufferedImageAsPNG(bufferedoutputstream, bufferedimage);
        }
        catch(IOException ioexception)
        {
            System.out.println(ioexception.toString());
        }
    }
}
