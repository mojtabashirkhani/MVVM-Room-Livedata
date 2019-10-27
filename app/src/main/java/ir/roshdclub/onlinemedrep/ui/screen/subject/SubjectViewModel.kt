package ir.roshdclub.onlinemedrep.ui.screen.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.roshdclub.onlinemedrep.R

class SubjectViewModel: ViewModel() {

    private val mTxtProfession = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("قلب و عروق", "گوارش", "گوش و حلق و بینی",
            "پوست و مو", "مغز و اعصاب", "اعصاب و روان")
    }

    private val mTxtSupplements = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("ورزشی", "غذایی", "پوست مو ناخن", "کودکان")
    }

    private val mImageProfession = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.ic_heart, R.drawable.ic_esophagus,
            R.drawable.ic_throat, R.drawable.ic_dermis,
            R.drawable.ic_intelligence, R.drawable.ic_neurology)
    }

    private val mImageSupplements = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.ic_protein_supplement, R.drawable.ic_pills_bottle,
            R.drawable.ic_dermis, R.drawable.ic_supplement)
    }



    val txtProfession: LiveData<ArrayList<String>> = mTxtProfession
    val txtSupplements : LiveData<ArrayList<String>> = mTxtSupplements
    val imgProfession: LiveData<ArrayList<Int>> = mImageProfession
    val imgSupplements: LiveData<ArrayList<Int>> = mImageSupplements


}