
package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

import com.zhtelecom.common.snmp.mib.MibDeviceEntry;

public class SNMPGetMibDevice extends SNMPBaseAction
{
    public SNMPGetMibDevice()
    {
        super("查看设备设施状态");
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
                        {"设备编号","设备描述","工作状态","发生错误个数"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibDeviceEntry table = (MibDeviceEntry) obj;
                    Object[] viDatas =
                        {
                          new Integer(table.getHrDeviceIndex()),table.getHrDeviceDescr(),
                          new Integer(table.getHrDeviceStatus()),new Long(table.getHrDeviceErrors())
                       };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibDeviceEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(600, 500);
            Value[] vs = new Value[5];
            vs[0] = new Value(new Integer(1), "未知");
            vs[1] = new Value(new Integer(2), "运行中");
            vs[2] = new Value(new Integer(3), "有故障");
            vs[3] = new Value(new Integer(2), "测试中");
            vs[4] = new Value(new Integer(3), "关闭");
            dialog.table.setRendererKVType(2, vs);
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
            SNMPGetMibDevice action = new SNMPGetMibDevice();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
