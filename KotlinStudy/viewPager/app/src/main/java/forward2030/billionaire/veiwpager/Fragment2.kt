package forward2030.billionaire.veiwpager

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class Fragment2 : Fragment()  {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
            var view = inflater!!.inflate(R.layout.fragment_2, container, false)

            return view
        }
}