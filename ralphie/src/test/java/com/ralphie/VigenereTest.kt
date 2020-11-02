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
    fun `Decode matches original`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val encoded = vigenere.encode(msg)
        val decoded = vigenere.decode(encoded)

        assertNotEquals(encoded, decoded)
        assertEquals(msg, decoded)
    }
}