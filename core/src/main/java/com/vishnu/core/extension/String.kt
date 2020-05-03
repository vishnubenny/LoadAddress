package com.vishnu.core.extension

import com.vishnu.core.Constants.Companion.EMPTY_STRING

fun String?.getText(): String = this ?: EMPTY_STRING
