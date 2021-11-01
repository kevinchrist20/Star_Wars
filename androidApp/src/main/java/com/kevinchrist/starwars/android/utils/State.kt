package com.kevinchrist.starwars.android.utils

import com.kevinchrist.starwars.PeopleResponse

sealed class State {
    object Loading : State()
    class Success(val result: PeopleResponse) : State()
    class Error(val msg: String?) : State()
}
