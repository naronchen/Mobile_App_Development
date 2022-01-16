package com.example.simpletodo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import org.apache.commons.io.FileUtils
import java.io.File
import java.io.IOException
import java.nio.charset.Charset


class MainActivity : AppCompatActivity() {

    var listOfTasks = mutableListOf<String>()
    lateinit var adapter: TaskItemAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val onLongClickListener = object : TaskItemAdapter.OnLongClickListener {
            override fun onItemLongClicked(position: Int) {
                // remove Item from List
                // Notify Adapter that data set has changed

                listOfTasks.removeAt(position)

                adapter.notifyDataSetChanged()

                saveItem()
            }
        }

        val onClickListener = object : TaskItemAdapter.OnClickListener {
            override fun onItemClicked(position: Int) {
                Log.i("Naron", "Hi from MainActivity onItemClicked")
                val i = Intent(this@MainActivity, EditActivity::class.java)
                startActivity(i) // bring EditActivity
            }
        }

//        listOfTasks.add("ReDo Laundry")
//        listOfTasks.add("Go for a walk")
        loadItem()
        //look up recyclerView in layout
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        //create adapter passing the sample user data
        adapter = TaskItemAdapter(listOfTasks, onLongClickListener, onClickListener)
        //Attach the adapter to the recyclerview to populate items
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager( this)

        val inputTextField = findViewById<EditText>(R.id.addTaskField)

        findViewById<Button>(R.id.button).setOnClickListener{
            // Will be executed if clicked on button
            // 1. grab the text the user has inputted into @id/addTaskField
            val userInputtedTask = inputTextField.text.toString()
            // 2. Add the String to our list of tasks
            listOfTasks.add(userInputtedTask)
            // Notify the adaptor that item has been inserted
            adapter.notifyItemInserted(listOfTasks.size - 1)
            inputTextField.setText("")

            saveItem()

        }

    }



    // Save the data that user has inputted
    // save by reading/writing into a file

    // Get data file
    fun getDataFile() : File {
        return File(filesDir, "data.txt")
    }
    // load the file by reading every line in the data file
    fun loadItem(){
        try{
            listOfTasks = FileUtils.readLines(getDataFile(), Charset.defaultCharset())
        } catch( ioException: IOException){
            ioException.printStackTrace()
        }
    }
    // save item by writing them into data file
    fun saveItem(){
        try {
            FileUtils.writeLines(getDataFile(), listOfTasks)
        } catch( ioException: IOException){
            ioException.printStackTrace()
        }
    }

}