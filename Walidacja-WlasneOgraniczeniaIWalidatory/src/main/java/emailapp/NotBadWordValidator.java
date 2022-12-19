package emailapp;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;

public class NotBadWordValidator implements ConstraintValidator<NotBadWord, String> {
    private Lang[] languages;
    @Override
    public void initialize(NotBadWord constraintAnnotation) {
        this.languages = constraintAnnotation.lang();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        for (Lang lang : languages) {
            if (constainsBadWord(value, lang.getBadWords())){
                return false;
            }
        }
        return true;
    }

    private boolean constainsBadWord(String text, String[] badWords) {
        String lowerCaseText = text.toLowerCase();
        return Arrays.stream(badWords)
                .anyMatch(lowerCaseText::contains);

    }
}
