package com.jozze.playground

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform