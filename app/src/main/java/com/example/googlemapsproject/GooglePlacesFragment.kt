package com.example.googlemapsproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

lateinit var placeArrayList: ArrayList<Places>
lateinit var adapter: MyAdapter
lateinit var recyclerView: RecyclerView

lateinit var iconImg: ArrayList<Int>
lateinit var placeName: ArrayList<String>


class GooglePlacesFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_google_places, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        dataInit()
        val layoutManager = LinearLayoutManager(context)
        recyclerView = view.findViewById(R.id.recyclerView)
        recyclerView.layoutManager = layoutManager
        recyclerView.setHasFixedSize(true)
        adapter = MyAdapter(placeArrayList)
        recyclerView.adapter = adapter
    }

    private fun dataInit(){
        placeArrayList = arrayListOf<Places>()

        iconImg = arrayListOf(
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            R.drawable.ic_location,
            )

        placeName = arrayListOf(
            "London,On",
            "Toronto",
            "Montreal",
            "London,On",
            "Toronto",
            "Montreal",
            "London,On",
            "Toronto",
            "Montreal",
        )

        for(i in iconImg.indices){
            val place = Places(iconImg[i], placeName[i])
            placeArrayList.add(place)
        }
    }
}