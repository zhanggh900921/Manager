package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

import com.zhtelecom.common.topograph.TopoGraphView;
import com.zhtelecom.common.topograph.TopoObject;

public class ActionAlarmDel extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {

        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");
        TopoObject obj = topoView.getSelectedObject();
        obj.cleareAlarm();
    }

    public ActionAlarmDel()
    {
        super("Çå³ý¸æ¾¯");
    }
}
