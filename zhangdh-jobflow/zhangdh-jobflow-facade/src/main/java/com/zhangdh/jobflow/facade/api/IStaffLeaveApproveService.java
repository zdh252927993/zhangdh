package com.zhangdh.jobflow.facade.api;

import com.zhangdh.jobflow.facade.pojo.ApproveInfoBO; /**
 * @author yinshi
 * @date 2024/5/31
 * @apiNote
 */
public interface IStaffLeaveApproveService {

    /**
     * 休假申请
     */
    String approve(ApproveInfoBO approveInfoBO);

    /**
     * 获取流程图
     * @param processId
     */
    byte[] genProcessDiagram(String processId) throws Exception;

}
