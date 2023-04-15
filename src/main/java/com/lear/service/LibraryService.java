package com.lear.service;

import com.lear.entity.Library;
import com.lear.mapper.LibraryMapper;
import com.lear.service.base.CrudService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * library服务
 * @author 天狗
 */
@Slf4j
@Service
public class LibraryService extends CrudService<LibraryMapper, Library> {


}
