package com.alezzgo.socialmedia.ui.ext

import androidx.compose.foundation.lazy.LazyListState

fun LazyListState.isItemVisible(index: Int) = with(layoutInfo) {
    visibleItemsInfo.find { it.index == index }?.let {
        viewportEndOffset - it.offset >= it.size
    } ?: false
}

val LazyListState.lastVisibleItemIndex: Int
    get() = layoutInfo.visibleItemsInfo.lastOrNull()?.index ?: -1

val LazyListState.isLastItemVisible: Boolean
    get() = lastVisibleItemIndex == layoutInfo.totalItemsCount - 1