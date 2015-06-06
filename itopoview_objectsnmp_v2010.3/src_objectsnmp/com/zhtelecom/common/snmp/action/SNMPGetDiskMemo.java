
package com.zhtelecom.common.snmp.action;
import java.awt.event.*;

import com.l2fprod.common.beans.editor.*;
import com.l2fprod.common.beans.editor.ComboBoxPropertyEditor.*;
import com.zhtelecom.common.base.*;
import com.zhtelecom.common.snmp.*;
import com.zhtelecom.common.snmp.mib.*;
import com.zhtelecom.common.snmp.view.*;
import com.zhtelecom.common.table.*;
import com.zhtelecom.common.snmp.mib.MibDiskAndMemoEntry;

public class SNMPGetDiskMemo extends SNMPBaseAction
{
    public SNMPGetDiskMemo()
    {
        super("查看磁盘和内存存储状态");
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
                        {"存储编号", "存储描述","总存储大小","已用存储大小","剩余空间","使用百分比"};
                    return cols;
                }

                public Object[] getRowDatas(Object obj)
                {

                    MibDiskAndMemoEntry table = (MibDiskAndMemoEntry) obj;
                    long allSize=(long)table.getHrStorageSize()*(long)table.getHrStorageAllocationUnits();
                    long userSize=(long)table.getHrStorageUsed()*(long)table.getHrStorageAllocationUnits();
                    long canUseSize=allSize-userSize;
                    String use="";
                    if(allSize!=0)
                    {
                        use=""+(userSize*100)/allSize+"%";
                    }
                    Object[] viDatas =
                        {
                          new Integer(table.getHrStorageIndex()),table.getHrStorageDescr(),
                          ""+allSize/1024/1024/1024+"GB"+(allSize%(1024*1024*1024))/1024/1024+"MB",
                          ""+userSize/1024/1024/1024+"GB"+(userSize%(1024*1024*1024))/1024/1024+"MB",
                          ""+canUseSize/1024/1024/1024+"GB"+(canUseSize%(1024*1024*1024))/1024/1024+"MB",
                          use

                       };

                    return viDatas;
                }

                public Class getTableObjectClass()
                {
                    return MibDiskAndMemoEntry.class;
                }
            };

            SNMPTarget target = getTarget();
            SNMPTableDialog dialog = new SNMPTableDialog(getFrame(),desc, false, false, false, true);
            dialog.setSize(600, 300);
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
            SNMPGetDiskMemo action = new SNMPGetDiskMemo();
            action.actionPerformed(null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
