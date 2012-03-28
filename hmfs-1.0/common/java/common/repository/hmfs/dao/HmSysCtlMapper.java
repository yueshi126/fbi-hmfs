package common.repository.hmfs.dao;

import common.repository.hmfs.model.HmSysCtl;
import common.repository.hmfs.model.HmSysCtlExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HmSysCtlMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int countByExample(HmSysCtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int deleteByExample(HmSysCtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int deleteByPrimaryKey(String sctSeqno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int insert(HmSysCtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int insertSelective(HmSysCtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    List<HmSysCtl> selectByExample(HmSysCtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    HmSysCtl selectByPrimaryKey(String sctSeqno);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int updateByExampleSelective(@Param("record") HmSysCtl record, @Param("example") HmSysCtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int updateByExample(@Param("record") HmSysCtl record, @Param("example") HmSysCtlExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int updateByPrimaryKeySelective(HmSysCtl record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HM_SYS_CTL
     *
     * @mbggenerated Wed Mar 28 11:34:32 CST 2012
     */
    int updateByPrimaryKey(HmSysCtl record);
}