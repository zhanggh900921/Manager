package com.zhtelecom.common.topograph.example;

import java.awt.*;
import javax.swing.*;

import com.zhtelecom.common.topograph.*;

//演示拓扑图的主要功能。可同时在Applet和应用程序中运行。

//network的展开和隐藏；没有限制的级别，network下可再挂network,node或link
//树的图形显示
//图形改变后，拓扑图自动更新
//颜色自动向上改变
//放大、缩小 转到上层
//Link 路由模式和直连模式
//添加、删除告警，自动触发颜色变化
//鼠标、菜单处理
//树选择与拓扑图选择同步
//添加、删除 节点、网络、连接
//<p>Copyright: www.zhtelecom.com Copyright (c) 2007</p>
public class NMSExample extends JApplet
{
    static int i = 1;

    public static int getNum()
    {
        return i++;
    }

    /**
     * WEB Applet小程序初始化接口。也是Application应用程序的初始化接口。
     * 构建拓扑图框架。
     */
    public void init()
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            //创建数据源
            TopoDataSource source = new TopoDataSource();

            //通过数据源创建拓扑视图。
            TopoGraphView topoView = new TopoGraphView(source);
            topoView.getStatusLabel().setText("状态栏");
            //初始化图形界面。Swing技术。
            JScrollPane sGraph = new JScrollPane(topoView);

            //设置拓扑图视图的事件处理程序。
            TopoMouseAction menuHandle = new TopoMouseAction();
            topoView.setMouseHandle(menuHandle);

            //根据数据源创建树
            TopoTreeView tree = new TopoTreeView(source);
            //将树的用户选择对象、拓扑图的用户选择对象，同步起来。
            tree.syncTopoview(topoView);

