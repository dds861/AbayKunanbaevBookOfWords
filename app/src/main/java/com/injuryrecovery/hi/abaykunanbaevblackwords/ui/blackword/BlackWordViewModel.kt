package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import android.util.Log
import com.dd.domain.manager.ResourceManager
import com.dd.domain.model.RequestBlackWordModel
import com.dd.domain.usecase.GetBlackWordUseCase
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsViewModel
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel


class BlackWordViewModel(
        val resourceManager: ResourceManager,
        private val getBlackWordUseCase: GetBlackWordUseCase
) : BaseToolbarsViewModel<BlackWordState, BlackWordNavigator.Navigation>() {

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
                else -> resourceManager.getToolbarTitleKazakh()
            }

        }

    }

    override val initialViewState: BlackWordState = BlackWordState()

    override fun onStartFirstTime(statePreloaded: Boolean) {
        setupBlackWord()
    }

    private fun backButtonClicked() {
        mainToolbarsVm.onActionBackClicked()
    }

    private fun setupBlackWord() {
        checkDataState {
            executeUseCaseWithException({
                val result = when (it.languageName) {
                    LanguageName.RUSSIAN -> getBlackWordUseCase.execute(RequestBlackWordModel(
                            languageName = com.dd.domain.model.LanguageName.RUSSIAN,
                            position = it.position))

                    LanguageName.ENGLISH -> getBlackWordUseCase.execute(RequestBlackWordModel(
                            languageName = com.dd.domain.model.LanguageName.ENGLISH,
                            position = it.position))

                    LanguageName.DUTCH -> getBlackWordUseCase.execute(RequestBlackWordModel(
                            languageName = com.dd.domain.model.LanguageName.DUTCH,
                            position = it.position))

                    LanguageName.PORTUGUESE -> getBlackWordUseCase.execute(RequestBlackWordModel(
                            languageName = com.dd.domain.model.LanguageName.PORTUGUESE,
                            position = it.position))

                    else -> getBlackWordUseCase.execute(RequestBlackWordModel(
                            languageName = com.dd.domain.model.LanguageName.KAZAKH,
                            position = it.position))
                }


                val blackWord = result.blackWord
                        .replace("\\\\n".toRegex(), "\n")
                        .replace("\\\\t".toRegex(), "\t")

                updateToNormalState {
                    copy(
                            blackWord = blackWord
                    )
                }
            }, { e ->
                updateToErrorState(e)
                Log.i("autolog", "e: " + e);
            })
        }
    }
}
