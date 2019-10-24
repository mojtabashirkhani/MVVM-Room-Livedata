package ir.roshdclub.onlinemedrep.ui.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.roshdclub.onlinemedrep.R

class SubjectViewModel: ViewModel() {

    private val mTxtProfession = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("قلب و عروق", "گوارش", "گوش و حلق و بینی", "پوست و مو", "مغز و اعصاب", "اعصاب و روان")
    }

    private val mTxtSupplements = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("ورزشی", "غذایی", "پوست مو ناخن", "کودکان")
    }

    private val mTxtArticles = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("آخرین مقالات", "پادکست ها")
    }

    private val mTxtConference = MutableLiveData<ArrayList<String>>().apply {
      value = arrayListOf("همایش های بین المللی", "همایش های ملی")
    }

    val txtProfession: LiveData<ArrayList<String>> = mTxtProfession
    val txtSupplements : LiveData<ArrayList<String>> = mTxtSupplements
    val txtArticles: LiveData<ArrayList<String>> = mTxtArticles
    val txtConference: LiveData<ArrayList<String>> = mTxtConference

}