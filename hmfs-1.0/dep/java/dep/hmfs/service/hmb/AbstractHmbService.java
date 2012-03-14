package dep.hmfs.service.hmb;

import common.repository.hmfs.dao.HisMsginLogMapper;
import common.repository.hmfs.dao.HisMsgoutLogMapper;
import common.repository.hmfs.dao.HmSctMapper;
import common.repository.hmfs.model.HmSct;
import common.service.SystemService;
import dep.gateway.hmb8583.HmbMessageFactory;
import dep.gateway.xsocket.client.impl.XSocketBlockClient;
import dep.hmfs.common.HmbTxnsnGenerator;
import dep.hmfs.online.hmb.domain.HmbMsg;
import dep.hmfs.online.hmb.domain.SummaryMsg;
import dep.util.PropertyManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: zhanrui
 * Date: 12-3-14
 * Time: ����2:35
 * To change this template use File | Settings | File Templates.
 */
abstract public class AbstractHmbService {
    private static final Logger logger = LoggerFactory.getLogger(AbstractHmbService.class);

    @Resource
    protected HmSctMapper hmSctMapper;

    @Resource
    protected HisMsgoutLogMapper hisMsgoutLogMapper;

    @Resource
    protected HisMsginLogMapper hisMsginLogMapper;

    @Resource
    HmbTxnsnGenerator txnsnGenerator;

    protected XSocketBlockClient socketBlockClient;
    protected String hmfsServerIP = PropertyManager.getProperty("socket_server_ip_hmfs");
    protected int hmfsServerPort = PropertyManager.getIntProperty("socket_server_port_hmfs");
    protected int hmfsServerTimeout = PropertyManager.getIntProperty("socket_server_timeout");
    protected HmbMessageFactory messageFactory = new HmbMessageFactory();

    public HmSct getAppSysStatus() {
        return hmSctMapper.selectByPrimaryKey("1");
    }
    
    protected void assembleSummaryMsg(String  txnCode, SummaryMsg msg, int submsgNum) {
        msg.msgSn = txnsnGenerator.generateTxnsn(txnCode);
        msg.submsgNum = submsgNum;
        msg.sendSysId = PropertyManager.getProperty("SEND_SYS_ID");
        msg.origSysId = PropertyManager.getProperty("ORIG_SYS_ID");
        msg.msgDt = SystemService.formatTodayByPattern("yyyyMMddHHmmss");
        msg.msgEndDate = "#";
    }

    protected Map<String, List<HmbMsg>> sendDataUntilRcv(byte[] bytes) throws Exception {
        byte[] hmfsDatagram;
        try {
            socketBlockClient = new XSocketBlockClient(hmfsServerIP, hmfsServerPort, hmfsServerTimeout);
            hmfsDatagram = socketBlockClient.sendDataUntilRcvToHmb(bytes);
        } finally {
            socketBlockClient.close();
        }
        return messageFactory.unmarshal(hmfsDatagram);
    }

}