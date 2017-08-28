package miaojie.example.com.zhongkeyuan.Utils

import android.app.Activity
import android.content.Context
import android.location.Location
import android.location.LocationManager
import android.support.v4.app.ActivityCompat
import android.util.Log

/**
 * Created by miaorenjie_sx on 2017/8/28.
 */
object LocationUtil {
    var gpsEnable=false
    fun getLocation(activity: Activity):Location{

        var locationManager:LocationManager= activity.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        val location = locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER)
        Log.e("asd",location.altitude.toString())
        return location
    }
}