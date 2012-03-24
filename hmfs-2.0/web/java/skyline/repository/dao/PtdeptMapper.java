package skyline.repository.dao;

import skyline.repository.model.Ptdept;
import skyline.repository.model.PtdeptExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

@Component

public interface PtdeptMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int countByExample(PtdeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int deleteByExample(PtdeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int deleteByPrimaryKey(String deptid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insert(Ptdept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int insertSelective(Ptdept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    List<Ptdept> selectByExample(PtdeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    Ptdept selectByPrimaryKey(String deptid);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExampleSelective(@Param("record") Ptdept record, @Param("example") PtdeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByExample(@Param("record") Ptdept record, @Param("example") PtdeptExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByPrimaryKeySelective(Ptdept record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PTDEPT
     *
     * @mbggenerated Fri Jul 22 13:16:43 CST 2011
     */
    int updateByPrimaryKey(Ptdept record);
}