package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.languages

import com.dd.domain.manager.ResourceManager
import com.dd.domain.model.LanguageModel
import com.dd.domain.model.RequestSelectLanguageModel
import com.dd.domain.usecase.GetSelectLanguageUseCase
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.ChecklistState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel


class LanguageViewModel(
        private val resourceManager: ResourceManager,
        private val getSelectLanguageUseCase: GetSelectLanguageUseCase
) : BaseToolbarsViewModel<LanguageState, LanguageNavigator.Navigation>() {

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {
        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(title = resourceManager.getToolbarTitle(),
                    visibility = false)
        }
    }

    override fun onStartFirstTime(statePreloaded: Boolean) {

        setupLanguages()
    }


    override val initialViewState: LanguageState = LanguageState()

    /**
     * Custom functions
     */

    private fun setupLanguages() {
        executeUseCaseWithException({
            val result =
                    getSelectLanguageUseCase.execute(RequestSelectLanguageModel())
            updateToNormalState {
                copy(
                        languages = result.list
                )
            }
        }, { e ->
            updateToErrorState(e)
        })
    }


    fun onActionLanguageClick(model: LanguageModel) {
        navigate(
                LanguageNavigator.Navigation.CheckList(
                        ChecklistState(
                                languageName = getLanguageSelected(model.numerical.toInt())
                        )
                )
        )
    }

    private fun getLanguageSelected(id: Int): LanguageName {
        return when (id) {
            2 -> LanguageName.RUSSIAN
            3 -> LanguageName.ENGLISH
            4 -> LanguageName.PORTUGUESE
            5 -> LanguageName.DUTCH
            6 -> LanguageName.CHINESE
            else -> LanguageName.KAZAKH
        }
    }

}