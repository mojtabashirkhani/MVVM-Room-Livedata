package ir.roshdclub.onlinemedrep.ui.screen.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import ir.roshdclub.onlinemedrep.R

class HomeViewModel : ViewModel() {

/*    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text*/
    private val txtSubject = MutableLiveData<ArrayList<String>>().apply {
    value = arrayListOf("محبوب ترین ها", "تخصص ها", "داروهای گیاهی", "مکمل ها", "مقالات علمی", "همایش ها", "یافته های جدید پزشکی")
    }
    private val imgSubject = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.ic_file, R.drawable.ic_doctor,R.drawable.ic_herbal , R.drawable.ic_vitamins,
            R.drawable.ic_copyright, R.drawable.ic_lecture, R.drawable.ic_research)

    }

    val list: LiveData<ArrayList<String>> = txtSubject
    val image: LiveData<ArrayList<Int>> = imgSubject
}