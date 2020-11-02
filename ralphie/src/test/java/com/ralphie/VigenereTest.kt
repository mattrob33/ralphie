package com.ralphie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class VigenereTest {

    private lateinit var vigenere: VigenereCipher
    
    @Before
    fun setup() {
        vigenere = VigenereCipher()
    }
    
    @Test
    fun `Decrypt matches original`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val encrypted = vigenere.encrypt(msg)
        val decrypted = vigenere.decrypt(encrypted)

        assertNotEquals(encrypted, decrypted)
        assertEquals(msg, decrypted)
    }
}