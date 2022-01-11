package com.latelier.catmash.controller;

import com.latelier.catmash.Dto.CatDto;
import com.latelier.catmash.service.CatService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/cats")
@Slf4j
public class CatController {
    @Autowired
    private CatService catService;

    @GetMapping("/list")
    public List<CatDto> getListCats(){
        log.info("Inside getListCats of CatController");
        return catService.getListCats();
    }

    @GetMapping("/score")
    public List<CatDto> getScore(){
        log.info("Inside getScore of CatController");
        return catService.getScore();
    }

    @PostMapping("/vote")
    public boolean vote(@RequestBody CatDto catDto){
        log.info("Inside vote of CatController");
        return catService.vote(catDto);
    }
}
