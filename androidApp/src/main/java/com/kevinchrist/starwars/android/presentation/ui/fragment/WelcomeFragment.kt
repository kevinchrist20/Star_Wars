package com.kevinchrist.starwars.android.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.viewpager.widget.ViewPager
import com.kevinchrist.starwars.android.R
import com.kevinchrist.starwars.android.presentation.ui.adapter.SliderAdapter
import com.kevinchrist.starwars.android.presentation.viewmodel.StarWarsViewModel

class WelcomeFragment : Fragment() {

    private val viewModel: StarWarsViewModel by lazy {
        ViewModelProvider(this).get(StarWarsViewModel::class.java)
    }

    private lateinit var nextBtn: Button
    private lateinit var mViewPager: ViewPager

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mSlider = SliderAdapter(requireContext())
        mViewPager = view.findViewById(R.id.pager)
        mViewPager.adapter = mSlider

        nextBtn = view.findViewById(R.id.next_btn)
        nextBtn.setOnClickListener {
            if (nextBtn.text == getString(R.string.start)) {
                viewModel.saveCompleteState(true)
                it.findNavController().navigate(R.id.action_welcomeFragment_to_peoplesFragment)
            }
            nextSlide()
        }

        mViewPager.addOnPageChangeListener(changeListener)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.slidePosition.observe(viewLifecycleOwner) { position ->
            buttonUpdate(position)
            mViewPager.currentItem = position
        }
    }

    private val changeListener: ViewPager.OnPageChangeListener =
        object : ViewPager.OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                buttonUpdate(position)
                viewModel.saveCurrentState(position)
            }

            override fun onPageScrollStateChanged(state: Int) {
            }
        }

    private fun buttonUpdate(position: Int) {
        if (position == 2) {
            nextBtn.text = getString(R.string.start)
        } else {
            nextBtn.text = getString(R.string.next)
        }
    }

    private fun nextSlide() {
        when (mViewPager.currentItem) {
            0 -> mViewPager.currentItem = 1
            1 -> {
                mViewPager.currentItem = 2
                nextBtn.text = getString(R.string.start)
            }
        }
    }
}