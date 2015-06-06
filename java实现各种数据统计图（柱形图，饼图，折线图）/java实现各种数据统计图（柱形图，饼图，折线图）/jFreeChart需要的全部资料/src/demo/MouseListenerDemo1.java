



package demo;

import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.io.PrintStream;
import org.jfree.chart.*;
import org.jfree.chart.entity.ChartEntity;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

public class MouseListenerDemo1 extends ApplicationFrame
    implements ChartMouseListener
{

    public MouseListenerDemo1(String s)
    {
        super(s);
        DefaultPieDataset defaultpiedataset = new DefaultPieDataset();
        defaultpiedataset.setValue("Java", new Double(43.200000000000003D));
        defaultpiedataset.setValue("Visual Basic", new Double(0.0D));
        defaultpiedataset.setValue("C/C++", new Double(17.5D));
        org.jfree.chart.JFreeChart jfreechart = ChartFactory.createPieChart("Pie Chart Demo 1", defaultpiedataset, true, true, false);
        ChartPanel chartpanel = new ChartPanel(jfreechart, false, false, false, false, false);
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
        MouseListenerDemo1 mouselistenerdemo1 = new MouseListenerDemo1("Mouse Listener Demo");
        mouselistenerdemo1.pack();
        RefineryUtilities.centerFrameOnScreen(mouselistenerdemo1);
        mouselistenerdemo1.setVisible(true);
    }
}
