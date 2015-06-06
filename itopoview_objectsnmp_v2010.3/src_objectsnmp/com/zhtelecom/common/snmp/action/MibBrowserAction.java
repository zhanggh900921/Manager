package com.zhtelecom.common.snmp.action;

import java.awt.event.*;

import com.zhtelecom.common.snmp.*;

public class MibBrowserAction extends SNMPBaseAction
{

    public void actionPerformed(ActionEvent e)
    {
        SnmpMibBrowser.showMibBrowser(getTarget(), null);
    }

    public MibBrowserAction()
    {
        super("SNMP MIBÊý¾Ýä¯ÀÀÆ÷");
    }
}
