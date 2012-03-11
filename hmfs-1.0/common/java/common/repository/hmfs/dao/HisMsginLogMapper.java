package common.repository.hmfs.dao;

import common.repository.hmfs.model.HisMsginLog;
import common.repository.hmfs.model.HisMsginLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HisMsginLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int countByExample(HisMsginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int deleteByExample(HisMsginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int deleteByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int insert(HisMsginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int insertSelective(HisMsginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    List<HisMsginLog> selectByExample(HisMsginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    HisMsginLog selectByPrimaryKey(String pkid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int updateByExampleSelective(@Param("record") HisMsginLog record, @Param("example") HisMsginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int updateByExample(@Param("record") HisMsginLog record, @Param("example") HisMsginLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int updateByPrimaryKeySelective(HisMsginLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.HIS_MSGIN_LOG
     *
     * @mbggenerated Sun Mar 11 19:14:16 CST 2012
     */
    int updateByPrimaryKey(HisMsginLog record);
}