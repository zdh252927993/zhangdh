package com.zhangdh.jobflow.core;

import lombok.extern.slf4j.Slf4j;
import org.flowable.bpmn.model.BpmnModel;
import org.flowable.bpmn.model.FlowElement;
import org.flowable.bpmn.model.FlowNode;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import javax.xml.stream.XMLStreamException;
import java.io.ByteArrayInputStream;
import java.nio.charset.StandardCharsets;
import java.util.*;

@Slf4j
@Component
public class BpmnValidator implements ApplicationContextAware {

    private List<ModelValidator> modelValidators = new LinkedList<>();
    private Map<Class<FlowNode>, NodeValidator> nodeValidators = new HashMap<>();


    public String validate(String bpmnXml) {
        BpmnModel model;
        try {
            model = BpmnConverter.convert2Model(new ByteArrayInputStream(bpmnXml.getBytes(StandardCharsets.UTF_8)));
        } catch (XMLStreamException e) {
            log.error("错误的bpmn xml文件。", e);
            return e.getMessage();
        }
        for (ModelValidator modelValidator : modelValidators) {
            String error = modelValidator.validate(model);
            if (null != error) {
                return error;
            }
        }
        for (FlowElement flowElement : model.getMainProcess().getFlowElements()) {
            NodeValidator nodeValidator = nodeValidators.get(flowElement.getClass());
            if (null != nodeValidator) {
                String error = nodeValidator.validate((FlowNode) flowElement);
                if (null != error) {
                    return error;
                }
            }
        }
        return null;
    }

    @Override
    public void setApplicationContext(ApplicationContext ctx) throws BeansException {
        Collection<NodeValidator> values = ctx.getBeansOfType(NodeValidator.class).values();
        for (NodeValidator value : values) {
            nodeValidators.put(value.getTClass(), value);
        }
        modelValidators.addAll(ctx.getBeansOfType(ModelValidator.class).values());
        modelValidators.sort(Comparator.comparingInt(ModelValidator::order));
    }
}
