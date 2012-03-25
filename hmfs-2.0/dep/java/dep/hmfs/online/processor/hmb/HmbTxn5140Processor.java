package dep.hmfs.online.processor.hmb;

import dep.hmfs.online.processor.hmb.domain.HmbMsg;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

@Component
public class HmbTxn5140Processor extends HmbSyncAbstractTxnProcessor {

    private static final Logger logger = LoggerFactory.getLogger(HmbTxn5140Processor.class);

    @Override
    public int process(String txnCode, String msgSn, List<HmbMsg> hmbMsgList) throws InvocationTargetException, IllegalAccessException {
        return hmbActinfoService.createActinfoFundsByMsgList(hmbMsgList.subList(1, hmbMsgList.size()));
    }
}