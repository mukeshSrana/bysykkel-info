package no.oslo.bysykkel.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StasjonInformasjonData {

    @JsonAlias("stations")
    List<StasjonInformasjon> stasjonInformasjon;

    public List<StasjonInformasjon> getStasjonInformasjon() {
        return stasjonInformasjon;
    }

    public void setStasjonInformasjon(List<StasjonInformasjon> stasjonInformasjon) {
        this.stasjonInformasjon = stasjonInformasjon;
    }
}
