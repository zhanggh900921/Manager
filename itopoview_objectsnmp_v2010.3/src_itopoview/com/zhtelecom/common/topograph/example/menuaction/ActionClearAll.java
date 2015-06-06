package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoObject;

public class ActionClearAll extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        topoView.getTopoDataSource().clearAllData();

    }

    public ActionClearAll()
    {
        super("Çå¿ÕÍØÆËÍ¼");
    }
}
