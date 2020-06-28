package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_select_language.*
import org.kodein.di.generic.instance

class LanguageViewFragment
    : BaseToolbarsFragment<LanguageState, LanguageViewModel, LanguageNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = R.layout.fragment_select_language

    override val navigator: LanguageNavigator by instance()

    override val viewModelSeed: LanguageViewModel by instance()

    /**
     * Custom variables
     */
    private lateinit var vm: LanguageViewModel

    /**
     * Default functions
     */

    override fun onInitializedWithToolbarsManagement(viewModel: LanguageViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        setupRecycler()
    }


    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: LanguageState) {
        loadRecyclerViews(data)
    }


    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
        TODO("Not yet implemented")
    }

    override fun onError(error: Throwable) {

    }

    /**
     * Custom functions
     */
    private fun setupRecycler() {
        rvLanguages.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }

    private fun loadRecyclerViews(data: LanguageState) {
        rvLanguages.adapter = data.languages.toMutableList().let { it ->
            LanguageAdapter(requireContext(), listItems = it) {
                vm.onActionLanguageClick(it)
            }
        }
    }

}
