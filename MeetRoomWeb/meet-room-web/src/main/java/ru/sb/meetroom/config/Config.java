package ru.sb.meetroom.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = "ru.sb.meetroom")
@EnableJpaRepositories(basePackages = {"ru.sb.meetroom"})
@EntityScan("ru.sb.meetroom.model")
@EnableTransactionManagement
public class Config {
}
