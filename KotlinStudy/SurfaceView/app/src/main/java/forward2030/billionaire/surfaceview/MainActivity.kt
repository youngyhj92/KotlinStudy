package forward2030.billionaire.surfaceview

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.SurfaceHolder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(),SurfaceHolder.Callback, MediaPlayer.OnPreparedListener {


    var surfaceHolder : SurfaceHolder? = null
    var mediaPlayer : MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        surfaceHolder = surfaceView.holder
        surfaceHolder!!.addCallback(this)
        btn_back.setOnClickListener {
            var position = mediaPlayer!!.currentPosition - 5000
            mediaPlayer!!.seekTo(position)
        }
        btn_faster.setOnClickListener {
            var position = mediaPlayer!!.currentPosition + 5000
            mediaPlayer!!.seekTo(position)
        }
        btn_stop.setOnClickListener {
            mediaPlayer!!.pause()
        }
        btn_play.setOnClickListener {
            mediaPlayer!!.start()
        }
    }

    override fun surfaceChanged(p0: SurfaceHolder?, p1: Int, p2: Int, p3: Int) {
    }

    override fun surfaceDestroyed(p0: SurfaceHolder?) {

    }

    override fun surfaceCreated(p0: SurfaceHolder?) {
        var url = "https://www.radiantmediaplayer.com/media/bbb-360p.mp4"
        mediaPlayer = MediaPlayer()
        mediaPlayer!!.setDisplay(p0)
        mediaPlayer!!.setDataSource(url)
        mediaPlayer!!.prepare()
        mediaPlayer!!.setOnPreparedListener(this)
    }

    override fun onPrepared(p0: MediaPlayer?) {
        mediaPlayer!!.start()
    }
}
