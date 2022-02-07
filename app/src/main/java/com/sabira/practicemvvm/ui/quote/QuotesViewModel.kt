package com.sabira.practicemvvm.ui.quote

import androidx.lifecycle.ViewModel
import com.sabira.practicemvvm.data.Quote
import com.sabira.practicemvvm.data.QuoteRepository

class QuotesViewModel(private val quoteRepository: QuoteRepository): ViewModel() {

    fun getQuotes() = quoteRepository.getQuote()

    fun addQuotes(quote: Quote) = quoteRepository.addQuote(quote)
}