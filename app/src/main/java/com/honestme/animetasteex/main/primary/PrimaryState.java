package com.honestme.animetasteex.main.primary;

import android.graphics.Movie;

import com.honestme.animetasteex.BaseState;

import java.util.List;

/**
 * Created by Administrator on 2015/11/29 0029.
 */
public interface PrimaryState extends BaseState {


    public void setCollection(List<Movie> collection);

    public boolean hasCollection();

    public static class CollectionChangedEvent{}
}
