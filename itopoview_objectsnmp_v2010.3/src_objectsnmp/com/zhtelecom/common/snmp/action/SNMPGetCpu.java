package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;
import com.zhtelecom.common.snmp.mib.MibProcessorEntry;

public class SNMPGetCpu extends SNMPBaseAction
{
    public SNMPGetCpu()
    {
        super("查看CPU状态");
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
                        {"CPU固件编号","CPU负载"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {
                    MibProcessorEntry table = (MibProcessorEntry) obj;
                    Object[] viDatas =
                        {
                          table.getHrProcessorFrwID(),""+table.getHrProcessorLoad()+"%"
                       };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibProcessorEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(), desc, false, false, false, true);
            dialog.setSize(300, 200);
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
            SNMPGetCpu action = new SNMPGetCpu();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
