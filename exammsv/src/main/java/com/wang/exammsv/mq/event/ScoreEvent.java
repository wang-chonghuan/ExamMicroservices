package com.wang.exammsv.mq.event;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ScoreEvent {
    private List<Score> scoreList;
}
