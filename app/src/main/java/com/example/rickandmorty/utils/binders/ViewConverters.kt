package com.example.rickandmorty.utils.binders

import android.view.View

object ViewConverters
{
    @JvmStatic
    fun boolToVisible(vis: Boolean): Int = if (vis) View.VISIBLE else View.GONE

    @JvmStatic
    fun boolToVisibleHidden(vis: Boolean): Int = if (vis) View.VISIBLE else View.INVISIBLE
}