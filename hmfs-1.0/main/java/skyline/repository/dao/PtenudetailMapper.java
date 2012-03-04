package skyline.repository.dao;

import skyline.repository.model.Ptenudetail;
import skyline.repository.model.PtenudetailExample;
import skyline.repository.model.PtenudetailKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface PtenudetailMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int countByExample(PtenudetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int deleteByExample(PtenudetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int deleteByPrimaryKey(PtenudetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insert(Ptenudetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insertSelective(Ptenudetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    List<Ptenudetail> selectByExample(PtenudetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    Ptenudetail selectByPrimaryKey(PtenudetailKey key);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExampleSelective(@Param("record") Ptenudetail record, @Param("example") PtenudetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExample(@Param("record") Ptenudetail record, @Param("example") PtenudetailExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByPrimaryKeySelective(Ptenudetail record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTENUDETAIL
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByPrimaryKey(Ptenudetail record);
}