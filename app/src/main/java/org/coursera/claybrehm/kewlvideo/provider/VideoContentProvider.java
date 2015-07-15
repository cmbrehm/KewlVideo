package org.coursera.claybrehm.kewlvideo.provider;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class VideoContentProvider extends ContentProvider {

    /**
     * The URI Matcher used by this content provider.
     */
    private static final UriMatcher sUriMatcher =
            buildUriMatcher();

    public static final int VIDEO=100;

    public static final int VIDEOS=101;

    private VideoDatabaseHelper dbHelper;
    /**
     * Helper method to match each URI to the ACRONYM integers
     * constant defined above.
     *
     * @return UriMatcher
     */
    private static UriMatcher buildUriMatcher() {
        // All paths added to the UriMatcher have a corresponding code
        // to return when a match is found.  The code passed into the
        // constructor represents the code to return for the rootURI.
        // It's common to use NO_MATCH as the code for this case.
        final UriMatcher matcher =
                new UriMatcher(UriMatcher.NO_MATCH);

        // The "Content authority" is a name for the entire content
        // provider, similar to the relationship between a domain name
        // and its website.  A convenient string to use for the
        // content authority is the package name for the app, which is
        // guaranteed to be unique on the device.
        final String authority =
                VideoContract.CONTENT_AUTHORITY;

        // For each type of URI that is added, a corresponding code is
        // created.
        matcher.addURI(authority,
                VideoContract.PATH_VIDEOS,
                VIDEO);
        matcher.addURI(authority,
                VideoContract.PATH_VIDEOS+"/#",
                VIDEOS);

        return matcher;
    }

    public VideoContentProvider() {
    }

    @Override
    public boolean onCreate() {
        dbHelper = new VideoDatabaseHelper(getContext());
        return true;
    }

    @Override
    public int delete(Uri uri, String selection, String[] selectionArgs) {
        // Implement this to handle requests to delete one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }

    @Override
    public String getType(Uri uri) {
        // Use Uri Matcher to determine what kind of URI this is.
        final int match = sUriMatcher.match(uri);

        // Match the id returned by UriMatcher to return appropriate
        // MIME_TYPE.
        switch (match) {
            case VIDEOS:
                return VideoContract.VideoEntry.CONTENT_TYPE;
            case VIDEO:
                return VideoContract.VideoEntry.CONTENT_ITEM_TYPE;
            default:
                throw new UnsupportedOperationException("Unknown uri: "
                        + uri);
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {

        SQLiteDatabase db = dbHelper.getWritableDatabase();
        Uri returnUri;
        switch(sUriMatcher.match(uri)) {
            case (VIDEOS):
                long id = db.insert(VideoContract.VideoEntry.TABLE_NAME, null, values);
                if (id > 0) {
                    returnUri = VideoContract.VideoEntry.buildAcronymUri(id);
                } else {
                    throw new android.database.SQLException
                            ("Failed to insert row into " + uri);
                }
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: "
                        + uri);
        }
        return returnUri;

    }


    @Override
    public Cursor query(Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor retCursor;
        switch(sUriMatcher.match(uri)) {
            case (VIDEOS):
               retCursor = db.query(VideoContract.VideoEntry.TABLE_NAME, projection, selection, selectionArgs, null, null, sortOrder);
                break;
            case(VIDEO):
                final String idClause = VideoContract.VideoEntry.COLUMN_ID+"="+ ContentUris.parseId(uri);
                retCursor = db.query(VideoContract.VideoEntry.TABLE_NAME,projection, idClause, null, null, null, null);
                break;
            default:
                throw new UnsupportedOperationException("Unknown uri: "
                        + uri);
        }
        return retCursor;
    }


    @Override
    public int update(Uri uri, ContentValues values, String selection,
                      String[] selectionArgs) {
        // TODO: Implement this to handle requests to update one or more rows.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
