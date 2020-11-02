package com.ralphie.ciphers

import com.ralphie.util.isLatinAlphabet

/**
 * Encrypts and decrypts text using a Caesar Cipher, where letters are shifted
 * left or right by a specified number of letters. For example, a shift value
 * of three transforms 'AbCd' into 'DeFg'.
 *
 * A positive or negative shift is allowed, and any shift > ABS(26) will become
 * shift % 26. So, a shift of -29 is equal to a shift of -3.
 */
class CaesarCipher(
    shift: Int = DEFAULT_CAESAR_SHIFT
): Cipher {

    val shift: Int = shift % 26

    /**
     * Encrypts text using a Caesar Cipher.
     *
     * @param msg The text to encrypt. Must consist only of latin alphabet characters (a-z or A-Z) and whitespaces.
     *
     */
    override fun encrypt(msg: String): String {
        val encrypted = StringBuilder()

        msg.forEach { c ->
            val encryptedChar = encryptChar(c, shift)
            encrypted.append(encryptedChar)
        }

        return encrypted.toString()
    }

    /**
     * Decrypts text using a Caesar Cipher.
     *
     * @param encryptedMsg The encrypted text to decrypt.
     *
     */
    override fun decrypt(encryptedMsg: String): String {
        val decryptShift = -shift // Decoding a Caesar Cipher is just shifting the encrypted text in the opposite direction (i.e. undoing the shift)

        val decrypted = StringBuilder()

        encryptedMsg.forEach { c ->
            val encryptedChar = encryptChar(c, decryptShift)
            decrypted.append(encryptedChar)
        }

        return decrypted.toString()
    }

    private fun encryptChar(c: Char, shift: Int): Char {
        return when(c) {
            in 'A'..'Z' -> {
                var encrypted = c + shift
                if (encrypted > 'Z')
                    encrypted -= 26
                else if (encrypted < 'A')
                    encrypted += 26
                encrypted
            }
            in 'a'..'z' -> {
                var encrypted = c + shift
                if (encrypted > 'z')
                    encrypted -= 26
                else if (encrypted < 'a')
                    encrypted += 26
                encrypted
            }
            ' ' -> ' '
            else -> c
        }
    }

    companion object {
        private const val DEFAULT_CAESAR_SHIFT = 3
    }
}