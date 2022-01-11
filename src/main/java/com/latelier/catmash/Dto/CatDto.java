package com.latelier.catmash.Dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CatDto {
    private String id;
    private String url;
    @Builder.Default
    private Integer score = 0;
}
