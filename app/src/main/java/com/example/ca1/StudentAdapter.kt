package com.example.ca1

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class StudentAdapter(private val list: ArrayList<Details>) :
    RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.tvName)
        val roll: TextView = itemView.findViewById(R.id.tvRoll)
        val marks: TextView = itemView.findViewById(R.id.tvMarks)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = list[position]
        holder.name.text = "Name: ${student.name}"
        holder.roll.text = "Roll No: ${student.roll_no}"
        holder.marks.text = "Marks: ${student.marks}"
    }
}
