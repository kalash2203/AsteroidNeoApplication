package com.example.asteroidneoapplication.ui.fragment

import android.app.DatePickerDialog
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.DatePicker
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.asteroidneoapp.viewmodels.MainViewModel
import com.example.asteroidneoapp.viewmodels.MainViewModelFactory
import com.example.asteroidneoapplication.AsteroidApplication
import com.example.asteroidneoapplication.MainActivity
import com.example.asteroidneoapplication.R
import com.example.asteroidneoapplication.databinding.FragmentHomeBinding
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject


class HomeFragment : Fragment() {
    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!
    lateinit var mainViewModel: MainViewModel
    var cal = Calendar.getInstance()
    var startDate:String=""
    var endDate:String=""

    @Inject
    lateinit var mainViewModelFactory: MainViewModelFactory
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment cntainer, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)


        (activity?.application as AsteroidApplication).applicationComponent.inject((this))
        mainViewModel= ViewModelProvider(this,mainViewModelFactory)
            .get(MainViewModel::class.java)


        // create an OnDateSetListener
        val dateSetListenerStart = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInViewStart()

            }
        }
        // create an OnDateSetListener
        val dateSetListenerEnd = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(view: DatePicker, year: Int, monthOfYear: Int,
                                   dayOfMonth: Int) {
                cal.set(Calendar.YEAR, year)
                cal.set(Calendar.MONTH, monthOfYear)
                cal.set(Calendar.DAY_OF_MONTH, dayOfMonth)
                updateDateInViewEnd()

            }
        }
        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        binding.txtFragmentHomeStartDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(requireContext(),
                    dateSetListenerStart,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
        // when you click on the button, show DatePickerDialog that is set with OnDateSetListener
        binding.txtFragmentHomeEndDate!!.setOnClickListener(object : View.OnClickListener {
            override fun onClick(view: View) {
                DatePickerDialog(requireContext(),
                    dateSetListenerEnd,

                    cal.get(Calendar.YEAR),
                    cal.get(Calendar.MONTH),
                    cal.get(Calendar.DAY_OF_MONTH)).show()
            }

        })
binding.btnSubmit.setOnClickListener {
    if(mainViewModel.checkIsEmpty(startDate,endDate)) {
        if(mainViewModel.checkDifferenceOfDates(startDate,endDate)) {
            mainViewModel.getAsteroidData(startDate, endDate)
            mainViewModel.asteroidsLiveData.observe(viewLifecycleOwner, Observer {
                val action = HomeFragmentDirections.actionHomeFragmentToAsteroidDetailsFragment(it)
                findNavController().navigate(action)
            })

        }
        else
            Toast.makeText(requireContext(),"Date difference should be 7 or less than 7 days",Toast.LENGTH_SHORT).show()
    }
    else
        Toast.makeText(requireContext(),"Start Date And End Date should not be empty",Toast.LENGTH_SHORT).show()

}
        return binding.root
    }
    private fun updateDateInViewStart() {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        startDate = sdf.format(cal.getTime())
      binding.txtFragmentHomeStartDate.text=startDate
    }
    private fun updateDateInViewEnd() {
        val myFormat = "yyyy-MM-dd"
        val sdf = SimpleDateFormat(myFormat, Locale.US)
        endDate = sdf.format(cal.getTime())
binding.txtFragmentHomeEndDate.text=endDate
    }
    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

