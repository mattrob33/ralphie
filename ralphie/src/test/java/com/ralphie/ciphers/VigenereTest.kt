package com.ralphie.ciphers

import com.ralphie.ciphers.VigenereCipher
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VigenereTest {

    private lateinit var vigenere: VigenereCipher
    
    @Before
    fun setup() {
        vigenere = VigenereCipher("LEMON")
    }
    
    @Test
    fun `Decrypt matches original`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val encrypted = vigenere.encrypt(msg)
        val decrypted = vigenere.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }
}