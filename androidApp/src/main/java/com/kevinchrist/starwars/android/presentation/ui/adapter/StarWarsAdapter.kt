package com.kevinchrist.starwars.android.presentation.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.kevinchrist.starwars.People
import com.kevinchrist.starwars.android.R
import com.kevinchrist.starwars.android.utils.ItemClickListener
import com.kevinchrist.starwars.android.utils.formString

class StarWarsAdapter(private val listener: ItemClickListener) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    private val peopleList: ArrayList<People> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            ItemPosition.EVEN.ordinal -> {
                EvenViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_even_star_war_character, parent, false),
                    listener
                )
            }
            ItemPosition.ODD.ordinal -> {
                OddViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_odd_star_war_character, parent, false),
                    listener
                )
            }
            else -> {
                EvenViewHolder(
                    LayoutInflater.from(parent.context)
                        .inflate(R.layout.layout_even_star_war_character, parent, false),
                    listener
                )
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val itemViewHolder: RecyclerView.ViewHolder
        val people = peopleList[position]

        when (holder.itemViewType) {
            ItemPosition.EVEN.ordinal -> {
                itemViewHolder = holder as EvenViewHolder
                itemViewHolder.bind(people)
            }
            ItemPosition.ODD.ordinal -> {
                itemViewHolder = holder as OddViewHolder
                itemViewHolder.bindData(people)
            }
        }
    }

    override fun getItemCount(): Int {
        return peopleList.size
    }

    override fun getItemViewType(position: Int): Int {
        return if (position % 2 == 0) ItemPosition.EVEN.ordinal else ItemPosition.ODD.ordinal
    }

    inner class OddViewHolder(itemView: View, private val listener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val nameTv: TextView = itemView.findViewById(R.id.odd_character_name_tv)
        private val birthYearTv: TextView = itemView.findViewById(R.id.odd_birth_day_tv)
        private val heightTv: TextView = itemView.findViewById(R.id.odd_height_tv)
        private val massTv: TextView = itemView.findViewById(R.id.odd_mass_tv)
        private val skinColorTv: TextView = itemView.findViewById(R.id.odd_skin_color_tv)
        private val hairColorTv: TextView = itemView.findViewById(R.id.odd_hair_color_tv)
        private val eyeColorTv: TextView = itemView.findViewById(R.id.odd_eye_color_tv)
        private val genderTv: TextView = itemView.findViewById(R.id.odd_gender_tv)
        private val filmsTv: TextView = itemView.findViewById(R.id.odd_films_tv)

        init {
            itemView.setOnClickListener(this)
        }

        fun bindData(people: People) {
            nameTv.text = people.name
            birthYearTv.text = formString("birth", people.birthYear)
            heightTv.text = formString("height", people.height)
            massTv.text = formString("mass", people.mass)
            skinColorTv.text = formString("skin", people.skinColor)
            hairColorTv.text = formString("hair", people.hairColor)
            eyeColorTv.text = formString("eye", people.eyeColor)
            genderTv.text = formString("gender", people.gender)
            filmsTv.text = formString("films", people.films.size.toString())
        }

        override fun onClick(v: View?) {
            listener.onItemClicked(adapterPosition)
        }
    }

    inner class EvenViewHolder(itemView: View, private val listener: ItemClickListener) :
        RecyclerView.ViewHolder(itemView), View.OnClickListener {
        private val nameTv: TextView = itemView.findViewById(R.id.even_character_name_tv)
        private val birthYearTv: TextView = itemView.findViewById(R.id.even_birth_day_tv)
        private val heightTv: TextView = itemView.findViewById(R.id.even_height_tv)
        private val massTv: TextView = itemView.findViewById(R.id.even_mass_tv)
        private val skinColorTv: TextView = itemView.findViewById(R.id.even_skin_color_tv)
        private val hairColorTv: TextView = itemView.findViewById(R.id.even_hair_color_tv)
        private val eyeColorTv: TextView = itemView.findViewById(R.id.even_eye_color_tv)
        private val genderTv: TextView = itemView.findViewById(R.id.even_gender_tv)
        private val filmsTv: TextView = itemView.findViewById(R.id.even_films_tv)

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(people: People) {
            nameTv.text = people.name
            birthYearTv.text = formString("birth", people.birthYear)
            heightTv.text = formString("height", people.height)
            massTv.text = formString("mass", people.mass)
            skinColorTv.text = formString("skin", people.skinColor)
            hairColorTv.text = formString("hair", people.hairColor)
            eyeColorTv.text = formString("eye", people.eyeColor)
            genderTv.text = formString("gender", people.gender)
            filmsTv.text = formString("films", people.films.size.toString())
        }

        override fun onClick(v: View?) {
            listener.onItemClicked(adapterPosition)
        }
    }

    fun addPeoples(peoples: List<People>) {
        peopleList.addAll(peoples)
    }

    private enum class ItemPosition {
        ODD,
        EVEN
    }
}