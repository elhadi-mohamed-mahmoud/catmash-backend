package com.latelier.catmash.mapper;

import com.latelier.catmash.Dto.CatDto;
import com.latelier.catmash.entity.Cat;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CatMapper {
    @Mappings({
            @Mapping(target="id", source="imageId"),
            @Mapping(target="url", source="imageUrl")
    })
    CatDto toCatDto(Cat cat);

    List<CatDto> toCatDto(List<Cat> cats);
}
