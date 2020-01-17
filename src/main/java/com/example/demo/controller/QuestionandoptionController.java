package com.example.demo.controller;

import com.example.demo.entity.Questionandoption;
import com.example.demo.entity.Result;
import com.example.demo.service.QuestionandoptionService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api(tags = "题目接口")
@CrossOrigin
@RestController
@RequestMapping("/questionandoption/")
public class QuestionandoptionController {
    @Autowired
                QuestionandoptionService questionandoptionService;
        @ApiOperation(value = "创建题目",httpMethod ="POST",notes = "")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "questionnaire_id",value = "问卷id",required = true),
                @ApiImplicitParam(name="")
        })
        @PostMapping("add")
        public Result addquestionandoption(@RequestBody Questionandoption questionandoption){
            return Result.ok("创建成功！",questionandoptionService.addquestionandoption(questionandoption));
    }

}
