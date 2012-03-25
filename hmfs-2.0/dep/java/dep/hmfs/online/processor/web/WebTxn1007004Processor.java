package dep.hmfs.online.processor.web;

import common.repository.hmfs.dao.HmChkActMapper;
import common.repository.hmfs.model.HmChkAct;
import dep.hmfs.online.processor.hmb.domain.*;
import dep.hmfs.online.service.hmb.HmbSysTxnService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * ������ˮ����.  �ݲ���
 * User: zhanrui
 * Date: 12-3-15
 * Time: ����1:45
 * To change this template use File | Settings | File Templates.
 */
@Component
public class WebTxn1007004Processor extends WebAbstractHmbProductTxnProcessor {
    @Resource
    private HmbSysTxnService hmbSysTxnService;
    @Resource
    private HmChkActMapper hmChkActMapper;

    @Override
    public String process(String request) {
        String txnCode = "7004";
        //���ͱ���
        Map<String, List<HmbMsg>> responseMap = sendDataUntilRcv(getRequestBuf(txnCode));

        //�������ر���
        List<HmbMsg> msgList = responseMap.get(txnCode);
        if (msgList == null || msgList.size() == 0) {
            throw new RuntimeException("���չ����ֱ��ĳ���������Ϊ��");
        }

        Msg002 msg002 = (Msg002) msgList.get(0);
        if (!msg002.rtnInfoCode.equals("00")) {
            throw new RuntimeException("�����ַ��ش�����Ϣ��" + msg002.rtnInfo);
        } else {
            //���浽�������ݿ�
            processChkDetlResponse(msgList);
            //TODO �˶�
        }

        return "0000|��ˮ���ʽ��׳ɹ�";
    }

    private byte[] getRequestBuf(String txnCode) {
        List<HmbMsg> hmbMsgList = new ArrayList<HmbMsg>();

        //���ܱ��Ĵ���
        Msg001 msg001 = new Msg001();
        assembleSummaryMsg(txnCode, msg001, 1, false);
        msg001.txnType = "1";//����������
        msg001.bizType = "#"; //?
        msg001.origTxnCode = "#"; //TODO ????
        hmbMsgList.add(msg001);

        //�ӱ��Ĵ���  095-���㻧 092-���㻧
        return messageFactory.marshal(txnCode, hmbMsgList);
    }

    /**
     * ���������ַ��ص���ˮ������Ϣ
     */
    private void processChkDetlResponse(List<HmbMsg> msgList) {
        Msg002 msg002 = (Msg002) msgList.get(0);
        String txnDate = msg002.msgDt.substring(0, 8);
        for (HmbMsg hmbMsg : msgList.subList(1, msgList.size())) {
            HmChkAct hmChkAct = new HmChkAct();
            hmChkAct.setTxnDate(txnDate);
            hmChkAct.setSendSysId("00");
            if (hmbMsg instanceof Msg095) {
                hmChkAct.setActno(((Msg095) hmbMsg).fundActno1);
                hmChkAct.setActbal(((Msg095) hmbMsg).getTxnAmt1());
            } else {
                hmChkAct.setActno(((Msg092) hmbMsg).settleActno1);
                hmChkAct.setActbal(((Msg092) hmbMsg).getTxnAmt1());
            }
            hmChkActMapper.insert(hmChkAct);
        }
    }

}