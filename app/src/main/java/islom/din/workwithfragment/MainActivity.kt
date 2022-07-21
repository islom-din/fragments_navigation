package islom.din.workwithfragment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import islom.din.workwithfragment.databinding.ActivityMainBinding

// 1) Создали фрагмент - FirstFragment
// 2) Создали контэйнер в активити
// 3) Прикрепить фрагмент к активити

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fragment1 = FirstFragment()

        if(savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.nav_host_fragment_container, fragment1)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    //TODO: remove this and use navigation component
    fun launchSecondFragment(name: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(
                R.id.nav_host_fragment_container,
                SecondFragment.getInstance(name)
            )
            .addToBackStack("second_fragment")
            .commit()
    }

    //TODO: remove this and use navigation component
    fun launchResultFragment(name: String, surname: String) {
        val fragment3 = ResultFragment.getInstance(name, surname)

        supportFragmentManager
            .beginTransaction()
            .replace(R.id.nav_host_fragment_container, fragment3)
            .addToBackStack("result_fragment")
            .commit()
    }
}