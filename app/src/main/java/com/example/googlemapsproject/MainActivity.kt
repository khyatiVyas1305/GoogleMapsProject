package com.example.googlemapsproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.google.android.material.internal.NavigationMenu
import com.google.android.material.navigation.NavigationView


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    lateinit var toggle: ActionBarDrawerToggle
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawerLayout = findViewById<DrawerLayout>(R.id.drawerLayout)
        val navView = findViewById<NavigationView>(R.id.navView)
        val toolbar = findViewById<Toolbar>((R.id.toolBar))
        setSupportActionBar(toolbar)

        //toggle = ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close)
        toggle = ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.open, R.string.close)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()
        navView.setNavigationItemSelectedListener(this)

        if (savedInstanceState == null) {
            updateFragment(GoogleMapFragment())
            navView.setCheckedItem(R.id.googleMap)
        }

//        navView.setNavigationItemSelectedListener {
//
//            when(it.itemId){
//                R.id.googleMap -> Toast.makeText(applicationContext,"Google map!",Toast.LENGTH_SHORT).show()
//                R.id.googlePlaces -> Toast.makeText(applicationContext,"Google Places!",Toast.LENGTH_SHORT).show()
//                R.id.email -> Toast.makeText(applicationContext,"Email!",Toast.LENGTH_SHORT).show()
//                R.id.about -> Toast.makeText(applicationContext,"About !",Toast.LENGTH_SHORT).show()
//            }
//            true
//        }

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.googleMap -> updateFragment(GoogleMapFragment())
            R.id.googlePlaces -> updateFragment(GooglePlacesFragment())
            R.id.email -> updateFragment(EmailFragment())
            R.id.about -> updateFragment(AboutFragment())
        }
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    private fun updateFragment(fragment: Fragment) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frameContainer, fragment)
        transaction.commit()
    }


    override fun onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            onBackPressedDispatcher.onBackPressed()
        }
    }
}

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//
//        if(toggle.onOptionsItemSelected(item)){
//            return true
//        }
//
//        return super.onOptionsItemSelected(item)
//    }


