package com.lgmro.recycleviewlistgmail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.lgmro.recycleviewlistgmail.model.Email
import com.lgmro.recycleviewlistgmail.model.email
import com.lgmro.recycleviewlistgmail.model.fakeEmails
import com.mooveit.library.Fakeit
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    private lateinit var adapter: EmailAdapter
    private val recycler get() = findViewById<RecyclerView>(R.id.recycle_view_main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fakeit.init()
        setContentView(R.layout.activity_main)



        adapter = EmailAdapter(fakeEmails())
        recycler.adapter = adapter
        recycler.layoutManager = LinearLayoutManager(this)


    }

    fun addEmail(view: View) {
        val sdf = SimpleDateFormat("dd/MM/yyyy", Locale("pt", "BR")).parse(
            Fakeit.dateTime().dateFormatter()
        )
        adapter.emails.add(0, email {
            stared = false
            unread = true
            user = Fakeit.name().firstName()
            subject = Fakeit.company().name()
            date = SimpleDateFormat("d MMM", Locale("pt", "BR")).format(sdf)
            preview = mutableListOf<String>().apply {
                repeat(10) {
                    add(Fakeit.lorem().words())
                }
            }.joinToString(" ")
        })
        adapter.notifyItemInserted(0)

        recycler.scrollToPosition(0)
    }
}