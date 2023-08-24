package com.example.randomuserapplication.presentation.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import com.example.randomuserapplication.adapter.UserAdapter
import com.example.randomuserapplication.databinding.FragmentUserListBinding
import com.example.randomuserapplication.viewmodel.UserViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UserListFragment : Fragment() {
    private var _binding: FragmentUserListBinding?= null
    private val binding get() = _binding!!
    private lateinit var rvAdapter: UserAdapter
    private val userViewModel: UserViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentUserListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpRV()
        rvAdapter.onContactClickListener = { userId ->
            val action = UserListFragmentDirections.actionUserListFragmentToUserDetailsFragment(userId)
            findNavController().navigate(action)
            Log.d("CHECK_ID", "USER ID IS - $userId")
        }

    }

    private fun setUpRV() {
        rvAdapter = UserAdapter()
        binding.rvUserList.adapter = rvAdapter
        userViewModel.userList.observe(viewLifecycleOwner){result->
            rvAdapter.submitList(result)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}