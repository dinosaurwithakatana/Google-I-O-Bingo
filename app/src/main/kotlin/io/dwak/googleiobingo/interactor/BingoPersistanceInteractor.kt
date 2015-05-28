package io.dwak.googleiobingo.interactor

import io.dwak.googleiobingo.model.BingoEntry
import java.util.ArrayList

public trait BingoPersistanceInteractor {
    fun getBingoEntries() : ArrayList<BingoEntry>
    fun saveBingoEntries(entries : ArrayList<BingoEntry>)
    fun createBingoEntry(entryText : String, clicked : Boolean) : BingoEntry
    fun toggleBingoClicked(bingoEntry : BingoEntry)
}