package common.repository.hmfs.model;

import java.math.BigDecimal;

public class HmChkLog {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.PKID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String pkid;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.TXN_DATE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String txnDate;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.SEND_SYS_ID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String sendSysId;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.ACTNO
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String actno;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.TXNAMT
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private BigDecimal txnamt;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.DC_FLAG
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String dcFlag;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.MSG_SN
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String msgSn;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.MSG_TYPE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String msgType;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.ACTION_CODE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String actionCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column HMFS.HM_CHK_LOG.CHKSTS
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    private String chksts;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.PKID
     *
     * @return the value of HMFS.HM_CHK_LOG.PKID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getPkid() {
        return pkid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.PKID
     *
     * @param pkid the value for HMFS.HM_CHK_LOG.PKID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setPkid(String pkid) {
        this.pkid = pkid == null ? null : pkid.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.TXN_DATE
     *
     * @return the value of HMFS.HM_CHK_LOG.TXN_DATE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getTxnDate() {
        return txnDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.TXN_DATE
     *
     * @param txnDate the value for HMFS.HM_CHK_LOG.TXN_DATE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setTxnDate(String txnDate) {
        this.txnDate = txnDate == null ? null : txnDate.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.SEND_SYS_ID
     *
     * @return the value of HMFS.HM_CHK_LOG.SEND_SYS_ID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getSendSysId() {
        return sendSysId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.SEND_SYS_ID
     *
     * @param sendSysId the value for HMFS.HM_CHK_LOG.SEND_SYS_ID
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setSendSysId(String sendSysId) {
        this.sendSysId = sendSysId == null ? null : sendSysId.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.ACTNO
     *
     * @return the value of HMFS.HM_CHK_LOG.ACTNO
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getActno() {
        return actno;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.ACTNO
     *
     * @param actno the value for HMFS.HM_CHK_LOG.ACTNO
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setActno(String actno) {
        this.actno = actno == null ? null : actno.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.TXNAMT
     *
     * @return the value of HMFS.HM_CHK_LOG.TXNAMT
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public BigDecimal getTxnamt() {
        return txnamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.TXNAMT
     *
     * @param txnamt the value for HMFS.HM_CHK_LOG.TXNAMT
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setTxnamt(BigDecimal txnamt) {
        this.txnamt = txnamt;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.DC_FLAG
     *
     * @return the value of HMFS.HM_CHK_LOG.DC_FLAG
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getDcFlag() {
        return dcFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.DC_FLAG
     *
     * @param dcFlag the value for HMFS.HM_CHK_LOG.DC_FLAG
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setDcFlag(String dcFlag) {
        this.dcFlag = dcFlag == null ? null : dcFlag.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.MSG_SN
     *
     * @return the value of HMFS.HM_CHK_LOG.MSG_SN
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getMsgSn() {
        return msgSn;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.MSG_SN
     *
     * @param msgSn the value for HMFS.HM_CHK_LOG.MSG_SN
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setMsgSn(String msgSn) {
        this.msgSn = msgSn == null ? null : msgSn.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.MSG_TYPE
     *
     * @return the value of HMFS.HM_CHK_LOG.MSG_TYPE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getMsgType() {
        return msgType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.MSG_TYPE
     *
     * @param msgType the value for HMFS.HM_CHK_LOG.MSG_TYPE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setMsgType(String msgType) {
        this.msgType = msgType == null ? null : msgType.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.ACTION_CODE
     *
     * @return the value of HMFS.HM_CHK_LOG.ACTION_CODE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getActionCode() {
        return actionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.ACTION_CODE
     *
     * @param actionCode the value for HMFS.HM_CHK_LOG.ACTION_CODE
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setActionCode(String actionCode) {
        this.actionCode = actionCode == null ? null : actionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column HMFS.HM_CHK_LOG.CHKSTS
     *
     * @return the value of HMFS.HM_CHK_LOG.CHKSTS
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public String getChksts() {
        return chksts;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column HMFS.HM_CHK_LOG.CHKSTS
     *
     * @param chksts the value for HMFS.HM_CHK_LOG.CHKSTS
     *
     * @mbggenerated Wed Mar 14 09:21:32 CST 2012
     */
    public void setChksts(String chksts) {
        this.chksts = chksts == null ? null : chksts.trim();
    }
}