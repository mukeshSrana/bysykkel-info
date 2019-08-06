package no.oslo.bysykkel.status;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StasjonInformasjon {
    @JsonAlias("station_id")
    private String stationId;

    @JsonAlias("name")
    private String navn;

    @JsonAlias("address")
    private String adresse;

    @JsonAlias("capacity")
    private int kapasitet;

    public String getStationId() {
        return stationId;
    }

    public void setStationId(String stationId) {
        this.stationId = stationId;
    }

    public String getNavn() {
        return navn;
    }

    public void setNavn(String navn) {
        this.navn = navn;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public int getKapasitet() {
        return kapasitet;
    }

    public void setKapasitet(int kapasitet) {
        this.kapasitet = kapasitet;
    }
}
