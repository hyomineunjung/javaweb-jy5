package com.itdr.common;

public class Const {
    //用户相关状态
    public static final Integer USER_SUCCESS_CODE = 100;
    public static final Integer USER_PARAMETER_CODE = 101;
    public static final String USER_PARAMETER_MSG = "参数为空";

    public static final Integer USER_DISPEAR_CODE = 102;
    public static final String USER_DISPEAR_MSG = "用户列表不存在";

    public static final Integer USER_NO_CODE = 103;
    public static final String USER_NO_MSG = "用户不存在";

    public static final Integer USER_DISABLE_CODE = 104;
    public static final String USER_DISABLE_MSG = "用户已经被禁用";

    public static final Integer USER_WRONG_CODE = 105;
    public static final String USER_WRONG_MSG = "账户或密码错误";

    public static final Integer USER_CANT_CODE = 106;
    public static final String USER_CANT_MSG = "没有操作权限";

    public static final Integer USER_UN_CODE = 107;
    public static final String USER_UN_MSG = "输入非法字符";

    public static final Integer USER_BAN_CODE = 108;
    public static final String USER_BAN_MSG = "用户禁用失败";

    //商品相关状态
    public static final Integer PRODUCT_SUCCESS_CODE = 200;
    public static final Integer PRODUCT_DISPEAR_CODE = 201;
    public static final String PRODUCT_DISPEAR_MSG = "商品列表不存在";

    public static final Integer PRODUCT_NO_CODE = 202;
    public static final String PRODUCT_NO_MSG = "商品不存在";

    public static final Integer PRODUCT_ALREADYUP_CODE = 203;
    public static final String PRODUCT_ALREADYUP_MSG = "该商品已经是上架商品了";

    public static final Integer PRODUCT_ALREADYDOWN_CODE = 204;
    public static final String PRODUCT_ALREADYDOWN_MSG = "该商品已经是下架商品了";

    public static final Integer PRODUCT_UPDATEFAIL_CODE = 205;
    public static final String PRODUCT_UPDATEFAIL_MSG = "商品上架/下架失败";

    public static final Integer PRODUCT_ADD_CODE = 206;
    public static final String PRODUCT_ADD_MSG = "已存在同样商品";

    public static final Integer PRODUCT_UPDATE_CODE = 207;
    public static final String PRODUCT_UPDATE_MSG = "更新失败";

    public static final Integer PRODUCT_NONE_CODE = 208;
    public static final String PRODUCT_NONE_MSG = "请输入全部参数";


    //订单相关状态
    public static final Integer ORDER_SUCCESS_CODE = 300;

    public static final Integer ORDER_DISPEAR_CODE = 301;
    public static final String ORDER_DISPEAR_MSG = "订单列表不存在";

    public static final Integer ORDER_NO_CODE = 302;
    public static final String ORDER_NO_MSG = "订单不存在";

    public static final Integer ORDER_THROW_CODE = 303;
    public static final String ORDER_THROW_MSG = "订单已发货";

    public static final Integer ORDER_NONE_CODE = 304;
    public static final String ORDER_NONE_MSG = "请输入完整信息";
    //分块相关状态

    public static final Integer FENKUAI_SUCCESS_CODE = 400;

    public static final Integer FENKUAI_NONE_CODE = 401;
    public static final String FENKUAI_NONE_MSG = "请输入完整信息";

    public static final Integer FENKUAI_SAME_CODE = 402;
    public static final String FENKUAI_SAME_MSG = "已存在相同节点";

    public static final Integer FENKUAI_NO_CODE = 403;
    public static final String FENKUAI_NO_MSG = "不存在节点";
    public static final String FENKUAI_DO_MSG = "更新失败";
}
