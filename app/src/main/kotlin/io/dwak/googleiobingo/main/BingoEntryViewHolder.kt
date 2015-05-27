package io.dwak.googleiobingo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import io.dwak.googleiobingo.R
import kotlinx.android.anko.text

public class BingoEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bingoEntry: TextView by bindView(R.id.bingo_text)

    companion object {
        fun create(context: Context, parent: ViewGroup?): BingoEntryViewHolder {
            return BingoEntryViewHolder(LayoutInflater.from(context)
                                                .inflate(R.layout.item_bingo_entry, parent, false))
        }

        fun bind(holder: BingoEntryViewHolder?, entry: String?) {
            holder?.bingoEntry?.text = entry
        }
    }
}