package com.hariofspades.randomusers.feature.userlist

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import com.hariofspades.randomusers.R
import com.hariofspades.randomusers.common.extensions.isNetworkStatusAvailable
import com.hariofspades.randomusers.core.BaseActivity
import com.hariofspades.randomusers.core.BaseModelFactory
import com.hariofspades.randomusers.feature.userdetail.UserDetailActivity
import com.hariofspades.randomusers.feature.userdetail.UserDetailFragment

import kotlinx.android.synthetic.main.activity_user_list.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import timber.log.Timber

/**
 * An activity representing a list of Pings. This activity
 * has different presentations for handset and tablet-size devices. On
 * handsets, the activity presents a list of items, which when touched,
 * lead to a [UserDetailActivity] representing
 * item details. On tablets, the activity presents the list of items and
 * item details side-by-side using two vertical panes.
 */
class UserListActivity : BaseActivity(), KodeinAware {

    /**
     * Whether or not the activity is in two-pane mode, i.e. running on a tablet
     * device.
     */
    private var twoPane: Boolean = false

    override val kodein by closestKodein()
    private val factory: BaseModelFactory by instance("factory")

    private lateinit var viewModel: UserListViewModel
    private lateinit var listAdapter: UserListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_list)
        init()
        getNetworkState()
        if (user_detail_container != null) {
            // The detail container view will be present only in the
            // large-screen layouts (res/values-w900dp).
            // If this view is present, then the
            // activity should be in two-pane mode.
            twoPane = true
        }

        observe()
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this, factory).get(UserListViewModel::class.java)
        setupRecyclerView(user_list)
    }

    private fun getNetworkState() {
        Timber.d("internet connection - ${this.isNetworkStatusAvailable()}")
        viewModel.isConnected.value = this.isNetworkStatusAvailable()
    }

    private fun setupRecyclerView(recyclerView: RecyclerView) {
        listAdapter = UserListAdapter {
            if (twoPane) {
                val fragment = UserDetailFragment().apply {
                    arguments = Bundle().apply {
                        putString(UserDetailFragment.ARG_ITEM_ID, it.firstName)
                    }
                }
                supportFragmentManager
                        .beginTransaction()
                        .replace(R.id.user_detail_container, fragment)
                        .commit()
            } else {
                val intent = Intent(this@UserListActivity,
                        UserDetailActivity::class.java).apply {
                    putExtra(UserDetailFragment.ARG_ITEM_ID, it.firstName)
                }
                startActivity(intent)
            }
        }
        //recyclerView.adapter = SimpleItemRecyclerViewAdapter(this, DummyContent.ITEMS, twoPane)
        recyclerView.adapter = listAdapter
    }

    private fun observe() {
        viewModel.getRandomUserList().observe(this, Observer {

            listAdapter.submitList(it)
            Timber.d("received user size- ${it?.size}")

        })
    }

}
