package ir.roshdclub.onlinemedrep.ui.screen.contactus

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ContactUsViewModel: ViewModel() {

    private val mTxtContactUs = MutableLiveData<String>().apply {
        value = "با ما در تماس باشید.\n" +
                "منتظر نظرات،انتقادات و پیشنهادات شما هستیم.\n"

    }

    private val mTxtPhone = MutableLiveData<String>().apply {
        value = "شماره تماس: ۰۹۹۰۸۸۳۳۳۹۵"
    }

    private val mTxtWebsite = MutableLiveData<String>().apply {
        value = "وبسایت: www.roshdclub.ir"
    }

    val txtContactUs: LiveData<String> = mTxtContactUs
    val txtPhone: LiveData<String> = mTxtPhone
    val txtWebsite: LiveData<String> = mTxtWebsite
}