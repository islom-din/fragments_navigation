package islom.din.workwithfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import islom.din.workwithfragment.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val name = requireArguments().getString(NAME)
        val surname = requireArguments().getString(SURNAME)
        binding.text.text = "Hello $name $surname, glad to see you : )"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val NAME = "name_arg"
        private const val SURNAME = "surname_arg"

        fun getInstance(name: String, surname: String): ResultFragment {
            return ResultFragment().apply {
                arguments = Bundle().apply {
                    putString(NAME, name)
                    putString(SURNAME, surname)
                }
            }
//
//            val fragment = ResultFragment()// создание объекта
//            val args = Bundle()// создание объекта
//            args.putString(NAME, name)// использование свойства объекта
//            args.putString(SURNAME, surname) // использование свойства объекта
//            fragment.arguments = args // использование свойства объекта
//            return fragment
        }
    }
}