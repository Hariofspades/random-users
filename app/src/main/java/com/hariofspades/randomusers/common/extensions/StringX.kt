package com.hariofspades.randomusers.common.extensions

import android.text.TextUtils

fun String.toCamelCase(): String {
    val str = (this)
    if (TextUtils.isEmpty(str)) {
        return ""
    }
    return Character.toUpperCase(str[0]) +
            str.substring(1).toLowerCase()
}