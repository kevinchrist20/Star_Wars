package com.kevinchrist.starwars.android.utils

fun formString(type: String, value: String): String {
    return when (type) {
        "birth" -> {
            "Birth Year: $value"
        }
        "height" -> {
            "Height: $value cm"
        }
        "mass" -> {
            "Mass: $value kg"
        }
        "skin" -> {
            "Skin color: $value"
        }
        "hair" -> {
            "Hair color: $value"
        }
        "eye" -> {
            "Eye color: $value"
        }
        "gender" -> {
            "Gender: $value"
        }
        "films", "vehicles", "starships" -> {
            "# of $type: $value"
        }
        else -> ""
    }
}

interface ItemClickListener {
    fun onItemClicked(position: Int)
}