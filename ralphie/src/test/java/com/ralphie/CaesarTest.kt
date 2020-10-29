package com.ralphie

import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CaesarTest {

    private lateinit var caesar: CaesarCipher
    
    @Before
    fun setup() {
        caesar = CaesarCipher()
    }
    
    @Test
    fun `Encode, with explicit positive shift`() {
        val msg = "Z Caesar Testz"
        val shift = 3

        val actual = caesar.encode(msg, shift)
        val expected = "C Fdhvdu Whvwc"

        assertEquals(expected, actual)
    }

    @Test
    fun `Encode, with explicit negative shift`() {
        val msg = "C Fdhvdu Whvwc"
        val shift = -3

        val actual = caesar.encode(msg, shift)
        val expected = "Z Caesar Testz"

        assertEquals(expected, actual)
    }

    @Test
    fun `Decode matches original, with explicit positive shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"
        val shift = 3

        val encoded = caesar.encode(msg, shift)
        val decoded = caesar.decode(encoded, shift)

        assertEquals(msg, decoded)
    }

    @Test
    fun `Decode matches original, with explicit negative surplus shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"
        val shift = -37

        val encoded = caesar.encode(msg, shift)
        val decoded = caesar.decode(encoded, shift)

        assertEquals(msg, decoded)
    }

    @Test
    fun `Decode matches original, with positive shift field`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        caesar.shift = 7

        val encoded = caesar.encode(msg)
        val decoded = caesar.decode(encoded)

        assertEquals(msg, decoded)
    }
}