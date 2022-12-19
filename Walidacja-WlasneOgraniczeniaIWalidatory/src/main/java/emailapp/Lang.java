package emailapp;

import lombok.Getter;

@Getter
public enum Lang {
    PL(new String[]{"kurka","cholerka"}),
    EN(new String[]{"fak"});

    private final String [] badWords;

    Lang(String[] badWords) {
        this.badWords = badWords;
    }
}
