package common.repository.hmfs.dao;

import common.repository.hmfs.model.TmpMsgoutLog;
import common.repository.hmfs.model.TmpMsgoutLogExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TmpMsgoutLogMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int countByExample(TmpMsgoutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int deleteByExample(TmpMsgoutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int insert(TmpMsgoutLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int insertSelective(TmpMsgoutLog record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    List<TmpMsgoutLog> selectByExample(TmpMsgoutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int updateByExampleSelective(@Param("record") TmpMsgoutLog record, @Param("example") TmpMsgoutLogExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table HMFS.TMP_MSGOUT_LOG
     *
     * @mbggenerated Thu Mar 15 21:49:57 CST 2012
     */
    int updateByExample(@Param("record") TmpMsgoutLog record, @Param("example") TmpMsgoutLogExample example);
}