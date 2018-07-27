package com.color.note.view.fragment

import android.content.Context
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.widget.SearchView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.color.note.R
import com.color.note.view.component.SectionNote

class HomeFragment : Fragment() {
  interface HomeListener {
    fun onClickAdd()
  }

  private lateinit var listener: HomeListener
  private lateinit var searchView: SearchView
  private lateinit var addNoteLayout: SectionNote
  private lateinit var recyclerView: RecyclerView
  private lateinit var btnAdd: FloatingActionButton

  override fun onAttach(context: Context?) {
    super.onAttach(context)
    if (context is HomeListener) {
      listener = context
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater,
    container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    return inflater.inflate(R.layout.fragment_home, null).apply {
      searchView = findViewById(R.id.search_bar)
      addNoteLayout = findViewById(R.id.section_note)
      recyclerView = findViewById(R.id.recycler_view)
      btnAdd = findViewById(R.id.add)
    }
  }

  override fun onViewCreated(
    view: View,
    savedInstanceState: Bundle?
  ) {
    super.onViewCreated(view, savedInstanceState)

    activity?.let {
      btnAdd.setOnClickListener{
        listener.onClickAdd()
      }
    }
  }

  companion object {
    fun getFragment(): HomeFragment = HomeFragment()
  }
}