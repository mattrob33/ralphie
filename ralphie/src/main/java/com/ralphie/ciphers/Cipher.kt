package com.ralphie.ciphers

interface Cipher {
	fun encode(msg: String): String
	fun decode(encodedMsg: String): String
}