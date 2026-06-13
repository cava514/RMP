package com.example.labwork30

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun division_isCorrect() {
        assertEquals(1, 2 / 2)
    }

    @Test
    fun dividingComplexValues_isCorrect() {
        assertEquals(37, 111 / 3)
    }

    @Test
    fun division_isNotCorrect() {
        assertNotEquals(0, 2 / 1)
    }
}