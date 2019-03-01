package ru.sb.MeetRoomBot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.telegram.telegrambots.ApiContextInitializer;

@SpringBootApplication
public class MeetRoomBotApplication {

	public static void main(String[] args) {
		ApiContextInitializer.init();
		SpringApplication.run(MeetRoomBotApplication.class, args);
	}

}
