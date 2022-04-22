package com.example.github_profile_repo_search.presentation

import android.os.*
import android.view.*
import androidx.fragment.app.Fragment
import com.example.github_profile_repo_search.R


class SearchFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.search_fragment, container, false)
    }

}