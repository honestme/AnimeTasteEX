package com.honestme.animetasteex;

import android.content.res.AssetManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by zhangconglin on 2016/1/29.
 */
@Module(
        includes = {

        },
        injects = {
                FontTextView.class,
                FloatLabelLayout.class
        }

)

public class ViewUtilProvider {
    @Provides @Singleton TypefaceManager provideTypefaceManager(AssetManager assetManager){
        return new TypefaceManager(assetManager);
    }
}
