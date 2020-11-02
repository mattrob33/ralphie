package com.ralphie.ciphers

import com.ralphie.util.isLatinAlphabet

/**
 * Encrypts and decrypts text using an Alberti Cipher, where letters are encrypted
 * according to a given key, historically existing in the form of an Alberti disk.
 *
 * The same AlbertiCipher instance <i>must</i> be used to encrypt/decrypt, since the
 * "Alberti Disk" lookup table is specific to a given instance.
 */
class AlbertiCipher: Cipher {

    // The lookup table of encrypted chars
    private val albertiDisk: HashMap<Char, Char> = hashMapOf()

    // The reverse lookup table, used for decoding chars
    private val reverseAlbertiDisk: HashMap<Char, Char> = hashMapOf()

    // TODO: ensure disk is sufficiently scrambled
    init {
        val encryptedUpperChars = ('A'..'Z').toMutableList().apply { shuffle() }

        encryptedUpperChars.forEachIndexed { index, encryptedUpperChar ->
            val encryptedLowerChar = encryptedUpperChar + ('a' - 'A')

            val upperChar = ('A'.toInt() + index).toChar()
            val lowerChar = ('a'.toInt() + index).toChar()

            albertiDisk[upperChar] = encryptedUpperChar
            albertiDisk[lowerChar] = encryptedLowerChar

            reverseAlbertiDisk[encryptedUpperChar] = upperChar
            reverseAlbertiDisk[encryptedLowerChar] = lowerChar
        }

        albertiDisk[' '] = ' '
        reverseAlbertiDisk[' '] = ' '
    }

    /**
     * Encrypts text using an Alberti Cipher.
     *
     * @param msg The text to encrypt. Must consist only of latin alphabet characters (a-z or A-Z) and whitespaces.
     *
     */
    override fun encrypt(msg: String): String {
        val encrypted = StringBuilder()

        msg.forEach { c ->
            val encryptedChar = encryptChar(c)
            encrypted.append(encryptedChar)
        }

        return encrypted.toString()
    }

    /**
     * Decrypts text using an Alberti Cipher.
     *
     * @param encryptedMsg The encrypted text to decrypt.
     *
     */
    override fun decrypt(encryptedMsg: String): String {
        val decrypted = StringBuilder()

        encryptedMsg.forEach { c ->
            val decryptedChar = decryptChar(c)
            decrypted.append(decryptedChar)
        }

        return decrypted.toString()
    }

    private fun encryptChar(c: Char): Char {
        return if (isLatinAlphabet(c)) {
            albertiDisk[c] ?: throw IllegalArgumentException("Illegal char $c")
        } else {
            c
        }
    }

    private fun decryptChar(c: Char): Char {
        return if (isLatinAlphabet(c)) {
            reverseAlbertiDisk[c] ?: throw IllegalArgumentException("Illegal char $c")
        } else {
            c
        }
    }
}