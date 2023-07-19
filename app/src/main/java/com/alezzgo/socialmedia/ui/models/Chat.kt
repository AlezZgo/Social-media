package com.alezzgo.socialmedia.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Chat(
    val id : Int,
    val members : List<ChatMember>
) : Parcelable

