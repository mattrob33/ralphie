package com.ralphie.ciphers

import org.junit.Assert.assertEquals
import org.junit.Test

class CaesarTest {

    @Test
    fun `Decrypted matches original, positive bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 7)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypted matches original, positive unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 47)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypted matches original, negative bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -7)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypted matches original, negative unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -47)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }


    @Test
    fun `Decrypted matches original, with punctuation`() {
        val msg = "The Quick Brown Fox JUMPS Over the Lazy Dog! Mr. Dog just barks, barks, barks?"

        val caesar = CaesarCipher(shift = -47)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }
}