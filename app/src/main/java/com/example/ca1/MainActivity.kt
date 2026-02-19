package com.example.ca1

import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.firebase.database.*

class MainActivity : AppCompatActivity() {

    private lateinit var etName: EditText
    private lateinit var etRoll: EditText
    private lateinit var etMarks: EditText

    private lateinit var btnAdd: Button
    private lateinit var btnView: Button
    private lateinit var btnUpdate: Button
    private lateinit var btnDelete: Button

    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: StudentAdapter

    private val studentList = ArrayList<Details>()

    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Views
        etName = findViewById(R.id.name)
        etRoll = findViewById(R.id.roll_no)
        etMarks = findViewById(R.id.Marks)

        btnAdd = findViewById(R.id.add)
        btnView = findViewById(R.id.view)
        btnUpdate = findViewById(R.id.update)
        btnDelete = findViewById(R.id.delete)

        recyclerView = findViewById(R.id.recyclerView)

        // RecyclerView setup
        recyclerView.layoutManager = LinearLayoutManager(this)
        adapter = StudentAdapter(studentList)
        recyclerView.adapter = adapter

        // Firebase
        database = FirebaseDatabase.getInstance().getReference("Students")

        // ADD
        btnAdd.setOnClickListener {
            val name = etName.text.toString()
            val roll = etRoll.text.toString()
            val marks = etMarks.text.toString()

            if (roll.isNotEmpty()) {
                val student = Details(name, roll, marks)

                database.child(roll).setValue(student)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Student Added", Toast.LENGTH_SHORT).show()
                        loadStudents()
                    }
            }
        }

        // VIEW
        btnView.setOnClickListener {
            loadStudents()
        }

        // UPDATE
        btnUpdate.setOnClickListener {
            val name = etName.text.toString()
            val roll = etRoll.text.toString()
            val marks = etMarks.text.toString()

            val student = Details(name, roll, marks)

            database.child(roll).setValue(student)
                .addOnSuccessListener {
                    Toast.makeText(this, "Updated", Toast.LENGTH_SHORT).show()
                    loadStudents()
                }
        }

        // DELETE
        btnDelete.setOnClickListener {
            val roll = etRoll.text.toString()

            database.child(roll).removeValue()
                .addOnSuccessListener {
                    Toast.makeText(this, "Deleted", Toast.LENGTH_SHORT).show()
                    loadStudents()
                }
        }
    }

    private fun loadStudents() {
        database.addListenerForSingleValueEvent(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                studentList.clear()

                for (data in snapshot.children) {
                    val student = data.getValue(Details::class.java)
                    if (student != null) {
                        studentList.add(student)
                    }
                }

                adapter.notifyDataSetChanged()
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@MainActivity, "Error", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
