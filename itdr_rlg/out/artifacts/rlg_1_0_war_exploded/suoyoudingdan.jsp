<%--
  Created by IntelliJ IDEA.
  User: kimch
  Date: 2019/8/7
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>所有订单</title>
    <link rel="stylesheet" href="css/guanlijiemian.css">
    <link rel="stylesheet" href="css/yhlb.css">
</head>
<body>
<div id="shangbiao">
    <div id="tb">
        <img src="picture/tubiao.jpg" alt="" style="width: 100%;height: 100%">
    </div>
    <div id="mz">
        <p>睿乐购</p>
    </div>
</div>


<div id="cm_1">
    <div id="mk_2">
        <div id="yhtb">
            <img src="picture/yonghu.png" alt="" style="width: 100%;height: 100%">
        </div>
        <p>用&nbsp;&nbsp;户&nbsp;&nbsp;列&nbsp;&nbsp;表</p>

    </div>
    <div id="mk_2_1">
        <a href="huoquyonghuliebiao.jsp" style="text-decoration:none;  color: black">查&nbsp;看&nbsp;所&nbsp;有&nbsp;用&nbsp;户</a>
    </div>
    <div id="mk_2_2">
        <a href="fjyh.jsp" style="text-decoration:none;  color: black">封&nbsp;禁&nbsp;用&nbsp;户</a>
    </div>


    <div id="mk_3">
        <div id="sptb">
            <img src="picture/shangpin.png" alt="" style="width: 100%;height: 100%">
        </div>
        <p>商&nbsp;&nbsp;品&nbsp;&nbsp;列&nbsp;&nbsp;表</p>
    </div>

    <div id="mk_3_1">
        <a href="shangpinliebiao.jsp" style="text-decoration:none;  color: black">查&nbsp;看&nbsp;所&nbsp;有&nbsp;商&nbsp;品</a>
    </div>
    <div id="mk_3_2">
        <a href="sousuosp.jsp" style="text-decoration:none;  color: black">搜&nbsp;索&nbsp;商&nbsp;品</a>
    </div>
    <div id="mk_3_3">
        <a href="spsj.jsp" style="text-decoration:none;  color: black">商&nbsp;品&nbsp;上&nbsp;架</a>
    </div>
    <div id="mk_3_4">
        <a href="spxj.jsp" style="text-decoration:none;  color: black">商&nbsp;品&nbsp;下&nbsp;架</a>
    </div>
    <div id="mk_3_5">
        <a href="zjsp.jsp" style="text-decoration:none;  color: black">增&nbsp;加&nbsp;商&nbsp;品</a>
    </div>
    <div id="mk_3_6">
        <a href="" style="text-decoration:none;  color: black">更&nbsp;新&nbsp;商&nbsp;品</a>
    </div>

    <div id="mk_4">
        <div id="ddtb">
            <img src="picture/dingdan.png" alt="" style="width: 100%;height: 100%">
        </div>
        <p>订&nbsp;&nbsp;单&nbsp;&nbsp;列&nbsp;&nbsp;表</p>
    </div>
    <div id="mk_4_1">
        <a href="suoyoudingdan.jsp" style="text-decoration:none;  color: black">查&nbsp;看&nbsp;所&nbsp;有&nbsp;订&nbsp;单</a>
    </div>
    <div id="mk_4_2">
        <a href="ddhchaxun.jsp" style="text-decoration:none;  color: black">订&nbsp;单&nbsp;号&nbsp;查&nbsp;询</a>
    </div>
    <div id="mk_4_3">
        <a href="" style="text-decoration:none;  color: black">订&nbsp;单&nbsp;详&nbsp;情</a>
    </div>
    <div id="mk_4_4">
        <a href="ddfh.jsp" style="text-decoration:none;  color: black">订&nbsp;单&nbsp;发&nbsp;货</a>
    </div>

    <div id="mk_5">
        <div id="fltb">
            <img src="picture/fenlei.png" alt="" style="width: 100%;height: 100%">
        </div>
        <p>分&nbsp;&nbsp;类&nbsp;&nbsp;类&nbsp;&nbsp;表</p>
    </div>
    <div id="mk_5_1">
        <a href="syjd.jsp" style="text-decoration:none;  color: black">获&nbsp;取&nbsp;分&nbsp;类&nbsp;id&nbsp;及&nbsp;子&nbsp;节&nbsp;点</a>
    </div>
    <div id="mk_5_2">
        <a href="ssjd.jsp" style="text-decoration:none;  color: black">获&nbsp;取&nbsp;品&nbsp;类&nbsp;子&nbsp;节&nbsp;点</a>
    </div>
    <div id="mk_5_3">
        <a href="zjjd.jsp" style="text-decoration:none;  color: black">增&nbsp;加&nbsp;节&nbsp;点</a>
    </div>
    <div id="mk_5_4">
        <a href="xglm.jsp" style="text-decoration:none;  color: black">修&nbsp;改&nbsp;类&nbsp;名</a>
    </div>

