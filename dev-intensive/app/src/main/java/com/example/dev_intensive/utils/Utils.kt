package com.example.dev_intensive.utils

object Utils {
    fun parseFullName(fullName:String?):Pair<String?, String?>{
        //TODO FIX ME
        val patrs : List<String>? = fullName?.split(" ")

        val firstName =patrs?.getOrNull(0)
        val lastName =patrs?.getOrNull(1)
//        return Pair(firstName, lastName)
        return firstName to lastName
    }

    fun transliteration(payload: String, divider:String = " "): String {
        TODO("not implemented")
    }

    fun toInitials(firstName: String?, lastName: String?): String? {
        TODO("not implemented")
    }
}