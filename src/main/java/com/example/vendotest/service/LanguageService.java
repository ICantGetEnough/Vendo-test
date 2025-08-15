package com.example.vendotest.service;

import com.example.vendotest.config.language.LanguageProperties;
import com.example.vendotest.domain.enums.Country;
import com.example.vendotest.domain.enums.Language;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LanguageService {
    private final LanguageProperties  languageProperties;

    public Language detectLanguageByCountry(Country country) {
        return languageProperties.getLanguageMapping().entrySet().stream()
                .filter(entry -> entry.getValue().contains(country.name()))
                .map(entry -> Language.valueOf(entry.getKey()))
                .findFirst()
                .orElse(Language.ENGLISH);
    }
}
