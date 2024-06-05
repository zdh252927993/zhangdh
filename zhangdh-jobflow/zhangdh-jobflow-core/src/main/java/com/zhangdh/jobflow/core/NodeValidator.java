package com.zhangdh.jobflow.core;

import org.flowable.bpmn.model.FlowNode;
import java.lang.reflect.ParameterizedType;

public interface NodeValidator<T extends FlowNode> {

    /**
     * 获取泛型具体类型
     *
     * @return 泛型类型
     */
    default Class<T> getTClass() {
        return (Class<T>) ((ParameterizedType) getClass().getGenericInterfaces()[0]).getActualTypeArguments()[0];
    }

    /**
     * 验证bpmn中的节点
     *
     * @param node 节点元素
     * @return 错误信息；没有返回null
     */
    String validate(T node);
}
