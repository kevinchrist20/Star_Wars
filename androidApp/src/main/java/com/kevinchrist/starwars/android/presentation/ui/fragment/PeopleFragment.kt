package com.kevinchrist.starwars.android.presentation.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.kevinchrist.starwars.People
import com.kevinchrist.starwars.android.R
import com.kevinchrist.starwars.android.utils.formString

class PeopleFragment : Fragment() {

    private val args: PeopleFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_people, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val people: People = args.people

        view.findViewById<TextView>(R.id.character_name_tv).text = people.name
        view.findViewById<TextView>(R.id.birth_day_tv).text = formString("birth", people.birthYear)
        view.findViewById<TextView>(R.id.height_tv).text = formString("height", people.height)
        view.findViewById<TextView>(R.id.mass_tv).text = formString("mass", people.mass)
        view.findViewById<TextView>(R.id.skin_color_tv).text = formString("skin", people.skinColor)
        view.findViewById<TextView>(R.id.hair_color_tv).text = formString("hair", people.hairColor)
        view.findViewById<TextView>(R.id.eye_color_tv).text = formString("eye", people.eyeColor)
        view.findViewById<TextView>(R.id.gender_tv).text = formString("gender", people.gender)
        view.findViewById<TextView>(R.id.films_tv).text = formString("films", people.films.size.toString())
        view.findViewById<TextView>(R.id.vehicles_tv).text = formString("vehicles", people.films.size.toString())
        view.findViewById<TextView>(R.id.starships_tv).text = formString("starships", people.films.size.toString())
    }
}