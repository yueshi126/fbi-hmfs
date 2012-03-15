package dep.hmfs.online.service.hmb;

import common.enums.SysCtlSts;
import common.repository.hmfs.model.HmSct;
import dep.hmfs.online.processor.hmb.domain.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * ��������ǩ��ǩ�� ����.
 * User: zhanrui
 * Date: 12-3-12
 * Time: ����9:55
 * To change this template use File | Settings | File Templates.
 */
@Service
public class HmbCmnTxnService extends HmbBaseService {
    private static final Logger logger = LoggerFactory.getLogger(HmbCmnTxnService.class);

    /**
     * �������ǩ��
     */
    @Transactional
    public void processSignon() {
        HmSct hmSct = getAppSysStatus();
        SysCtlSts sysCtlSts = SysCtlSts.valueOfAlias(hmSct.getSysSts());
        if (sysCtlSts.equals(SysCtlSts.INIT) || sysCtlSts.equals(SysCtlSts.HMB_CHK_SUCCESS)) {
            try {
                doHmbSignTxn("7000", "301");
                hmSct.setSysSts(SysCtlSts.SIGNON.getCode());
                hmSct.setSignonDt(new Date());
                hmSctMapper.updateByPrimaryKey(hmSct);
            } catch (Exception e) {
                logger.error("ǩ��ʧ�ܡ�", e);
                throw new RuntimeException("ǩ��ʧ�ܡ�" + e.getMessage());
            }
        } else {
            throw new RuntimeException("ϵͳ��ʼ��������ֶ�����ɺ󷽿�ǩ����");
        }
    }

    private void doHmbSignTxn(String txnCode, String actionCode) throws Exception {
        boolean result = false;
        Msg001 msg001 = new Msg001();
        assembleSummaryMsg(txnCode, msg001, 1, false);
        msg001.txnType = "1";//����������
        msg001.bizType = "3"; //????
        msg001.origTxnCode = "#"; //TODO ????

        Msg096 msg096 = new Msg096();
        msg096.actionCode = actionCode; //301:ǩ��

        List<HmbMsg> hmbMsgList = new ArrayList<HmbMsg>();
        hmbMsgList.add(msg001);
        hmbMsgList.add(msg096);
        byte[] txnBuf = messageFactory.marshal(txnCode, hmbMsgList);
        //���ͱ���
        Map<String, List<HmbMsg>> responseMap = sendDataUntilRcv(txnBuf);

        List<HmbMsg> msgList = responseMap.get(txnCode);
        if (msgList == null || msgList.size() == 0) {
            //
            throw new RuntimeException("���չ����ֱ��ĳ���������Ϊ��");
        }

        Msg002 msg002 = (Msg002) msgList.get(0);
        if (!msg002.rtnInfoCode.equals("00")) {
            throw new RuntimeException("�����ַ��ش�����Ϣ��" + msg002.rtnInfo);
        }
    }


    @Transactional
    public void processSignout() {
        //TODO
        HmSct hmSct = getAppSysStatus();
        SysCtlSts sysCtlSts = SysCtlSts.valueOfAlias(hmSct.getSysSts());
        if (sysCtlSts.equals(SysCtlSts.SIGNON)) {
            try {
                doHmbSignTxn("7001", "302");
                hmSct.setSysSts(SysCtlSts.SIGNOUT.getCode());
                hmSct.setSignoutDt(new Date());
                hmSctMapper.updateByPrimaryKey(hmSct);
            } catch (Exception e) {
                logger.error("ǩ��ʧ�ܡ������·���ǩ�ˡ�", e);
                throw new RuntimeException("ǩ��ʧ�ܡ������·���ǩ�ˡ�" + e.getMessage());
            }
        } else {
            throw new RuntimeException("ϵͳǩ����ɺ󷽿�ǩ�ˡ�");
        }
    }
    
    

