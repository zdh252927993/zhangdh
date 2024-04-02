package com.zhangdh.storage.core.manager.impl;

import com.zhangdh.storage.core.entity.StorageEntity;
import com.zhangdh.storage.core.mapper.StorageMapper;
import com.zhangdh.storage.core.manager.StorageManager;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author zhangdh
 * @since 2024-04-01
 */
@Service
public class StorageManagerImpl extends ServiceImpl<StorageMapper, StorageEntity> implements StorageManager {

}
