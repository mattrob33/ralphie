package com.ralphie.ciphers

import com.ralphie.util.isLatinAlphabet
import java.util.*
import com.ralphie.ciphers.EncryptDecrypt.*
import com.ralphie.util.toLatinLower
import com.ralphie.util.toLatinUpper

/**
 * Encrypts and decrypts text using a Vigenère Cipher, where a keyword is used to
 * generate a number of interwoven Caesar ciphers.
 *
 * @param keyword The keyword used to generate the encryption table (case-insensitive)
 */
class VigenereCipher(
	keyword: String
): Cipher {

	val keyword = keyword.toLatinUpper()

	private val keywordLower = keyword.toLatinLower()

	override fun encrypt(msg: String): String {
		val encrypted = StringBuilder()

		msg.forEachIndexed { index, char ->
			encrypted.append(encryptChar(char, index))
		}

		return encrypted.toString()
	}

	override fun decrypt(encryptedMsg: String): String {
		val decrypted = StringBuilder()

		encryptedMsg.forEachIndexed { index, char ->
			decrypted.append(decryptChar(char, index))
		}

		return decrypted.toString()
	}

	/**
	 * Can be describe algebraically as Ci = Ek(Mi) = (Mi + Ki) mod 26.
	 */
	private fun encryptChar(char: Char, index: Int) = encryptDecrypt(char, index, ENCRYPT)

	/**
	 * Can be describe algebraically as Mi = Dk(Ci) = (Ci - Ki + 26) mod 26.
	 */
	private fun decryptChar(char: Char, index: Int) = encryptDecrypt(char, index, DECRYPT)


	private fun encryptDecrypt(char: Char, index: Int, opType: EncryptDecrypt): Char {
		if (!isLatinAlphabet(char)) return char

		val isUpperCase = (char in 'A'..'Z')
		val asciiOffset: Int = if (isUpperCase) 'A'.toInt() else 'a'.toInt()

		val keyChar = if (isUpperCase)
			keyword[index % keyword.length]
		else
			keywordLower[index % keywordLower.length]

		val charLetter = (char - asciiOffset).toInt()
		val keyCharLetter = (keyChar - asciiOffset).toInt()

		return when (opType) {
			ENCRYPT -> (((charLetter + keyCharLetter)) % 26 + asciiOffset).toChar()
			DECRYPT ->  (((charLetter - keyCharLetter + 26)) % 26 + asciiOffset).toChar()
		}
	}
}

private enum class EncryptDecrypt {
	ENCRYPT,
	DECRYPT
}