package org.coursera.claybrehm.kewlvideo.model;


import android.net.Uri;

import java.util.Collection;

import retrofit.client.Response;
import retrofit.http.GET;
import retrofit.http.Multipart;
import retrofit.http.POST;
import retrofit.http.Part;
import retrofit.http.Path;
import retrofit.http.Streaming;
import retrofit.mime.TypedFile;

/**
 * Created by claybrehm on 7/14/15.
 */
public interface VideoService {

    @Multipart
    @POST("/upload")
    public Uri addVideo(@Part("video") VideoMetadata videoMetadata, @Part("data") TypedFile videoContent);

    @Streaming
    @GET("/video/{id}")
    public Response getData(@Path("id") long id);

    @GET("/video")
    public Collection<VideoMetadata> getVideoList();

    @POST("/video/{id}/stars/{stars}")
    public VideoMetadata rateVideo(@Path("id") long id, @Path("stars") int stars);


}
