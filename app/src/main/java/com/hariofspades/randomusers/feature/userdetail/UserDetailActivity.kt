package com.hariofspades.randomusers.feature.userdetail

import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.hariofspades.randomusers.R
import com.hariofspades.randomusers.core.BaseActivity
import com.hariofspades.randomusers.feature.userlist.UserListActivity
import kotlinx.android.synthetic.main.user_detail.*
import timber.log.Timber

/**
 * An activity representing a single User detail screen. This
 * activity is only used on narrow width devices. On tablet-size devices,
 * item details are presented side-by-side with a list of items
 * in a [UserListActivity].
 */
class UserDetailActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_detail)

        if (savedInstanceState == null) {
            val fragment = UserDetailFragment().apply {
                arguments = Bundle().apply {
                    putString(UserDetailFragment.FIRST_NAME,
                            intent.getStringExtra(UserDetailFragment.FIRST_NAME))
                }
            }

            supportFragmentManager.beginTransaction()
                    .add(R.id.user_detail_container, fragment)
                    .commit()
        }
    }

}
