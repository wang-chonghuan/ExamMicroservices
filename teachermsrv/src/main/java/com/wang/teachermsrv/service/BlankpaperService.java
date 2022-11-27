package com.wang.teachermsrv.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.wang.teachermsrv.domain.Question;
import com.wang.teachermsrv.domain.dto.QuestionSetting;
import com.wang.teachermsrv.domain.dto.QuestionSettingsDTO;
import com.wang.teachermsrv.domain.event.BlankpaperEvent;
import com.wang.teachermsrv.repository.QuestionRepository;
import com.wang.teachermsrv.utils.AnyUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BlankpaperService {
    private final BlankpaperPublisher blankpaperPublisher;
    private final QuestionRepository questionRepository;
    public void createBlankpaper(QuestionSettingsDTO questionSettingsDTO) throws JsonProcessingException {

        List<QuestionDecorator> qdList = new ArrayList<>();

        for(QuestionSetting qs: questionSettingsDTO.getQuestionSettingList()) {
            Question q = questionRepository.findById(qs.getQuestionId()).get();
            QuestionDecorator qd = new QuestionDecorator(q, qs);
            qdList.add(qd);
        }

        Map<String, Object> qListJsonmap = QuestionDecorator.questionDecoratorListToJsonmap(
                qdList, QListTag.blank_question_list.name());
        // aString = anIntList.stream().map(String::valueOf).collect(Collectors.joining(","))
        BlankpaperEvent event = new BlankpaperEvent(
                questionSettingsDTO.getExamId(),
                AnyUtil.jsonmapToJsonstr(qListJsonmap));
        blankpaperPublisher.publish(event);
    }

    public enum QListTag {
        blank_question_list, answered_question_list, writing_question_list
    }
}