package com.itdr.controller;

import com.itdr.common.ResponseCode;
import com.itdr.pojo.Users;
import com.itdr.service.UserService;
import com.itdr.utils.JsonUtils;
import com.itdr.utils.PathUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.ResponseCache;
import java.util.List;

import static com.itdr.common.Const.*;

@WebServlet("/manage/user/*")
public class UsersController extends javax.servlet.http.HttpServlet {

    private UserService uc = new UserService();

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        //处理乱码
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //怎么获取请求路径信息
        String pathInfo = request.getPathInfo();
        String path = PathUtils.getPath(pathInfo);

        ResponseCode rs = null;
        //判断请求
        switch (path) {
            case "list":
                rs = listDo(request);
                break;
            case "login":
               rs = loginDo(request,response);
                break;
            case "disableusers":
                rs = disableusersDo(request);
                break;
        }

        //返回响应数据
        response.setContentType("text/json;charset=utf-8");
        response.getWriter().write(JsonUtils.obj2String(rs));

//        if (rs!=null){
//            response.getWriter().write(rs.toString());
//        }
    }


    //获取所有用户列表的请求
    private ResponseCode listDo(HttpServletRequest request) {
        ResponseCode rs = new ResponseCode();

        HttpSession session = request.getSession();
        Users user = (Users) session.getAttribute("users");
        if (user == null) {
            rs.setStatus(3);
            rs.setMag("请登录后操作！");
            return rs;
        }

        //获取参数
        String pageSize = request.getParameter("pageSize");
        String pageNum = request.getParameter("pageNum");
        rs = uc.selectAll(pageSize, pageNum);
        //调用业务层处理业务
        return rs;
    }


    //用户登录的请求
    private ResponseCode loginDo(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        //获取参数
        String username = request.getParameter("username");
        String password = request.getParameter("password");

        ResponseCode rs = uc.selectOne(username, password);
        //获取seesion对象

        HttpSession session = request.getSession();
        session.setAttribute("users", rs.getData());
//        if (rs.getStatus()==USER_PARAMETER_CODE||rs.getStatus()==USER_WRONG_CODE||rs.getStatus()==USER_CANT_CODE){
//            response.sendRedirect("/rlg_ym/dljm.jsp");
//        }else {
//            request.getRequestDispatcher("/WEB-INF/guanlijiemian.jsp").forward(request,response);
//        }

//        //调用业务层处理业务
        return rs;
    }

    //禁用用户的请求
    private ResponseCode disableusersDo(HttpServletRequest request) {
        //获取参数
        String uid = request.getParameter("uid");
        ResponseCode rs = uc.selectOne(uid);
        return rs;
    }
}
