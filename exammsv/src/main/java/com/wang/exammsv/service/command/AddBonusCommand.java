package com.wang.exammsv.service.command;

import com.wang.exammsv.domain.StudentExamResult;

import java.util.List;

public class AddBonusCommand implements GradeCommand {
    @Override
    public void execute(long examId, List<StudentExamResult> resultList) throws BreakChainException {

    }

    private String expression;

    public AddBonusCommand(String expression) {
        this.expression = expression;
    }
}
