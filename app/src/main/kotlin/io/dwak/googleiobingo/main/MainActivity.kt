package io.dwak.googleiobingo.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import butterknife.bindView
import io.dwak.googleiobingo.*
import io.dwak.googleiobingo.view.MainView
import io.dwak.meh.base.MvpActivity
import java.util.ArrayList

class MainActivity : MvpActivity<MainPresenterImpl>(), MainView {
    override val presenterClass: Class<MainPresenterImpl> = javaClass()
    val recyclerView : RecyclerView by bindView(R.id.recycler_view)
    val layoutManager = GridLayoutManager(this, 5)
    val adapter = BingoAdapter(this)

    override fun setView() {
        presenter.view = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<MvpActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST))

        presenter.generateBingo(getResources().getStringArray(R.array.bingo_entries))
    }

    override fun displayBingo(bingoEntries: ArrayList<String>) {
        Log.d("wodihw", bingoEntries.toString())
        adapter.list.addAll(bingoEntries)
    }

}