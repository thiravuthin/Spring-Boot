package com.example.springboot.common.domain;

import com.example.springboot.utils.DateTimeUtils;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.generator.BeforeExecutionGenerator;
import org.hibernate.generator.EventType;

import java.util.EnumSet;

/**
 *  This class is used to generate date time for entity
 *  that extends {@link BeforeExecutionGenerator}
 */
public class DateTimeGeneration implements BeforeExecutionGenerator {
    private final EventType eventTypes;

    public DateTimeGeneration(GeneratedDateTime annotation) {
        eventTypes = annotation.timing();
    }

    @Override
    public Object generate(SharedSessionContractImplementor session, Object owner, Object currentValue, EventType eventType) {
        return DateTimeUtils.ictNow().format(DateTimeUtils.VA_FORMATTER_DTM14);
    }

    @Override
    public EnumSet<EventType> getEventTypes() {
        return EnumSet.of(eventTypes);
    }
}