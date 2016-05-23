package com.codechallenges.controller;

import com.codechallenges.service.TranslatorService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by colin.mills on 5/20/2016.
 */
@RestController
@RequestMapping("/")
public class TranslationController {

    @Resource
    TranslatorService translatorService;

    @RequestMapping(value = "/translate")
    public String translateText(String text){
        return translatorService.getTranslation(text);
    }
}
