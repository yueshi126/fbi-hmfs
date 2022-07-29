package common.repository.hmfs.dao.hmfs;

import common.repository.hmfs.model.HmMsgIn;
import common.repository.hmfs.model.HmVchStore;
import common.repository.hmfs.model.hmfs.HmChkActVO;
import common.repository.hmfs.model.hmfs.HmChkTxnVO;
import common.repository.hmfs.model.hmfs.HmFundTxnVO;
import common.repository.hmfs.model.hmfs.HmVchStoreSumVO;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * ��Ʊ�ݹ���. ��Ҫ�ǳ�������.
 * User: zhanrui
 * Date: 20150423
 */
@Repository
public interface HmVoucherMapper {

    //��������ѯƱ�ݿ�����
    public List<HmVchStore> selectInstVoucherStoreList(@Param("instNo") String instNo);

    //public List<HmVchStoreSumVO> selectInstVoucherStoreSumInfo(@Param("instNo") String instNo);

    //���������ҵ�ǰ�������Ʊ�ݺ�
    public String selectInstVchMaxEndNo(@Param("instNo") String instNo);



    //��������Ʊ�ݺŴ�Ŀ���¼�е����
    public String selectStoreStartno_GreaterThanVchno( @Param("vchNo") String vchNo);

    //��������Ʊ�ݺ�С�Ŀ���¼�е�ֹ��
    public String selectStoreEndno_LessThanVchno(@Param("vchNo") String vchNo);

    //������ֹ�Ų��ҿ���¼�е��ڴ˷�Χ�ڵļ�¼������Ʊ����
    public int selectStoreRecordnumBetweenStartnoAndEndno(@Param("startNo") String startNo, @Param("endNo") String endNo);

    //������ֹ�Ų��ҿ���¼�е��ڴ˷�Χ�ڵļ�¼��
    public List<HmVchStore> selectStoreRecordListBetweenStartnoAndEndno(@Param("startNo") String startNo, @Param("endNo") String endNo);



    //����ɾ��
    public int deleteVoucherByPkid(@Param("pkid") String pkid, @Param("recversion") int recversion);

    //������� (ֻ����ֹ��)
    public int updateVoucherStoreRecordEndnoByPkid(@Param("pkid") String pkid, @Param("recversion") int recversion, @Param("endNo") String endNo);

    //ͳ��vchstore����ĳ�����Ŀ��  sql92
    @Select("select (case when sum(t.vch_count) is null then 0 else sum(t.vch_count) end) from hm_vch_store t where t.branch_id=#{instNo}")
    public int selectVchStoreTotalNum(@Param("instNo") String instNo);

    //ͳ��vchjrnl����ĳ�����Ŀ��  sql92
    @Select("select (case when sum(t.vch_count) is null then 0 else sum(t.vch_count) end) from hm_vch_jrnl t where t.branch_id=#{instNo} and t.vch_state=#{vchStatus}")
    public int selectVchJrnlTotalNum(@Param("instNo") String instNo, @Param("vchStatus") String vchStatus);
}