package com.mattercube.intentscompanionapp


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button

// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WelcomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class WelcomeFragment : Fragment() {
    private var param1: String? = null
    private var param2: String? = null

    // The buttons
    private var style1: Button? = null
    private var style2: Button? = null
    private var style3: Button? = null

    private var parcel: Intent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_welcome, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // Assigning Buttons by finding their views
        style1 = view?.findViewById(R.id.button_style1)
        style2 = view?.findViewById(R.id.button_style2)
        style3 = view?.findViewById(R.id.button_style3)

        // Set the button on click listeners
        style1?.setOnClickListener {
            prepReturnIntent(1)
            returnIntent()
        }

        style2?.setOnClickListener {
            // Toast here
        }

        style3?.setOnClickListener {
            // Toast here
        }
    }

    fun prepReturnIntent(style: Int) {

        if (style == 1) {
            parcel = Intent().putExtra("com.mattercube.basicfragments.FONT_VALUE", 1)
        }

        else if (style == 2) {
            parcel = Intent().putExtra("com.mattercube.basicfragments.FONT_VALUE", 2)
        }

        else {
            parcel = Intent().putExtra("com.mattercube.basicfragments.FONT_VALUE", 3)
        }

    }

    fun returnIntent(){
        this.activity?.setResult(Activity.RESULT_OK, parcel)
        this.activity?.finish()
    }
}
