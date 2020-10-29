package com.ralphie

fun isLatinAlphabet(text: String): Boolean {
    text.forEach { c ->
        if ((c !in 'A'..'Z') && (c !in 'a'..'z') && c != ' ') {
            return false
        }
    }
    return true
}