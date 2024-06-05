package com.zhangdh.jobflow.core.service;

import com.alibaba.fastjson2.util.IOUtils;
import com.zhangdh.jobflow.facade.api.IStaffLeaveApproveService;
import com.zhangdh.jobflow.facade.pojo.ApproveInfoBO;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.engine.ProcessEngineConfiguration;
import org.flowable.engine.runtime.Execution;
import org.flowable.engine.runtime.ProcessInstance;
import org.flowable.image.ProcessDiagramGenerator;
import org.flowable.task.api.Task;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.*;

/**
 * @author yinshi
 * @date 2024/5/31
 * @apiNote
 */
@Service
public class StaffLeaveApproveServiceImpl extends JobFlowService implements IStaffLeaveApproveService {

    @Override
    public String approve(ApproveInfoBO approveInfoBO) {
        //数据的id（假设这是申请数据的id）
        String id = UUID.randomUUID().toString().replaceAll("-", "");
        //放入流程中的数据
        Map<String, Object> variables = new HashMap<>();
        variables.put("status", 1);
        variables.put("data", approveInfoBO);
        //启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("staff_leave", id, variables);
        String processInstanceId = processInstance.getId();
        System.out.println("流程启动id是：" + processInstanceId);
        return id;
    }

    /**
     * 返回流程图
     *
     * @param processId
     */
    @Override
    public byte[] genProcessDiagram(String processId) throws Exception {
        ProcessInstance pi = runtimeService.createProcessInstanceQuery().processInstanceId(processId).singleResult();
        //流程走完的不显示图
        if (pi == null) {
            return null;
        }
        Task task = taskService.createTaskQuery().processInstanceId(pi.getId()).singleResult();
        //使用流程实例ID，查询正在执行的执行对象表，返回流程实例对象
        String InstanceId = task.getProcessInstanceId();
        List<Execution> executions = runtimeService
                .createExecutionQuery()
                .processInstanceId(InstanceId)
                .list();

        //得到正在执行的Activity的Id
        List<String> activityIds = new ArrayList<>();
        List<String> flows = new ArrayList<>();
        for (Execution exe : executions) {
            List<String> ids = runtimeService.getActiveActivityIds(exe.getId());
            activityIds.addAll(ids);
        }

        //获取流程图
        BpmnModel bpmnModel = repositoryService.getBpmnModel(pi.getProcessDefinitionId());
        ProcessEngineConfiguration engconf = processEngine.getProcessEngineConfiguration();
        ProcessDiagramGenerator diagramGenerator = engconf.getProcessDiagramGenerator();
        InputStream in = diagramGenerator.generateDiagram(bpmnModel, "png", activityIds, flows, engconf.getActivityFontName(), engconf.getLabelFontName(), engconf.getAnnotationFontName(), engconf.getClassLoader(), 1.0, true);
        try {
            return readInputStream(in);
        } finally {
            IOUtils.close(in);
        }
    }

    public void create(){

    }

    private byte[] readInputStream(InputStream inputStream) throws IOException {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[4096];
        int bytesRead;

        while ((bytesRead = inputStream.read(buffer)) != -1) {
            outputStream.write(buffer, 0, bytesRead);
        }

        return outputStream.toByteArray();
    }

}
