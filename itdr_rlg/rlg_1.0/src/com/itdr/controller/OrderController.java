package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.OrderService;
import com.itdr.service.ProductService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static com.itdr.common.Const.*;

@WebServlet("/manage/order/*")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //怎么获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUtils.getPath(pathInfo);

        ResponseCode rs = null;
        //判断
        switch (path) {
            //订单List
            case "List":
                rs = listDo(request);
                break;
            //按订单号查询
            case "search":
                rs = search(request);
                break;
            //订单详情
            case "detail":
                rs = detail(request);
                break;
            //订单发货
            case "sendgoods":
                rs = sendgoods(request);
                break;
        }
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));
    }

    private OrderService ps = new OrderService();

    //订单发货
    private ResponseCode sendgoods(HttpServletRequest request) {
        //获取参数
        String id = request.getParameter("spid");
        if (id == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(ORDER_NONE_CODE);
            qs.setMag(ORDER_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.fahuo(id);
        return rs;
    }


    //订单详情
    private ResponseCode detail(HttpServletRequest request) {
        //获取参数
        String id = request.getParameter("spid");
        if (id == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(ORDER_NONE_CODE);
            qs.setMag(ORDER_NONE_MSG);
            return qs;
        }
        //调用业务层
        ResponseCode rs = ps.detail(id);
        return rs;
    }


    //订单搜索
    private ResponseCode search(HttpServletRequest request) {
        String id = request.getParameter("spid");
        if (id == null) {
            ResponseCode qs = new ResponseCode();
            qs.setStatus(ORDER_NONE_CODE);
            qs.setMag(ORDER_NONE_MSG);
            return qs;
        }
        ResponseCode rs = ps.SearchOrder(id);
        return rs;
    }


    //订单列表
    //   有网的时候要好好看一下字段8/6
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rs = ps.getAll();
        return rs;
    }

}
