package com.dev.davidgaspar.dsunshine

import android.support.v7.app.AppCompatActivity
import android.support.v4.app.Fragment
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.LayoutInflater
import android.view.ViewGroup
import android.view.View
import android.widget.ArrayAdapter
import android.widget.ListView

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if(savedInstanceState == null) supportFragmentManager.beginTransaction().add(R.id.container, PlaceholderFragment()).commit()

    }

    override fun onCreateOptionsMenu(menu: Menu?) : Boolean {

        // Inflate the menu; this adds items to the action bar if it is parent.
        menuInflater.inflate(R.menu.main, menu)
        return true

    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        val id : Int = item?.itemId!!

        if(id == R.id.action_settings) return true

        return super.onOptionsItemSelected(item)
    }


    class PlaceholderFragment: Fragment() {

        /**
         * @param android.view.LayoutInflater inflater
         * @param android.view.ViewGroup container
         * @param android.os.Bundle savedInstanceState
         */
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup? , savedInstanceState: Bundle?) : View? {

            // Final initialization
            val root: View = inflater.inflate(R.layout.fragment_main, container, false)

            val list: ArrayList<String> = ArrayList()
            list.add("Today - Sunny - 88/63")
            list.add("Tomorrow - Foggy - 70/46")
            list.add("Weds - Cloudy - 72/46")
            list.add("Thurs - Rainy - 64/51")
            list.add("Fri - Foggy - 70/46")
            list.add("Sat - Sunny - 76/68")

            val listAdapter: ArrayAdapter<String> = ArrayAdapter(activity, R.layout.list_item_forecast, R.id.forecast_item, list)
            val listView: ListView = root.findViewById(R.id.listview_forecast)
            listView.adapter = listAdapter

            return root

        }

    }

}
