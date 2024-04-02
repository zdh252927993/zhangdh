package com.zhangdh.storage.core.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhangdh
 * @since 2024-04-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("zhangdh_storage")
@ApiModel(value="StorageEntity对象", description="")
public class StorageEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String commodityCode;

    private Integer count;

    @ApiModelProperty(value = "创建人")
    private String createBy;

    @ApiModelProperty(value = "更新人")
    private String updateBy;

    @ApiModelProperty(value = "创建时间")
    private LocalDateTime createTime;

    @ApiModelProperty(value = "更新时间")
    private LocalDateTime updateTime;


}
