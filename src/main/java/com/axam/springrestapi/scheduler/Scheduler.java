package com.axam.springrestapi.scheduler;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class Scheduler {

    @Scheduled(cron = "60 * * * * *")
    public void statistiques(){
        log.info("Method with cron expression");
    }
}
