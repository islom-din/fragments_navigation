package islom.din.workwithfragment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import islom.din.workwithfragment.databinding.ActivityMainBinding
import islom.din.workwithfragment.databinding.FragmentFirstBinding
import islom.din.workwithfragment.databinding.FragmentSecondBinding

class SecondFragment(
// Так не делай! Одумайся )
//    private val name: String
) : Fragment() {
    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val args: Bundle = requireArguments()
        val name = args.getString("NAME")
        binding.text.text = "Hello, $name"
        requireArguments()
    }










    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()
    }

    override fun onPause() {
        super.onPause()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}