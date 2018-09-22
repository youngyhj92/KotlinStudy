package forward2030.billionaire.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        howlRecyclerView.adapter = MainRecyclerViewAdapter()
        howlRecyclerView.layoutManager = LinearLayoutManager(this)
    }

    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
        var images = arrayOf(R.drawable.test, R.drawable.test2, R.drawable.test3, R.drawable.test4)
        var titles = arrayOf("프랑크프루트", "런던", "파리", "서울")
        var countries = arrayOf("독일", "영국", "프랑스", "한국")

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(p0!!.context).inflate(R.layout.item_layout, p0,false)

            return CustomViewHolder(view)
        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
            var imageView:ImageView? = null
            var textView : TextView? = null
            var textView2 : TextView? = null
            init {
                imageView = view?.findViewById(R.id.profileImageView)
                textView = view?.findViewById(R.id.title_TextView)
                textView2 = view?.findViewById(R.id.country_textView)
            }

        }

        override fun getItemCount(): Int {
          return images.size
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            var view = p0 as CustomViewHolder
            view.imageView?.setImageResource(images[p1])
            view.textView?.text = titles[p1]
            view.textView2?.text = countries[p1]
        }

    }
}
