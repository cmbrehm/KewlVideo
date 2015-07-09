package org.coursera.claybrehm.kewlvideo.provider;

import android.provider.BaseColumns;

/**
 * Created by claybrehm on 7/8/15.
 */
public interface VideoContract {

    public static final class VideoEntry implements BaseColumns
    {
        public static final String TABLE_NAME="video_index";

        public static final String COLUMN_ID="id";
        public static final String COLUMN_DATA_URI="data_uri";

    }
}
