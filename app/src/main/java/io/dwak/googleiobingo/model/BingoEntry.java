package io.dwak.googleiobingo.model;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

public class BingoEntry extends RealmObject{
    @PrimaryKey
    private String entryText;
    private boolean clicked;

    public BingoEntry() {
    }

    public BingoEntry(String entryText, boolean clicked) {
        this.entryText = entryText;
        this.clicked = clicked;
    }

    public String getEntryText() {
        return entryText;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    public void setEntryText(String entryText) {
        this.entryText = entryText;
    }
}
