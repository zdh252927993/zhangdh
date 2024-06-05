package com.zhangdh.jobflow.core;

import org.flowable.bpmn.model.BpmnModel;

public interface ModelValidator {

    /**
     * 检验整体bpmn模型
     *
     * @param model 模型
     * @return 错误
     */
    String validate(BpmnModel model);

    /**
     * 校验顺序
     *
     * @return 顺序
     */
    int order();
}
