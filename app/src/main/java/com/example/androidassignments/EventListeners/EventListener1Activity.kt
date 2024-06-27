package com.example.androidassignments.EventListeners

import android.content.Context
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityEventListener1Binding


class EventListener1Activity : AppCompatActivity() {
    private lateinit var binding:ActivityEventListener1Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEventListener1Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.editTextText.addTextChangedListener(checkKey(this@EventListener1Activity))
        binding.editTextText2.addTextChangedListener(checkKey(this@EventListener1Activity))

        binding.editTextText.setOnFocusChangeListener { _, hasFocus ->
            checkFocus(hasFocus,binding.textView2)
        }
        binding.editTextText2.setOnFocusChangeListener { _, hasFocus ->
            checkFocus(hasFocus,binding.textView3)
        }

        binding.button.setOnClickListener {
            Toast.makeText(this@EventListener1Activity, "Button clicked", Toast.LENGTH_SHORT).show()
        }
    }
}

fun checkFocus(hasFocus:Boolean,view: TextView){
    if(hasFocus)
        view.text="Focus is on above editText"
    else
        view.text="Focus is not on above editText"
}

fun checkKey(context: Context,)= object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
    }
    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
    }
    override fun afterTextChanged(s: Editable?) {
        if (s != null) {
            if(s.contains('1'))
                Toast.makeText(context, "key 1 is pressed", Toast.LENGTH_SHORT).show()
        }
    }
}
