package ir.roshdclub.onlinemedrep.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ir.roshdclub.onlinemedrep.R
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@Database(entities = [Medicine::class], version = 1)
abstract class MedicineDatabase: RoomDatabase() {

    abstract fun medicineDao(): MedicineDao


    private class WordDatabaseCallback(
        private val scope: CoroutineScope
    ) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let { database ->
                scope.launch {
                    var medicineDao = database.medicineDao()

                    // Delete all content here.
//                    wordDao.deleteAll()
                    medicineDao.deleteAll()

                    // Add sample words.
                    var word = Medicine(1, "استامینوفن (Acetaminophen)", "Acetaminophen,استامینوفن", "محبوب ترین ها", R.drawable.ic_file, "acetaminophen.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(2, "آموکسی سیلین (Amoxicillin)", "Amoxicillin,آموکسی سیلین", "محبوب ترین ها", R.drawable.ic_file, "amoxicillin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(3, "سفیکسیم (Cefixime)", "Cefixime,سفیکسیم", "محبوب ترین ها", R.drawable.ic_file, "cefixime.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(4, "کلوپیدوگرل (Clopidogrel)", "Clopidogrel,کلوپیدوگرل", "محبوب ترین ها", R.drawable.ic_file, "clopidogrel.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(5, "کو آموکسی کلاو (Coamoxiclove)", "Coamoxiclove,کو آموکسی کلاو", "محبوب ترین ها", R.drawable.ic_file, "coamoxiclove.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(6, "فیلگراستیم (Filgerastim)", "Filgerastim,فیلگراستیم", "محبوب ترین ها", R.drawable.ic_file, "filgerastim.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(7, "متفورمین (Metformin)", "Metformin,متفورمین", "محبوب ترین ها", R.drawable.ic_file, "metformin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(8, "پاک کننده آرایشی", "پاک کننده آرایشی", "دارو های گیاهی", R.drawable.ic_herbal, "cleanmakeup.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(9, "شربت آلوئه ورا", "شربت آلوئه ورا", "دارو های گیاهی", R.drawable.ic_herbal, "aloevera.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(10, "لیتورکس بی", "لیتوریکس بی,litorexb", "دارو های گیاهی", R.drawable.ic_herbal, "litorexb.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(11, "کاف استاپ", "سرفه,کاف استاپ", "دارو های گیاهی", R.drawable.ic_herbal, "coughstop.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(12, "مقاله علمی (۱)", "کبد چرب", "مقالات علمی", R.drawable.ic_copyright, "articleone.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(13, "مقاله علمی (۲)", "هپاتیت", "مقالات علمی", R.drawable.ic_copyright, "articletwo.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(14, "مقاله علمی (۳)", "چربی,آلزایمر", "مقالات علمی", R.drawable.ic_copyright, "articlethree.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(15, "کنفرانس (۱)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "conai.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(16, "کنفرانس (۲)", "کنفرانس,همایش", "همایش ها", R.drawable.ic_lecture, "conbaby.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(17, "کنفرانس (۳)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "conburn.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(18, "کنفرانس (۴)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "confood.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(19, "کنفرانس (۵)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "conintele.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(20, "یافته های پزشکی (۱)", "پزشکی,کنفرانس", "یافته های جدید پزشکی", R.drawable.ic_research, "medicalone.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(21, "یافته های پزشکی (۲)", "پزشکی,کنفرانس", "یافته های جدید پزشکی", R.drawable.ic_research, "medicaltwo.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(22, "یافته های پزشکی (۳)", "پزشکی,کنفرانس", "یافته های جدید پزشکی", R.drawable.ic_research, "medicalthree.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(23, "ریواروکسابان (Rivaroxaban)", "ریواروکسابان,Rivaroxaban", "قلب و عروق", R.drawable.ic_heart, "rivaroxaban.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(24, "آپیکسابان (Apixaban)", "آپیکسابان,apixaban", "قلب و عروق", R.drawable.ic_heart, "apixaban.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(25, "وارفارین (Warfarin)", "وارفارین,warfarin", "قلب و عروق", R.drawable.ic_heart, "warfarin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(26, "هپارین (Heparin)", "هپارین,warfarin", "قلب و عروق", R.drawable.ic_heart, "heparin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(27, "منیزیوم هیدروکسید (Magnesium hydroxide)", "منیزیوم هیدروکسید,warfarin", "گوارش", R.drawable.ic_esophagus, "mgoh.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(28, "آلومینیوم ام جی اس (Aluminium Mg S)", "آلومینیوم ام جی اس,Aluminium Mg S", "گوارش", R.drawable.ic_esophagus, "almgs.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(29, "دومپریدون (Domperidone)", "دومپریدون,Domperidone", "گوارش", R.drawable.ic_esophagus, "domperidone.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(30, "دیفنوکسیلات (Diphenoxylate)", "دیفنوکسیلات,Diphenoxylate", "گوارش", R.drawable.ic_esophagus, "diphenoxylate.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(31, "آلبوترول (Albuterol)", "آلبوترول,albuterol", "گوش و حلق و بینی", R.drawable.ic_throat, "albuterol.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(32, "آموکسی سیلین کالووالناتیک (Caluvenate amoxicillin)", "آموکسی سیلین کالووالناتیک,caluvenate amoxicillin", "گوش و حلق و بینی", R.drawable.ic_throat, "caluvenateamoxicillin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(33, "اریترومایسین (Erythromycin)", "اریترومایسین,Erythromycin", "گوش و حلق و بینی", R.drawable.ic_throat, "erythromycin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(34, "(Viviscal) ویسیکال", "ویسیکال,Viviscal", "پوست و مو", R.drawable.ic_dermis, "viviscal.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(35, "(Topical minoxidil) ماینوکسیدیل موضعی", "ماینوکسیدیل موضعی,Topical minoxidil", "پوست و مو", R.drawable.ic_dermis, "minoxidil.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(36, "(Imedeen) ایمدین", "ایمدین,Imedeen", "پوست و مو", R.drawable.ic_dermis, "imedeen.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(37, "فنوباربیتال (Phenobarbital)", "فنوباربیتال,Phenobarbital", "مغز و اعصاب", R.drawable.ic_intelligence, "phenobarbital.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(38, "ایزوسورباید دی نیترات (Isosorbide dinitrate)", "Isosorbide dinitrate,ایزوسورباید دی نیترات", "مغز و اعصاب", R.drawable.ic_intelligence, "isosorbidedinitrate.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(39, "کلونازپام (Clonazepam)", "کلونازپام,clonazepam", "مغز و اعصاب", R.drawable.ic_intelligence, "")
                    medicineDao.insertMedicines(word)
                    word = Medicine(40, "لورازپام (Lorazepam)", "لورازپام,Lorazepam", "اعصاب و روان", R.drawable.ic_neurology, "lorazepam.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(41, "دیازپام (Diazepam)", "دیازپام,Diazepam", "اعصاب و روان", R.drawable.ic_neurology, "diazepam.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(42, "(Chlordiazepoxide) کلردیازپوکساید", "کلردیازپوکساید,Chlordiazepoxide", "اعصاب و روان", R.drawable.ic_neurology, "chlordiazepoxide.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(43, "(Fiber cell) فایبرسل", "فایبرسل,fiber cell", "ورزشی", R.drawable.ic_protein_supplement, "fibercell.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(44, "(Whey gold) وی گلد 908 گرم ژن استار", "وی گلد 908 گرم ژن استار,Whey gold", "ورزشی", R.drawable.ic_protein_supplement, "wheygold.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(45, "(AAKG Extreme) ای ای کی جی اکستریم 1250 مگا کپس", "ای ای کی جی اکستریم 1250 مگا کپس,AAKG Extreme", "ورزشی", R.drawable.ic_protein_supplement, "aakg.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(46, "(Creatine) ال کراتین", "کراتین,Creatine", "غذایی", R.drawable.ic_pills_bottle, "creatine.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(47, "(Melatonin) ملاتونین", "ملاتونین,Melatonin", "غذایی", R.drawable.ic_pills_bottle, "melatonin.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(48, "(Creatine Monohydrate) کراتین مونوهیدرات", "کراتین مونوهیدرات,Creatine Monohydrate", "غذایی", R.drawable.ic_pills_bottle, "creatinemono.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(49, "(Hair Skin And Nails FemMed) فم مد", "فم مد,Hair Skin And Nails FemMed", "پوست مو ناخن", R.drawable.ic_dermis, "femmed.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(50, "(Acti Derm) اکتی درم", "اکتی درم,acti derm", "پوست مو ناخن", R.drawable.ic_dermis, "actiderm.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(51, "(Ekolife) اکولایف", "اکولایف,acti derm", "پوست مو ناخن", R.drawable.ic_dermis, "ekolife.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(52, "(Ram Joice) رام جویس", "رام جویس,Ram joice", "کودکان", R.drawable.ic_supplement, "ramjoice.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(53, "(Cami Cough) کامی کاف", "کامی کاف,Cami Cough", "کودکان", R.drawable.ic_supplement, "camicough.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(54, "کیدزی کولیک (Kidssi Colic)", "کیدزی کولیک,Kidssi Colic", "کودکان", R.drawable.ic_supplement, "kidssicolic.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(55, "همایش (۶)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "conbio.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(56, "همایش (۷)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "concare.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(57, "همایش (۸)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "conmedical.pdf")
                    medicineDao.insertMedicines(word)
                    word = Medicine(58, "همایش (۹)", "همایش,کنفرانس", "همایش ها", R.drawable.ic_lecture, "concan.pdf")
                    medicineDao.insertMedicines(word)


                }
            }
        }
    }


        companion object {

            /**
             * This is just for singleton pattern
             */
            private var INSTANCE: MedicineDatabase? = null

            fun getDatabase(context: Context, scope: CoroutineScope): MedicineDatabase {
                if (INSTANCE == null) {
                    synchronized(MedicineDatabase::class.java) {
                        if (INSTANCE == null) {
                            // Get PhraseRoomDatabase database instance
                            INSTANCE = Room.databaseBuilder(
                                context.applicationContext,
                                MedicineDatabase::class.java, "medicine_database"
                            )
                                .addCallback(WordDatabaseCallback(scope))
                                .build()
                        }
                    }
                }
                return INSTANCE!!
            }
        }



}