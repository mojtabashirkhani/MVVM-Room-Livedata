package mirzae.com.medicine.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mirzae.com.medicine.R

class HomeViewModel : ViewModel() {

/*    private val _text = MutableLiveData<String>().apply {
        value = "This is home Fragment"
    }
    val text: LiveData<String> = _text*/
    private val txtSubject = MutableLiveData<ArrayList<String>>().apply {
    value = arrayListOf("1","2","3","4","5","6")
    }
    private val imgSubject = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(R.drawable.ic_copyright,R.drawable.ic_doctor,R.drawable.ic_file,R.drawable.ic_lecture
        ,R.drawable.ic_research,R.drawable.ic_vitamins)
    }

    val list: LiveData<ArrayList<String>> = txtSubject
    val image: LiveData<ArrayList<Int>> = imgSubject
}