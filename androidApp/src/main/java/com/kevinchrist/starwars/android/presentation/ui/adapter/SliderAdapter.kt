package com.kevinchrist.starwars.android.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.viewpager.widget.PagerAdapter
import com.kevinchrist.starwars.android.R

class SliderAdapter(private val mContext: Context) : PagerAdapter() {
    private var mInflater: LayoutInflater? = null

    private val titleList = intArrayOf(
        R.string.welcome, R.string.slider_title_1, R.string.slider_title_2
    )
    private val descriptionList = intArrayOf(
        R.string.swipe_to_continue,
        R.string.slider_desc_1, R.string.slider_desc_2
    )

    override fun getCount(): Int {
       return titleList.size
    }

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        mInflater = mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        val mView = if (mInflater != null) mInflater!!.inflate(
            R.layout.layout_slider_pager,
            container,
            false
        ) else null

        mView?.let { view ->
            val tvTitle = view.findViewById<TextView>(R.id.slide_title)
            val tvDescription = view.findViewById<TextView>(R.id.slide_description)

            tvTitle?.setText(titleList[position])
            tvDescription?.setText(descriptionList[position])
        }

        container.addView(mView)
        return mView!!
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as ConstraintLayout)
    }
}