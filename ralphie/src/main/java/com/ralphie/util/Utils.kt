package com.ralphie.util

fun isLatinAlphabet(text: String): Boolean {
    text.forEach { c ->
        if ((c !in 'A'..'Z') && (c !in 'a'..'z') && c != ' ') {
            return false
        }
    }
    return true
}

fun isLatinAlphabet(char: Char) = (char in 'A'..'Z') || (char in 'a'..'z')

fun String.toLatinUpper(): String {
    val sb = StringBuilder()

    val upperLowerOffset: Int = 'a' - 'A'

    this.forEach { char ->
        val upperChar = if (char in 'a'..'z') {
            (char - upperLowerOffset)
        } else {
            char
        }
        sb.append(upperChar)
    }

    return sb.toString()
}

fun String.toLatinLower(): String {
    val sb = StringBuilder()

    val upperLowerOffset: Int = 'a' - 'A'

    this.forEach { char ->
        val lowerChar = if (char in 'A'..'Z') {
            (char + upperLowerOffset)
        } else {
            char
        }
        sb.append(lowerChar)
    }

    return sb.toString()
}