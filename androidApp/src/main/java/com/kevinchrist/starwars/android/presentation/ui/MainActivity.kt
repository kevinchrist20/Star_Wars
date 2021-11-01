package com.kevinchrist.starwars.android.presentation.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.kevinchrist.starwars.android.R
import com.kevinchrist.starwars.android.presentation.viewmodel.StarWarsViewModel


class MainActivity : AppCompatActivity() {

    private val viewModel: StarWarsViewModel by lazy {
        ViewModelProvider(this).get(StarWarsViewModel::class.java)
    }

    private lateinit var mNavController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mNavController = Navigation.findNavController(this, R.id.nav_host_fragment);

    }

    override fun onResume() {
        super.onResume()

        viewModel.completeSlide.observe(this) { isComplete ->
            if (isComplete)
                mNavController.navigate(R.id.action_welcomeFragment_to_peoplesFragment)
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        return mNavController.navigateUp()
    }
}
