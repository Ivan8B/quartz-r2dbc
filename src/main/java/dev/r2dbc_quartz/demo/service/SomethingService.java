package dev.r2dbc_quartz.demo.service;

import dev.r2dbc_quartz.demo.entity.Something;
import dev.r2dbc_quartz.demo.repository.SomethingRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import reactor.core.publisher.Mono;

@Service
public class SomethingService {

    private final Logger logger = LoggerFactory.getLogger(SomethingService.class);
    private final SomethingRepository somethingRepository;

    public SomethingService(SomethingRepository somethingRepository) {
        this.somethingRepository = somethingRepository;
    }

    @Transactional
    public Mono<Something> doCreateSomething() {
        logger.info("Something created with id");
        Something something = new Something();
        somethingRepository.save(something);
    }

}
