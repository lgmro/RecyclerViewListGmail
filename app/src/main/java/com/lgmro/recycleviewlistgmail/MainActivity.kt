package com.lgmro.recycleviewlistgmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lgmro.recycleviewlistgmail.model.fakeEmails

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recycler = findViewById<RecyclerView>(R.id.recycle_view_main)
        recycler.adapter = EmailAdapter(fakeEmails())
        recycler.layoutManager = LinearLayoutManager(this)


    }
}