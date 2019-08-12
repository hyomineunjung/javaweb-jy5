package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.OrderDao;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Order;
import com.itdr.pojo.Product;

import java.util.List;

import static com.itdr.common.Const.*;


public class OrderService {
    private OrderDao pd = new OrderDao();


    //订单List
    public ResponseCode getAll() {
        ResponseCode rs = null;
        List<Order> li = pd.selectAll();
        if (li == null) {
            rs = ResponseCode.defeatedRS(ORDER_DISPEAR_CODE, ORDER_DISPEAR_MSG);
        }
        rs = ResponseCode.successRS(ORDER_SUCCESS_CODE, li);
        return rs;
    }

    //订单查询
    public ResponseCode SearchOrder(String id) {
        ResponseCode rs = new ResponseCode();
        Order a = null;
        a = pd.SearchProduct(id);
        if (a == null) {
            rs = ResponseCode.defeatedRS(ORDER_NO_CODE, ORDER_NO_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(ORDER_SUCCESS_CODE, a.getZfje());
        return rs;
    }

    //订单详情
    public ResponseCode detail(String id) {
        ResponseCode rs = new ResponseCode();
        Order a = pd.detail(id);
        if (a == null) {
            rs = ResponseCode.defeatedRS(ORDER_NO_CODE, ORDER_NO_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(ORDER_SUCCESS_CODE, a);
        return rs;
    }

    //订单发货
    public ResponseCode fahuo(String id) {
        ResponseCode rs = new ResponseCode();
        Order b = pd.hedui(id);
        //0代表未发货，1代表已发货
        if (b == null) {
            rs = ResponseCode.defeatedRS(ORDER_NO_CODE, ORDER_NO_MSG);
            return rs;
        }
        if (b.getDdzt().equals("1")) {
            rs = ResponseCode.defeatedRS(ORDER_THROW_CODE, ORDER_THROW_MSG);
            return rs;
        }

        int a = pd.fahuo(id);
        rs = ResponseCode.successRS(ORDER_SUCCESS_CODE, a);
        return rs;
    }
}
