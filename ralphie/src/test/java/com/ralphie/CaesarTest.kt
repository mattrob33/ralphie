package com.ralphie

import com.ralphie.ciphers.CaesarCipher
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class CaesarTest {

    @Test
    fun `Decode matches original, positive bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 7)

        val encoded = caesar.encode(msg)
        val decoded = caesar.decode(encoded)

        assertEquals(msg, decoded)
    }

    @Test
    fun `Decode matches original, positive unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 47)

        val encoded = caesar.encode(msg)
        val decoded = caesar.decode(encoded)

        assertEquals(msg, decoded)
    }

    @Test
    fun `Decode matches original, negative bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -7)

        val encoded = caesar.encode(msg)
        val decoded = caesar.decode(encoded)

        assertEquals(msg, decoded)
    }

    @Test
    fun `Decode matches original, negative unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -47)

        val encoded = caesar.encode(msg)
        val decoded = caesar.decode(encoded)

        assertEquals(msg, decoded)
    }
}