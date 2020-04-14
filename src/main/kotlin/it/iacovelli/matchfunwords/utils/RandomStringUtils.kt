package it.iacovelli.matchfunwords.utils

import org.springframework.stereotype.Component

@Component
class RandomStringUtils {

    fun getRandomString(n: Int): String {
        val alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ" + "0123456789" + "abcdefghijklmnopqrstuvxyz"
        val sb: StringBuilder = StringBuilder(n)
        for (i in 0..n) {
            val idx: Int = (alphabet.length * Math.random().toInt())
            sb.append(alphabet[idx])
        }
        return sb.toString()
    }

}