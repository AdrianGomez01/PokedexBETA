package com.example.pokedex

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.pokedex.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding
        get() = _binding!!

    private lateinit var drawerLayout: DrawerLayout
    private lateinit var sharedViewModel: SharedViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        sharedViewModel = ViewModelProvider(this).get(SharedViewModel::class.java)

        val navFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        val navController = navFragment.navController

        drawerLayout = binding.drawerLayout

        setSupportActionBar(binding.toolbar)
        //Esta línea oculta la Main toolbar
        //supportActionBar?.hide()

        NavigationUI.setupActionBarWithNavController(this, navController, drawerLayout)

        //eventos de escucha del menú de navegación...
        binding.nvMain.setNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.about_menu -> {
                    navController.navigate(R.id.action_menuFragment_to_creditFragment)
                    drawerLayout.closeDrawer(GravityCompat.START)
                    true
                }

                else -> false
            }
        }

    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.fragmentContainerView)
        return NavigationUI.navigateUp(navController, drawerLayout)
    }

    fun createMail() {
        val intent = Intent(Intent.ACTION_SEND)
        intent.type = "plain/text"
        intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(getString(R.string.mail)))
        intent.putExtra(Intent.EXTRA_SUBJECT, getString(R.string.subject))
        startActivity(Intent.createChooser(intent, ""))
    }

    @SuppressLint("MissingSuperCall")
    override fun onBackPressed() {
        // Aquí puedes realizar alguna acción específica o simplemente ignorar la pulsación
        // Por ejemplo, puedes no hacer nada para evitar que el usuario vuelva hacia atrás
        // super.onBackPressed() // Comentar o eliminar esta línea para evitar el comportamiento predeterminado
    }


}