



package demo;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import org.jfree.chart.*;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo2 extends ApplicationFrame
    implements ChartMouseListener
{

    public MouseListenerDemo2(String s)
    {
        super(s);
        DefaultCategoryDataset defaultcategorydataset = new DefaultCategoryDataset();
        defaultcategorydataset.addValue(1.0D, "S1", "C1");
        defaultcategorydataset.addValue(4D, "S1", "C2");
        defaultcategorydataset.addValue(3D, "S1", "C3");
        defaultcategorydataset.addValue(5D, "S1", "C4");
        defaultcategorydataset.addValue(5D, "S1", "C5");
        defaultcategorydataset.addValue(6D, "S1", "C6");
        defaultcategorydataset.addValue(7D, "S1", "C7");
        defaultcategorydataset.addValue(8D, "S1", "C8");
        defaultcategorydataset.addValue(5D, "S2", "C1");
        defaultcategorydataset.addValue(7D, "S2", "C2");
        defaultcategorydataset.addValue(6D, "S2", "C3");
        defaultcategorydataset.addValue(8D, "S2", "C4");
        defaultcategorydataset.addValue(4D, "S2", "C5");
        defaultcategorydataset.addValue(4D, "S2", "C6");
        defaultcategorydataset.addValue(3D, "S2", "C7");
        defaultcategorydataset.addValue(1.0D, "S2", "C8");
        defaultcategorydataset.addValue(4D, "S3", "C1");
        defaultcategorydataset.addValue(3D, "S3", "C2");
        defaultcategorydataset.addValue(2D, "S3", "C3");
        defaultcategorydataset.addValue(3D, "S3", "C4");
        defaultcategorydataset.addValue(6D, "S3", "C5");
        defaultcategorydataset.addValue(3D, "S3", "C6");
        defaultcategorydataset.addValue(4D, "S3", "C7");
        defaultcategorydataset.addValue(3D, "S3", "C8");
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createBarChart("Test", "Category", "Value", defaultcategorydataset, PlotOrientation.VERTICAL, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart);
        chartpanel.addChartMouseListener(this);
        chartpanel.setPreferredSize(new Dimension(500, 270));
        setContentPane(chartpanel);
    }

    public void chartMouseClicked(ChartMouseEvent chartmouseevent)
    {
        ChartEntity chartentity = chartmouseevent.getEntity();
        if(chartentity != null)
            System.out.println("Mouse clicked: " + chartentity.toString());
        else
            System.out.println("Mouse clicked: null entity.");
    }

    public void chartMouseMoved(ChartMouseEvent chartmouseevent)
    {
        int i = chartmouseevent.getTrigger().getX();
        int j = chartmouseevent.getTrigger().getY();
        ChartEntity chartentity = chartmouseevent.getEntity();
        if(chartentity != null)
            System.out.println("Mouse moved: " + i + ", " + j + ": " + chartentity.toString());
        else
            System.out.println("Mouse moved: " + i + ", " + j + ": null entity.");
    }

    public static void main(String args[])
    {
        MouseListenerDemo2 mouselistenerdemo2 = new MouseListenerDemo2("Mouse Listener Demo 2");
        mouselistenerdemo2.pack();
        RefineryUtilities.centerFrameOnScreen(mouselistenerdemo2);
        mouselistenerdemo2.setVisible(true);
    }
}
