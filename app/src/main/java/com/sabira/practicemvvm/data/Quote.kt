package com.sabira.practicemvvm.data

data class Quote(
    val quote: String,
    val author: String
){
    override fun toString(): String {
        return "$quote - $author"
    }
}
