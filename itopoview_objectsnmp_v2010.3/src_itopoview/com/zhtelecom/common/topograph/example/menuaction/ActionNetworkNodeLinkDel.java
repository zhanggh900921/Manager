package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoObject;

public class ActionNetworkNodeLinkDel extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        TopoObject topoObject = topoView.getSelectedObject();
        topoView.getTopoDataSource().removeTopoData(topoObject);
    }

    public ActionNetworkNodeLinkDel()
    {
        super(" É¾³ý");
    }
}
