package com.kevinchrist.starwars.android.presentation.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.kevinchrist.starwars.People
import com.kevinchrist.starwars.android.R
import com.kevinchrist.starwars.android.presentation.ui.adapter.StarWarsAdapter
import com.kevinchrist.starwars.android.presentation.viewmodel.StarWarsViewModel
import com.kevinchrist.starwars.android.utils.ItemClickListener
import com.kevinchrist.starwars.android.utils.State

class PeoplesFragment : Fragment(), ItemClickListener {

    private val viewModel: StarWarsViewModel by lazy {
        ViewModelProvider(this).get(StarWarsViewModel::class.java)
    }

    private lateinit var navController: NavController
    private var peopleList: ArrayList<People> = arrayListOf()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_peoples, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = Navigation.findNavController(view)

        val adapter = StarWarsAdapter(this)
        val recyclerView = view.findViewById<RecyclerView>(R.id.recycler_view).apply {
            layoutManager = LinearLayoutManager(requireContext())
            setHasFixedSize(true)
        }

        viewModel.peopleResponse.observe(viewLifecycleOwner) { state ->
            when (state) {
                is State.Loading -> {
                    println("Loading...")
                }
                is State.Success -> {
                    adapter.addPeoples(state.result.peoples)
                    peopleList.addAll(state.result.peoples)
                    recyclerView.adapter = adapter
                }
                is State.Error -> {
                    println(state.msg)
                }
            }
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel.getStarWarsCharacters()
    }

    override fun onItemClicked(position: Int) {
        val people = peopleList[position]
        val action = PeoplesFragmentDirections.actionPeoplesFragmentToPeopleFragment(people)
        navController.navigate(action)
    }
}