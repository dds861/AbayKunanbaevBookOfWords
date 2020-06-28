package com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword

import android.util.Log
import android.widget.Toast
import com.carmabs.ema.core.state.EmaExtraData
import com.google.android.youtube.player.YouTubeInitializationResult
import com.google.android.youtube.player.YouTubePlayer
import com.google.android.youtube.player.YouTubePlayerFragment
import com.google.android.youtube.player.YouTubePlayerSupportFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.R
import com.injuryrecovery.hi.abaykunanbaevblackwords.base.BaseToolbarsFragment
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.checklist.LanguageName
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.main.MainToolbarsViewModel
import kotlinx.android.synthetic.main.fragment_black_word.*
import org.kodein.di.generic.instance


class BlackWordViewFragment
    : BaseToolbarsFragment<BlackWordState, BlackWordViewModel, BlackWordNavigator.Navigation>() {

    /**
     * Default variables
     */

    override val layoutId: Int = R.layout.fragment_black_word

    override val navigator: BlackWordNavigator by instance()

    override val viewModelSeed: BlackWordViewModel by instance()

    /**
     * Custom variables
     */
    private lateinit var vm: BlackWordViewModel
    private val RECOVERY_DIALOG_REQUEST = 1

    /**
     * Default functions
     */

    override fun onInitializedWithToolbarsManagement(viewModel: BlackWordViewModel, mainToolbarViewModel: MainToolbarsViewModel) {
        vm = viewModel

    }

    override fun onAlternative(data: EmaExtraData) {
    }

    override fun onNormal(data: BlackWordState) {
        if (data.languageName == LanguageName.KAZAKH) {
            setYoutubeVideo(data.position)
            showYoutubePlayer()
        } else {
            hideYoutubePlayer()
        }
        tvBlackWord.text = data.blackWord
    }

    override fun onError(error: Throwable) {}

    override fun onSingleEvent(data: EmaExtraData) {
    }

    override fun onSingle(data: EmaExtraData) {
    }


    private fun showYoutubePlayer() {
//        val fm: FragmentManager? = requireActivity().supportFragmentManager
//        fm?.beginTransaction()
//                ?.hide(youtubesupportfragment)
//                ?.commit()
    }

    private fun hideYoutubePlayer() {
//        val fm: FragmentManager? = requireActivity().supportFragmentManager
//        fm?.beginTransaction()
//                ?.show(youtubesupportfragment)
//                ?.commit()
    }

    private fun setYoutubeVideo(position: Int) {
//        val ysF = YouTubePlayerSupportFragment()
//
//        val fm: FragmentManager = requireActivity().supportFragmentManager
//        val ft: FragmentTransaction = fm.beginTransaction()
//        ft.add(R.id.youtubesupportfragment, ysF)
//        ft.commit()

        val  youTubePlayerFragment: YouTubePlayerSupportFragment = requireActivity().supportFragmentManager
                .findFragmentById(R.id.youtubesupportfragment) as YouTubePlayerSupportFragment


//        val youTubePlayerFragment =
//                requireActivity().supportFragmentManager.findFragmentById(R.id.youtubesupportfragment)
//                        as YouTubePlayerFragment?
//        youTubePlayerFragment!!.initialize(PlayerConfig.API_KEY, this)

        val mYoutubeLinks = resources.getStringArray(R.array.youtube_links)


        val onInitializedListener: YouTubePlayer.OnInitializedListener = object : YouTubePlayer.OnInitializedListener {
            override fun onInitializationSuccess(provider: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, b: Boolean) {
                Log.i("autolog", "mYoutubeLinks[position]: " + mYoutubeLinks[position]);
                youTubePlayer.loadVideo(mYoutubeLinks[position])
                youTubePlayer.play()
            }

            override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
                if (youTubeInitializationResult.isUserRecoverableError) {
                    youTubeInitializationResult.getErrorDialog(activity, RECOVERY_DIALOG_REQUEST).show()
                } else {
                    val errorMessage = String.format("There was an error initializing the YouTubePlayer (%1\$s)", youTubeInitializationResult.toString())
                    Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
                }
            }
        }

        youTubePlayerFragment?.initialize(PlayerConfig.API_KEY, onInitializedListener)
    }

//    override fun onInitializationSuccess(p0: YouTubePlayer.Provider, youTubePlayer: YouTubePlayer, wasRestored: Boolean) {
//        if (!wasRestored) {
//            youTubePlayer.cueVideo("nCgQDjiotG0");
//        }
//    }
//
//    override fun onInitializationFailure(provider: YouTubePlayer.Provider, youTubeInitializationResult: YouTubeInitializationResult) {
//        if (youTubeInitializationResult.isUserRecoverableError) {
//            youTubeInitializationResult.getErrorDialog(activity, RECOVERY_DIALOG_REQUEST).show()
//        } else {
//            val errorMessage = String.format("There was an error initializing the YouTubePlayer (%1\$s)", youTubeInitializationResult.toString())
//            Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
//        }
//    }
}
