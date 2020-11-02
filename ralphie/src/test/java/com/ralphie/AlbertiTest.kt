package com.ralphie

import com.ralphie.ciphers.AlbertiCipher
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class AlbertiTest {

    private lateinit var alberti: AlbertiCipher
    
    @Before
    fun setup() {
        alberti = AlbertiCipher()
    }
    
    @Test
    fun `Decode matches original`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val encoded = alberti.encode(msg)
        val decoded = alberti.decode(encoded)

        assertNotEquals(encoded, decoded)
        assertEquals(msg, decoded)
    }
}