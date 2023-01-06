package com.example.mycorutinetrail.screens.main

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.mycorutines.adapters.RvAdapter
import com.example.mycorutines.screens.main.home.MainViewModel
import com.example.mycorutinetrail.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private val vm: MainViewModel by viewModels()
    private lateinit var binding: ActivityMainBinding
    lateinit var rvAdapter: RvAdapter
    var languageList: List<com.example.mycorutines.model.Result> = listOf()

    @SuppressLint("NotifyDataSetChanged")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root

        setContentView(view)
        val mLayoutManager = LinearLayoutManager(this@MainActivity, LinearLayoutManager.VERTICAL, false)
        binding. rec.layoutManager=mLayoutManager;
        rvAdapter = RvAdapter(applicationContext,languageList)
        binding.rec.adapter=rvAdapter
        rvAdapter.onclick = {
                langItem ->
        }

        vm.myApi().observe(this){
            it?.let {
                rvAdapter.updateList( it.results)

            }
            if(it==null){

            }

        }




        // launching a new coroutine


    }
}