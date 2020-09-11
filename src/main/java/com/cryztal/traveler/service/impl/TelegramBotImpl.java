package com.cryztal.traveler.service.impl;

import com.cryztal.traveler.domain.dto.AnswerDto;
import com.cryztal.traveler.domain.dto.CityDto;
import com.cryztal.traveler.service.CityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Random;

public class TelegramBotImpl extends TelegramLongPollingBot {
    private final static String botUserName = "TravelerRestBot";
    private final static String botToken = "1385355810:AAHdKKCWpCBnZ_J-_gRQIBKwtuRcT-3J2D8";
    private static final Logger logger = LoggerFactory.getLogger(TelegramBotImpl.class);

    private CityService cityService;

    @Autowired
    public TelegramBotImpl(CityService cityService) {
        this.cityService = cityService;
    }


    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String messageText = update.getMessage().getText();
            Long chatId = update.getMessage().getChatId();

            SendMessage message;

            if (messageText.equals("/start")) {
                message = new SendMessage()
                        .setChatId(chatId)
                        .setText("Привет. Отправь мне название города в котором хочешь побывать)");
            } else {
                String phrase = getPhraseByCityName(messageText);
                message = new SendMessage()
                        .setChatId(chatId)
                        .setText(phrase);
            }
            try {
                execute(message);
            } catch (TelegramApiException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String getBotUsername() {
        return botUserName;
    }

    @Override
    public String getBotToken() {
        return botToken;
    }

    private String getAnswer(List<AnswerDto> answerDto) {
        return answerDto.get(new Random().nextInt(answerDto.size())).getAnswer();
    }

    private String getPhraseByCityName(String cityName) {
        CityDto cityDto = cityService.findByCityName(cityName);
        if (cityDto.getAnswerDto().size() > 0)
            return getAnswer(cityDto.getAnswerDto());
        else return "Не бывал здесь :)";
    }

    @PostConstruct
    public void start() {
        logger.info("username: {}, token: {}", botUserName, botToken);
    }
}
