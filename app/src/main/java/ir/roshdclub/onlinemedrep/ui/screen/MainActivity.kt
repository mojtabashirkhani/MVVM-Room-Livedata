package ir.roshdclub.onlinemedrep.ui.screen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView
import ir.roshdclub.onlinemedrep.ui.listener.HomeInteractionListener
import ir.roshdclub.onlinemedrep.ui.listener.SubjectInteractionListener
import ir.roshdclub.onlinemedrep.R
import ir.roshdclub.onlinemedrep.ui.listener.DrugIntractionListener

class MainActivity : AppCompatActivity(), HomeInteractionListener, SubjectInteractionListener, DrugIntractionListener {



    override fun drugToDetail(name: String) {
        val args = Bundle()
        args.putString("name",name)

        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_drug_to_nav_detail, args)
    }

    override fun homeToSubject(position: Int) {
        val args = Bundle()
        args.putInt("position", position)
        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_subject, args)
    }

    override fun homeToDrug(subject: String) {
        val args = Bundle()
        args.putString("subject", subject)

        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_home_to_nav_drug, args)
    }

    override fun subjectToDrug(subject: String) {
        val args = Bundle()
        args.putString("subject", subject)

        findNavController(R.id.nav_host_fragment).navigate(R.id.action_nav_subject_to_nav_drug, args)
    }


    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)

      /*  val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_account, R.id.nav_contactus,
                 R.id.nav_aboutus
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }



    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
