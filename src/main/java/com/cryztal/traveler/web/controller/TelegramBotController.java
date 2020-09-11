package com.cryztal.traveler.web.controller;

import com.cryztal.traveler.service.CityService;
import com.cryztal.traveler.service.impl.TelegramBotImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@RestController
public class TelegramBotController {

    @Autowired
    private CityService cityService;

    @Autowired
    public void telegramBotInit() {
        ApiContextInitializer.init();
        TelegramBotsApi botApi = new TelegramBotsApi();
        try {
            botApi.registerBot(new TelegramBotImpl(cityService));
        } catch (TelegramApiException e) {
            e.printStackTrace();
        }
    }
}
