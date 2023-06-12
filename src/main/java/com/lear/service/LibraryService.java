package com.lear.service;

import com.lear.entity.Library;
import com.lear.mapper.LibraryMapper;
import com.lear.service.base.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 天狗
 */
@Service
public class LibraryService extends CrudService<LibraryMapper, Library> {

    @Autowired
    private LibraryMapper libraryMapper;

    public int bookStateChange(String entityId) {
        Library library = this.get(entityId);
        if (library==null) {
            return 0;
        }
        library.setLentFlag(Library.NOT_LENT.equals(library.getLentFlag())?Library.LENT:Library.NOT_LENT);
        return this.save(library);
    }

    public Integer getBookCount(String bookId) {
        return libraryMapper.getBookCount(bookId);
    }

    public Boolean isLent(String entityId) {
        return Library.LENT.equals(this.get(entityId).getLentFlag());
    }

}
