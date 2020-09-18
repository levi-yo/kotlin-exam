package com.example.kotlin.ch_2


fun recognize(c: Char) = when (c) {
    //'0' <= c && c <= '9'
    in '0'..'9' -> "It's digit!"
    //'a' <= c && c <= 'z'
    in 'a'..'z', in 'A'..'Z' -> "It's a letter"
    else -> "I don't know"
}