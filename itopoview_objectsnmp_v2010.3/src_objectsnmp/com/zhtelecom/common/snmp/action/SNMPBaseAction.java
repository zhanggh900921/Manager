package com.zhtelecom.common.snmp.action;

import javax.swing.*;
import com.zhtelecom.common.snmp.*;
import java.awt.Frame;


public abstract class SNMPBaseAction extends AbstractAction
{
    private static Frame mainFrame;
    private static final String Target_ID="SNMP_Target_ID";
    public SNMPBaseAction(String actionname)
    {
        super(actionname);
    }

    public SNMPTarget getTarget()
    {
        SNMPTarget target = (SNMPTarget)getValue(Target_ID);
        return target;
    }

    public void  setTarget(SNMPTarget target)
   {
       this.putValue(Target_ID,target);
   }


    public String getTitle()
    {
        return getValue(this.NAME).toString();
    }

    public String getErroTitle()
    {
        return getValue(this.NAME).toString() + "³ö´í";
    }

    public Frame getFrame()
    {
        return mainFrame;
    }

    public static void setFrame(Frame frame)
    {
        mainFrame=frame;
    }

}
