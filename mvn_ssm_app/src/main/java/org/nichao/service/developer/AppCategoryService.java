package org.nichao.service.developer;

import org.nichao.pojo.AppCategory;

import java.util.List;

public interface AppCategoryService {
    public List<AppCategory> firstGrade();
    public List<AppCategory> secondGrade(int parentId);
}
