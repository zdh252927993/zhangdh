package com.zhangdh.jobflow.controller;

import com.alibaba.fastjson2.util.IOUtils;
import com.zhangdh.jobflow.facade.api.IStaffLeaveApproveService;
import com.zhangdh.jobflow.facade.pojo.ApproveInfoBO;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

/**
 * @author yinshi
 * @date 2024/5/31
 * @apiNote
 */
@RestController
@RequestMapping("/staff_leave")
public class StaffLeaveApproveController {

    @Resource
    private IStaffLeaveApproveService iStaffLeaveApproveService;

    /**
     * 休假申请
     */
    @PostMapping("/approve")
    public String approve(@RequestBody ApproveInfoBO approveInfoBO) {
        return iStaffLeaveApproveService.approve(approveInfoBO);
    }

    /**
     * 返回流程图
     *
     * @param processId
     * @throws Exception
     */
    @GetMapping("/genProcessDiagram/{processId}")
    public void genProcessDiagram(HttpServletResponse response, @PathVariable("processId") String processId) throws Exception {
        byte[] bytes = iStaffLeaveApproveService.genProcessDiagram(processId);
        ServletOutputStream outputStream = response.getOutputStream();
        try {
            outputStream.write(bytes);
            response.flushBuffer();
        } finally {
            IOUtils.close(outputStream);
        }
    }
}