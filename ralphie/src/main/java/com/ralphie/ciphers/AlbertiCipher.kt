package com.ralphie.ciphers

import com.ralphie.util.isLatinAlphabet

/**
 * Encodes and decodes text using an Alberti Cipher, where letters are encoded
 * according to a given key, historically existing in the form of an Alberti disk.
 *
 * The same AlbertiCipher instance <i>must</i> be used to encode/decode, since the
 * "Alberti Disk" lookup table is specific to a given instance.
 */
class AlbertiCipher {

    // The lookup table of encoded chars
    private val albertiDisk: HashMap<Char, Char> = hashMapOf()

    // The reverse lookup table, used for decoding chars
    private val reverseAlbertiDisk: HashMap<Char, Char> = hashMapOf()

    init {
        val encodedUpperChars = ('A'..'Z').toMutableList().apply { shuffle() }

        encodedUpperChars.forEachIndexed { index, encodedUpperChar ->
            val encodedLowerChar = encodedUpperChar + 32

            val upperChar = (65 + index).toChar()
            val lowerChar = (97 + index).toChar()

            albertiDisk[upperChar] = encodedUpperChar
            albertiDisk[lowerChar] = encodedLowerChar

            reverseAlbertiDisk[encodedUpperChar] = upperChar
            reverseAlbertiDisk[encodedLowerChar] = lowerChar
        }

        albertiDisk[' '] = ' '
        reverseAlbertiDisk[' '] = ' '
    }

    /**
     * Encodes text using an Alberti Cipher.
     *
     * @param msg The text to encode. Must consist only of latin alphabet characters (a-z or A-Z) and whitespaces.
     *
     */
    fun encode(msg: String): String {
        require(isLatinAlphabet(msg)) {
            "Message must contain only latin alphabet characters (a-z or A-Z)"
        }

        val encoded = StringBuilder()

        msg.forEach { c ->
            val encodedChar = encodeChar(c)
            encoded.append(encodedChar)
        }

        return encoded.toString()
    }

    /**
     * Decodes text using an Alberti Cipher.
     *
     * @param encodedMsg The encoded text to decode.
     *
     */
    fun decode(encodedMsg: String): String {
        require(isLatinAlphabet(encodedMsg)) {
            "Message must contain only latin alphabet characters (a-z or A-Z)"
        }

        val decoded = StringBuilder()

        encodedMsg.forEach { c ->
            val decodedChar = decodeChar(c)
            decoded.append(decodedChar)
        }

        return decoded.toString()
    }

    // TODO: ensure disk is sufficiently scrambled
    private fun createAlbertiDisk(): HashMap<Char, Char> {
        val disk: HashMap<Char, Char> = hashMapOf()

        val scrambled = ('A'..'Z').toMutableList().apply { shuffle() }

        scrambled.forEachIndexed { index, char ->
            disk[(65 + index).toChar()] = char
            disk[(97 + index).toChar()] = char + 32
        }

        disk[' '] = ' '

        return disk
    }

    private fun encodeChar(c: Char): Char {
        return albertiDisk[c] ?: throw IllegalArgumentException("Illegal char $c")
    }

    private fun decodeChar(c: Char): Char {
        return reverseAlbertiDisk[c] ?: throw IllegalArgumentException("Illegal char $c")
    }
}