package com.reunitefamilies.reunitefamilies.landing

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.reunitefamilies.reunitefamilies.R
import com.reunitefamilies.reunitefamilies.StatusPageActivity
import com.reunitefamilies.reunitefamilies.main.BaseActivity
import com.reunitefamilies.reunitefamilies.preferences.AppPreferences
import com.viewpagerindicator.CirclePageIndicator
import io.reactivex.disposables.CompositeDisposable


class LandingActivity: BaseActivity() {

    private lateinit var presenter: LandingContract.Presentation
    var mAuth: FirebaseAuth? = null
    var mCompositeDisposable: CompositeDisposable? = null
    var appPreferences: AppPreferences? = null
    var userTextView: TextView? = null
    var mButton: Button? = null
    var mCheckMark:ImageView? = null

    private var mPagerAdapter: PagerAdapter? = null
    private var mViewPager: ViewPager? = null
    private var mPageIndicator: CirclePageIndicator? = null


    fun provide(presenter: LandingContract.Presentation) {
        this.presenter = presenter
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base)


        LandingDependencies().inject(this)
        mAuth = FirebaseAuth.getInstance()
        mCompositeDisposable = CompositeDisposable()
        appPreferences = AppPreferences(this)
        userTextView = findViewById(R.id.landing_user_firstname)
        mButton = findViewById(R.id.verify_next_button)
       //mCheckMark = findViewById(R.id.checkmark)

        mViewPager = findViewById(R.id.verification_viewPager) as ViewPager
        mPageIndicator = findViewById(R.id.page_indicator) as CirclePageIndicator
        mPagerAdapter = PagerAdapter(supportFragmentManager)
        mViewPager!!.setAdapter(mPagerAdapter)
        mPageIndicator!!.setViewPager(mViewPager)

        //this.presenter.openRegistrationIfNeeded()

        getUserInfo()

        mButton!!.setOnClickListener({
           val position = mViewPager!!.currentItem
            if (position < 2 ){
                mViewPager!!.setCurrentItem(position +1, true);
            }
            else {
                mButton!!.setText("View Status")
               // mCheckMark!!.setVisibility(View.VISIBLE)
               val intent = Intent(this, StatusPageActivity::class.java)
               startActivity(intent)
            }

        })

    }

    class PagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
        val NUM_ITEMS = 3
        override fun getCount(): Int {
            return NUM_ITEMS
        }


        override fun getItem(position: Int): Fragment {
            var fragmentId = 0
            when (position) {
                0 -> fragmentId = R.layout.activity_verification
                1 -> fragmentId = R.layout.add_child
                2 -> fragmentId = R.layout.case_submitted

                else -> {
                }
            }
            val fragment = VerificationFlowFragment.newInstance(fragmentId)
            if (position == NUM_ITEMS - 1) {
                fragment.setmOnFragmentClickListener({


                })

            }
            return fragment
        }

    }





    fun getUserInfo() {
       val user = mAuth!!.currentUser
        val userId = user!!.uid
        mCompositeDisposable!!.add(presenter.getUserInfo(userId).subscribe { userModel->
           appPreferences!!.saveCurrentUser(userModel)
            userTextView!!.setText("Welcome, " + userModel.first_name+ " " +userModel.last_name)
        })
    }

}