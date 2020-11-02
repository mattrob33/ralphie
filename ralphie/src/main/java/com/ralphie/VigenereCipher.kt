package com.ralphie

import com.ralphie.ciphers.Cipher

/**
 * Encodes and decodes text using a Vigenère Cipher, where a keyword is used to
 * generate a number of interwoven Caesar ciphers.
 */
class VigenereCipher: Cipher {
	override fun encode(msg: String): String {
		return msg
	}

	override fun decode(encodedMsg: String): String {
		return encodedMsg
	}
}