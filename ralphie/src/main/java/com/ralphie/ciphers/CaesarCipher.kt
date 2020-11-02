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
    shift: Int = DEFAULT_CAESAR_SHIFT
): Cipher {

    var shift: Int = shift % 26
        private set(value) {
            field = value % 26
        }

    /**
     * Encodes text using a Caesar Cipher.
     *
     * @param msg The text to encode. Must consist only of latin alphabet characters (a-z or A-Z) and whitespaces.
     *
     */
    override fun encode(msg: String): String {
        require(isLatinAlphabet(msg)) {
            "Message must contain only latin alphabet characters (a-z or A-Z)"
        }

        val encoded = StringBuilder()

        msg.forEach { c ->
            val encodedChar = encodeChar(c, shift)
            encoded.append(encodedChar)
        }

        return encoded.toString()
    }

    /**
     * Decodes text using a Caesar Cipher.
     *
     * @param encodedMsg The encoded text to decode.
     *
     */
    override fun decode(encodedMsg: String): String {
        require(isLatinAlphabet(encodedMsg)) {
            "Message must contain only latin alphabet characters (a-z or A-Z)"
        }

        val decodeShift = -shift // Decoding a Caesar Cipher is just shifting the encoded text in the opposite direction (i.e. undoing the shift)

        val decoded = StringBuilder()

        encodedMsg.forEach { c ->
            val encodedChar = encodeChar(c, decodeShift)
            decoded.append(encodedChar)
        }

        return decoded.toString()
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