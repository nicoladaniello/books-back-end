package io.githgub.nicoladaniello.books.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Locale;

/**
 * Helper to simplify accessing i18n messages in code.
 */
@Component
public class Messages {
    private final MessageSourceAccessor accessor;

    @Autowired
    public Messages(MessageSource messageSource) {
        this.accessor = new MessageSourceAccessor(messageSource, Locale.getDefault());
    }

    public String get(String code) {
        return accessor.getMessage(code);
    }
}