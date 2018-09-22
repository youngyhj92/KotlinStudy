package forward2030.billionaire.kotlinstudy

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        howlRecyclerView.adapter = MainRecyclerViewAdapter()
        var gridManager= GridLayoutManager(this, 3)
        howlRecyclerView.layoutManager =gridManager
        
        gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup()  {
            override fun getSpanSize(p0: Int): Int {
                if(p0 == 0)  {
                    return 3
                }
                return 1
            }

        }


    }

    class MainRecyclerViewAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>()  {
        var images = arrayOf(R.drawable.test, R.drawable.test2, R.drawable.test3, R.drawable.test4)

        override fun onCreateViewHolder(p0: ViewGroup, p1: Int): RecyclerView.ViewHolder {
            var view = LayoutInflater.from(p0!!.context).inflate(R.layout.item_layout,p0,false)
            var params = view.layoutParams

            if(p1 == 0)  {
                params.height = (p0.measuredWidth / 3) * 2
                params.width = p0.measuredWidth
                view.layoutParams = params
                return CustomViewHolder(view)
            }
            params.height = p0.measuredWidth / 3
            params.width = p0.measuredWidth / 3
            view.layoutParams = params
            return CustomViewHolder(view)

        }

        class CustomViewHolder(view: View?) : RecyclerView.ViewHolder(view!!) {
            var imageView : ImageView? = null
            init {
                imageView = view!!.findViewById(R.id.layoutItem_imageView)
            }

        }

        // 포지션 값에 따라서 타입을 바꿔주는 기능. - onCreateViewHolder
        override fun getItemViewType(position: Int): Int {
            if(position == 0)  {
                return 0
            }
            return 1
        }

        override fun getItemCount(): Int {
          return images.size
        }

        override fun onBindViewHolder(p0: RecyclerView.ViewHolder, p1: Int) {
            var view = p0 as CustomViewHolder
            view!!.imageView!!.setImageResource(images[p1])
        }


    }
}
