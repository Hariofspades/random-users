package com.hariofspades.randomusers.feature.userdetail

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.hariofspades.randomusers.R
import com.hariofspades.randomusers.common.glide.GlideApp
import com.hariofspades.randomusers.common.glide.PlaceHolder
import com.hariofspades.randomusers.core.BaseFragment
import com.hariofspades.randomusers.core.BaseModelFactory
import kotlinx.android.synthetic.main.address_layout.*
import kotlinx.android.synthetic.main.content_detail.*
import kotlinx.android.synthetic.main.email_layout.*
import kotlinx.android.synthetic.main.phone_layout.*
import kotlinx.android.synthetic.main.user_detail.*
import kotlinx.android.synthetic.main.user_detail.view.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import timber.log.Timber

/**
 * A fragment representing a single User detail screen.
 * This fragment is either contained in a [UserListActivity]
 * in two-pane mode (on tablets) or a [UserDetailActivity]
 * on handsets.
 */
class UserDetailFragment : BaseFragment(), KodeinAware {

    lateinit var rootView: View

    override val kodein by closestKodein()
    private val factory: BaseModelFactory by instance("factory")

    private lateinit var viewModel: UserDetailViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        rootView = inflater.inflate(R.layout.user_detail, container, false)
        setUpToolbar()
        init()
        observe()

        return rootView
    }

    private fun observe() {
        arguments?.let {
            Timber.d("bundle value frag = ${it.getString(FIRST_NAME)}")
            if (it.containsKey(FIRST_NAME)) {
                viewModel.getThisUser(it.getString(FIRST_NAME)).observe(this, Observer {
                    it?.let {
                        name.text = String.format(
                                getString(R.string.namePlaceholder), it.firstName, it.lastName)
                        mobile.text = it.cell
                        email.text = it.email
                        street.text = it.street
                        city.text = it.city
                        state.text = it.state
                        pincode.text = it.postcode
                        setAvatar(it.large)
                    }

                })
            }
        }
    }

    private fun setAvatar(url: String) {
        GlideApp.with(avatar.context)
                .load(url)
                .centerCrop()
                .placeholder(PlaceHolder.getRandomPlaceholders())
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(avatar)
    }

    private fun init() {
        viewModel = ViewModelProviders.of(this, factory).get(UserDetailViewModel::class.java)
    }

    private fun setUpToolbar() {
        rootView.toolbar.setNavigationIcon(R.drawable.ic_arrow_back_black_24dp)
        rootView.toolbar.setNavigationOnClickListener { activity?.finish() }
    }

    companion object {
        /**
         * The fragment argument representing the item ID that this fragment
         * represents.
         */
        const val FIRST_NAME = "first_name"
    }
}
