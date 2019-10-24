package mirzae.com.medicine.ui.about

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class AboutUsViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "تیم اپلیکیشن \"مدرپ آنلاین\" با بکار گیری جدید ترین اطلاعات روز، برای بالا بردن اطلاعات و آگاهی شما نسبت به داروها و اطلاعات جدید پزشکی فعالیت میکند.\n" +
                "هدف ما ترویج اطلاعات صحیح پزشکی،بالا بردن سطح اطلاعات دارویی و خدمت به جامعه جهت ارتقای سطح سلامت است.\n" +
                "با اپلیکیشن \"مدرپ آنلاین\" همیشه یک داروخانه به روز همراه خود داشته باشید."
    }
    val text: LiveData<String> = _text
}