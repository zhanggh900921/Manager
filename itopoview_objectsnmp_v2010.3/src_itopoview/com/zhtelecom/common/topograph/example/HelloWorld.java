package com.zhtelecom.common.topograph.example;

import javax.swing.*;

import com.zhtelecom.common.topograph.*;

/**
 *
 * <p>Title: </p>
 * <p>Description: </p>
 * <p>Copyright: www.zhtelecom.com Copyright (c) 2007</p>
 * <p>Company: </p>
 * @author not attributable
 * @version 1.0
 */
public class HelloWorld
{
    public static void main(String[] args)
    {
        //......步骤1，创建显示组件......
        TopoGraphView topoView = new TopoGraphView(new TopoDataSource()); //通过数据源创建拓扑视图
        TopoTreeView tree = new TopoTreeView(topoView.getTopoDataSource()); //根据数据源创建树
        tree.syncTopoview(topoView); //将树与拓扑图的选择事件同步起来

        //......步骤2，设置菜单、鼠标 事件处理程序......
        HelloMouseAction menuHandle = new HelloMouseAction(); //定义事件处理程序
        topoView.setMouseHandle(menuHandle); //给拓扑视图设置处理程序

        //......步骤3，普通java swing操作，把拓扑视图、树形视图添加到界面上......
        JFrame frame = new JFrame("网络拓扑图HelloWorld");
        JScrollPane graphPane = new JScrollPane(topoView);
        JScrollPane treePane = new JScrollPane(tree);
        JSplitPane pane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, treePane, graphPane);
        pane.setDividerLocation(200);
        frame.setContentPane(pane);
        frame.setSize(600, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

        //......步骤4，定义数据元素......

        TopoNetwork net = new TopoNetwork("网络"); //定义网络
        TopoNode nodePC = new TopoNode("PC"); //定义PC设备
        TopoNode nodeGW = new TopoNode("网关"); //定义家庭网关设备
        nodeGW.setXY(300, 98); // 设置x y坐标
        nodeGW.setImageIconFromTopoFile("dm.png"); //设置图片
        TopoLink linkPCGW = new TopoLink("100M", nodePC, nodeGW); //通过起点终点，创建链接
        nodePC.addAlarm("alarm1", TopoSysConfig.AlarmSeverity_Critical); //添加紧急告警
        linkPCGW.addAlarm("alarm2", TopoSysConfig.AlarmSeverity_Major); //添加主要告警

        //......步骤5，将数据添加到数据源......
        TopoDataSource source = topoView.getTopoDataSource(); //获取数据源
        source.addTopoData(net); //把网络1加入到根视图下
        source.addTopoData(nodePC, net); //把PC加入到网络1中
        source.addTopoData(nodeGW, net); //把网关加入到网络1中
        source.addTopoData(linkPCGW, net); //把连接加入到网络1中

    }
}

//实现事件处理接口
class HelloMouseAction implements TopoMouseHandle
{
    //在拓扑图对象上面点击右键的菜单
    public JPopupMenu createRightClickMenu(TopoGraphView topoView)
    {
        JPopupMenu menu = new JPopupMenu();
        menu.add("右键对象:" + topoView.getSelectedObject());
        return menu;
    }

    //在拓扑图空白区域点击右键的菜单
    public JPopupMenu createRightClickBlankMenu(TopoGraphView topoView)
    {
        JPopupMenu menu = new JPopupMenu();
        menu.add("右键空白区域，当前网络：" + topoView.getCurrentNetwork());
        return menu;
    }

    //双击事件
    public void doubleClickAction(TopoGraphView topoView)
    {
        JOptionPane.showMessageDialog(topoView, "对象：" + topoView.getSelectedObject(), "双击操作",
                                      JOptionPane.INFORMATION_MESSAGE);
    }
}
