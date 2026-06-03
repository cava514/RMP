package com.example.testingapp

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun `add 2 + 2`() {
        val calc = Calculator()

        val result = calc.add(2, 2)

        assertEquals(4, result)
    }
}