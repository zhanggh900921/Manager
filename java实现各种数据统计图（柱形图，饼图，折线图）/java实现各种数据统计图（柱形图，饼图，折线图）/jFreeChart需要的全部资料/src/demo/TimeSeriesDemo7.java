



package demo;

import java.awt.Dimension;
import java.awt.geom.GeneralPath;
import java.io.PrintStream;
import javax.swing.JPanel;
import org.jfree.chart.*;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.time.*;
import org.jfree.data.xy.XYDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class TimeSeriesDemo7 extends ApplicationFrame
{

    public TimeSeriesDemo7(String s)
    {
        super(s);
        JPanel jpanel = createDemoPanel();
        jpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(jpanel);
    }

    private static JFreeChart createChart(XYDataset xydataset)
    {
        JFreeChart jfreechart = ChartFactory.createTimeSeriesChart("Time Series Demo 7", "Date", "Value", xydataset, true, true, false);
        XYPlot xyplot = (XYPlot)jfreechart.getPlot();
        XYLineAndShapeRenderer xylineandshaperenderer = (XYLineAndShapeRenderer)xyplot.getRenderer();
        GeneralPath generalpath = new GeneralPath();
        generalpath.moveTo(-6F, 0.0F);
        generalpath.lineTo(-3F, 6F);
        generalpath.lineTo(3F, -6F);
        generalpath.lineTo(6F, 0.0F);
        xylineandshaperenderer.setLegendLine(generalpath);
        return jfreechart;
    }

    private static XYDataset createDataset()
    {
        TimeSeries timeseries = new TimeSeries("EUR/GBP");
        try
        {
            timeseries.add(new Day(2, 1, 2001), new Double(1.5788D));
            timeseries.add(new Day(3, 1, 2001), new Double(1.5912999999999999D));
            timeseries.add(new Day(4, 1, 2001), new Double(1.5807D));
            timeseries.add(new Day(5, 1, 2001), new Double(1.5710999999999999D));
            timeseries.add(new Day(8, 1, 2001), new Double(1.5778000000000001D));
            timeseries.add(new Day(9, 1, 2001), new Double(1.5851D));
            timeseries.add(new Day(10, 1, 2001), new Double(1.5846D));
            timeseries.add(new Day(11, 1, 2001), new Double(1.5727D));
            timeseries.add(new Day(12, 1, 2001), new Double(1.5585D));
            timeseries.add(new Day(15, 1, 2001), new Double(1.5693999999999999D));
            timeseries.add(new Day(16, 1, 2001), new Double(1.5629D));
            timeseries.add(new Day(17, 1, 2001), new Double(1.5831D));
            timeseries.add(new Day(18, 1, 2001), new Double(1.5624D));
            timeseries.add(new Day(19, 1, 2001), new Double(1.5693999999999999D));
            timeseries.add(new Day(22, 1, 2001), new Double(1.5615000000000001D));
            timeseries.add(new Day(23, 1, 2001), new Double(1.5656000000000001D));
            timeseries.add(new Day(24, 1, 2001), new Double(1.5794999999999999D));
            timeseries.add(new Day(25, 1, 2001), new Double(1.5851999999999999D));
            timeseries.add(new Day(26, 1, 2001), new Double(1.5797000000000001D));
            timeseries.add(new Day(29, 1, 2001), new Double(1.5862000000000001D));
            timeseries.add(new Day(30, 1, 2001), new Double(1.5803D));
            timeseries.add(new Day(31, 1, 2001), new Double(1.5713999999999999D));
            timeseries.add(new Day(1, 2, 2001), new Double(1.5717000000000001D));
            timeseries.add(new Day(2, 2, 2001), new Double(1.5734999999999999D));
            timeseries.add(new Day(5, 2, 2001), new Double(1.5690999999999999D));
            timeseries.add(new Day(6, 2, 2001), new Double(1.5676000000000001D));
            timeseries.add(new Day(7, 2, 2001), new Double(1.5677000000000001D));
            timeseries.add(new Day(8, 2, 2001), new Double(1.5737000000000001D));
            timeseries.add(new Day(9, 2, 2001), new Double(1.5653999999999999D));
            timeseries.add(new Day(12, 2, 2001), new Double(1.5621D));
            timeseries.add(new Day(13, 2, 2001), new Double(1.5761000000000001D));
            timeseries.add(new Day(14, 2, 2001), new Double(1.5898000000000001D));
            timeseries.add(new Day(15, 2, 2001), new Double(1.6045D));
            timeseries.add(new Day(16, 2, 2001), new Double(1.5851999999999999D));
            timeseries.add(new Day(19, 2, 2001), new Double(1.5704D));
            timeseries.add(new Day(20, 2, 2001), new Double(1.5891999999999999D));
            timeseries.add(new Day(21, 2, 2001), new Double(1.5844D));
            timeseries.add(new Day(22, 2, 2001), new Double(1.5933999999999999D));
            timeseries.add(new Day(23, 2, 2001), new Double(1.5951D));
            timeseries.add(new Day(26, 2, 2001), new Double(1.5848D));
            timeseries.add(new Day(27, 2, 2001), new Double(1.5706D));
            timeseries.add(new Day(28, 2, 2001), new Double(1.5680000000000001D));
            timeseries.add(new Day(1, 3, 2001), new Double(1.5645D));
            timeseries.add(new Day(2, 3, 2001), new Double(1.5753999999999999D));
            timeseries.add(new Day(5, 3, 2001), new Double(1.5808D));
            timeseries.add(new Day(6, 3, 2001), new Double(1.5766D));
            timeseries.add(new Day(7, 3, 2001), new Double(1.5755999999999999D));
            timeseries.add(new Day(8, 3, 2001), new Double(1.5760000000000001D));
            timeseries.add(new Day(9, 3, 2001), new Double(1.5748D));
            timeseries.add(new Day(12, 3, 2001), new Double(1.5779000000000001D));
            timeseries.add(new Day(13, 3, 2001), new Double(1.5837000000000001D));
            timeseries.add(new Day(14, 3, 2001), new Double(1.5886D));
            timeseries.add(new Day(15, 3, 2001), new Double(1.5931D));
            timeseries.add(new Day(16, 3, 2001), new Double(1.5945D));
            timeseries.add(new Day(19, 3, 2001), new Double(1.5880000000000001D));
            timeseries.add(new Day(20, 3, 2001), new Double(1.5817000000000001D));
            timeseries.add(new Day(21, 3, 2001), new Double(1.5927D));
            timeseries.add(new Day(22, 3, 2001), new Double(1.6065D));
            timeseries.add(new Day(23, 3, 2001), new Double(1.6006D));
            timeseries.add(new Day(26, 3, 2001), new Double(1.6007D));
            timeseries.add(new Day(27, 3, 2001), new Double(1.5989D));
            timeseries.add(new Day(28, 3, 2001), new Double(1.6134999999999999D));
            timeseries.add(new Day(29, 3, 2001), new Double(1.6282000000000001D));
            timeseries.add(new Day(30, 3, 2001), new Double(1.609D));
            timeseries.add(new Day(2, 4, 2001), new Double(1.6107D));
            timeseries.add(new Day(3, 4, 2001), new Double(1.6093D));
            timeseries.add(new Day(4, 4, 2001), new Double(1.5880000000000001D));
            timeseries.add(new Day(5, 4, 2001), new Double(1.5931D));
            timeseries.add(new Day(6, 4, 2001), new Double(1.5968D));
            timeseries.add(new Day(9, 4, 2001), new Double(1.6072D));
            timeseries.add(new Day(10, 4, 2001), new Double(1.6167D));
            timeseries.add(new Day(11, 4, 2001), new Double(1.6214D));
            timeseries.add(new Day(12, 4, 2001), new Double(1.6120000000000001D));
            timeseries.add(new Day(17, 4, 2001), new Double(1.6229D));
            timeseries.add(new Day(18, 4, 2001), new Double(1.6297999999999999D));
            timeseries.add(new Day(19, 4, 2001), new Double(1.6158999999999999D));
            timeseries.add(new Day(20, 4, 2001), new Double(1.5995999999999999D));
            timeseries.add(new Day(23, 4, 2001), new Double(1.6042000000000001D));
            timeseries.add(new Day(24, 4, 2001), new Double(1.6061000000000001D));
            timeseries.add(new Day(25, 4, 2001), new Double(1.6045D));
            timeseries.add(new Day(26, 4, 2001), new Double(1.597D));
            timeseries.add(new Day(27, 4, 2001), new Double(1.6094999999999999D));
            timeseries.add(new Day(30, 4, 2001), new Double(1.6141000000000001D));
            timeseries.add(new Day(1, 5, 2001), new Double(1.6075999999999999D));
            timeseries.add(new Day(2, 5, 2001), new Double(1.6076999999999999D));
            timeseries.add(new Day(3, 5, 2001), new Double(1.6034999999999999D));
            timeseries.add(new Day(4, 5, 2001), new Double(1.6060000000000001D));
            timeseries.add(new Day(8, 5, 2001), new Double(1.6177999999999999D));
            timeseries.add(new Day(9, 5, 2001), new Double(1.6083000000000001D));
            timeseries.add(new Day(10, 5, 2001), new Double(1.6107D));
            timeseries.add(new Day(11, 5, 2001), new Double(1.6209D));
            timeseries.add(new Day(14, 5, 2001), new Double(1.6228D));
            timeseries.add(new Day(15, 5, 2001), new Double(1.6184000000000001D));
            timeseries.add(new Day(16, 5, 2001), new Double(1.6167D));
            timeseries.add(new Day(17, 5, 2001), new Double(1.6223000000000001D));
            timeseries.add(new Day(18, 5, 2001), new Double(1.6305000000000001D));
            timeseries.add(new Day(21, 5, 2001), new Double(1.6419999999999999D));
            timeseries.add(new Day(22, 5, 2001), new Double(1.6484000000000001D));
            timeseries.add(new Day(23, 5, 2001), new Double(1.6547000000000001D));
            timeseries.add(new Day(24, 5, 2001), new Double(1.6444000000000001D));
            timeseries.add(new Day(25, 5, 2001), new Double(1.6577D));
            timeseries.add(new Day(29, 5, 2001), new Double(1.6606000000000001D));
            timeseries.add(new Day(30, 5, 2001), new Double(1.6604000000000001D));
            timeseries.add(new Day(31, 5, 2001), new Double(1.6772D));
            timeseries.add(new Day(1, 6, 2001), new Double(1.6717D));
            timeseries.add(new Day(4, 6, 2001), new Double(1.6685000000000001D));
            timeseries.add(new Day(5, 6, 2001), new Double(1.6620999999999999D));
            timeseries.add(new Day(6, 6, 2001), new Double(1.6459999999999999D));
            timeseries.add(new Day(7, 6, 2001), new Double(1.6333D));
            timeseries.add(new Day(8, 6, 2001), new Double(1.6265000000000001D));
            timeseries.add(new Day(11, 6, 2001), new Double(1.6311D));
            timeseries.add(new Day(12, 6, 2001), new Double(1.6237999999999999D));
            timeseries.add(new Day(13, 6, 2001), new Double(1.6299999999999999D));
            timeseries.add(new Day(14, 6, 2001), new Double(1.6289D));
            timeseries.add(new Day(15, 6, 2001), new Double(1.6275999999999999D));
            timeseries.add(new Day(18, 6, 2001), new Double(1.6298999999999999D));
            timeseries.add(new Day(19, 6, 2001), new Double(1.6353D));
            timeseries.add(new Day(20, 6, 2001), new Double(1.6377999999999999D));
            timeseries.add(new Day(21, 6, 2001), new Double(1.6567000000000001D));
            timeseries.add(new Day(22, 6, 2001), new Double(1.6523000000000001D));
            timeseries.add(new Day(25, 6, 2001), new Double(1.6417999999999999D));
            timeseries.add(new Day(26, 6, 2001), new Double(1.6429D));
            timeseries.add(new Day(27, 6, 2001), new Double(1.6438999999999999D));
            timeseries.add(new Day(28, 6, 2001), new Double(1.6605000000000001D));
            timeseries.add(new Day(29, 6, 2001), new Double(1.6598999999999999D));
            timeseries.add(new Day(2, 7, 2001), new Double(1.6727000000000001D));
            timeseries.add(new Day(3, 7, 2001), new Double(1.6619999999999999D));
            timeseries.add(new Day(4, 7, 2001), new Double(1.6628000000000001D));
            timeseries.add(new Day(5, 7, 2001), new Double(1.673D));
            timeseries.add(new Day(6, 7, 2001), new Double(1.6649D));
            timeseries.add(new Day(9, 7, 2001), new Double(1.6603000000000001D));
            timeseries.add(new Day(10, 7, 2001), new Double(1.6489D));
            timeseries.add(new Day(11, 7, 2001), new Double(1.6420999999999999D));
            timeseries.add(new Day(12, 7, 2001), new Double(1.6497999999999999D));
            timeseries.add(new Day(13, 7, 2001), new Double(1.6447000000000001D));
            timeseries.add(new Day(16, 7, 2001), new Double(1.6373D));
            timeseries.add(new Day(17, 7, 2001), new Double(1.6443000000000001D));
            timeseries.add(new Day(18, 7, 2001), new Double(1.6246D));
            timeseries.add(new Day(19, 7, 2001), new Double(1.6294999999999999D));
            timeseries.add(new Day(20, 7, 2001), new Double(1.6362000000000001D));
            timeseries.add(new Day(23, 7, 2001), new Double(1.6348D));
            timeseries.add(new Day(24, 7, 2001), new Double(1.6242000000000001D));
            timeseries.add(new Day(25, 7, 2001), new Double(1.6241000000000001D));
            timeseries.add(new Day(26, 7, 2001), new Double(1.6281000000000001D));
            timeseries.add(new Day(27, 7, 2001), new Double(1.6295999999999999D));
            timeseries.add(new Day(30, 7, 2001), new Double(1.6278999999999999D));
            timeseries.add(new Day(31, 7, 2001), new Double(1.6299999999999999D));
            timeseries.add(new Day(1, 8, 2001), new Double(1.629D));
            timeseries.add(new Day(2, 8, 2001), new Double(1.6236999999999999D));
            timeseries.add(new Day(3, 8, 2001), new Double(1.6137999999999999D));
            timeseries.add(new Day(6, 8, 2001), new Double(1.6121000000000001D));
            timeseries.add(new Day(7, 8, 2001), new Double(1.617D));
            timeseries.add(new Day(8, 8, 2001), new Double(1.6134999999999999D));
            timeseries.add(new Day(9, 8, 2001), new Double(1.5995999999999999D));
            timeseries.add(new Day(10, 8, 2001), new Double(1.5931D));
            timeseries.add(new Day(13, 8, 2001), new Double(1.5828D));
            timeseries.add(new Day(14, 8, 2001), new Double(1.5824D));
            timeseries.add(new Day(15, 8, 2001), new Double(1.5783D));
            timeseries.add(new Day(16, 8, 2001), new Double(1.581D));
            timeseries.add(new Day(17, 8, 2001), new Double(1.5761000000000001D));
            timeseries.add(new Day(20, 8, 2001), new Double(1.5831D));
            timeseries.add(new Day(21, 8, 2001), new Double(1.587D));
            timeseries.add(new Day(22, 8, 2001), new Double(1.5808D));
            timeseries.add(new Day(23, 8, 2001), new Double(1.5845D));
            timeseries.add(new Day(24, 8, 2001), new Double(1.5844D));
            timeseries.add(new Day(28, 8, 2001), new Double(1.5924D));
            timeseries.add(new Day(29, 8, 2001), new Double(1.595D));
            timeseries.add(new Day(30, 8, 2001), new Double(1.5941000000000001D));
            timeseries.add(new Day(31, 8, 2001), new Double(1.5968D));
            timeseries.add(new Day(3, 9, 2001), new Double(1.6020000000000001D));
            timeseries.add(new Day(4, 9, 2001), new Double(1.6235999999999999D));
            timeseries.add(new Day(5, 9, 2001), new Double(1.6352D));
            timeseries.add(new Day(6, 9, 2001), new Double(1.6302000000000001D));
            timeseries.add(new Day(7, 9, 2001), new Double(1.6180000000000001D));
            timeseries.add(new Day(10, 9, 2001), new Double(1.6217999999999999D));
            timeseries.add(new Day(11, 9, 2001), new Double(1.6182000000000001D));
            timeseries.add(new Day(12, 9, 2001), new Double(1.6156999999999999D));
            timeseries.add(new Day(13, 9, 2001), new Double(1.6171D));
            timeseries.add(new Day(14, 9, 2001), new Double(1.5960000000000001D));
            timeseries.add(new Day(17, 9, 2001), new Double(1.5952D));
            timeseries.add(new Day(18, 9, 2001), new Double(1.5863D));
            timeseries.add(new Day(19, 9, 2001), new Double(1.579D));
            timeseries.add(new Day(20, 9, 2001), new Double(1.5810999999999999D));
            timeseries.add(new Day(21, 9, 2001), new Double(1.5916999999999999D));
            timeseries.add(new Day(24, 9, 2001), new Double(1.6005D));
            timeseries.add(new Day(25, 9, 2001), new Double(1.5914999999999999D));
            timeseries.add(new Day(26, 9, 2001), new Double(1.6012D));
            timeseries.add(new Day(27, 9, 2001), new Double(1.6032D));
            timeseries.add(new Day(28, 9, 2001), new Double(1.6133D));
            timeseries.add(new Day(1, 10, 2001), new Double(1.6147D));
            timeseries.add(new Day(2, 10, 2001), new Double(1.6002000000000001D));
            timeseries.add(new Day(3, 10, 2001), new Double(1.6041000000000001D));
            timeseries.add(new Day(4, 10, 2001), new Double(1.6172D));
            timeseries.add(new Day(5, 10, 2001), new Double(1.6121000000000001D));
            timeseries.add(new Day(8, 10, 2001), new Double(1.6044D));
            timeseries.add(new Day(9, 10, 2001), new Double(1.5973999999999999D));
            timeseries.add(new Day(10, 10, 2001), new Double(1.5914999999999999D));
            timeseries.add(new Day(11, 10, 2001), new Double(1.6022000000000001D));
            timeseries.add(new Day(12, 10, 2001), new Double(1.6013999999999999D));
            timeseries.add(new Day(15, 10, 2001), new Double(1.5942000000000001D));
            timeseries.add(new Day(16, 10, 2001), new Double(1.5925D));
            timeseries.add(new Day(17, 10, 2001), new Double(1.6007D));
            timeseries.add(new Day(18, 10, 2001), new Double(1.6000000000000001D));
            timeseries.add(new Day(19, 10, 2001), new Double(1.603D));
            timeseries.add(new Day(22, 10, 2001), new Double(1.6013999999999999D));
            timeseries.add(new Day(23, 10, 2001), new Double(1.5994999999999999D));
            timeseries.add(new Day(24, 10, 2001), new Double(1.5951D));
            timeseries.add(new Day(25, 10, 2001), new Double(1.5952999999999999D));
            timeseries.add(new Day(26, 10, 2001), new Double(1.6056999999999999D));
            timeseries.add(new Day(29, 10, 2001), new Double(1.6051D));
            timeseries.add(new Day(30, 10, 2001), new Double(1.6027D));
            timeseries.add(new Day(31, 10, 2001), new Double(1.6144000000000001D));
            timeseries.add(new Day(1, 11, 2001), new Double(1.6138999999999999D));
            timeseries.add(new Day(2, 11, 2001), new Double(1.6189D));
            timeseries.add(new Day(5, 11, 2001), new Double(1.6248D));
            timeseries.add(new Day(6, 11, 2001), new Double(1.6267D));
            timeseries.add(new Day(7, 11, 2001), new Double(1.6281000000000001D));
            timeseries.add(new Day(8, 11, 2001), new Double(1.631D));
            timeseries.add(new Day(9, 11, 2001), new Double(1.6313D));
            timeseries.add(new Day(12, 11, 2001), new Double(1.6272D));
            timeseries.add(new Day(13, 11, 2001), new Double(1.6361000000000001D));
            timeseries.add(new Day(14, 11, 2001), new Double(1.6323000000000001D));
            timeseries.add(new Day(15, 11, 2001), new Double(1.6252D));
            timeseries.add(new Day(16, 11, 2001), new Double(1.6141000000000001D));
            timeseries.add(new Day(19, 11, 2001), new Double(1.6086D));
            timeseries.add(new Day(20, 11, 2001), new Double(1.6054999999999999D));
            timeseries.add(new Day(21, 11, 2001), new Double(1.6132D));
            timeseries.add(new Day(22, 11, 2001), new Double(1.6073999999999999D));
            timeseries.add(new Day(23, 11, 2001), new Double(1.6065D));
            timeseries.add(new Day(26, 11, 2001), new Double(1.6061000000000001D));
            timeseries.add(new Day(27, 11, 2001), new Double(1.6039000000000001D));
            timeseries.add(new Day(28, 11, 2001), new Double(1.6069D));
            timeseries.add(new Day(29, 11, 2001), new Double(1.6044D));
            timeseries.add(new Day(30, 11, 2001), new Double(1.5928D));
        }
        catch(Exception exception)
        {
            System.err.println(exception.getMessage());
        }
        return new TimeSeriesCollection(timeseries);
    }

    public static JPanel createDemoPanel()
    {
        JFreeChart jfreechart = createChart(createDataset());
        return new ChartPanel(jfreechart);
    }

    public static void main(String args[])
    {
        TimeSeriesDemo7 timeseriesdemo7 = new TimeSeriesDemo7("Time Series Demo 7");
        timeseriesdemo7.pack();
        RefineryUtilities.centerFrameOnScreen(timeseriesdemo7);
        timeseriesdemo7.setVisible(true);
    }
}
