package com.example.fragmentsuebung

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.SurfaceControl
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.fragmentsuebung.database.*
import com.example.fragmentsuebung.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    val mManager = supportFragmentManager
    val mFragment = InputFragment()
    val mTransaction = mManager.beginTransaction()

    private lateinit var binding: ActivityMainBinding
    private lateinit var vehicleViewModel: VehicleViewModel
  //  private lateinit var adapter: MyRecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        val dao: VehicleDAO = VehicleDatabase.getInstance(application).vehicleDAO
        val repository = VehicleRepository(dao)
        val factory = VehicleViewModelFactory(repository)
        vehicleViewModel = ViewModelProvider(this, factory).get(VehicleViewModel::class.java)
        binding.myViewMode = vehicleViewModel
        binding.lifecycleOwner = this

        mTransaction.replace(R.id.FragmeantPlace, mFragment)
        mTransaction.commit()
    }


}
