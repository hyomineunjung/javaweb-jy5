package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

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
        //判断请求
//        switch (path) {
//            case "list":
//                rs = listDo(request);
//                break;
//            case "search":
//                rs = searchDo(request);
//                break;
//            case "detail":
//                rs = detailDo(request);
//                break;
//            case "send_goods":
//                rs = sendgoodsDo(request);
//                break;
//        }

        //返回响应数据
        response.getWriter().write(rs.toString());
    }

    //获取订单List
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rs = new ResponseCode();

        HttpSession session = request.getSession();
        Users user =(Users) session.getAttribute("users");
        if (user==null){
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return rs;
        }

        //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
//        rs=uc.selectAll(pageSize,pageNum);
        //调用业务层处理业务
        return rs;
    }


}
