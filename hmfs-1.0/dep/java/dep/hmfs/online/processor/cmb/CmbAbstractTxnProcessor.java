package dep.hmfs.online.processor.cmb;

import dep.hmfs.online.processor.cmb.domain.base.TOA;

/**
 * Created by IntelliJ IDEA.
 * User: zhangxiaobo
 * Date: 12-3-8
 * Time: ����7:23
 * To change this template use File | Settings | File Templates.
 */
public abstract class CmbAbstractTxnProcessor {

    public abstract TOA process(String txnSerialNo, byte[] bytes) throws Exception;
}