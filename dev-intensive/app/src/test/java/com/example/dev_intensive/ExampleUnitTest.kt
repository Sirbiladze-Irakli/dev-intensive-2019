package com.example.dev_intensive

import com.example.dev_intensive.extentions.TimeUnits
import com.example.dev_intensive.extentions.add
import com.example.dev_intensive.extentions.format
import com.example.dev_intensive.extentions.toUserView
import com.example.dev_intensive.models.*
import org.junit.Test

import org.junit.Assert.*
import java.util.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }

    @Test
    fun test_instance() {
        val user2 = User("2", "John", "Wick")
    }

    @Test
    fun test_factory() {
//        val user = User.makeUser("John Cena")
//        val user2 = User.makeUser("John Silverhand")
        val user = User.makeUser("John Wick")
        val user2 = user.copy(id="2", lastName = "Cena", lastVisit = Date())
        print("$user\n$user2")
    }

    @Test
    fun test_decomposition(){
        val user = User.makeUser("John Wick")

        fun getUserInfo() = user

        val (id, firstName, lastName) = getUserInfo()

        println("$id, $firstName, $lastName")
        println("${user.component1()}, ${user.component2()}, ${user.component3()}")
    }

    @Test
    fun test_copy(){
        val user = User.makeUser("John Wick")
        var user2 = user.copy(lastVisit = Date())
        var user3 = user.copy(lastVisit = Date().add(-2, TimeUnits.SECOND))
        var user4 = user.copy(lastName = "Cena", lastVisit = Date().add(2, TimeUnits.HOUR))
//        val user2 = user.copy(id="2", lastVisit = Date())

        println("""
            ${user.lastVisit?.format()}
            ${user2.lastVisit?.format()}
            ${user3.lastVisit?.format()}
            ${user4.lastVisit?.format()}
        """.trimIndent())
    }

    @Test
    fun test_dataq_maping() {
        val user = User.makeUser("Сирбиладзе Иракли")
        println(user)

        val userView = user.toUserView()

        userView.printMe()
    }

    @Test
    fun test_abstract_factory() {
        val user = User.makeUser("Сириладзе Иракли")
    val txtMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any text message", type = "text")
    val imgMessage = BaseMessage.makeMessage(user, Chat("0"), payload = "any image url", type = "image")

    println(txtMessage.formateMessage())
    println(imgMessage.formateMessage())
    }
}
