
package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

import com.zhtelecom.common.snmp.mib.MibSoftwareRunEntry;

public class SNMPGetRunSW extends SNMPBaseAction
{
    public SNMPGetRunSW()
    {
        super("查看进程状态");
    }

    public void actionPerformed(ActionEvent e)
    {
        try
        {
            ObjectTableDesc desc = new ObjectTableDesc()
            {
                public Object[] getcolumnNames()
                {
                    String[] cols =
                        {"进程ID","进程名称","进程参数","启动路径","运行状态","进程类型"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibSoftwareRunEntry table = (MibSoftwareRunEntry) obj;
                    Object[] viDatas =
                        {
                          new Integer(table.getHrSWRunIndex()),table.getHrSWRunName(),
                          table.getHrSWRunParameters(),table.getHrSWRunPath(),
                          new Integer(table.getHrSWRunStatus()),new Integer(table.getHrSWRunType())
                       };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibSoftwareRunEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(600, 500);
            Value[] vs = new Value[4];
            vs[0] = new Value(new Integer(1), "未知");
            vs[1] = new Value(new Integer(2), "操作系统软件");
            vs[2] = new Value(new Integer(3), "设备驱动软件");
            vs[3] = new Value(new Integer(4), "应用软件");
            dialog.table.setRendererKVType(5, vs);

            Value[] vst = new Value[4];
            vst[0] = new Value(new Integer(1), "正在运行");
            vst[1] = new Value(new Integer(2), "准备运行");
            vst[2] = new Value(new Integer(3), "不可运行");
            vst[3] = new Value(new Integer(4), "失效");
            dialog.table.setRendererKVType(4, vst);


            dialog.setTitle(getTitle());
            dialog.myInit(target, null, null);
            dialog.processQueryall();
            DialogTools.dialogPack(getFrame(), dialog);
        } catch (Exception ex)
        {
            DialogTools.showErroMsgFromEx(getFrame(), getErroTitle(), ex);
        }

    }

    public static void main(String[] ag)
    {
        try
        {
            SNMPFactory.init(SNMPFactory.Mode_Local, null);
            SNMPGetRunSW action = new SNMPGetRunSW();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
