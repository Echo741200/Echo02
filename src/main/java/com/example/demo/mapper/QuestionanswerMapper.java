package com.example.demo.mapper;

import com.example.demo.entity.Questionanswer;
import io.swagger.models.auth.In;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface QuestionanswerMapper {

    @Insert({
            "<script>",
            "INSERT INTO questionanswer(user_ip,questionnaire_id,questionandoption_id,answer) values ",
            "<foreach collection='questionanswer' item='B' index='index' separator=','>",
            "(#{B.user_ip}, #{B.questionnaire_id}, #{B.questionandoption_id},#{B.answer})",
            "</foreach>",
            "</script>"
    })
    int addquestionanswer(@Param(value="questionanswer") List<Questionanswer> questionanswer) ;
}
