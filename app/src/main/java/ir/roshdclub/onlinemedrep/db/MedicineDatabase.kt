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
                    var word = Medicine(1, "استامینوفن (Acetaminophen)", "acetaminophen,استامینوفن", "محبوب ترین ها", R.drawable.ic_file, "acetaminophen.pdf")
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