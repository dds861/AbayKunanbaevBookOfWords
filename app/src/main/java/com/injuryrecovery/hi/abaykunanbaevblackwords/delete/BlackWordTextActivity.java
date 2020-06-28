package com.injuryrecovery.hi.abaykunanbaevblackwords.delete;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;
import com.injuryrecovery.hi.abaykunanbaevblackwords.DatabaseAccess;
import com.injuryrecovery.hi.abaykunanbaevblackwords.R;
import com.injuryrecovery.hi.abaykunanbaevblackwords.ui.blackword.PlayerConfig;

import java.util.List;

public class BlackWordTextActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_black_word_text);


        //реклама
        AdView mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        Intent mIntent = getIntent();
        String language = mIntent.getStringExtra("language");
        final int position = mIntent.getIntExtra("position", 0);

        DatabaseAccess databaseAccess = DatabaseAccess.getInstance(this);
        databaseAccess.open();

        List<String> list_qazaqsha_counter = databaseAccess.getTextBlackWords(language);
        databaseAccess.close();
        TextView mTvText = findViewById(R.id.tvBlackWord);

        String s1 = list_qazaqsha_counter.get(position);
        s1 = s1.replaceAll("\\\\n", "\n");
        s1 = s1.replaceAll("\\\\t", "\t");
        mTvText.setText(s1);

        setYoutubeVideo(position, language);


    }

    private void setYoutubeVideo(final int position, String language) {
        final YouTubePlayerView youTubePlayerView = findViewById(R.id.youtube_fragment);

        if(language.equals(getResources().getString(R.string.kazakhBlackWordsTitle))){youTubePlayerView.setVisibility(View.VISIBLE);}

        final String[] mYoutubeLinks = getResources().getStringArray(R.array.youtube_links);

        final YouTubePlayer.OnInitializedListener onInitializedListener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {
                youTubePlayer.loadVideo(mYoutubeLinks[position]);
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {

            }
        };

        youTubePlayerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                youTubePlayerView.initialize(PlayerConfig.API_KEY,onInitializedListener);
            }
        });
    }
}
