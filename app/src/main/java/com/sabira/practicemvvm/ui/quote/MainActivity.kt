package com.sabira.practicemvvm.ui.quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.sabira.practicemvvm.R
import com.sabira.practicemvvm.data.Quote
import com.sabira.practicemvvm.utilities.InjectUtils
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    lateinit var textView: TextView
    lateinit var button: Button
    lateinit var quoteEd: EditText
    lateinit var quoteAuthor: EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        quoteEd = findViewById(R.id.quote_tv)
        quoteAuthor = findViewById(R.id.author_tv)

        initializeUi()
    }

    private fun initializeUi() {
        val factory = InjectUtils.provideQuoteViewModelFactory()
        val viewModel = ViewModelProviders.of(this, factory)
            .get(QuotesViewModel::class.java)

        viewModel.getQuotes().observe(this, Observer { quotes ->
            val stringBuilder = StringBuilder()
            quotes.forEach { quote ->
                stringBuilder.append("$quote\n\n")
            }
            textView.text = stringBuilder.toString()
        })
        button.setOnClickListener {
            val quote = Quote(quoteEd.text.toString(), quoteAuthor.text.toString())
            viewModel.addQuotes(quote)
            quoteEd.setText("")
            quoteAuthor.setText("")
        }

    }
}