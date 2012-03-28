package common.repository.hmfs.dao.hmfs;

import common.repository.hmfs.model.HmMsgIn;
import common.repository.hmfs.model.hmfs.HmChkActVO;
import common.repository.hmfs.model.hmfs.HmChkTxnVO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * web�㽻�״���.
 * User: zhanrui
 * Date: 12-3-14
 * Time: ����2:05
 * To change this template use File | Settings | File Templates.
 */
@Repository
public interface HmWebTxnMapper {

    //�ɿ�ף���ѯ�ӱ�����Ϣ
    public List<HmMsgIn> selectSubMsgListByMsgSn(@Param("msgSn") String msgSn);

    //�����ʽ����ѯ
    public List<HmChkActVO> selectChkActResult(@Param("sendSysId") String sendSysId, @Param("txnDate") String txnDate);

    //��ˮ���ʽ����ѯ
    public List<HmChkTxnVO> selectChkTxnResult(@Param("sendSysId") String sendSysId, @Param("txnDate") String txnDate);

}