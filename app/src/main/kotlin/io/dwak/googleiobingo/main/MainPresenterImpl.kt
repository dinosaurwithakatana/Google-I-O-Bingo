package io.dwak.googleiobingo.main

import io.dwak.googleiobingo.presenter.MainPresenter
import io.dwak.googleiobingo.view.MainView
import io.dwak.meh.base.AbstractPresenter
import java.util.ArrayList
import java.util.Collections

public class MainPresenterImpl : AbstractPresenter<MainView>(), MainPresenter {
    val totalEntryCount = 23

    override fun generateBingo(strings: Array<out String>) {
        val numberOfValues = strings.size()
        var bingoRandomArrayList = ArrayList<Int>()

        for (i in 0..numberOfValues - 1) {
            bingoRandomArrayList.add(i)
        }

        Collections.shuffle(bingoRandomArrayList)

        var bingoEntries: ArrayList<String> = ArrayList()

        for (i in 0..totalEntryCount) {
            bingoEntries.add(strings.get(bingoRandomArrayList.get(i)))
        }

        bingoEntries.add(12, "Google I/O free space")
        view.displayBingo(bingoEntries)
    }
}