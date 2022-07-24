package islom.din.workwithfragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.bumptech.glide.Glide
import islom.din.workwithfragment.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        loadImage()
        setupListeners()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun showText(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }

    private fun loadImage() {
        Glide
            .with(requireActivity())
            .load("https://avatars.mds.yandex.net/get-zen_doc/1712263/pub_5f95635298e57704a13a2ca7_5f9572ba506beb0472506f03/scale_1200")
            .centerCrop()
            .placeholder(R.drawable.ic_launcher_foreground)
            .into(binding.image)
    }

    private fun setupListeners() {
        binding.button.setOnClickListener {
            val enteredName = binding.name.text.toString()
            if (enteredName.isEmpty()) {
                showText("Name must not be empty!")
            } else {
                findNavController().navigate(
                    R.id.secondFragment,
                    SecondFragment.getBundle(enteredName)
                )
            }
        }
    }
}