package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.carmabs.ema.core.state.EmaExtraData
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.LanguageAdapter
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_select_language.*
import org.kodein.di.generic.instance

class ChecklistViewFragment
    : BaseToolbarsFragment<ChecklistState, ChecklistViewModel, ChecklistNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = com.injuryrecovery.hi.abaykunanbaevblackwords.R.layout.fragment_checklist

    override val navigator: ChecklistNavigator by instance()

    override val viewModelSeed: ChecklistViewModel by instance()


    /**
     * Custom variables
     */
    private lateinit var vm: ChecklistViewModel

    /**
     * Default functions
     */
    override fun onInitializedWithToolbarsManagement(viewModel: ChecklistViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel
        setupRecycler()
    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: ChecklistState) {
        loadRecyclerViews(data)
    }

    override fun onError(error: Throwable) {

    }


    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }
    /**
     * Custom functions
     */
    private fun setupRecycler() {
        rvLanguages.layoutManager = LinearLayoutManager(requireContext(), RecyclerView.VERTICAL, false)
    }

    private fun loadRecyclerViews(data: ChecklistState) {
        rvLanguages.adapter = data.list.toMutableList().let { it ->
            ChecklistAdapter(requireContext(), listItems = it) {
                vm.onItemFromListClicked(it)
            }
        }
    }
}
