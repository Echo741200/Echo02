package com.example.demo.mapper;

import com.example.demo.entity.Questionnaire;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionnaireMapper {
        @Insert("INSERT INTO questionnaire(questionnaire_name,questionnaire_date,userid) VALUES(#{questionnaire_name},#{questionnaire_date},#{userid}) ")
        @Options(useGeneratedKeys = true, keyProperty = "questionnaire_id")     //返回主键
        Integer addquestionnaire(Questionnaire questionnaire);

        @Update("UPDATE questionnaire SET is_delete= 1 where questionnaire_id=#{questionnaire_id}")
        Integer deletequestionnaire(int  questionnaire_id);

        @Select("SELECT questionnaire_id,questionnaire_name,questionnaire_date FROM questionnaire WHERE  userid=#{id} AND is_delete=0 ")
        List<Questionnaire> selectmyquestionnaire(int id);

        @Select("SELECT questionnaire_id,questionnaire_name,questionnaire_date,userid FROM questionnaire WHERE is_delete=0")
        List<Questionnaire> selectallquestionnaire();
}
