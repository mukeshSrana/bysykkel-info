package no.oslo.bysykkel.status.klient;

import com.fasterxml.jackson.annotation.JsonAlias;

import no.oslo.bysykkel.status.StasjonStatusData;

public class ResponseFraStasjonStatus {

    @JsonAlias("data")
    private StasjonStatusData stasjonStatusData;

    public StasjonStatusData getStasjonStatusData() {
        return stasjonStatusData;
    }

    public void setStasjonStatusData(StasjonStatusData stasjonStatusData) {
        this.stasjonStatusData = stasjonStatusData;
    }
}

