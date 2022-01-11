package com.latelier.catmash.service;

import com.latelier.catmash.Dto.CatDto;
import com.latelier.catmash.Dto.CatList;
import com.latelier.catmash.entity.Cat;
import com.latelier.catmash.mapper.CatMapper;
import com.latelier.catmash.mapper.CatMapperImpl;
import com.latelier.catmash.repository.CatRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class CatService {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CatRepository catRepository;

    public List<CatDto> getListCats() {
        log.info("Inside getListCats of CatService");
        CatList cats = restTemplate.getForObject("https://latelier.co/data/cats.json", CatList.class);
        return cats.getImages();
    }


    public List<CatDto> getScore() {
        log.info("Inside getScore of CatService");
        List<Cat> cats = catRepository.findAll();
        CatMapper mapper = new CatMapperImpl();
        return mapper.toCatDto(cats);
    }

    public boolean vote(CatDto catDto) {
        if(catDto == null || catDto.getId() == null || catDto.getUrl() == null) throw new IllegalArgumentException("CatInfo not valid");
        Cat dbCat = catRepository.findByImageId(catDto.getId());
        if(dbCat != null){
            dbCat.setScore(dbCat.getScore() + 1);
            catRepository.save(dbCat);
        }
        if(dbCat == null) {
            Cat newCat = new Cat();
            newCat.setImageId(catDto.getId());
            newCat.setScore(1);
            newCat.setImageUrl(catDto.getUrl());
            catRepository.save(newCat);
        }
        return true;
    }
}
