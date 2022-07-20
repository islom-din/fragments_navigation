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
                .replace(R.id.fragment_container1, fragment1)
                .commit()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun launchSecondFragment(name: String) {
        // Так делать не хорошо
        //val fragment2 = SecondFragment(name)
        // Так надо делать!
        val fragment2 = SecondFragment()
        val args: Bundle = Bundle()
        args.putString("NAME", name)
        fragment2.arguments = args
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container1, fragment2)
            .commit()
    }
}