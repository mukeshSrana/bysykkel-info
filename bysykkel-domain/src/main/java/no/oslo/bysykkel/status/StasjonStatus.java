package no.oslo.bysykkel.status;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StasjonStatus {
    @JsonAlias("station_id")
    private String stationId;

    @JsonAlias("num_bikes_available")
    private int ledigSykler;

    @JsonAlias("num_docks_available")
    private int tilgjengeligeLaaser;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public int getLedigSykler() {
        return ledigSykler;
    }

    public void setLedigSykler(int ledigSykler) {
        this.ledigSykler = ledigSykler;
    }

    public int getTilgjengeligeLaaser() {
        return tilgjengeligeLaaser;
    }

    public void setTilgjengeligeLaaser(int tilgjengeligeLaaser) {
        this.tilgjengeligeLaaser = tilgjengeligeLaaser;
    }
}
