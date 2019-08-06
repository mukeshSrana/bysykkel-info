package no.oslo.bysykkel.status.klient;

import com.fasterxml.jackson.annotation.JsonAlias;

import no.oslo.bysykkel.status.StasjonInformasjonData;

public class ResponseFraStasjonInformasjon {

    @JsonAlias("data")
    private StasjonInformasjonData stasjonInformasjonData;

    public StasjonInformasjonData getStasjonInformasjonData() {
        return stasjonInformasjonData;
    }

    public void setStasjonInformasjonData(StasjonInformasjonData stasjonInformasjonData) {
        this.stasjonInformasjonData = stasjonInformasjonData;
    }
}

