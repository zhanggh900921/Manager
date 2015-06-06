
package com.zhtelecom.common.topograph.example.menuaction;

import java.awt.event.*;
import javax.swing.*;

import com.zhtelecom.common.topograph.*;

public class ActionDelAllAlarm extends AbstractAction
{

    public void actionPerformed(ActionEvent e)
    {
        //之前已被赋值，这里获取该拓扑对象。也可以通过TopoGraphView.getContextGraphView()快速获取唯一实例。
        TopoGraphView topoView = (TopoGraphView) getValue("topoGraphView");

        TopoDataSource tds = topoView.getTopoDataSource();
       tds.cleareAllAlarm();
    }

    public ActionDelAllAlarm()
    {
        super("清空全部告警");
    }
}
