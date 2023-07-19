package com.alezzgo.socialmedia.ui.screens.description

import android.util.Log
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.alezzgo.socialmedia.ui.models.Chat
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class DescriptionViewModel  @Inject constructor(
    private val savedStateHandle: SavedStateHandle
) : ViewModel() {



    init {
        Log.d("my","${savedStateHandle.get<Chat>("chat")?.members?.joinToString { it.name }}")
    }

}