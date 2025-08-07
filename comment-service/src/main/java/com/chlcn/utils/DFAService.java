package com.chlcn.utils;

import com.chlcn.dto.SensitiveWordDto;
import com.chlcn.entity.TbSensitiveWordsExample;
import com.chlcn.service.ISensitiveService;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 构建DFA敏感词过滤算法
 */
@Service
@Slf4j
public class DFAService implements InitializingBean {
    @Autowired
    private ISensitiveService sensitiveService;

    private final State startState = new State();
    @Override
    public void afterPropertiesSet() throws Exception {
        // 1. 从数据库查询敏感词
        TbSensitiveWordsExample tbSensitiveWordsExample = new TbSensitiveWordsExample();
        tbSensitiveWordsExample.setLimit(1000);
        List<SensitiveWordDto> sensitiveWordDtos = sensitiveService.queryByParam(tbSensitiveWordsExample);
        // 构建敏感词算法-DFA
        List<String> words = sensitiveWordDtos.stream().map(x -> x.getWord()).collect(Collectors.toList());
        addWords(words);
    }

    /**
     * 批量构建
     * @param words
     */
    private void addWords(List<String> words) {
        if(CollectionUtils.isEmpty(words)){
            return;
        }
        for(String word : words){
            addWord(word);
        }
    }

    /**
     * 单个构建
     * @param word
     */
    private void addWord(String word) {
        log.info("DFAService-添加敏感词-入参:{}",word);
        State currentState = startState;
        char[] charArray = word.toCharArray();
        for (char c : charArray) {
            State nextState = currentState.nextState(c);
            if(nextState == null){
                nextState = new State();
                currentState.add(c, nextState);
            }
            currentState = nextState;
        }
        currentState.setTerminal(true);
    }
    /**
     * 敏感词的匹配
     * 逻辑：如果匹配到敏感词，把敏感词替换为* 未匹配则返回原值
     */
    public String checkSensitiveWord(String word, char replacement){
        if(StringUtils.isBlank(word)){
            return word;
        }
        // 结果集
        StringBuilder result = new StringBuilder(word);
        int length = word.length();
        for(int i = 0; i < length;){
            State currentState = startState;
            int j = i;
            while(j<length && currentState != null){
                currentState = currentState.nextState(word.charAt(j));
                if(currentState != null && currentState.isTerminal()){
                    // 替换敏感词
                    for(int k=i;k<=j;k++){
                        result.setCharAt(k,replacement);
                    }
                    i = j+1;
                    break;
                }
                j++;
            }
            if(currentState == null){
                i++;
            }
        }
        return result.toString();
    }

    private static class State{
        private final Map<Character, State> transition = new HashMap<>();

        @Getter
        @Setter
        private boolean isTerminal = false;

        public State nextState(char c){
            return transition.getOrDefault(c,null);
        }

        public void add(char c, State nextState){
            transition.put(c, nextState);
        }

    }
}
