package forward2030.billionaire.progressbar

import android.os.AsyncTask
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //불확정성 ProgressBar
        button1.setOnClickListener {
            if (progressBar1.visibility == View.INVISIBLE)
                progressBar1.visibility = View.VISIBLE
            else
                progressBar1.visibility == View.INVISIBLE
        }

        //확정성 ProgressBar
        button2.setOnClickListener {
            progressBar2.visibility = View.VISIBLE
            var i = 0
            object : AsyncTask<Void, Void, Void>()  {
                override fun doInBackground(vararg p0: Void?): Void? {
                    while (i <= 100)  {
                        progressBar2.setProgress(i)
                        i = i + 1
                        Thread.sleep(100)
                    }

                    return null
                }

            }.execute()
        }
    }
}
