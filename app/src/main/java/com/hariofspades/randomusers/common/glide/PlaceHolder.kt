package com.hariofspades.randomusers.common.glide

import com.hariofspades.randomusers.R
import java.util.*

object PlaceHolder {

    val drawables = listOf<Int>(
            R.color.sBlue,
            R.color.sCyan,
            R.color.sGreen,
            R.color.sIndigo,
            R.color.sPink,
            R.color.sPurple,
            R.color.sYellow,
            R.color.sRed
    )

    fun getRandomPlaceholders(): Int {
        return drawables[Random().nextInt(drawables.size)]
    }
}