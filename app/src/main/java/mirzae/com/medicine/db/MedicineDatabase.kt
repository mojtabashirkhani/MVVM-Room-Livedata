package mirzae.com.medicine.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Medicine::class], version = 1)
abstract class MedicineDatabase: RoomDatabase() {

    abstract fun medicineDao(): MedicineDao

    companion object {

        /**
         * This is just for singleton pattern
         */
        private var INSTANCE: MedicineDatabase? = null

        fun getDatabase(context: Context): MedicineDatabase {
            if (INSTANCE == null) {
                synchronized(MedicineDatabase::class.java) {
                    if (INSTANCE == null) {
                        // Get PhraseRoomDatabase database instance
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            MedicineDatabase::class.java, "medicine_database"
                        )
                            .allowMainThreadQueries()
                            .build()
                    }
                }
            }
            return INSTANCE!!
        }
    }


}