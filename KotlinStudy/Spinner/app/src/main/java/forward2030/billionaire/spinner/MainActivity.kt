package forward2030.billionaire.spinner

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    var countries = arrayOf("한국", "미국")
    var city_korea = arrayOf("Seoul","Daejeon","Busan")
    var city_usa = arrayOf("New York", "워싱턴", "LA")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countryAdapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,countries)
        spinner_country.adapter = countryAdapter

        spinner_country.onItemSelectedListener = object : AdapterView.OnItemSelectedListener  {
            override fun onNothingSelected(p0: AdapterView<*>?) {

            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {
                var country = p0!!.getItemAtPosition(p2)

                if(country == "한국")  {
                    var adapter = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,city_korea)
                    spinner_city.adapter = adapter
                } else if(country == "미국")  {
                    var adapter2 = ArrayAdapter<String>(this@MainActivity,android.R.layout.simple_spinner_dropdown_item,city_usa)
                    spinner_city.adapter = adapter2
                }
            }
        }

        spinner_city.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(p0: AdapterView<*>?) {
            }

            override fun onItemSelected(p0: AdapterView<*>?, p1: View?, p2: Int, p3: Long) {

                var country = p0!!.getItemAtPosition(p2).toString()
                Toast.makeText(this@MainActivity,country+"를 선택하셨습니다",Toast.LENGTH_LONG).show()
            }

        }
    }
}
