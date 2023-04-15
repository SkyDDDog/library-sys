package com.lear.service;

import com.lear.entity.LentInfo;
import com.lear.mapper.LentInfoMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * lent_info服务
 * @author 天狗
 */
@Slf4j
@Service
public class LentInfoService extends CrudService<LentInfoMapper, LentInfo> {


}
