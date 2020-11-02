package com.ralphie.ciphers

import com.ralphie.util.isLatinAlphabet

/**
 * Encodes and decodes text using a Caesar Cipher, where letters are shifted
 * left or right by a specified number of letters. For example, a shift value
 * of three transforms 'AbCd' into 'DeFg'.
 *
 * A positive or negative shift is allowed, and any shift > ABS(26) will become
 * shift % 26. So, a shift of -29 is equal to a shift of -3.
 */
class CaesarCipher(
    shiftBy: Int = DEFAULT_CAESAR_SHIFT
) {

    var shift: Int = shiftBy % 26
        set(value) {
            field = value % 26
        }

    /**
     * Encodes text using a Caesar Cipher.
     *
     * @param msg The text to encode. Must consist only of latin alphabet characters (a-z or A-Z) and whitespaces.
     *
     * @param shiftBy An optional shift value. If none is specified, the value of the shift field is used.
     *
     */
    fun encode(msg: String, shiftBy: Int = shift): String {
        require(isLatinAlphabet(msg)) {
            "Message must contain only latin alphabet characters (a-z or A-Z)"
        }

        val adjustedShift = shiftBy % 26

        val encoded = StringBuilder()

        msg.forEach { c ->
            val encodedChar = encodeChar(c, adjustedShift)
            encoded.append(encodedChar)
        }

        return encoded.toString()
    }

    /**
     * Decodes text using a Caesar Cipher.
     *
     * @param msg The encoded text to decode.
     *
     * @param encodeShiftBy The shift value that was used to encode the encoded text.
     *
     */
    fun decode(encodedMsg: String, encodeShiftBy: Int = shift): String {
        val decodeShiftBy = -encodeShiftBy
        return encode(encodedMsg, decodeShiftBy)
    }

    private fun encodeChar(c: Char, shift: Int): Char {
        return when(c) {
            in 'A'..'Z' -> {
                var encoded = c + shift
                if (encoded > 'Z')
                    encoded -= 26
                else if (encoded < 'A')
                    encoded += 26
                encoded
            }
            in 'a'..'z' -> {
                var encoded = c + shift
                if (encoded > 'z')
                    encoded -= 26
                else if (encoded < 'a')
                    encoded += 26
                encoded
            }
            ' ' -> ' '
            else -> c
        }
    }

    companion object {
        private const val DEFAULT_CAESAR_SHIFT = 3
    }
}