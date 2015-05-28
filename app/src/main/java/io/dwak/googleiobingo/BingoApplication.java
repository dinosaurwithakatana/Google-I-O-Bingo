package io.dwak.googleiobingo;

import android.app.Application;

import io.realm.Realm;

public class BingoApplication extends Application {
    private static BingoApplication instance;
    public Realm realm;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;

        realm = Realm.getInstance(this);
    }

    public static BingoApplication getInstance(){
        return instance;
    }
}
