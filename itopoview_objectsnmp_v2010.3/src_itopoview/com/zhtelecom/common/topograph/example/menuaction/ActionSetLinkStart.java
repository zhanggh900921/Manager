package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;

public class ActionSetLinkStart extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");

        topoView.setLinkSource(topoView.getSelectedNode());

    }

    public ActionSetLinkStart()
    {
        super("设置连接起点");
    }
}
