package com.alezzgo.socialmedia.ui.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class ChatMember(
    val userId : Int,
    val name : String
) : Parcelable
