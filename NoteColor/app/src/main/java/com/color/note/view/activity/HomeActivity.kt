package com.color.note.view.activity

import android.os.Bundle
import android.support.v4.app.Fragment
import com.color.note.R
import com.color.note.util.Constant.REQUEST_ADD_CATEGORY
import com.color.note.view.fragment.HomeFragment
import com.color.note.view.fragment.HomeFragment.HomeListener
import com.color.note.view.fragment.NoteFragment
import com.color.note.view.fragment.SettingFragment
import com.color.note.view.fragment.TodoTaskFragment
import it.sephiroth.android.library.bottomnavigation.BottomNavigation
import kotterknife.bindView

class HomeActivity : BaseActivity(), HomeListener {
  private val bottomNavigation by bindView<BottomNavigation>(R.id.bottom_navigation)

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(R.layout.activity_home)

    bottomNavigation.setOnMenuItemClickListener(object : BottomNavigation.OnMenuItemSelectionListener {
      override fun onMenuItemSelect(menuId: Int, position: Int, fromUser: Boolean) {
        when (position) {
          0 -> replaceFragment(HomeFragment.getFragment())
          1 -> replaceFragment(NoteFragment.getFragment())
          2 -> replaceFragment(TodoTaskFragment.getFragment())
          3 -> replaceFragment(SettingFragment.getFragment())
        }
      }

      override fun onMenuItemReselect(menuId: Int, position: Int, fromUser: Boolean) {
      }
    })

    // init first fragment
    replaceFragment(HomeFragment.getFragment())
  }

  private fun replaceFragment(fragment: Fragment) {
    supportFragmentManager.beginTransaction().apply {
      replace(R.id.fragment_container, fragment, FRAGMENT_MENU)
      commit()
    }
  }

  // [HomeListener]
  override fun onClickAdd() {
    startActivityForResult(AddCategoryActivity.getIntent(applicationContext), REQUEST_ADD_CATEGORY)
  }

  companion object {
    private const val FRAGMENT_MENU = "fragment_menu"
  }
}
