package com.creditcloud.chinapay.model.response;

import com.creditcloud.chinapay.ChinaPayConstant;
import java.util.List;
import java.util.Properties;

import com.creditcloud.chinapay.model.POJO;
import com.creditcloud.chinapay.utils.StringUtils;

public class SingleCutQueryResult extends POJO {

    protected String responseCode = "";// 应答信息 数字 定长，2位 是 00表示成功，其它代表代扣失败或查询失败，具体参看6.1交易状态码表

    protected String merId = "";// 商户号 数字 定长，15位 否 同原始交易中的商户号

    protected String orderNo = "";// 订单号 数字 定长，16位 否 同原始交易中的订单号

    protected String transAmt = "";// 金额 数字 变长，12位 否 同原始交易中的金额

    protected String curyId = "";// 币种 数字 定长，3位 否 同原始交易中的币种

    protected String transDate = "";// 商户日期 数字 定长，8位 否 同原始交易中的商户日期

    protected String transType = "";// 交易类型 数字 定长，4位 否 0003

    protected String transStat = "";// 代扣状态 数字 定长，4位 是 交易状态（查询结果）

    protected String priv1 = "";// 私有域 字符 变长，60位 否 同原始交易中的私有域

    protected String openBankId = "";// 开户行代号 数字 定长，4位 否 同原始交易中的开户行代号

    protected String cardType = "";// 卡折标志 数字 定长，1位 否 同原始交易中的卡、折标志

    protected String cardNo = "";// 卡号/折号 字符 变长，25位 否 同原始交易中的卡号、折号

    protected String usrNme = "";// 持卡人姓名 字符 变长，20位 否 同原始交易中的持卡人姓名

    protected String certType = "";// 证件类型 字符 定长，2位 否 同原始交易中的证件类型

    protected String certId = "";// 证件号 字符 变长，25位 否 同原始交易中的证件号。

    protected String message = "";// 描述 字符 变长，256位 否 交易应答返回描述

    protected String chkValue = "";// 签名值 字符 定长，256位 必填
    // 对返回字串的签名。返回报文中后256位字符串以前的都是作为签名的明文，明文需进行BASE64编码，具体见下方。

    public static SingleCutQueryResult parse(String responseText) {
        final String PAIR_DELIMITER = "&";
        final String NAME_VALUE_DELIMITER = "=";
        final boolean trimToken = true;
        List<String> namedValues = StringUtils.parseTokens(responseText, PAIR_DELIMITER, trimToken);
        Properties prop = new Properties();
        for (String namedValue : namedValues) {
            List<String> nameAndValue = StringUtils.parseTokens(namedValue, NAME_VALUE_DELIMITER, trimToken);
            String name = nameAndValue.get(0);
            String value = nameAndValue.size() >= 2 ? nameAndValue.get(1) : "";
            prop.put(name, value);
        }

        SingleCutQueryResult result = new SingleCutQueryResult();

        result.responseCode = prop.getProperty("responseCode", "");
        result.merId = prop.getProperty("merId", "");
        result.orderNo = prop.getProperty("orderNo", "");
        result.transAmt = prop.getProperty("transAmt", "");
        result.curyId = prop.getProperty("curyId", "");
        result.transDate = prop.getProperty("transDate", "");
        result.transType = prop.getProperty("transType", "");
        result.transStat = prop.getProperty("transStat", "");
        result.priv1 = StringUtils.fromUnicode(prop.getProperty("priv1", ""));
        result.openBankId = prop.getProperty("openBankId", "");
        result.cardType = prop.getProperty("cardType", "");
        result.cardNo = prop.getProperty("cardNo", "");
        result.usrNme = StringUtils.fromUnicode(prop.getProperty("usrNme", ""));
        result.certType = prop.getProperty("certType", "");
        result.certId = prop.getProperty("certId", "");
        result.message = StringUtils.fromUnicode(prop.getProperty("message", ""));
        result.chkValue = prop.getProperty("chkValue", "");

        return result;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getMerId() {
        return merId;
    }

    public void setMerId(String merId) {
        this.merId = merId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getTransAmt() {
        return transAmt;
    }

    public void setTransAmt(String transAmt) {
        this.transAmt = transAmt;
    }

    public String getCuryId() {
        return curyId;
    }

    public void setCuryId(String curyId) {
        this.curyId = curyId;
    }

    public String getTransDate() {
        return transDate;
    }

    public void setTransDate(String transDate) {
        this.transDate = transDate;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public String getTransStat() {
        return transStat;
    }

    public void setTransStat(String transStat) {
        this.transStat = transStat;
    }

    public String getPriv1() {
        return priv1;
    }

    public void setPriv1(String priv1) {
        this.priv1 = priv1;
    }

    public String getOpenBankId() {
        return openBankId;
    }

    public void setOpenBankId(String openBankId) {
        this.openBankId = openBankId;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getUsrNme() {
        return usrNme;
    }

    public void setUsrNme(String usrNme) {
        this.usrNme = usrNme;
    }

    public String getCertType() {
        return certType;
    }

    public void setCertType(String certType) {
        this.certType = certType;
    }

    public String getCertId() {
        return certId;
    }

    public void setCertId(String certId) {
        this.certId = certId;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getChkValue() {
        return chkValue;
    }

    public void setChkValue(String chkValue) {
        this.chkValue = chkValue;
    }

    public boolean success() {
        return ChinaPayConstant.SINGLE_CUT_SUCCESS.equals(responseCode);
    }
}
