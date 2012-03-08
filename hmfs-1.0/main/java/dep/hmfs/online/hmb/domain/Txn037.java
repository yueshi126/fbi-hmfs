package dep.hmfs.online.hmb.domain;

import java.math.BigDecimal;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 12-3-8
 * Time: 下午6:50
 * To change this template use File | Settings | File Templates.
 */
public class Txn037 extends SubMsg{
    //F8：动作代码
    public String actionCode;

    //F16：信息ID1
    public String infoId1;

    //F17：信息ID1类型
    public String infoIdType1;

    //F21：信息名称
    public String infoName;

    //F22：信息地址
    public String infoAddr;

    //F24：建筑面积
    public String builderArea;

    //F28：核算户账号1。
    public String fundActno1;

    //F29：核算户账号1类型
    public String fundActtype1;

    //F45：交易金额1
    public BigDecimal txnAmt1;

    private String orgId;
    private String orgType;

    private String orgName;

}

