package miaojie.example.com.zhongkeyuan
import android.Manifest
import android.app.FragmentTransaction
import android.content.pm.PackageManager
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.ActivityCompat
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.Toolbar
import android.util.Log
import android.view.View

import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*
import miaojie.example.com.zhongkeyuan.MatchingConstellation.MatchingConstellaionFragment
import miaojie.example.com.zhongkeyuan.Utils.LocationUtil
import miaojie.example.com.zhongkeyuan.`interface`.ActionBarController
import java.util.*

class MainActivity : AppCompatActivity(), ActionBarController {
    override fun getCurrentDate() {
        var c = Calendar.getInstance()
        var month: Int =c.get(Calendar.MONTH)
        month+=1
        var day:Int=c.get(Calendar.DAY_OF_MONTH)
        currentDate.setText(month.toString()+"月"+day.toString()+"日")
    }

    override fun requestNoActionBar() {
        toolBar.visibility= View.GONE
    }

    override fun setActionBar(toolbar: Toolbar) {
        setSupportActionBar(toolbar)
    }

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_match -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_earth -> {

                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_photo -> {

                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolBar)
        val matchingConstellationFragment: MatchingConstellaionFragment = MatchingConstellaionFragment()
        matchingConstellationFragment.actionBarController =this
        var permissions= arrayOf(Manifest.permission.ACCESS_FINE_LOCATION)
        requestPermission(permissions)
        val transaction: FragmentTransaction =fragmentManager.beginTransaction()
        transaction.replace(R.id.content_main,matchingConstellationFragment,"1")
        transaction.commit()
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }
    fun requestPermission(permissions:Array<String>)
    {
        ActivityCompat.requestPermissions(this,permissions,1)
    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if (requestCode==1)
        {
            Log.e("asd","success")
            LocationUtil.getLocation(this)

        }
    }
}


