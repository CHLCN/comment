package com.chlcn.service.impl;

import com.chlcn.dao.TbSensitiveWordsDao;
import com.chlcn.dto.SensitiveWordDto;
import com.chlcn.entity.TbSensitiveWords;
import com.chlcn.entity.TbSensitiveWordsExample;
import com.chlcn.service.ISensitiveService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Slf4j
public class SensitiveServiceImpl implements ISensitiveService {
    @Autowired
    private TbSensitiveWordsDao tbSensitiveWordsDao;

    @Override
    public int insert(SensitiveWordDto sensitiveWordDto) {
        TbSensitiveWords tbSensitiveWords = new TbSensitiveWords();
        tbSensitiveWords.setWord(sensitiveWordDto.getWord());
        tbSensitiveWords.setCategory(sensitiveWordDto.getCategory());
        return tbSensitiveWordsDao.insertSelective(tbSensitiveWords);
    }

    @Override
    public List<SensitiveWordDto> queryByParam(TbSensitiveWordsExample tbSensitiveWordsExample) {
        List<TbSensitiveWords> tbSensitiveWords = tbSensitiveWordsDao.selectByExample(tbSensitiveWordsExample);
        if(CollectionUtils.isEmpty(tbSensitiveWords)){
            return new ArrayList<>();
        }
        List<SensitiveWordDto> resultList = buildSensitiveWordsDtos(tbSensitiveWords);
        return resultList;
    }

    /**
     * 结果集转换
     * @param tbSensitiveWords
     * @return
     */
    private List<SensitiveWordDto> buildSensitiveWordsDtos(List<TbSensitiveWords> tbSensitiveWords) {
        List<SensitiveWordDto> resultList = new ArrayList<>();
        for (int i =  0; i < tbSensitiveWords.size(); i++) {
            TbSensitiveWords tbSensitiveWord = tbSensitiveWords.get(i);
            if(tbSensitiveWords == null){
                continue;
            }
            SensitiveWordDto wordDto = new SensitiveWordDto();
            wordDto.setWord(tbSensitiveWord.getWord());
            wordDto.setCategory(tbSensitiveWord.getCategory());
            resultList.add(wordDto);
        }
        return resultList;
    }
}
