package com.itdr.service;

import com.itdr.common.ResponseCode;
import com.itdr.dao.ProductDao;
import com.itdr.pojo.Product;

import java.util.List;

import static com.itdr.common.Const.*;

public class ProductService {
    private ProductDao pd = new ProductDao();
    //状态码和信息还没改 记得抄
    //状态码和信息还没改 记得抄
    //状态码和信息还没改 记得抄

    //商品列表
    public ResponseCode getAll() {
        ResponseCode rs = null;
        List<Product> li = pd.selectAll();
        if (li == null) {
            rs = ResponseCode.defeatedRS(PRODUCT_DISPEAR_CODE, PRODUCT_DISPEAR_MSG);
        }
        rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE, li);
        return rs;
    }

    //搜索商品(用商品名搜索)
    public ResponseCode SearchProduct(String pname) {
        ResponseCode rs = new ResponseCode();
        Product a = null;
        a = pd.SearchProduct(pname);
        if (a == null) {
            rs = ResponseCode.defeatedRS(PRODUCT_NO_CODE, PRODUCT_NO_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE, a.getPname());
        return rs;
    }

    //用商品id搜索
    public ResponseCode SearchProduct(Integer id) {
        ResponseCode rs = new ResponseCode();
        Product a = null;
        a = pd.SearchProduct(id);
        if (a == null) {
            rs = ResponseCode.defeatedRS(PRODUCT_NO_CODE, PRODUCT_NO_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE, a.getPname());
        return rs;
    }

    //商品详情
    public ResponseCode detail(Integer id) {
        ResponseCode rs = new ResponseCode();
        Product a = pd.detail(id);
        if (a == null) {
            rs = ResponseCode.defeatedRS(PRODUCT_NO_CODE, PRODUCT_NO_MSG);
            return rs;
        }
        rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE,a);
        return rs;
    }

    //上下架
    //1为上架 0为下架
    public ResponseCode shangjia(Integer id) {
        ResponseCode rs = new ResponseCode();
        Product b = pd.hedui(id);
        if (b==null){
            rs=ResponseCode.defeatedRS(PRODUCT_NO_CODE,PRODUCT_NO_MSG);
            return rs;
        }
        if (b.getStatus()==1){
            rs=ResponseCode.defeatedRS(PRODUCT_ALREADYUP_CODE,PRODUCT_ALREADYUP_MSG);
            return rs;
        }
        int a=pd.shangjia(id);
        rs=ResponseCode.successRS(PRODUCT_SUCCESS_CODE,a);
        return rs;
    }

    //新增商品
    public ResponseCode add(Integer id, String pname, Integer status, Integer categoryId, String price, String cuxiao) {
        ResponseCode rs = new ResponseCode();
        Product b = pd.hedui(id, pname);
        if (b == null) {
            int a = pd.add(id, pname, status, categoryId, price, cuxiao);
            rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE, a);
            return rs;
        } else {
            rs = ResponseCode.defeatedRS(PRODUCT_ADD_CODE, PRODUCT_ADD_MSG);
            return rs;
        }
    }

    //更新商品
    public ResponseCode gengxin(Integer id, String pname, Integer status, Integer categoryId, String price, String cuxiao) {
        ResponseCode rs = new ResponseCode();
        Product b = pd.hedui(id);
        if (b == null) {
            rs = ResponseCode.defeatedRS(PRODUCT_UPDATE_CODE, PRODUCT_UPDATE_MSG);
            return rs;
        }
        int a = pd.gengxin(id, pname, status, categoryId, price, cuxiao);
        rs = ResponseCode.successRS(PRODUCT_SUCCESS_CODE, a);
        return rs;
    }

    //1为上架 0为下架
    public ResponseCode xiajia(Integer id) {
        ResponseCode rs = new ResponseCode();
        Product b = pd.hedui(id);
        if (b==null){
            rs=ResponseCode.defeatedRS(PRODUCT_NO_CODE,PRODUCT_NO_MSG);
            return rs;
        }
        if (b.getStatus()==0){
            rs=ResponseCode.defeatedRS(PRODUCT_ALREADYDOWN_CODE,PRODUCT_ALREADYDOWN_MSG);
            return rs;
        }
        int a=pd.xiajia(id);
        rs=ResponseCode.successRS(PRODUCT_SUCCESS_CODE,a);
        return rs;
    }
}
