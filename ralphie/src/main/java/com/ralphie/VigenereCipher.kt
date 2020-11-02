package com.ralphie

import com.ralphie.ciphers.Cipher

/**
 * Encrypts and decrypts text using a Vigenère Cipher, where a keyword is used to
 * generate a number of interwoven Caesar ciphers.
 */
class VigenereCipher(
	val keyword: String
): Cipher {
	override fun encrypt(msg: String): String {
		return msg
	}

	override fun decrypt(encryptedMsg: String): String {
		return encryptedMsg
	}

	private fun encryptChar(c: Char): Char {

	}
}