问题1：如何设定默认的绘图位置？
    准备更改画图函数的参数为（startX，startY，points）
问题2：如何增加画图精度？
    采用了新算法
        1：通过增加描点的数量
        2：对xPoint，yPoint采用double类型
问题3：Panel和Box有什么区别
    这是在帮其他同学改代码时候发现的问题
    发现有用Box替代Panel的做法
    查找资料后发现这两个都是组件容器

CheckBox的使用:
    构造方法：
        private final JCheckBox SinCheckBox = new JCheckBox("Sin(x)", false);
    监听样例：
        SinCheckBox.addItemListener(e ->
                {
                    String gName = "Sin";
                    /*判断CheckBox的选中状态*/
                    if (((JCheckBox) e.getItem()).isSelected())
                    {
                        drawLineComponent.addGraph(gName, new GetSinPoints());
                    } else
                    {
                        drawLineComponent.subGraph(gName);
                    }
                });
问题4：右击拖动无法监听

