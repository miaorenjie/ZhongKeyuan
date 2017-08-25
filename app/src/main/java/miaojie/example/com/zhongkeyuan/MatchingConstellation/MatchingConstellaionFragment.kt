package miaojie.example.com.zhongkeyuan.MatchingConstellation

import android.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

import de.hdodenhof.circleimageview.CircleImageView
import kotlinx.android.synthetic.main.main.view.*
import kotlinx.android.synthetic.main.matching_constellation_fragment.view.*
import miaojie.example.com.zhongkeyuan.MatchingConstellation.RatingView.RatingBar
import miaojie.example.com.zhongkeyuan.MatchingConstellation.RatingView.RatingView
import miaojie.example.com.zhongkeyuan.R
import miaojie.example.com.zhongkeyuan.`interface`.ActionBarController
import java.util.*


/**
 * Created by miaojie on 2017/8/13.
 */
class MatchingConstellaionFragment : Fragment() {

    var actionBarController: ActionBarController?=null
    var headPhotograph1:CircleImageView?=null
    var headPhotograph2:CircleImageView?=null
    var headPhotograph3:CircleImageView?=null
    var headPhotograph4:CircleImageView?=null

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {

        var view=inflater!!.inflate(R.layout.matching_constellation_fragment,container,false)
        return view
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
    }



    fun initView(view: View?) {
        actionBarController?.requestNoActionBar()
        val bar1 = RatingBar(1, "洗发水")
        val bar2 = RatingBar(8, "沐浴露")
        val bar3 = RatingBar(3, "洗面奶")
        actionBarController?.getCurrentDate()
        view!!.ratingView.animatorListener = object : RatingView.AnimatorListener {
            override fun onRotateStart() {

            }

            override fun onRotateEnd() {
                view.start_bt.visibility = View.VISIBLE
            }

            override fun onRatingStart() {

            }

            override fun onRatingEnd() {}
        }

        view.ratingView.addRatingBar(bar1)
        view.ratingView.addRatingBar(bar2)
        view.ratingView.addRatingBar(bar3)
//        view.addRatingBar(bar4);
        view.ratingView.show()

        view.start_bt.setOnClickListener {
            view. ratingView.clear()
            bar1.rate = 1
            bar2.rate = 8
            bar3.rate = 3
            view.ratingView.show()
        }
    }

}