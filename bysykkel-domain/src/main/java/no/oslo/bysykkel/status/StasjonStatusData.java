package no.oslo.bysykkel.status;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;

public class StasjonStatusData {

    @JsonAlias("stations")
    List<StasjonStatus> stasjonStatus;

    public List<StasjonStatus> getStasjonStatus() {
        return stasjonStatus;
    }

    public void setStasjonStatus(List<StasjonStatus> stasjonStatus) {
        this.stasjonStatus = stasjonStatus;
    }
}
