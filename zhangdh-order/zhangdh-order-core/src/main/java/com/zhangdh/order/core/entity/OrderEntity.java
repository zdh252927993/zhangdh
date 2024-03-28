package com.zhangdh.order.core.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 订单
 * </p>
 *
 * @author zhangdh
 * @since 2024-03-27
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("order")
@ApiModel(value = "OrderEntity对象", description = "订单")
public class OrderEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "主键")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @ApiModelProperty(value = "用户id")
    @TableField("user_id")
    private String userId;

    @ApiModelProperty(value = "产品code")
    @TableField("commodity_code")
    private String commodityCode;

    @ApiModelProperty(value = "数量")
    private Integer count;

    @ApiModelProperty(value = "金额")
    private Integer money;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
