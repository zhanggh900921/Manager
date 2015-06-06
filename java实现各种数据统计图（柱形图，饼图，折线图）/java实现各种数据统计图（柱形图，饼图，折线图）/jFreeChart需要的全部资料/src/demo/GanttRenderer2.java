



package demo;

import java.awt.*;
import java.awt.geom.Rectangle2D;
import java.io.Serializable;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.event.RendererChangeEvent;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.renderer.category.IntervalBarRenderer;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.gantt.GanttCategoryDataset;

public class GanttRenderer2 extends IntervalBarRenderer
    implements Serializable
{

    public GanttRenderer2()
    {
        setIncludeBaseInRange(false);
        completePaint = Color.green;
        incompletePaint = Color.red;
        startPercent = 0.34999999999999998D;
        endPercent = 0.65000000000000002D;
    }

    public Paint getCompletePaint()
    {
        return completePaint;
    }

    public void setCompletePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            completePaint = paint;
            notifyListeners(new RendererChangeEvent(this));
            return;
        }
    }

    public Paint getIncompletePaint()
    {
        return incompletePaint;
    }

    public void setIncompletePaint(Paint paint)
    {
        if(paint == null)
        {
            throw new IllegalArgumentException("Null 'paint' argument.");
        } else
        {
            incompletePaint = paint;
            notifyListeners(new RendererChangeEvent(this));
            return;
        }
    }

    public double getStartPercent()
    {
        return startPercent;
    }

    public void setStartPercent(double d)
    {
        startPercent = d;
        notifyListeners(new RendererChangeEvent(this));
    }

    public double getEndPercent()
    {
        return endPercent;
    }

    public void setEndPercent(double d)
    {
        endPercent = d;
        notifyListeners(new RendererChangeEvent(this));
    }

    public void drawItem(Graphics2D graphics2d, CategoryItemRendererState categoryitemrendererstate, Rectangle2D rectangle2d, CategoryPlot categoryplot, CategoryAxis categoryaxis, ValueAxis valueaxis, CategoryDataset categorydataset, 
            int i, int j, int k)
    {
        if(categorydataset instanceof GanttCategoryDataset)
        {
            GanttCategoryDataset ganttcategorydataset = (GanttCategoryDataset)categorydataset;
            drawTasks(graphics2d, categoryitemrendererstate, rectangle2d, categoryplot, categoryaxis, valueaxis, ganttcategorydataset, i, j);
        } else
        {
            super.drawItem(graphics2d, categoryitemrendererstate, rectangle2d, categoryplot, categoryaxis, valueaxis, categorydataset, i, j, k);
        }
    }

    protected void drawTasks(Graphics2D graphics2d, CategoryItemRendererState categoryitemrendererstate, Rectangle2D rectangle2d, CategoryPlot categoryplot, CategoryAxis categoryaxis, ValueAxis valueaxis, GanttCategoryDataset ganttcategorydataset, 
            int i, int j)
    {
        int k = ganttcategorydataset.getSubIntervalCount(i, j);
        if(k == 0)
            drawTask(graphics2d, categoryitemrendererstate, rectangle2d, categoryplot, categoryaxis, valueaxis, ganttcategorydataset, i, j);
        for(int l = 0; l < k; l++)
        {
            org.jfree.ui.RectangleEdge rectangleedge = categoryplot.getRangeAxisEdge();
            Number number = ganttcategorydataset.getStartValue(i, j, l);
            if(number == null)
                return;
            double d = valueaxis.valueToJava2D(number.doubleValue(), rectangle2d, rectangleedge);
            Number number1 = ganttcategorydataset.getEndValue(i, j, l);
            if(number1 == null)
                return;
            double d1 = valueaxis.valueToJava2D(number1.doubleValue(), rectangle2d, rectangleedge);
            if(d1 < d)
            {
                double d2 = d1;
                d1 = d;
                d = d2;
            }
            double d3 = calculateBarW0(categoryplot, categoryplot.getOrientation(), rectangle2d, categoryaxis, categoryitemrendererstate, i, j);
            double d4 = Math.abs(d1 - d);
            double d5 = categoryitemrendererstate.getBarWidth();
            java.awt.geom.Rectangle2D.Double double1 = null;
            if(categoryplot.getOrientation() == PlotOrientation.HORIZONTAL)
                double1 = new java.awt.geom.Rectangle2D.Double(d, d3, d4, d5);
            else
            if(categoryplot.getOrientation() == PlotOrientation.VERTICAL)
                double1 = new java.awt.geom.Rectangle2D.Double(d3, d, d5, d4);
            java.awt.geom.Rectangle2D.Double double2 = null;
            java.awt.geom.Rectangle2D.Double double3 = null;
            Number number2 = ganttcategorydataset.getPercentComplete(i, j, l);
            double d6 = getStartPercent();
            double d7 = getEndPercent();
            if(number2 != null)
            {
                double d8 = number2.doubleValue();
                if(categoryplot.getOrientation() == PlotOrientation.HORIZONTAL)
                {
                    double2 = new java.awt.geom.Rectangle2D.Double(d, d3 + d6 * d5, d4 * d8, d5 * (d7 - d6));
                    double3 = new java.awt.geom.Rectangle2D.Double(d + d4 * d8, d3 + d6 * d5, d4 * (1.0D - d8), d5 * (d7 - d6));
                } else
                if(categoryplot.getOrientation() == PlotOrientation.VERTICAL)
                {
                    double2 = new java.awt.geom.Rectangle2D.Double(d3 + d6 * d5, d + d4 * (1.0D - d8), d5 * (d7 - d6), d4 * d8);
                    double3 = new java.awt.geom.Rectangle2D.Double(d3 + d6 * d5, d, d5 * (d7 - d6), d4 * (1.0D - d8));
                }
            }
            Paint paint = getItemPaint(i, j);
            graphics2d.setPaint(paint);
            graphics2d.fill(double1);
            if(double2 != null)
            {
                graphics2d.setPaint(getCompletePaint());
                graphics2d.fill(double2);
            }
            if(double3 != null)
            {
                graphics2d.setPaint(getIncompletePaint());
                graphics2d.fill(double3);
            }
            if(isDrawBarOutline() && categoryitemrendererstate.getBarWidth() > 3D)
            {
                graphics2d.setStroke(getItemStroke(i, j));
                graphics2d.setPaint(getItemOutlinePaint(i, j));
                graphics2d.draw(double1);
            }
            if(categoryitemrendererstate.getInfo() == null)
                continue;
            EntityCollection entitycollection = categoryitemrendererstate.getEntityCollection();
            if(entitycollection == null)
                continue;
            String s = null;
            if(getToolTipGenerator(i, j) != null)
                s = getToolTipGenerator(i, j).generateToolTip(ganttcategorydataset, i, j);
            String s1 = null;
            if(getItemURLGenerator(i, j) != null)
                s1 = getItemURLGenerator(i, j).generateURL(ganttcategorydataset, i, j);
            CategoryItemEntity categoryitementity = new CategoryItemEntity(double1, s, s1, ganttcategorydataset, ganttcategorydataset.getRowKey(i), ganttcategorydataset.getColumnKey(j));
            entitycollection.add(categoryitementity);
        }

    }

    protected void drawTask(Graphics2D graphics2d, CategoryItemRendererState categoryitemrendererstate, Rectangle2D rectangle2d, CategoryPlot categoryplot, CategoryAxis categoryaxis, ValueAxis valueaxis, GanttCategoryDataset ganttcategorydataset, 
            int i, int j)
    {
        PlotOrientation plotorientation = categoryplot.getOrientation();
        org.jfree.ui.RectangleEdge rectangleedge = categoryplot.getRangeAxisEdge();
        Number number = ganttcategorydataset.getEndValue(i, j);
        if(number == null)
            return;
        double d = valueaxis.valueToJava2D(number.doubleValue(), rectangle2d, rectangleedge);
        Number number1 = ganttcategorydataset.getStartValue(i, j);
        if(number1 == null)
            return;
        double d1 = valueaxis.valueToJava2D(number1.doubleValue(), rectangle2d, rectangleedge);
        if(d1 < d)
        {
            double d2 = d1;
            d1 = d;
            d = d2;
            Number number2 = number1;
            number1 = number;
            number = number2;
        }
        int k = countNonNullValues(ganttcategorydataset, j);
        if(k == 0)
            return;
        int l = countPriorNonNullValues(ganttcategorydataset, j, i);
        double d3 = (categoryaxis.getCategoryEnd(j, getColumnCount(), rectangle2d, categoryplot.getDomainAxisEdge()) - categoryaxis.getCategoryStart(j, getColumnCount(), rectangle2d, categoryplot.getDomainAxisEdge())) / (double)k;
        double d4 = categoryaxis.getCategoryStart(j, getColumnCount(), rectangle2d, categoryplot.getDomainAxisEdge()) + d3 * (double)l;
        double d5 = Math.abs(d1 - d);
        java.awt.geom.Rectangle2D.Double double1 = null;
        if(plotorientation == PlotOrientation.HORIZONTAL)
            double1 = new java.awt.geom.Rectangle2D.Double(d, d4, d5, d3);
        else
        if(plotorientation == PlotOrientation.VERTICAL)
            double1 = new java.awt.geom.Rectangle2D.Double(d4, d1, d3, d5);
        java.awt.geom.Rectangle2D.Double double2 = null;
        java.awt.geom.Rectangle2D.Double double3 = null;
        Number number3 = ganttcategorydataset.getPercentComplete(i, j);
        double d6 = getStartPercent();
        double d7 = getEndPercent();
        if(number3 != null)
        {
            double d8 = number3.doubleValue();
            if(categoryplot.getOrientation() == PlotOrientation.HORIZONTAL)
            {
                double2 = new java.awt.geom.Rectangle2D.Double(d, d4 + d6 * d3, d5 * d8, d3 * (d7 - d6));
                double3 = new java.awt.geom.Rectangle2D.Double(d + d5 * d8, d4 + d6 * d3, d5 * (1.0D - d8), d3 * (d7 - d6));
            } else
            if(categoryplot.getOrientation() == PlotOrientation.VERTICAL)
            {
                double2 = new java.awt.geom.Rectangle2D.Double(d4 + d6 * d3, d1 + d5 * (1.0D - d8), d3 * (d7 - d6), d5 * d8);
                double3 = new java.awt.geom.Rectangle2D.Double(d4 + d6 * d3, d1, d3 * (d7 - d6), d5 * (1.0D - d8));
            }
        }
        Paint paint = getItemPaint(i, j);
        graphics2d.setPaint(paint);
        graphics2d.fill(double1);
        if(double2 != null)
        {
            graphics2d.setPaint(getCompletePaint());
            graphics2d.fill(double2);
        }
        if(double3 != null)
        {
            graphics2d.setPaint(getIncompletePaint());
            graphics2d.fill(double3);
        }
        if(isDrawBarOutline() && categoryitemrendererstate.getBarWidth() > 3D)
        {
            java.awt.Stroke stroke = getItemOutlineStroke(i, j);
            Paint paint1 = getItemOutlinePaint(i, j);
            if(stroke != null && paint1 != null)
            {
                graphics2d.setStroke(stroke);
                graphics2d.setPaint(paint1);
                graphics2d.draw(double1);
            }
        }
        org.jfree.chart.labels.CategoryItemLabelGenerator categoryitemlabelgenerator = getItemLabelGenerator(i, j);
        if(categoryitemlabelgenerator != null && isItemLabelVisible(i, j))
            drawItemLabel(graphics2d, ganttcategorydataset, i, j, categoryplot, categoryitemlabelgenerator, double1, false);
        if(categoryitemrendererstate.getInfo() != null)
        {
            EntityCollection entitycollection = categoryitemrendererstate.getEntityCollection();
            if(entitycollection != null)
            {
                String s = null;
                CategoryToolTipGenerator categorytooltipgenerator = getToolTipGenerator(i, j);
                if(categorytooltipgenerator != null)
                    s = categorytooltipgenerator.generateToolTip(ganttcategorydataset, i, j);
                String s1 = null;
                if(getItemURLGenerator(i, j) != null)
                    s1 = getItemURLGenerator(i, j).generateURL(ganttcategorydataset, i, j);
                CategoryItemEntity categoryitementity = new CategoryItemEntity(double1, s, s1, ganttcategorydataset, ganttcategorydataset.getRowKey(i), ganttcategorydataset.getColumnKey(j));
                entitycollection.add(categoryitementity);
            }
        }
    }

    protected double calculateBarW0(CategoryPlot categoryplot, PlotOrientation plotorientation, Rectangle2D rectangle2d, CategoryAxis categoryaxis, CategoryItemRendererState categoryitemrendererstate, int i, int j)
    {
        double d = 0.0D;
        if(plotorientation == PlotOrientation.HORIZONTAL)
            d = rectangle2d.getHeight();
        else
            d = rectangle2d.getWidth();
        double d1 = categoryaxis.getCategoryStart(j, getColumnCount(), rectangle2d, categoryplot.getDomainAxisEdge());
        int k = getRowCount();
        int l = getColumnCount();
        if(k > 1)
        {
            double d2 = (d * getItemMargin()) / (double)(l * (k - 1));
            double d3 = calculateSeriesWidth(d, categoryaxis, l, k);
            d1 = (d1 + (double)i * (d3 + d2) + d3 / 2D) - categoryitemrendererstate.getBarWidth() / 2D;
        } else
        {
            d1 = categoryaxis.getCategoryMiddle(j, getColumnCount(), rectangle2d, categoryplot.getDomainAxisEdge()) - categoryitemrendererstate.getBarWidth() / 2D;
        }
        return d1;
    }

    private int countNonNullValues(CategoryDataset categorydataset, int i)
    {
        return countPriorNonNullValues(categorydataset, i, categorydataset.getRowCount());
    }

    private int countPriorNonNullValues(CategoryDataset categorydataset, int i, int j)
    {
        if(j == 0)
            return 0;
        int k = 0;
        for(int l = 0; l < j; l++)
            if(categorydataset.getValue(l, i) != null)
                k++;

        return k;
    }

    private static final long serialVersionUID = 0xc85860b9f6a641a8L;
    private Paint completePaint;
    private Paint incompletePaint;
    private double startPercent;
    private double endPercent;
}
