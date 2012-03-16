package dep.hmfs.online.processor.hmb;

import dep.hmfs.online.processor.hmb.domain.HmbMsg;
import dep.hmfs.online.processor.hmb.domain.Msg003;
import dep.hmfs.online.processor.hmb.domain.Msg004;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class HmbTxn5130Processor extends HmbAbstractTxnProcessor {

    private static final Logger logger = LoggerFactory.getLogger(HmbTxn5130Processor.class);

    @Override
    public byte[] process(String txnCode, String msgSn, List<HmbMsg> hmbMsgList) {
        Msg004 msg004 = createRtnMsg004(msgSn);
        try {
            hmbBaseService.updateOrInsertMsginsByHmbMsgList(txnCode, hmbMsgList);
            Msg003 msg003 = (Msg003) hmbMsgList.get(0);
            msg004.infoId1 = msg003.infoId1;
            msg004.infoIdType1 = msg003.infoIdType1;
            msg004.districtId = msg003.districtId;
            int cnt = hmbDetailMsgService.createActinfosByMsgList(hmbMsgList.subList(1, hmbMsgList.size()));
            msg004.rtnInfo = cnt + "笔分户核算户开户处理完成";
        } catch (Exception e) {
            logger.error("5130交易处理异常！", e);
            msg004.rtnInfoCode = "99";
            msg004.rtnInfo = "报文接收失败";
        }
        // 响应
        List<HmbMsg> rtnHmbMsgList = new ArrayList<HmbMsg>();
        rtnHmbMsgList.add(msg004);
        return mf.marshal("5130", rtnHmbMsgList);
    }
}
