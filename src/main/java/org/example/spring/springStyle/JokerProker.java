package org.example.spring.springStyle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("joker")
@Scope("singleton")
public class JokerProker {

    @Autowired
    TranslatorService translatorService;


    public  String sayHello(){
        String book = translatorService.translate("book");
        return book;
    }
}
