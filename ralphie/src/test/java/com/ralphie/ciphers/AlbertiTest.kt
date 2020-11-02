package com.ralphie.ciphers

import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class AlbertiTest {

    private lateinit var alberti: AlbertiCipher
    
    @Before
    fun setup() {
        alberti = AlbertiCipher()
    }
    
    @Test
    fun `Decrypt matches original`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val encrypted = alberti.encrypt(msg)
        val decrypted = alberti.decrypt(encrypted)

        assertNotEquals(encrypted, decrypted)
        assertEquals(msg, decrypted)
    }
}