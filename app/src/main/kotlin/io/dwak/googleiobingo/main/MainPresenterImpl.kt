package io.dwak.googleiobingo.main

import io.dwak.googleiobingo.interactor.BingoPersistanceInteractor
import io.dwak.googleiobingo.model.BingoEntry
import io.dwak.googleiobingo.presenter.MainPresenter
import io.dwak.googleiobingo.view.MainView
import io.dwak.meh.base.AbstractPresenter
import java.util.ArrayList
import java.util.Collections

public class MainPresenterImpl : AbstractPresenter<MainView>(), MainPresenter {
    val totalEntryCount = 25
    var bingoEntryList: ArrayList<BingoEntry>? = null
    val persistenceInteractor: BingoPersistanceInteractor = BingoRealmInteractor()

    override fun toggleItemClick(bingoEntry : BingoEntry) {
        persistenceInteractor.toggleBingoClicked(bingoEntry)
    }

    override fun getBingo(strings: Array<String>) {
        if (bingoEntryList == null) {
            bingoEntryList = persistenceInteractor.getBingoEntries()
        }

        if (bingoEntryList == null || bingoEntryList!!.isEmpty()) {
            bingoEntryList = generateBingo(strings)
        }

        view.displayBingo(bingoEntryList!!)
    }

    fun generateBingo(strings: Array<String>): ArrayList<BingoEntry> {
        val numberOfValues = strings.size()
        var bingoRandomArrayList = ArrayList<Int>()

        for (i in 0..numberOfValues - 1) {
            bingoRandomArrayList.add(i)
        }

        Collections.shuffle(bingoRandomArrayList)

        var bingoEntries: ArrayList<BingoEntry> = ArrayList()

        for (i in 0..totalEntryCount -1 ) {
            if(i == 12){
                var bingoEntry = persistenceInteractor.createBingoEntry("Google I/O free space", true)
                bingoEntries.add(bingoEntry)
            }
            else {
                var bingoEntry = persistenceInteractor.createBingoEntry(strings.get(bingoRandomArrayList.get(i)), false)
                bingoEntries.add(bingoEntry)
            }
        }


        return bingoEntries
    }
}