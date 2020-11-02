package com.ralphie.ciphers

interface Cipher {
	fun encrypt(msg: String): String
	fun decrypt(encryptedMsg: String): String
}