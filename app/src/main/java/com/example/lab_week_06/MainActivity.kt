package com.example.lab_week_06

import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.lab_week_06.model.CatBreed
import com.example.lab_week_06.model.CatModel
import com.example.lab_week_06.model.Gender

class MainActivity : AppCompatActivity() {

    private val recyclerView: RecyclerView by lazy { findViewById(R.id.recycler_view) }

    private val catAdapter by lazy {
        CatAdapter(
            layoutInflater,
            GlideImageLoader(this),
            object : CatViewHolder.OnClickListener {      // << ganti tipe listener
                override fun onClick(cat: CatModel) {
                    showSelectionDialog(cat)
                }
            }
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.adapter = catAdapter
        recyclerView.layoutManager = LinearLayoutManager(this)

        val itemTouchHelper = androidx.recyclerview.widget.ItemTouchHelper(catAdapter.swipeToDeleteCallback)
        itemTouchHelper.attachToRecyclerView(recyclerView)

        catAdapter.setData(
            listOf(
                CatModel(Gender.Male,   CatBreed.BalineseJavanese, "Fred",   "Silent and deadly",          "https://cdn2.thecatapi.com/images/7dj.jpg"),
                CatModel(Gender.Female, CatBreed.ExoticShorthair,  "Wilma",  "Cuddly assassin",            "https://cdn2.thecatapi.com/images/egv.jpg"),
                CatModel(Gender.Unknown,CatBreed.AmericanCurl,     "Curious George","Award winning investigator","https://cdn2.thecatapi.com/images/bar.jpg"),
                CatModel(Gender.Male,   CatBreed.AmericanCurl,     "Ollie",  "Window-sill philosopher",    "https://cdn2.thecatapi.com/images/8ap.jpg"),
                CatModel(Gender.Female, CatBreed.BalineseJavanese, "Mochi",  "Zoomies at 3 AM",            "https://cdn2.thecatapi.com/images/2oo.jpg"),
                CatModel(Gender.Male,   CatBreed.ExoticShorthair,  "Simba",  "Nap enthusiast",             "https://cdn2.thecatapi.com/images/9je.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl,     "Nala",   "Laser pointer hunter",       "https://cdn2.thecatapi.com/images/aei.jpg"),
                CatModel(Gender.Unknown,CatBreed.ExoticShorthair,  "Pudding","Head-bump specialist",       "https://cdn2.thecatapi.com/images/ccv.jpg"),
                CatModel(Gender.Male,   CatBreed.BalineseJavanese, "Biscuit","Sunbeam sleeper",            "https://cdn2.thecatapi.com/images/b1o.jpg"),
                CatModel(Gender.Female, CatBreed.AmericanCurl,     "Cleo",   "Bird watcher extraordinaire","https://cdn2.thecatapi.com/images/3tb.jpg")
         )
        )
    }

    private fun showSelectionDialog(cat: CatModel) {
        AlertDialog.Builder(this)
            .setTitle("Cat Selected")
            .setMessage("You have selected cat ${cat.name}")
            .setPositiveButton("OK") { _, _ -> }
            .show()
    }
}
