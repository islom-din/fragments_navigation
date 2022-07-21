package islom.din.workwithfragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import islom.din.workwithfragment.databinding.FragmentSecondBinding

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
            Log.d("test_tag", "click!!! ")
            val surname = binding.surname.text.toString()
            Log.d("test_tag", "$surname ")

            if(surname.isEmpty()) {
                showText("Surname must not be empty!")
            } else {
                Log.d("test_tag", "!!")
                val name = requireArguments().getString(NAME, null) ?: return@setOnClickListener
                if(requireActivity() is MainActivity) {
                    (requireActivity() as MainActivity).launchResultFragment(name,surname)
                }
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

    companion object {
        private const val NAME = "name_arg"

        fun getInstance(name: String) : SecondFragment {
            return SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                }
            }
        }
    }
}