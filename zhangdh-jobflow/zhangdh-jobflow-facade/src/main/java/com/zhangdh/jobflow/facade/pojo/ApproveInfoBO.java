package com.zhangdh.jobflow.facade.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author yinshi
 * @date 2024/5/31
 * @apiNote
 */
@Data
public class ApproveInfoBO implements Serializable {

    private String name;

    private Date startTime;

    private Date endTime;

    private String remarks;

}
