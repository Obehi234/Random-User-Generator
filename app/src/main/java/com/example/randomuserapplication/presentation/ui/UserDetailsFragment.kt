package com.example.randomuserapplication.presentation.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.example.randomuserapplication.databinding.FragmentUserDetailsBinding
import com.example.randomuserapplication.viewmodel.UserViewModel
import com.squareup.picasso.Picasso
import kotlinx.coroutines.launch

class UserDetailsFragment : Fragment() {
    private var _binding: FragmentUserDetailsBinding? = null
    private val binding get() = _binding!!
    private val userViewModel: UserViewModel by activityViewModels()
    private var userId = ""
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentUserDetailsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        userId = requireArguments().getString("userId") ?: ""

        viewLifecycleOwner.lifecycleScope.launch {
            val user = userViewModel.getSingleUser(userId)
            binding.apply {
                user?.let {
                    Picasso.with(root.context)
                        .load(user.pictureLarge)
                        .into(imgUser)

                    userTitle.text = "Title: ${user.title}"
                    userName.text = "FullName: ${user.firstName} ${user.lastName}"
                    userLogInName.text = "Username: ${user.userName}"
                    userGender.text = "Gender: ${user.gender}"
                    userAge.text = "Age: ${user.dob.toString()}"
                    userAddress.text =
                        "Address: ${user.streetNumber}, ${user.streetName},${user.city}, ${user.state}, ${user.country}"
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}