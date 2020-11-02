package com.ralphie.ciphers

import com.ralphie.ciphers.CaesarCipher
import org.junit.Assert.*
import org.junit.Test

class CaesarTest {

    @Test
    fun `Decrypt matches original, positive bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 7)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypt matches original, positive unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = 47)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypt matches original, negative bounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -7)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }

    @Test
    fun `Decrypt matches original, negative unbounded shift`() {
        val msg = "ABCDEFGHIJKLMNOPQRSTUVWYZ abcdefghijklmnopqrstuvwxyz"

        val caesar = CaesarCipher(shift = -47)

        val encrypted = caesar.encrypt(msg)
        val decrypted = caesar.decrypt(encrypted)

        assertEquals(msg, decrypted)
    }
}