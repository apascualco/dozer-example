package com.apascualco.dozer.example;

import com.apascualco.dozer.example.domain.Form;
import org.dozer.ConfigurableCustomConverter;
import org.dozer.CustomConverter;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class YearsConverter implements ConfigurableCustomConverter {

    private LocalDate to;

    @Override
    public void setParameter(final String param) {
        this.to = LocalDate.parse(param);
    }

    @Override
    public Object convert(
            final Object destination,
            final Object source,
            final Class destinationClass,
            final Class sourceClass) {
        final Form form = (Form) source;
        return (int)ChronoUnit.YEARS.between(form.getBirthday(), to);
    }
}
