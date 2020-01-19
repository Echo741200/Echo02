package com.example.demo.service;
import com.example.demo.entity.Questionandoption;
import com.example.demo.entity.Questionnaire;
import com.example.demo.mapper.QuestionandoptionMapper;
import com.example.demo.mapper.QuestionnaireMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class QuestionnaireService {
    @Autowired
    QuestionnaireMapper questionnaireMapper;
    @Autowired
    QuestionandoptionMapper questionandoptionMapper;
    public  Integer addquestionnaire(Questionnaire questionnaire){
        questionnaire.setQuestionnaire_date(new Date()); //自动生成发布问卷的时间
        if(questionnaireMapper.addquestionnaire(questionnaire)!=0){      //发布问卷成功
            if(questionandoptionMapper.addallquestionandoption(questionnaire.questionandoptionList)!=0) {  //发布问题(问卷不能没有问题)
                return questionandoptionMapper.addallquestionandoption(questionnaire.questionandoptionList);
            }
                else{
                    return 0;  //返回0，表示发布问卷失败
                }

            }

        return 0;  //返回0，表示发布问卷失败
    }
    public Integer deletequestionnaire(int questionnaire_id){
        return questionnaireMapper.deletequestionnaire(questionnaire_id);
    }
    public List<Questionnaire> selectmyquestionniare(int id){

        return questionnaireMapper.selectmyquestionnaire(id);
    }
    public List<Questionnaire> selectallquestionniare(){
        return questionnaireMapper.selectallquestionnaire();
    }
    public List<Questionandoption> selectparticularquestion(int questionnaire_id){
        return questionandoptionMapper.selectparticularquestion(questionnaire_id);
    }
}
