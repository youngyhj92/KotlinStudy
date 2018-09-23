package forward2030.billionaire.veiwpager

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        howl_viewPager.adapter = MainViewPagerAdapter(supportFragmentManager)

        howlTabLayout.addTab(howlTabLayout.newTab().setText("Fragment1"))
        howlTabLayout.addTab(howlTabLayout.newTab().setText("Fragment2"))
        howlTabLayout.addOnTabSelectedListener(object:TabLayout.OnTabSelectedListener  {
            override fun onTabReselected(p0: TabLayout.Tab?) {
            }

            override fun onTabUnselected(p0: TabLayout.Tab?) {

            }

            override fun onTabSelected(p0: TabLayout.Tab?) {
               howl_viewPager.setCurrentItem(p0!!.position)
            }

        })
        howl_viewPager.addOnPageChangeListener(object:TabLayout.TabLayoutOnPageChangeListener(howlTabLayout){})
    }

    class MainViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {

        var fragment = arrayOf(Fragment1(), Fragment2())

        //화면을 넣어주는 부분
        override fun getItem(p0: Int): Fragment {
            return fragment[p0]
        }

        //전체 아이템의 개수를 파악하는 부분
        override fun getCount(): Int {
            return fragment.size
        }

    }
}
