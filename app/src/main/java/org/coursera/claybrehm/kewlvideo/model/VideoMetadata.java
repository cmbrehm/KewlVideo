package org.coursera.claybrehm.kewlvideo.model;

/**
 * Created by claybrehm on 7/14/15.
 */
public class VideoMetadata {

    private String id;
    private String title;
    private String author;
    private int numRates;
    private long totalStars;
    private String url;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getNumRates() {
        return numRates;
    }

    public void setNumRates(int numRates) {
        this.numRates = numRates;
    }

    public long getTotalStars() {
        return totalStars;
    }

    public void setTotalStars(long totalStars) {
        this.totalStars = totalStars;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public float getRating() {
        return ((float)totalStars/(float)numRates);
    }
}
