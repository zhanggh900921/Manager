package com.zhtelecom.common.snmp.test;

import com.zhtelecom.common.snmp.*;

public class RMISNMPServer
{
    public RMISNMPServer()
    {
    }

    /**
     * 启用ObjectSNMP的RMI远程服务。
     * @param args String[]
     */
    public static void main(String args[])
    {
        try
        {
            SNMPFactory.init(SNMPFactory.Mode_Server_Local, null);
        } catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
