package com.kevinchrist.starwars.android.presentation.viewmodel

import androidx.lifecycle.*
import com.kevinchrist.starwars.StarWarsRepo
import com.kevinchrist.starwars.android.utils.State
import kotlinx.coroutines.launch

class StarWarsViewModel(state: SavedStateHandle) : ViewModel() {
    companion object {
        private const val SLIDE_KEY = "SLIDE_POSITION"
        private const val SLIDE_COMPLETE_KEY = "SLIDE_COMPLETE"
    }

    private val repository = StarWarsRepo()
    private val savedStateHandle = state

    private val _slidePosition: MutableLiveData<Int> = savedStateHandle.getLiveData(SLIDE_KEY)
    val slidePosition: LiveData<Int> get() = _slidePosition

    private val _completeSlide: MutableLiveData<Boolean> =
        savedStateHandle.getLiveData(SLIDE_COMPLETE_KEY)
    val completeSlide: LiveData<Boolean> get() = _completeSlide

    private val _peopleResponse = MutableLiveData<State>()
    val peopleResponse: LiveData<State> get() = _peopleResponse

    fun getStarWarsCharacters() {
        viewModelScope.launch {
            _peopleResponse.postValue(State.Loading)
            kotlin.runCatching { repository.getPeoples() }
                .onSuccess { _peopleResponse.postValue(State.Success(it)) }
                .onFailure { _peopleResponse.postValue(State.Error(it.message)) }
        }
    }

    fun saveCurrentState(position: Int) {
        savedStateHandle.set(SLIDE_KEY, position)
    }

    fun saveCompleteState(isComplete: Boolean) {
        savedStateHandle.set(SLIDE_COMPLETE_KEY, isComplete)
    }
}