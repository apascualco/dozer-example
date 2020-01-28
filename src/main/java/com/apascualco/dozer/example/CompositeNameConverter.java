package com.apascualco.dozer.example;

import com.apascualco.dozer.example.domain.Form;
import org.dozer.CustomConverter;

public class CompositeNameConverter implements CustomConverter {

    @Override
    public Object convert(
            final Object destination,
            final Object source,
            final Class destinationClass,
            final Class sourceClass) {
        final Form form = (Form) source;
        return form.getName() + " " +form.getSurname();
    }
}
