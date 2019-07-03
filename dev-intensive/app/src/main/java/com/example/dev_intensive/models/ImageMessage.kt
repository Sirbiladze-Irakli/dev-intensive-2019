package com.example.dev_intensive.models

import com.example.dev_intensive.extentions.humanizeDiff
import java.util.*

class ImageMessage(
        id:String,
        from:User?,
        chat:Chat,
        isIncoming : Boolean = false,
        date: Date = Date(),
        var image:String?
) : BaseMessage(id, from, chat, isIncoming, date){
    override fun formateMessage(): String = "id:$id ${from?.firstName} " +
            " ${if (isIncoming) "Получил" else "Отправил" } изображение \"$image\" ${date.humanizeDiff()}"
}