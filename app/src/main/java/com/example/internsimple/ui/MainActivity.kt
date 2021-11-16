package com.example.internsimple.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.internsimple.R
import org.koin.android.ext.android.inject

class MainActivity : AppCompatActivity() {
    private val viewModel: CharactersViewModel by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel.onSetupUi()
        viewModel.character.observe(this) {
            //Log.e(TAG, it.toString())
        }
    }

    companion object {
        private val TAG = MainActivity::class.java.simpleName
    }
}