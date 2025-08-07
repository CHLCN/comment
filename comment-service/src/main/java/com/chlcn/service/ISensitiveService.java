package com.chlcn.service;

import com.chlcn.dto.SensitiveWordDto;
import com.chlcn.entity.TbSensitiveWordsExample;


import java.util.List;

/**
 * 敏感词过滤-service
 * @Date：2024/7/16 14:44
 */
public interface ISensitiveService {

    int insert(SensitiveWordDto sensitiveWordDto);

    List<SensitiveWordDto> queryByParam(TbSensitiveWordsExample sensitiveWordsExample);
}