    @Transactional
    public boolean processChkActBal() {
        //TODO
        HmSct hmSct = getAppSysStatus();
        if (!hmSct.getSysSts().equals(SysCtlSts.HOST_CHK_SUCCESS.getCode())) {
            throw new RuntimeException("ϵͳ״̬�����������ʳɹ��󷽿ɽ��й����ֶ��ʲ�����");
        }

        //depService.doSend

        //db

        //check db

        boolean result = false;
        //���˶��������ϵͳ״̬
        if (1 == 1) {
            hmSct = getAppSysStatus();
            SysCtlSts currentSysSts = SysCtlSts.valueOfAlias(hmSct.getSysSts());
            if (currentSysSts.equals(SysCtlSts.HMB_DETLCHK_SUCCESS)) {
                hmSct.setSysSts(SysCtlSts.HMB_CHK_SUCCESS.getCode());
            } else {
                hmSct.setSysSts(SysCtlSts.HMB_BALCHK_SUCCESS.getCode());
            }
            //TODO
            hmSct.setHostChkDt(new Date());
            hmSctMapper.updateByPrimaryKey(hmSct);
            result = true;
        }

        return result;
    }

    @Transactional
    public boolean processChkActDetl() {
        //TODO
        HmSct hmSct = getAppSysStatus();
        if (!hmSct.getSysSts().equals(SysCtlSts.HOST_CHK_SUCCESS.getCode())
                && !hmSct.getSysSts().equals(SysCtlSts.HMB_BALCHK_SUCCESS.getCode())) {
            throw new RuntimeException("ϵͳ״̬�����������ʳɹ����������������ɺ󷽿ɽ��й�������ˮ���ʡ�");
        }

        //depService.doSend

        //db

        //check db

        boolean result = false;
        //���˶��������ϵͳ״̬
        if (1 == 1) {
            hmSct = getAppSysStatus();
            SysCtlSts currentSysSts = SysCtlSts.valueOfAlias(hmSct.getSysSts());
            if (currentSysSts.equals(SysCtlSts.HMB_BALCHK_SUCCESS)) {
                hmSct.setSysSts(SysCtlSts.HMB_CHK_SUCCESS.getCode());
            } else {
                hmSct.setSysSts(SysCtlSts.HMB_DETLCHK_SUCCESS.getCode());
            }
            //TODO
            hmSct.setHostChkDt(new Date());
            hmSctMapper.updateByPrimaryKey(hmSct);
            result = true;
        }

        return result;
    }
    @Transactional
    public void processOpenactRequest(String request) {
        String txnCode = "5110";
        Msg003 msg003 = new Msg003();
        assembleSummaryMsg(txnCode, msg003, 1, true);

        msg003.txnType = "1";//����������
        msg003.bizType = "1"; //
        msg003.origTxnCode = "9110";

        String[] fields = request.split("\\|");

        Msg031 msg031 = new Msg031();
        msg031.actionCode = "100";
        int f = 2;
        msg031.cbsActno = fields[f++];
        msg031.cbsActtype = fields[f++];
        msg031.cbsActname  = fields[f++];
        msg031.bankName  = fields[f++];
        msg031.branchId  = fields[f++];
        msg031.depositType  = fields[f++];
        msg031.orgId   = fields[f++];
        msg031.orgType  = fields[f++];
        msg031.orgName   = fields[f];

        List<HmbMsg> hmbMsgList = new ArrayList<HmbMsg>();
        hmbMsgList.add(msg003);
        hmbMsgList.add(msg031);
        byte[] txnBuf = messageFactory.marshal(txnCode, hmbMsgList);
        //���ͱ���
        Map<String, List<HmbMsg>> responseMap = sendDataUntilRcv(txnBuf);
        List<HmbMsg> msgList = responseMap.get("9999");
        if (msgList == null || msgList.size() == 0) {
            throw new RuntimeException("���չ����ֱ��ĳ���������Ϊ��");
        }

        Msg100 msg100 = (Msg100) msgList.get(0);
        if (!msg100.rtnInfoCode.equals("00")) {
            throw new RuntimeException("�����ַ��ش�����Ϣ��" + msg100.rtnInfo);
        }
    }

    private void processOpenactRequest(){

    }
}