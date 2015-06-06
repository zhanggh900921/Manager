



package demo;

import java.awt.GradientPaint;
import java.awt.Graphics2D;
import java.awt.geom.*;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.entity.CategoryItemEntity;
import org.jfree.chart.entity.EntityCollection;
import org.jfree.chart.labels.CategoryToolTipGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer3D;
import org.jfree.chart.renderer.category.CategoryItemRendererState;
import org.jfree.chart.urls.CategoryURLGenerator;
import org.jfree.data.category.CategoryDataset;
import org.jfree.ui.GradientPaintTransformer;

public class CylinderRenderer extends BarRenderer3D
{

    public CylinderRenderer()
    {
    }

    public CylinderRenderer(double d, double d1)
    {
        super(d, d1);
    }

    public void drawItem(Graphics2D graphics2d, CategoryItemRendererState categoryitemrendererstate, Rectangle2D rectangle2d, CategoryPlot categoryplot, CategoryAxis categoryaxis, ValueAxis valueaxis, CategoryDataset categorydataset, 
            int i, int j, int k)
    {
        Number number = categorydataset.getValue(i, j);
        if(number == null)
            return;
        double d = number.doubleValue();
        java.awt.geom.Rectangle2D.Double double1 = new java.awt.geom.Rectangle2D.Double(rectangle2d.getX(), rectangle2d.getY() + getYOffset(), rectangle2d.getWidth() - getXOffset(), rectangle2d.getHeight() - getYOffset());
        PlotOrientation plotorientation = categoryplot.getOrientation();
        double d1 = calculateBarW0(categoryplot, plotorientation, double1, categoryaxis, categoryitemrendererstate, i, j);
        double ad[] = calculateBarL0L1(d);
        if(ad == null)
            return;
        org.jfree.ui.RectangleEdge rectangleedge = categoryplot.getRangeAxisEdge();
        float f = (float)valueaxis.valueToJava2D(ad[0], double1, rectangleedge);
        float f1 = (float)valueaxis.valueToJava2D(ad[1], double1, rectangleedge);
        float f2 = Math.min(f, f1);
        float f3 = Math.abs(f1 - f);
        GeneralPath generalpath = new GeneralPath();
        java.awt.geom.Ellipse2D.Double double2 = null;
        if(plotorientation == PlotOrientation.HORIZONTAL)
        {
            generalpath.moveTo((float)((double)f2 + getXOffset() / 2D), (float)d1);
            generalpath.lineTo((float)((double)(f2 + f3) + getXOffset() / 2D), (float)d1);
            java.awt.geom.Arc2D.Double double3 = new java.awt.geom.Arc2D.Double(f2 + f3, d1, getXOffset(), categoryitemrendererstate.getBarWidth(), 90D, 180D, 0);
            generalpath.append(double3, true);
            generalpath.lineTo((float)((double)f2 + getXOffset() / 2D), (float)(d1 + categoryitemrendererstate.getBarWidth()));
            double3 = new java.awt.geom.Arc2D.Double(f2, d1, getXOffset(), categoryitemrendererstate.getBarWidth(), 270D, -180D, 0);
            generalpath.append(double3, true);
            generalpath.closePath();
            double2 = new java.awt.geom.Ellipse2D.Double(f2 + f3, d1, getXOffset(), categoryitemrendererstate.getBarWidth());
        } else
        {
            generalpath.moveTo((float)d1, (float)((double)f2 - getYOffset() / 2D));
            generalpath.lineTo((float)d1, (float)((double)(f2 + f3) - getYOffset() / 2D));
            java.awt.geom.Arc2D.Double double4 = new java.awt.geom.Arc2D.Double(d1, (double)(f2 + f3) - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset(), 180D, 180D, 0);
            generalpath.append(double4, true);
            generalpath.lineTo((float)(d1 + categoryitemrendererstate.getBarWidth()), (float)((double)f2 - getYOffset() / 2D));
            double4 = new java.awt.geom.Arc2D.Double(d1, (double)f2 - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset(), 0.0D, -180D, 0);
            generalpath.append(double4, true);
            generalpath.closePath();
            double2 = new java.awt.geom.Ellipse2D.Double(d1, (double)f2 - getYOffset(), categoryitemrendererstate.getBarWidth(), getYOffset());
        }
        Object obj = getItemPaint(i, j);
        if(getGradientPaintTransformer() != null && (obj instanceof GradientPaint))
        {
            GradientPaint gradientpaint = (GradientPaint)obj;
            obj = getGradientPaintTransformer().transform(gradientpaint, generalpath);
        }
        graphics2d.setPaint(((java.awt.Paint) (obj)));
        graphics2d.fill(generalpath);
        if(obj instanceof GradientPaint)
            graphics2d.setPaint(((GradientPaint)obj).getColor2());
        if(double2 != null)
            graphics2d.fill(double2);
        if(isDrawBarOutline() && categoryitemrendererstate.getBarWidth() > 3D)
        {
            graphics2d.setStroke(getItemOutlineStroke(i, j));
            graphics2d.setPaint(getItemOutlinePaint(i, j));
            graphics2d.draw(generalpath);
            if(double2 != null)
                graphics2d.draw(double2);
        }
        org.jfree.chart.labels.CategoryItemLabelGenerator categoryitemlabelgenerator = getItemLabelGenerator(i, j);
        if(categoryitemlabelgenerator != null && isItemLabelVisible(i, j))
            drawItemLabel(graphics2d, categorydataset, i, j, categoryplot, categoryitemlabelgenerator, generalpath.getBounds2D(), d < 0.0D);
        if(categoryitemrendererstate.getInfo() != null)
        {
            EntityCollection entitycollection = categoryitemrendererstate.getEntityCollection();
            if(entitycollection != null)
            {
                String s = null;
                CategoryToolTipGenerator categorytooltipgenerator = getToolTipGenerator(i, j);
                if(categorytooltipgenerator != null)
                    s = categorytooltipgenerator.generateToolTip(categorydataset, i, j);
                String s1 = null;
                if(getItemURLGenerator(i, j) != null)
                    s1 = getItemURLGenerator(i, j).generateURL(categorydataset, i, j);
                CategoryItemEntity categoryitementity = new CategoryItemEntity(generalpath.getBounds2D(), s, s1, categorydataset, categorydataset.getRowKey(i), categorydataset.getColumnKey(j));
                entitycollection.add(categoryitementity);
            }
        }
    }
}
