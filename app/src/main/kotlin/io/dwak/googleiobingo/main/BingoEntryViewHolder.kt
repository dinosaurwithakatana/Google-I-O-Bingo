package io.dwak.googleiobingo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import butterknife.bindView
import io.dwak.googleiobingo.R
import io.dwak.googleiobingo.model.BingoEntry
import kotlinx.android.anko.backgroundColor
import kotlinx.android.anko.onClick
import kotlinx.android.anko.text
import kotlinx.android.anko.textColor

public class BingoEntryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val bingoEntry: TextView by bindView(R.id.bingo_text)

    companion object {
        fun create(context: Context, parent: ViewGroup?): BingoEntryViewHolder {
            return BingoEntryViewHolder(LayoutInflater.from(context)
                                                .inflate(R.layout.item_bingo_entry, parent, false))
        }

        fun bind(context: Context,
                 holder: BingoEntryViewHolder?,
                 position: Int,
                 entry: BingoEntry, bingoAdapterItemClickListener: BingoAdapter.Companion.BingoAdapterItemClickListener?) {

            holder?.bingoEntry?.text = entry.getEntryText()
            holder?.itemView?.onClick { bingoAdapterItemClickListener?.onItemClick(position) }

            if(entry.isClicked()){
                holder?.itemView?.backgroundColor = context.getResources().getColor(R.color.primary)
                holder?.bingoEntry?.textColor= context.getResources().getColor(R.color.icons)
            }
            else {
                holder?.itemView?.backgroundColor = context.getResources().getColor(R.color.icons)
                holder?.bingoEntry?.textColor= context.getResources().getColor(android.R.color.black)
            }
        }
    }
}