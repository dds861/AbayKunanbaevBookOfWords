package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import com.dd.domain.manager.ResourceManager
import com.dd.domain.model.RequestSelectLanguageModel
import com.dd.domain.usecase.GetSelectLanguageUseCase
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.SelectLanguageNavigator
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages.SelectLanguageState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel


class SelectLanguageViewModel(
        private val resourceManager: ResourceManager,
        private val getSelectLanguageUseCase: GetSelectLanguageUseCase
) : BaseToolbarsViewModel<SelectLanguageState, SelectLanguageNavigator.Navigation>() {

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(toolbarTitle = resourceManager.getToolbarTitle())
        }
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {
    }

    override val initialViewState: SelectLanguageState = SelectLanguageState()

    fun onActionUpdate(text: String) {


        executeUseCaseWithException({
            val result = getSelectLanguageUseCase.execute(
                    RequestSelectLanguageModel(
                            default = text
                    )
            )
        }, { e ->
            updateToErrorState(e)
        })
    }


}