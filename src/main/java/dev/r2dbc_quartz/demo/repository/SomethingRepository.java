package dev.r2dbc_quartz.demo.repository;

import dev.r2dbc_quartz.demo.entity.Something;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Mono;

public interface SomethingRepository extends R2dbcRepository<Something, Long> {
    Mono<Something> findById(Long id);
}
