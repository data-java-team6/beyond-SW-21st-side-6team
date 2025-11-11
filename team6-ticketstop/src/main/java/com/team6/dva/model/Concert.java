package com.team6.dva.model;

import java.util.List;

public class Concert {
    private String concertId;
    private String title;
    private String concertDate;
    private String description;
    private List<String> artistIds;

    public Concert(String concertId, String title, String concertDate, String description, List<String> artistIds) {
        this.concertId = concertId;
        this.title = title;
        this.concertDate = concertDate;
        this.description = description;
        this.artistIds = artistIds;
    }

    public String getConcertId() {
        return concertId;
    }

    public void setConcertId(String concertId) {
        this.concertId = concertId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getConcertDate() {
        return concertDate;
    }

    public void setConcertDate(String concertDate) {
        this.concertDate = concertDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getArtistIds() {
        return artistIds;
    }

    public void setArtistIds(List<String> artistIds) {
        this.artistIds = artistIds;
    }
}
