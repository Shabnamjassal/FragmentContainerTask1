package com.shivani.fragmentcontainertask1

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import android.content.Context

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [FirstFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class FirstFragment  : Fragment(), ActivityClickInterface {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    var mainActivity: MainActivity? = null
    var btnChangeText: Button? = null
    var tvActivityText: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivity = activity as MainActivity
        mainActivity?.activityClickInterface = this
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
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        btnChangeText = view.findViewById(R.id.btnChangeText)
        tvActivityText = view.findViewById(R.id.tvActivityText)

        btnChangeText?.setOnClickListener {
            mainActivity?.changeText("Changed from Fragment")
        }
    }
    override fun onAttach(context:Context) {
        super.onAttach(context)
        Toast.makeText(context, "onAttach", Toast.LENGTH_SHORT).show()
    }
    override fun onStart() {
        super.onStart()
        Toast.makeText(mainActivity, "on Start", Toast.LENGTH_SHORT).show()

    }

    override fun onResume() {
        super.onResume()
        Toast.makeText(mainActivity, "on Resume", Toast.LENGTH_SHORT).show()
        // mainActivity.a = 10
    }
    override fun onPause() {
        super.onPause()
        Toast.makeText(mainActivity, "on Pause", Toast.LENGTH_SHORT).show()
    }
    override fun onStop() {
        super.onStop()
        Toast.makeText(mainActivity, "on Stop", Toast.LENGTH_SHORT).show()
    }
    override fun onDestroyView() {
        super.onDestroyView()
        Toast.makeText(mainActivity, "on DestroyView", Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        Toast.makeText(mainActivity, "on Destroy", Toast.LENGTH_SHORT).show()
    }
    override fun onDetach() {
        super.onDetach()
        Toast.makeText(mainActivity, "onDetach ", Toast.LENGTH_SHORT).show()
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FirstFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FirstFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun ActivityClick(number:Int) {
        tvActivityText?.setText("Changed from activity $number")
    }
}