package com.zhtelecom.common.snmp.action;

import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;

public class SNMPGetMibIfEntry extends SNMPBaseAction
{
    public SNMPGetMibIfEntry()
    {
        super("查看网络接口信息");
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
                        {"网络接口序号", "接口名称", "运行状态", "物理地址", "速率(Mbps)", "管理状态"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibIfEntry table = (MibIfEntry) obj;
                    Object[] viDatas =
                        {new Integer(table.getIfIndex()), table.getIfDescr(), new Integer(table.getIfOperStatus()),
                        Utils.getHexString(table.getIfPhysAddress()), new Long(table.getIfSpeed() / 1000000),
                        new Integer(table.getIfAdminStatus())

                    };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibIfEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(600, 400);

            Value[] vs = new Value[3];
            vs[0] = new Value(new Integer(1), "运行");
            vs[1] = new Value(new Integer(2), "停止");
            vs[2] = new Value(new Integer(3), "测试");
            dialog.table.setRendererKVType(2, vs);
            dialog.table.setRendererKVType(5, vs);
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
            SNMPGetMibIfEntry action = new SNMPGetMibIfEntry();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
