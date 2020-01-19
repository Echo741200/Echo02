package com.example.demo.mapper;

import com.example.demo.entity.Questionandoption;
import com.example.demo.entity.Questionanswer;
import com.example.demo.entity.Questionnaire;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.lang.reflect.Array;
import java.util.*;

@Repository
@Mapper
public interface QuestionandoptionMapper {
    //发布问卷，将获取的问题信息数组插入数据库
    @Insert({
            "<script>",
            "insert into questionandoption(questionnaire_id, question_number, question_content,option1,option2,option3,option4) values ",
            "<foreach collection='questionandoptionlist' item='q' index='index' separator=','>",
            "(#{q.questionnaire_id}, #{q.question_number}, #{q.question_content}, #{q.option1},#{q.option2},#{q.option3},#{q.option4} )",
            "</foreach>",
            "</script>"
    })
    int  addallquestionandoption(@Param(value = "questionandoptionlist") List<Questionandoption> questionandoptionList);


    //创建单个问题
    @Insert("INSERT INTO questionandoption(questionnaire_id,question_number,question_content,option1,option2,option3,option4)" +
            "VALUES(#{questionnaire_id},#{questionnaire_number},#{question_content},#{option1},#{option2},#{option3},#{option4}) ")
    Integer addonequestionandoption(Questionandoption questionandoption);
    @Select("SELECT * FROM questionandoption WHERE questionnaire_id=#{questionnaire_id} ")
    List<Questionandoption> selectparticularquestion(int questionnaire_id);
    

}
