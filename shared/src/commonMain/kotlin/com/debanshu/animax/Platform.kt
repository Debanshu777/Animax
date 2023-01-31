package com.debanshu.animax

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform