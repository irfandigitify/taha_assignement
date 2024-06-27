package com.example.androidassignments.EventListeners

import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.AdapterView
import android.widget.AdapterView.OnItemSelectedListener
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.androidassignments.R
import com.example.androidassignments.databinding.ActivityEventListener2Binding


class EventListener2Activity : AppCompatActivity() {
    private lateinit var binding:ActivityEventListener2Binding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityEventListener2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button2.setOnClickListener {
            if(binding.button2.text=="Disable"){
                binding.button2.text="Enable"
                binding.spinner.isEnabled=false
            }else if(binding.button2.text=="Enable"){
                binding.button2.text="Disable"
                binding.spinner.isEnabled=true
            }
        }

        binding.button3.setOnClickListener {
            if(binding.button3.text=="Disable"){
                binding.button3.text="Enable"
                binding.editTextText3.isEnabled=false
            }else if(binding.button3.text=="Enable"){
                binding.button3.text="Disable"
                binding.editTextText3.isEnabled=true
            }
        }

        binding.editTextText3.setOnEditorActionListener(TextView.OnEditorActionListener { v, actionId, event ->
            if (actionId == EditorInfo.IME_ACTION_DONE) {
                val text = binding.editTextText3.text.toString()
                binding.textView4.text = text
                binding.editTextText3.text = null
            }
            false
        })

        val spinnerList= listOf("Pakistan","India","USA","England")
        val arrayAdapter= ArrayAdapter(this,android.R.layout.simple_list_item_1,spinnerList)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinner.adapter=arrayAdapter

        try {
            binding.spinner.onItemSelectedListener =object : OnItemSelectedListener {
                override fun onItemSelected(
                    parent: AdapterView<*>?,
                    view: View?,
                    position: Int,
                    id: Long
                ) {
                    if (parent != null) {
                        binding.textView.text=parent.getItemAtPosition(position).toString()
                    }
                }
                override fun onNothingSelected(parent: AdapterView<*>?) {
                }
            }
        }catch (e:Exception){
            e.message?.let { Log.d("TAG", it) }
        }
    }
}
