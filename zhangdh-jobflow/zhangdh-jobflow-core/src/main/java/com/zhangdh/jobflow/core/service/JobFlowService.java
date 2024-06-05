package com.zhangdh.jobflow.core.service;

import org.flowable.engine.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * flowable 服务统一管理
 * @author yinshi
 * @date 2024/5/30
 * @apiNote
 */
@Service
public class JobFlowService {
    /**
     * 流程引擎
     */
    @Autowired
    public ProcessEngine processEngine;

    /**
     * 流程仓库服务类
     */
    @Autowired
    public RepositoryService repositoryService;

    /**
     * 查询运行信息
     */
    @Autowired
    public RuntimeService runtimeService;

    /**
     * 查询任务信息
     */
    @Autowired
    public TaskService taskService;

    /**
     * 查询历史信息
     */
    @Autowired
    public HistoryService historyService;
}
