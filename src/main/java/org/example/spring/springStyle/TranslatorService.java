package org.example.spring.springStyle;

import org.springframework.stereotype.Component;

@Component
public class TranslatorService {




    public String translate(String word){
        if ("book".equals(word)){
            return "kniga";
        }
        if ("car".equals(word)){
            return "mashina";
        }
        return "";
    }
}
