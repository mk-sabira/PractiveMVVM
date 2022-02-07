package com.sabira.practicemvvm.utilities

import com.sabira.practicemvvm.data.FakeDatabase
import com.sabira.practicemvvm.data.QuoteRepository
import com.sabira.practicemvvm.ui.quote.QuotesViewModelFactory

object InjectUtils {
    fun provideQuoteViewModelFactory(): QuotesViewModelFactory {
        val quoteRepository = QuoteRepository.getInstance(FakeDatabase.getInstance().quoteDao)
        return QuotesViewModelFactory(quoteRepository)
    }
}