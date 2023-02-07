package org.east.laugh.app.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.east.laugh.app.domain.Blog;

import java.util.List;

@Mapper
public interface BlogMapper {
    //public all
    List<Blog> SelectBlogsByUid(@Param("uid")int value);

    void Insert(Blog blog);
}
