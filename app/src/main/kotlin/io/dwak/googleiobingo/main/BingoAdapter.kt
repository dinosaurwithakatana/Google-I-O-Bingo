package io.dwak.googleiobingo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.dwak.googleiobingo
import java.util.ArrayList

public class BingoAdapter(val context : Context) : RecyclerView.Adapter<BingoEntryViewHolder>(){
    val list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BingoEntryViewHolder? {
        return BingoEntryViewHolder.Companion.create(context, parent)
    }

    override fun onBindViewHolder(holder: BingoEntryViewHolder?, position: Int) {
        BingoEntryViewHolder.Companion.bind(holder, list.get(position))
    }

    override fun getItemCount(): Int {
        return list.size()
    }
}