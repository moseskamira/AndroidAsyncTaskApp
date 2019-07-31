package com.example.asynctaskapp

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast

lateinit var myListView: ListView
val stringArrayNames: ArrayList<String> = arrayListOf("Moses Kamira", "James Wafula", "Emmanuel Omona", "Vivian Nabulo", "Judith Had")

class MainActivity : AppCompatActivity() {




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        myListView = findViewById(R.id.list_view)
        if (myListView != null) {
            myListView.adapter = ArrayAdapter<String>(this, R.layout.item_list, ArrayList<String>())!!
        }

        MyAsyncTask().execute()
    }


    class MyAsyncTask : AsyncTask<Void, String, String>(){

        lateinit var newAdapter: ArrayAdapter<String>

        override fun onPreExecute() {
            newAdapter = myListView.adapter as ArrayAdapter<String>
        }

        override fun doInBackground(vararg params: Void?): String  {
            for (name in stringArrayNames) {
                publishProgress(name)

            }
            return "All the Names Were Successfully Added"
        }

        override fun onProgressUpdate(vararg values: String?) {
            newAdapter.add(values[0])

        }

//        override fun onPostExecute(result: String?) {
//            Toast.makeText(, result, Toast.LENGTH_SHORT).show()
//
//        }


    }
}