            JScrollPane sTree = new JScrollPane(tree);
            JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, sTree,
                                             sGraph);
            pane.setDividerLocation(200);

            this.getContentPane().setLayout(new BorderLayout());
            this.getContentPane().add(pane, BorderLayout.CENTER);
            //this.setVisible(true);

            //最后一步，单独加载拓扑数据。(也可以选择先加载拓扑数据，再构造拓扑视图)
            processData(topoView);

        } catch (Exception ex)
        {
            ex.printStackTrace();
        }

    }

    /**
     * 单独集中处理拓扑数据。
     * 将拓扑图的数据处理与界面显示分开处理。
     *
     */
    private void processData(TopoGraphView topoView)
    {
        //获取数据源
        TopoDataSource source = topoView.getTopoDataSource();

        //定义多业务汇聚网络
        TopoNetwork serviceNet = new TopoNetwork(new StringBuffer("多业务汇聚网")); // 使用StringBuffer,便于后面可修改
        serviceNet.setXY(163, 131);

        //定义多业务汇聚网内设备
        TopoNode nodePC = new TopoNode(new StringBuffer("PC"));
        nodePC.setXY(15, 273); // 设置x/y坐标
        TopoNode nodeTV = new TopoNode(new StringBuffer("TV机顶盒"));
        nodeTV.setXY(15, 166);
        nodeTV.setImageIconFromTopoFile("backRecovery.png"); //设置图片类型
        TopoNode nodePhone = new TopoNode(new StringBuffer("IP电话"));
        nodePhone.setXY(15, 57);
        nodePhone.setImageIconFromTopoFile("digiphone.png");
        TopoNode nodeGW = new TopoNode(new StringBuffer("家庭网关"));
        nodeGW.setXY(151, 156);
        nodeGW.setImageIconFromTopoFile("dm.png");
        TopoNode nodeAcess = new TopoNode(new StringBuffer("接入设备"));
        nodeAcess.setXY(281, 160);
        TopoNode serverManager = new TopoNode(new StringBuffer("业务服务器"));
        serverManager.setXY(301, 459);
        serverManager.setImageIconFromTopoFile("server_db.png");

        nodeAcess.setImageIconFromTopoFile("cartridge_system.png");
        TopoNode serverDB = new TopoNode(new StringBuffer("数据库"));
        serverDB.setXY(431, 452);
        serverDB.setImageIconFromTopoFile("single_database.png");
        TopoNode serverWeb = new TopoNode(new StringBuffer("网站服务器"));
        serverWeb.setXY(538, 459);
        serverWeb.setImageIconFromTopoFile("server.png");

        TopoNode routerAccess = new TopoNode(new StringBuffer("接入路由器"));
        routerAccess.setImageIconFromTopoFile("tw130.png");
        routerAccess.setXY(415, 150);
        TopoNode routerData = new TopoNode(new StringBuffer("数据路由器"));
        routerData.setXY(584, 48);
        routerData.setImageIconFromTopoFile("tw130.png");
        TopoNode routerPhone = new TopoNode(new StringBuffer("语音路由器"));
        routerPhone.setXY(702, 150);
        routerPhone.setImageIconFromTopoFile("tw130.png");
        TopoNode routerTV = new TopoNode(new StringBuffer("视频路由器"));
        routerTV.setXY(584, 235);
        routerTV.setImageIconFromTopoFile("tw130.png");

        //定义多业务汇聚网内连接
        TopoLink linkPCGW = new TopoLink(new StringBuffer("100M"), nodePC, nodeGW); //通过连接起点、终点，创建Link
        linkPCGW.setStraight(false); //设置转折线
        linkPCGW.setBrokenLink(true); //设置虚线
        linkPCGW.setLinkWidth(1); //设置宽度
        TopoLink linkTVGW = new TopoLink(new StringBuffer("Cable"), nodeTV, nodeGW);
        linkTVGW.setStraight(false);
        linkTVGW.setBrokenLink(true);
        linkTVGW.setLinkWidth(1);
        TopoLink linkPhoneGW = new TopoLink(new StringBuffer("RJ45"), nodePhone, nodeGW);
        linkPhoneGW.setStraight(false);
        linkPhoneGW.setBrokenLink(true);
        linkPhoneGW.setLinkWidth(1);
        TopoLink linkGWAcess = new TopoLink(new StringBuffer("FE"), nodeGW, nodeAcess);
        TopoLink linkAcessRouterAC = new TopoLink(new StringBuffer("GE"), nodeAcess, routerAccess);

        TopoLink linkAcessManager = new TopoLink(new StringBuffer("L1"), routerAccess, serverManager);
        linkAcessManager.setStraight(false);
        TopoLink linkAcessDB = new TopoLink(new StringBuffer("L2"), routerAccess, serverDB);
        linkAcessDB.setStraight(false);
        TopoLink linkAcessWeb = new TopoLink(new StringBuffer("L3"), routerAccess, serverWeb);
        linkAcessWeb.setStraight(false);

        TopoLink linkRouterACData = new TopoLink(new StringBuffer("G1"), routerAccess, routerData);
        linkRouterACData.setShowArrow(false);
        linkRouterACData.setLinkWidth(5);
        TopoLink linkRouterACTV = new TopoLink(new StringBuffer("G2"), routerAccess, routerTV);
        linkRouterACTV.setShowArrow(false);
        linkRouterACTV.setLinkWidth(5);
        TopoLink linkRouterACPhone = new TopoLink(new StringBuffer("G3"), routerAccess, routerPhone);
        linkRouterACPhone.setShowArrow(false);
        linkRouterACPhone.setLinkWidth(5);
        TopoLink linkRouterTVData = new TopoLink(new StringBuffer("备份1"), routerTV, routerData);
        linkRouterTVData.setShowArrow(false);
        linkRouterTVData.setBrokenLink(true);
        TopoLink linkRouterTVPhone = new TopoLink(new StringBuffer("备份2"), routerTV, routerPhone);
        linkRouterTVPhone.setShowArrow(false);
        linkRouterTVPhone.setBrokenLink(true);
        TopoLink linkRouterPhoneData = new TopoLink(new StringBuffer("备份3"), routerPhone, routerData);
        linkRouterPhoneData.setShowArrow(false);
        linkRouterPhoneData.setBrokenLink(true);

        //添加告警
        nodePC.addAlarm("alarm1", TopoSysConfig.AlarmSeverity_Critical); //紧急
        nodeTV.addAlarm("alarm2", TopoSysConfig.AlarmSeverity_Major); //主要
        nodePhone.addAlarm("alarm3", TopoSysConfig.AlarmSeverity_Minor); //次要;
        nodeGW.addAlarm("alarm4", TopoSysConfig.AlarmSeverity_Warning); //警告;
        linkGWAcess.addAlarm("alarm5", TopoSysConfig.AlarmSeverity_Indeterminate); //未知
        nodeAcess.addAlarm("alarm6", TopoSysConfig.AlarmSeverity_Indeterminate); //未知

        ////将多业务汇聚网络的数据放入到数据源容器中......................

        source.addTopoData(serviceNet); //serviceNet在根视图下
        source.addTopoData(nodePC, serviceNet); //nodePC在serviceNet下
        source.addTopoData(nodeTV, serviceNet);
        source.addTopoData(nodePhone, serviceNet);
        source.addTopoData(nodeGW, serviceNet);
        source.addTopoData(nodeAcess, serviceNet);
        source.addTopoData(routerAccess, serviceNet);

        source.addTopoData(serverManager, serviceNet);
        source.addTopoData(serverWeb, serviceNet);
        source.addTopoData(serverDB, serviceNet);

        source.addTopoData(routerTV, serviceNet);
        source.addTopoData(routerData, serviceNet);
        source.addTopoData(routerPhone, serviceNet);

        source.addTopoData(linkPCGW, serviceNet);
        source.addTopoData(linkTVGW, serviceNet);
        source.addTopoData(linkPhoneGW, serviceNet);
        source.addTopoData(linkGWAcess, serviceNet);
        source.addTopoData(linkAcessRouterAC, serviceNet);

        source.addTopoData(linkAcessDB, serviceNet);
        source.addTopoData(linkAcessManager, serviceNet);
        source.addTopoData(linkAcessWeb, serviceNet);

        source.addTopoData(linkRouterACData, serviceNet);
        source.addTopoData(linkRouterACTV, serviceNet);
        source.addTopoData(linkRouterACPhone, serviceNet);
        source.addTopoData(linkRouterTVData, serviceNet);
        source.addTopoData(linkRouterTVPhone, serviceNet);
        source.addTopoData(linkRouterPhoneData, serviceNet);

//................................................//
        //定义多子网网络和下属设备、连接
        TopoNetwork mutiNet = new TopoNetwork(new StringBuffer("多子网网络"));
        mutiNet.setXY(392, 242);
        TopoNetwork internet = new TopoNetwork(new StringBuffer("Internet"));
        internet.setXY(331, 303);
        TopoNetwork pstn = new TopoNetwork(new StringBuffer("电话网络"));
        pstn.setXY(330, 105);
        TopoNetwork vide = new TopoNetwork(new StringBuffer("视频网络"));
        vide.setXY(140, 192);
        TopoNode nodesw = new TopoNode(new StringBuffer("交换机"));
        nodesw.setXY(158, 393);
        TopoNode nodeVod1 = new TopoNode(new StringBuffer("视频服务器1"));
        nodeVod1.setXY(100, 100);
        TopoNode nodeVod2 = new TopoNode(new StringBuffer("视频服务器2"));
        nodeVod2.setXY(300, 100);
        TopoLink link1 = new TopoLink(new StringBuffer("Link1"), internet, pstn);
        TopoLink link2 = new TopoLink(new StringBuffer("Link2"), pstn, vide);
        TopoLink link3 = new TopoLink(new StringBuffer("Link3"), vide, internet);
        TopoLink link = new TopoLink(new StringBuffer("video"), nodeVod1, nodeVod2);

        //添加告警
        pstn.addAlarm("a1", TopoSysConfig.AlarmSeverity_Major);
        nodeVod1.addAlarm("a2", TopoSysConfig.AlarmSeverity_Critical);
        nodesw.addAlarm("a3", TopoSysConfig.AlarmSeverity_Warning);

        //将多子网网络内数据加入到数据源
        source.addTopoData(mutiNet);
        source.addTopoData(internet, mutiNet);
        source.addTopoData(pstn, mutiNet);
        source.addTopoData(vide, mutiNet);
        source.addTopoData(nodesw, mutiNet);
        source.addTopoData(link1, mutiNet);
        source.addTopoData(link2, mutiNet);
        source.addTopoData(link3, mutiNet);
        source.addTopoData(nodeVod1, vide);
        source.addTopoData(nodeVod2, vide);
        source.addTopoData(link, vide);

    }

    //Appliction程序入口，兼容Applet模式。
    public static void main(String[] args)
    {
        //初始化数据和图形
        NMSExample helloApplet = new NMSExample();
        helloApplet.init();

        //创建Application 窗口
        JFrame frame = new JFrame("网络拓扑图演示 ");
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(helloApplet.getContentPane());
        frame.setVisible(true);

    }

}
