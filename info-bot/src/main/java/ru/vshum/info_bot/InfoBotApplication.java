package ru.vshum.info_bot;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.info.BuildProperties;

@SpringBootApplication
@Slf4j
public class InfoBotApplication {

	public static void main(String[] args) {

        var context = SpringApplication.run(InfoBotApplication.class, args);
        BuildProperties buildProperties = context.getBean(BuildProperties.class);
        log.info("APP NAME - \"{}\", VERSION - \"{}\"", buildProperties.getName(), buildProperties.getVersion());
	}

}
