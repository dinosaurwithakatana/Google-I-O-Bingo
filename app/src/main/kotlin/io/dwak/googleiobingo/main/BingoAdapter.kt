package io.dwak.googleiobingo.main

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import io.dwak.googleiobingo.model.BingoEntry
import java.util.ArrayList

public class BingoAdapter(val context: Context) : RecyclerView.Adapter<BingoEntryViewHolder>() {

    val list = ArrayList<BingoEntry>()
    var itemClickListener : BingoAdapterItemClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): BingoEntryViewHolder? {
        return BingoEntryViewHolder.Companion.create(context, parent)
    }

    override fun onBindViewHolder(holder: BingoEntryViewHolder?, position: Int) {
        BingoEntryViewHolder.Companion.bind(context, holder, position, list.get(position), itemClickListener)
    }

    override fun getItemCount(): Int {
        return list.size()
    }

    fun toggleItemClick(position : Int){
        notifyItemChanged(position)
    }

    companion object {
        public trait BingoAdapterItemClickListener {
            fun onItemClick(position: Int)
        }
    }
}