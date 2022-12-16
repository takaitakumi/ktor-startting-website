package com.example.models

import java.util.concurrent.atomic.AtomicInteger

/**
 * @author： tomgao
 * @date：  2022-12-16 13:59
 * @Description:
 */

class Article
private constructor(val id: Int, var title: String, var body: String){
    companion object { // 伴生对象: 伴生对象在类中只能存在一个 类似Java静态方法 直接用类名调用
        private val idCounter = AtomicInteger()

        fun newEntry(title: String, body: String) = Article(idCounter.getAndIncrement(), title, body)
    }
}

val articles = mutableListOf(Article.newEntry(
    "The drive to develop!",
    "...it's what keeps me going."))