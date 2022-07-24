package islom.din.workwithfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import islom.din.workwithfragment.databinding.FragmentSecondBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SecondFragment : Fragment() {
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

        binding.button.setOnClickListener {
            binding.button.isVisible = false
            binding.loadAnimation.isVisible = true
            lifecycleScope.launch(Dispatchers.Main) {
                delay(4000)
                binding.button.isVisible = true
                binding.loadAnimation.isVisible = false
                launchResultFragment()
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showText(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    private fun launchResultFragment() {
        val surname = binding.surname.text.toString()
        if (surname.isEmpty()) {
            showText("Surname must not be empty!")
        } else {
            Log.d("test_tag", "!!")
            val name = requireArguments().getString(NAME, null) ?: return
            findNavController().navigate(
                R.id.resultFragment,
                ResultFragment.getBundle(name, surname)
            )
        }
    }

    companion object {
        private const val NAME = "name_arg"

        fun getBundle(name: String): Bundle {
            return Bundle().apply {
                putString(NAME, name)
            }
        }
    }
}