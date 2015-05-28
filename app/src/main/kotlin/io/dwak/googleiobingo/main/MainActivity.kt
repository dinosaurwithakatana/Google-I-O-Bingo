package io.dwak.googleiobingo.main

import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import butterknife.bindView
import io.dwak.googleiobingo.R
import io.dwak.googleiobingo.adapter
import io.dwak.googleiobingo.layoutManager
import io.dwak.googleiobingo.model.BingoEntry
import io.dwak.googleiobingo.view.MainView
import io.dwak.meh.base.MvpActivity
import kotlinx.android.anko.AnkoLogger
import kotlinx.android.anko.alert
import java.util.ArrayList

class MainActivity : MvpActivity<MainPresenterImpl>(), MainView, AnkoLogger {
    override val presenterClass: Class<MainPresenterImpl> = javaClass()

    val toolbar: Toolbar by bindView(R.id.toolbar)
    val recyclerView: RecyclerView by bindView(R.id.recycler_view)
    val layoutManager = GridLayoutManager(this, 5)
    var adapter = BingoAdapter(this)

    override fun setView() {
        presenter.view = this
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super<MvpActivity>.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setSupportActionBar(toolbar)

        var onItemClickListener = object : BingoAdapter.Companion.BingoAdapterItemClickListener {
            override fun onItemClick(position: Int) {
                adapter.toggleItemClick(position)
                presenter.toggleItemClick(adapter.list.get(position))
            }
        }
        adapter.itemClickListener = onItemClickListener

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.addItemDecoration(DividerItemDecoration(this, DividerItemDecoration.VERTICAL_LIST))

        presenter.getBingo(getResources().getStringArray(R.array.bingo_entries))
    }

    override fun displayBingo(bingoEntries: ArrayList<BingoEntry>) {
        debug(bingoEntries)
        adapter.setItems(bingoEntries)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        getMenuInflater().inflate(R.menu.menu_main, menu)
        return super<MvpActivity>.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when(item?.getItemId()){
            R.id.action_regenerate_board -> {
                alert("This will clear your current board", null) {
                    positiveButton("Ok") { presenter.getBingo(getResources().getStringArray(R.array.bingo_entries), true) }
                    negativeButton("Nevermind") {}
                }.show()
            }
        }
        return super<MvpActivity>.onOptionsItemSelected(item)
    }
}