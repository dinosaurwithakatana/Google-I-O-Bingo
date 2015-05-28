package io.dwak.googleiobingo.main

import io.dwak.googleiobingo.BingoApplication
import io.dwak.googleiobingo.interactor.BingoPersistanceInteractor
import io.dwak.googleiobingo.model.BingoEntry
import io.realm.Realm
import java.util.ArrayList

public class BingoRealmInteractor : BingoPersistanceInteractor {
    override fun clearBingoEntries() {
        val realm = BingoApplication.getInstance().realm
        var results = realm.where(javaClass<BingoEntry>()).findAll()

        realm.beginTransaction()
        results.clear()
        realm.commitTransaction()
    }

    override fun toggleBingoClicked(bingoEntry: BingoEntry) {
        BingoApplication.getInstance().realm.executeTransaction(object : Realm.Transaction {
            override fun execute(realm: Realm?) {
                bingoEntry.setClicked(!bingoEntry.isClicked())
            }
        })
    }

    override fun getBingoEntries(): ArrayList<BingoEntry> {
        var result = BingoApplication.getInstance().realm
                .where(javaClass<BingoEntry>())
                .findAll()
        return result.toArrayList()
    }

    override fun createBingoEntry(entryText: String, clicked: Boolean): BingoEntry {
        BingoApplication.getInstance().realm.beginTransaction()
        var bingoEntry = BingoApplication.getInstance().realm.createObject(javaClass<BingoEntry>())
        bingoEntry.setEntryText(entryText)
        bingoEntry.setClicked(clicked)
        BingoApplication.getInstance().realm.commitTransaction()

        return bingoEntry
    }

    override fun saveBingoEntries(entries: ArrayList<BingoEntry>) {
        BingoApplication.getInstance().realm.beginTransaction()

        BingoApplication.getInstance().realm.commitTransaction()
    }
}