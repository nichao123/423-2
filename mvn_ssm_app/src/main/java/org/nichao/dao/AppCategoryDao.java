package org.nichao.dao;

import org.nichao.pojo.AppCategory;

import java.util.List;

public interface AppCategoryDao {
    public List<AppCategory> firstGrade();
    public List<AppCategory> secondGrade(int parentId);
}
