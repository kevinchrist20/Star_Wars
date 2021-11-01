package com.kevinchrist.starwars

class Greeting {
    fun greeting(): String {
        return "Hello, ${Platform().platform}!"
    }
}