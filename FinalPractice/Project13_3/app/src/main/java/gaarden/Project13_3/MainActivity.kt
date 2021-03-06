package gaarden.Project13_3

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapFragment
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.GroundOverlayOptions
import com.google.android.gms.maps.model.LatLng

class MainActivity : AppCompatActivity(), OnMapReadyCallback {

    lateinit var gMap: GoogleMap
    lateinit var mapFrag: MapFragment
    lateinit var videoMark: GroundOverlayOptions

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        title="Google 지도 활용"

        mapFrag = fragmentManager.findFragmentById(R.id.map) as MapFragment
        mapFrag.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        gMap = map

        gMap.uiSettings.isZoomControlsEnabled = true
        gMap.setOnMapClickListener { point->
            videoMark = GroundOverlayOptions().image(
                BitmapDescriptorFactory.fromResource(R.drawable.
                presence_video_busy)).position(point, 100f, 100f)

            gMap.addGroundOverlay(videoMark)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        super.onCreateOptionsMenu(menu)
        menu.add(0, 1, 0, "위성 지도")
        menu.add(0, 2, 0, "일반 지도")
        menu.add(0, 3, 0, "일청담 바로가기")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            1->{
                gMap.mapType = GoogleMap.MAP_TYPE_HYBRID
                return true
            }

            2->{
                gMap.mapType = GoogleMap.MAP_TYPE_NORMAL
                return true
            }

            3->{
                gMap.moveCamera(CameraUpdateFactory.newLatLngZoom(LatLng(35.888663, 128.612122), 18f))
            }
        }

        return false
    }


}