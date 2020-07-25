package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist

import android.util.Log
import com.dd.domain.manager.ResourceManager
import com.dd.domain.model.RequestTitleBlackWordsModel
import com.dd.domain.model.TitleBlackWordModel
import com.dd.domain.usecase.GetTitleBlackWordsUseCase
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword.BlackWordState
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel


class ChecklistViewModel(
        val resourceManager: ResourceManager,
        private val getTitleBlackWordsUseCase: GetTitleBlackWordsUseCase
) : BaseToolbarsViewModel<ChecklistState, ChecklistNavigator.Navigation>() {

    override fun onConfigureToolbars(mainToolbarsVm: MainToolbarsViewModel) {


        mainToolbarsVm.onActionUpdateToolbar {
            it.copy(title = getTitle(),
                    visibility = true,
                    backVisibility = true,
                    backClickListener = ::backButtonClicked)
        }
    }

    private fun getTitle(): String {
        return checkDataState {
            when (it.languageName) {
                LanguageName.RUSSIAN -> resourceManager.getToolbarTitleRussian()
                LanguageName.ENGLISH -> resourceManager.getToolbarTitleEnglish()
                LanguageName.DUTCH -> resourceManager.getToolbarTitleDutch()
                LanguageName.PORTUGUESE -> resourceManager.getToolbarTitlePortuguese()
                LanguageName.CHINESE -> resourceManager.getToolbarTitleChinese()
                else -> resourceManager.getToolbarTitleKazakh()
            }

        }

    }

    override val initialViewState: ChecklistState = ChecklistState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        setupList()
    }

    /**
     * Custom functions
     */


    private fun setupList() {
        checkDataState {
            executeUseCaseWithException({
                val result =
                        when (it.languageName) {
                            LanguageName.RUSSIAN -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.RUSSIAN))
                            LanguageName.ENGLISH -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.ENGLISH))
                            LanguageName.DUTCH -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.DUTCH))
                            LanguageName.PORTUGUESE -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.PORTUGUESE))
                            LanguageName.CHINESE -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.CHINESE))
                            else -> getTitleBlackWordsUseCase.execute(RequestTitleBlackWordsModel(language = com.dd.domain.model.LanguageName.KAZAKH))
                        }



                updateToNormalState {
                    copy(
                            list = result.list
                    )
                }
            }, { e ->
                updateToErrorState(e)
            })
        }
    }


    private fun backButtonClicked() {
        mainToolbarsVm.onActionBackClicked()
    }

    fun onItemFromListClicked(model: TitleBlackWordModel) {
        checkDataState {
            navigate(ChecklistNavigator.Navigation.BlackWord(BlackWordState(
                    position = model.position,
                    languageName = it.languageName
            )))

        }
    }
}