package com.musicflux.movieflix.mapper;

import com.musicflux.movieflix.controller.request.CategoryRequest;
import com.musicflux.movieflix.controller.response.CategoryResponse;
import com.musicflux.movieflix.model.Category;
import lombok.experimental.UtilityClass;

@UtilityClass
public class CategoryMapper {

    public static Category toCategory(CategoryRequest categoryRequest) {
        return Category
                .builder()
                .name(categoryRequest.name())
                .build();
    }

    public static CategoryResponse toCategoryResponse(Category category) {
        return CategoryResponse
                .builder()
                .id(category.getId())
                .name(category.getName())
                .build();
    }
}
