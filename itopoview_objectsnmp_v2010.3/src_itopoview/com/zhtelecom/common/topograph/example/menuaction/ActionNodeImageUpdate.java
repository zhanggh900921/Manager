package com.zhtelecom.common.topograph.example.menuaction;

import java.io.File;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileFilter;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoNode;

public class ActionNodeImageUpdate extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        try
        {
            JFileChooser fc = new JFileChooser();
            FileFilter fileFilter = new FileFilter()
            {

                public boolean accept(File f)
                {
                    if (f == null)
                    {
                        return false;
                    }
                    if (f.getName() == null)
                    {
                        return false;
                    }
                    if (f.getName().endsWith(".jpg"))
                    {
                        return true;
                    }
                    if (f.getName().endsWith(".jpeg"))
                    {
                        return true;
                    }
                    if (f.getName().endsWith(".bmp"))
                    {
                        return true;
                    }
                    if (f.getName().endsWith(".gif"))
                    {
                        return true;
                    }
                    if (f.getName().endsWith(".png"))
                    {
                        return true;
                    }
                    if (f.isDirectory())
                    {
                        return true;
                    }

                    return false;
                }

                public String getDescription()
                {
                    return "图片类型(.bmp; .gif; .png; .jpg; .jpeg)";
                }
            };
            fc.setFileFilter(fileFilter);

            fc.setDialogType(fc.OPEN_DIALOG);
            int result = fc.showSaveDialog(topoView);
            if (result == JFileChooser.APPROVE_OPTION)
            {
                java.io.File file = fc.getSelectedFile();
                ImageIcon icon = new ImageIcon(file.getPath());
                TopoNode node = topoView.getSelectedNode();
                node.setImageIcon(icon);
            }

        }

        catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    public ActionNodeImageUpdate()
    {

        super("修改显示图片");
    }
}
