package gaarden.Project14_1_2

import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.IBinder
import android.widget.Toast

class MusicService : Service() {

    lateinit internal var mp: MediaPlayer

    override fun onBind(intent: Intent): IBinder? {
        return null
    }

    override fun onCreate() {
        Toast.makeText(applicationContext, "onCreate()", Toast.LENGTH_SHORT).show()
        super.onCreate()
    }

    override fun onDestroy() {
        Toast.makeText(applicationContext, "onDestroy()", Toast.LENGTH_SHORT).show()
        mp.stop()
        super.onDestroy()
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        Toast.makeText(applicationContext, "onStartCommand()", Toast.LENGTH_SHORT).show()

        mp = MediaPlayer.create(this, R.raw.song1)
        mp.isLooping = true
        mp.start()
        return super.onStartCommand(intent, flags, startId)

    }

}