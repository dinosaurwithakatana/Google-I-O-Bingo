package io.dwak.googleiobingo.presenter

import io.dwak.googleiobingo.model.BingoEntry

public trait MainPresenter {
    fun getBingo(strings: Array<String>)
    fun toggleItemClick(bingoEntry : BingoEntry)
}