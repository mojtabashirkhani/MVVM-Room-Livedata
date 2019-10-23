package mirzae.com.medicine.ui.subject

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import mirzae.com.medicine.R

class SubjectViewModel: ViewModel() {

    private val txtSubject = MutableLiveData<ArrayList<String>>().apply {
        value = arrayListOf("محبوب‌ ترین ها", "تخصص ها", "داروهای گیاهی", "مکمل ها", "مقالات علمی", "همایش ها", "یافته های جدید پزشکی")
    }

    private val imgSubject = MutableLiveData<ArrayList<Int>>().apply {
        value = arrayListOf(
            R.drawable.ic_file, R.drawable.ic_doctor, R.drawable.ic_herbal , R.drawable.ic_vitamins,
            R.drawable.ic_copyright, R.drawable.ic_lecture, R.drawable.ic_research)

    }

    val list: LiveData<ArrayList<String>> = txtSubject
    val image: LiveData<ArrayList<Int>> = imgSubject

}