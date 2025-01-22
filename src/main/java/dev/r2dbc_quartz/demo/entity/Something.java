package dev.r2dbc_quartz.demo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("something")
public record Something(
        @Id
        Long id
) {
}

