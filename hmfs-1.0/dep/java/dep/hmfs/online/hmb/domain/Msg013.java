package dep.hmfs.online.hmb.domain;

import dep.hmfs.common.annotation.Hmb8583Field;
import dep.hmfs.common.annotation.HmbMessage;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 12-3-8
 * Time: 下午7:05
 * To change this template use File | Settings | File Templates.
 */
@HmbMessage("013")
public class Msg013 extends SummaryMsg {
    //F9：和新交易相关的原始交易的报文编号，如抹账、冲正类交易被抹账、冲正交易的报文编号
    @Hmb8583Field(9)
    public String origMsgSn;

    //F12:交易方式  1－批量；2－单笔
    @Hmb8583Field(12)
    public String txnType;

    //F13:业务种类  1－单位；2－业主；3－其他；4－抹账
    @Hmb8583Field(13)
    public String bizType;

    //F14:交易类型 发起方的交易类型码
    @Hmb8583Field(14)
    public String origTxnCode;

    //F16：信息ID1
    @Hmb8583Field(16)
    public String infoId1;

    //F17：信息ID1类型
    @Hmb8583Field(17)
    public String infoIdType1;

    //F25：归属区县ID
    @Hmb8583Field(25)
    public String districtId;

    //F28：核算户账号1。
    @Hmb8583Field(28)
    public String fundActno1;

    //F29：核算户账号1类型
    @Hmb8583Field(29)
    public String fundActtype1;

    //F32：结算户账号1
    @Hmb8583Field(32)
    public String settleActno1;

    //F33：结算户账号1类型
    @Hmb8583Field(33)
    public String settleActtype1;

    //F45：交易金额1
    @Hmb8583Field(45)
    public BigDecimal txnAmt1;

    //F79：缴款类型 00:首次交款 01:维修资金追缴 02:维修资金续交 03:结息交款 04:欠款补交 05:其他交款 06:收益资金交款
    @Hmb8583Field(79)
    public String depType;
}
