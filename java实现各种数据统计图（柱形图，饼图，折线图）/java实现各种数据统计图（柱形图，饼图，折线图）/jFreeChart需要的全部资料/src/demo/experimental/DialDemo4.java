



package demo.experimental;

import java.awt.*;
import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultValueDataset;
import org.jfree.experimental.chart.plot.dial.*;
import org.jfree.ui.GradientPaintTransformType;
import org.jfree.ui.StandardGradientPaintTransformer;

public class DialDemo4 extends JFrame
{
    static class DemoPanel extends JPanel
        implements ChangeListener
    {

        public void stateChanged(ChangeEvent changeevent)
        {
            dataset.setValue(new Integer(slider.getValue()));
        }

        JSlider slider;
        DefaultValueDataset dataset;

        public DemoPanel()
        {
            super(new BorderLayout());
            dataset = new DefaultValueDataset(50D);
            DialPlot dialplot = new DialPlot();
            dialplot.setView(0.78000000000000003D, 0.37D, 0.22D, 0.26000000000000001D);
            dialplot.setDataset(dataset);
            StandardDialFrame standarddialframe = new StandardDialFrame(-10D, 20D);
            standarddialframe.setInnerRadius(0.69999999999999996D);
            standarddialframe.setOuterRadius(0.90000000000000002D);
            standarddialframe.setForegroundPaint(Color.darkGray);
            standarddialframe.setStroke(new BasicStroke(3F));
            dialplot.setDialFrame(standarddialframe);
            GradientPaint gradientpaint = new GradientPaint(new Point(), new Color(255, 255, 255), new Point(), new Color(240, 240, 240));
            DialBackground dialbackground = new DialBackground(gradientpaint);
            dialbackground.setGradientPaintTransformer(new StandardGradientPaintTransformer(GradientPaintTransformType.VERTICAL));
            dialplot.addLayer(dialbackground);
            StandardDialScale standarddialscale = new StandardDialScale(0.0D, 100D, -8D, 16D);
            standarddialscale.setTickRadius(0.81999999999999995D);
            standarddialscale.setTickLabelOffset(-0.040000000000000001D);
            standarddialscale.setMajorTickIncrement(25D);
            standarddialscale.setTickLabelFont(new Font("Dialog", 0, 14));
            dialplot.addScale(0, standarddialscale);
            org.jfree.experimental.chart.plot.dial.DialPointer.Pin pin = new org.jfree.experimental.chart.plot.dial.DialPointer.Pin();
            pin.setRadius(0.83999999999999997D);
            dialplot.addLayer(pin);
            JFreeChart jfreechart = new JFreeChart(dialplot);
            jfreechart.setTitle("Dial Demo 4");
            ChartPanel chartpanel = new ChartPanel(jfreechart);
            chartpanel.setPreferredSize(new Dimension(400, 250));
            slider = new JSlider(0, 100);
            slider.setMajorTickSpacing(10);
            slider.setPaintLabels(true);
            slider.addChangeListener(this);
            add(chartpanel);
            add(slider, "South");
        }
    }


    public static JPanel createDemoPanel()
    {
        return new DemoPanel();
    }

    public DialDemo4(String s)
    {
        super(s);
        setDefaultCloseOperation(3);
        setContentPane(createDemoPanel());
    }

    public static void main(String args[])
    {
        DialDemo4 dialdemo4 = new DialDemo4("JFreeChart - Demo Dial 4");
        dialdemo4.pack();
        dialdemo4.setVisible(true);
    }
}
