package com.chlcn.controller;

import com.alibaba.fastjson.JSON;
import com.chlcn.dto.SensitiveWordDto;
import com.chlcn.param.AddSensitiveWordParam;
import com.chlcn.param.BaseResult;
import com.chlcn.service.ISensitiveService;
import com.chlcn.utils.BaseResultUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


/**
 * 敏感词controller
 */
@RestController
@RequestMapping("/sensitivewords")
@Slf4j
public class SensitiveWordsController {
    @Autowired
    private ISensitiveService sensitiveService;

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public BaseResult<Boolean> addWord(@RequestBody AddSensitiveWordParam param){
        try {
            log.info("增加敏感词-controller层-addWord-入参:{}", JSON.toJSONString(param));
            // 参数校验
            checkParam(param);
            SensitiveWordDto sensitiveWordDto = new SensitiveWordDto();
            sensitiveWordDto.setWord(param.getWord());
            sensitiveWordDto.setCategory(param.getCategory());
            // 敏感词落库
            int insert = sensitiveService.insert(sensitiveWordDto);
            log.info("增加敏感词-controller层-addWord-出参:{}", insert);
            return BaseResultUtils.generateSuccess(insert>0);
        }catch (Exception e){
            log.error("增加敏感词-controller层-addWord-异常:", e);
            return BaseResultUtils.generateFail("增加敏感词异常:"+e.getMessage());
        }
    }

    private void checkParam(AddSensitiveWordParam param) {
        Assert.isTrue(param!=null,"入参不允许为空");
        Assert.isTrue(StringUtils.isNoneBlank(param.getWord()),"敏感词不允许为空");
        Assert.isTrue(StringUtils.isNoneBlank(param.getCategory()),"类别不允许为空");
    }
}