</div>
<div id="top_1">
    <div id="top_1_1">
        <img src="picture/rizhi.png" alt="" style="width: 100%;height: 100%">
    </div>
    <div id="top_1_2">
        <p>日志</p>
    </div>

    <div id="top_1_3">
        <img src="picture/geren.png" alt="" style="width: 100%;height: 100%">
    </div>
    <div id="top_1_4">
        <p>个人中心</p>
    </div>
    <div id="top_1_5">
        <img src="picture/shezhi.png" alt="" style="width: 100%;height: 100%">
    </div>
    <div id="top_1_6">
        <p>系统设置</p>
    </div>
    <div id="top_1_7">
        <img src="picture/exit.png" alt="" style="width: 100%;height: 100%">
    </div>
    <div id="top_1_8">
        <p>退出系统</p>
    </div>
</div>


<div id="zs">
    <table id="tab" cellspacing="0">
        <tr>
            <th>订单id</th>
            <th>支付金额</th>
            <th>支付状态(0代表未发货)</th>
            <th>支付方式</th>
            <th>订单状态(0代表未发货)</th>
        </tr>
    </table>
</div>


<%--出来的盒子--%>

<ul id="rz_1" hidden>
    <li>编写日志</li>
    <li>查看日志</li>
    <li>删除日志</li>
</ul>

<ul id="gr_1" hidden>
    <li>更换ID</li>
    <li>修改信息</li>
    <li>个人设置</li>
</ul>

<ul id="sz_1" hidden>
    <li>更换背景</li>
    <li>字体大小</li>
    <li>更换字体</li>
    <li>删除浏览信息</li>
</ul>
</body>
<script src="jq/jquery-3.3.1.js">
</script>
<script>

    $("#top_1_1").click(function () {
        $("#rz_1").slideToggle();
    })
    $("#top_1_3").click(function () {
        $("#gr_1").slideToggle();
    })
    $("#top_1_5").click(function () {
        $("#sz_1").slideToggle();
    })
    $("#top_1_8").click(function () {
        window.open("rlg_ym/dljm.jsp")
        window.opener=null;
        window.open('','_self');
        window.close();
    })

    $(function () {
        //发请求拿商品数据
        $.get(
            "/manage/order/List.do",
            function (dt) {
                if (dt.status != 300) {
                    alert(dt.mag);
                    alert(dt.status);
                } else {
                    for (var i = 0; i < dt.data.length; i++) {
                        var s = "<tr><td>" + dt.data[i].spid + "</td><td>" + dt.data[i].zfje + "</td><td>"+dt.data[i].zfzt+"</td><td>"+dt.data[i].zffs+"</td><td>"+dt.data[i].ddzt+"</td></tr>";
                        $("#tab").append(s)
                    }
                }
            },
            "json"
        )
    })
</script>

</html>
