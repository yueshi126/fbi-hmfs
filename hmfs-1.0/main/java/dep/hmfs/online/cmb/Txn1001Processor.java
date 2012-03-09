package dep.hmfs.online.cmb;

import common.enums.TxnCtlSts;
import common.repository.hmfs.model.HisMsginLog;
import common.service.HisMsginLogService;
import dep.hmfs.online.cmb.domain.base.TOA;
import dep.hmfs.online.cmb.domain.txn.TIA1001;
import dep.hmfs.online.cmb.domain.txn.TOA1001;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by IntelliJ IDEA.
 * User: zhangxiaobo
 * Date: 12-3-8
 * Time: 上午11:47
 * To change this template use File | Settings | File Templates.
 */
@Component
public class Txn1001Processor extends AbstractTxnProcessor {

    @Autowired
    private HisMsginLogService hisMsginLogService;

    @Override
    public TOA process(byte[] bytes) throws Exception{
        TIA1001 tia1001 = new TIA1001();
        tia1001.body.payApplyNo = new String(bytes, 0, 18).trim();

        TOA1001 toa1001 = null;
        // 查询交款汇总信息
        HisMsginLog totalPayInfo = hisMsginLogService.qryTotalPayInfoByMsgSn(tia1001.body.payApplyNo);

        if (totalPayInfo != null) {
            toa1001 = new TOA1001();
            toa1001.body.payApplyNo = tia1001.body.payApplyNo;
            toa1001.body.payAmt = totalPayInfo.getTxnAmt1().toString();
            toa1001.body.payFlag = TxnCtlSts.TXN_SUCCESS.getCode().equals(totalPayInfo.getTxnCtlSts()) ? "1" : "0";

            // 更新交款汇总信息和明细信息状态为：处理中 -- 更新完成后交款信息不可撤销
            hisMsginLogService.updatePayInfosTxnCtlStsByMsgSn(tia1001.body.payApplyNo, TxnCtlSts.TXN_HANDLING);
        }
        return toa1001;
    }
}