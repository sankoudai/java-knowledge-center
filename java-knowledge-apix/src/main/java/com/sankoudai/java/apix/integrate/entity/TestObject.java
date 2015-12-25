package com.sankoudai.java.apix.integrate.entity;

import java.text.SimpleDateFormat;

/**
 * Created by xuliufeng on 2015/12/18.
 */
public class TestObject {
    public static final SimpleDateFormat ALIPAY_DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 请求是否成功。请求成功不代表业务处理成功。
     * T 代表成功
     * F 代表失败
     * <p>
     * 不可空
     */
    public String is_success;

    /**
     * 支付宝签名
     */
    public String sign;

    /**
     * 签名类型
     */
    public String sign_type;

    /**
     * 查询交易信息失败的错误代码
     * 例如: TRADE_NOT_EXIST
     */
    public String error;

    /**
     * 对一笔交易的具体描述信息。如果是多种商品，请将商品描述字符串累加传给 body
     */
    public String body;

    /**
     * 买家支付宝账号
     * 不可空
     */
    public String buyer_email;

    /**
     * 买家支付宝账号对应的支付宝唯一用户号
     * 不可空
     */
    public String buyer_id;

    /**
     * 交易冻结状态
     * 1 表示冻结；
     * 0 表示未冻结
     * <p>
     * 不可空
     */
    public String flag_trade_locked;
    /**
     * 交易创建的时间。 格式为 yyyy-MM-dd HH:mm:ss
     * <p>
     * 不可空
     */
    public String gmt_create;
    /**
     * 付款时间
     */
    public String gmt_payment;
    /**
     * 交易金额是否调整过
     */
    public String is_total_fee_adjust;
    /**
     * 商户网站唯一订单号
     * 可空
     */
    public String out_trade_no;
    /**
     * 商品单价
     */
    public String price;
    /**
     * 购买数量
     */
    public String quantity;
    /**
     * 卖家的支付宝账号
     */
    public String seller_email;
    /**
     * 卖家支付宝账号对应的支付宝唯一用户号
     * 不可空
     */
    public String seller_id;
    /**
     * 商品名称
     */
    public String subject;
    /**
     * 交易总金额
     * 不可空
     */
    public String total_fee;
    /**
     * 支付宝交易号
     * 不可空
     */
    public String trade_no;
    /**
     * 退款状态
     * 可空
     */
    public String refund_status;
    /**
     * 交易状态
     * 不可空
     */
    public String trade_status;
    /**
     * 退款时间
     */
    public String gmt_refund;
    /**
     * 退款金额
     */
    public String refund_fee;
    /**
     * 退款 ID
     */
    public String refund_id;
    /**
     * 累计的已经退款金额
     * 可空
     */
    public String to_buyer_fee;
    /**
     * 累计的已打款给卖家的金额
     * 可空
     */
    public String to_seller_fee;

    public String time_out;
    public String time_out_type;
    public String discount;
    public String gmt_last_modified_time;
    public String refund_flow_type;
    public String operator_role;
    public String use_coupon;
    public String payment_type;

    @Override
    public String toString() {
        return "TestObject{" +
                        "is_success='" + is_success + '\'' +
                        ", sign='" + sign + '\'' +
                        ", sign_type='" + sign_type + '\'' +
                        ", error='" + error + '\'' +
                        ", body='" + body + '\'' +
                        ", buyer_email='" + buyer_email + '\'' +
                        ", buyer_id='" + buyer_id + '\'' +
                        ", flag_trade_locked='" + flag_trade_locked + '\'' +
                        ", gmt_create='" + gmt_create + '\'' +
                        ", gmt_payment='" + gmt_payment + '\'' +
                        ", is_total_fee_adjust='" + is_total_fee_adjust + '\'' +
                        ", out_trade_no='" + out_trade_no + '\'' +
                        ", price='" + price + '\'' +
                        ", quantity='" + quantity + '\'' +
                        ", seller_email='" + seller_email + '\'' +
                        ", seller_id='" + seller_id + '\'' +
                        ", subject='" + subject + '\'' +
                        ", total_fee='" + total_fee + '\'' +
                        ", trade_no='" + trade_no + '\'' +
                        ", refund_status='" + refund_status + '\'' +
                        ", trade_status='" + trade_status + '\'' +
                        ", gmt_refund='" + gmt_refund + '\'' +
                        ", refund_fee='" + refund_fee + '\'' +
                        ", refund_id='" + refund_id + '\'' +
                        ", to_buyer_fee='" + to_buyer_fee + '\'' +
                        ", to_seller_fee='" + to_seller_fee + '\'' +
                        ", time_out='" + time_out + '\'' +
                        ", time_out_type='" + time_out_type + '\'' +
                        ", discount='" + discount + '\'' +
                        ", gmt_last_modified_time='" + gmt_last_modified_time + '\'' +
                        ", refund_flow_type='" + refund_flow_type + '\'' +
                        ", operator_role='" + operator_role + '\'' +
                        ", use_coupon='" + use_coupon + '\'' +
                        ", payment_type='" + payment_type + '\'' +
                        '}';
    }
}
