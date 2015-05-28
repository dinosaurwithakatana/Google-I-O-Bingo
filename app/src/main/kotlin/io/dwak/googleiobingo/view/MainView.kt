package io.dwak.googleiobingo.view

import io.dwak.googleiobingo.model.BingoEntry
import java.util.ArrayList

public trait MainView {
    fun displayBingo(bingoEntries : ArrayList<BingoEntry>)
}