package no.oslo.bysykkel.status.mapper;

import no.oslo.bysykkel.api.StasjonStatusInformasjon;
import no.oslo.bysykkel.status.StasjonInformasjon;
import no.oslo.bysykkel.status.StasjonStatus;

public class StasjonsinformasjonMapper {
    public StasjonStatusInformasjon map(StasjonInformasjon info, StasjonStatus status) {
        StasjonStatusInformasjon til = new StasjonStatusInformasjon();

        til.setStationId(info.getStationId());
        til.setNavn(info.getNavn());
        til.setAdresse(info.getNavn());
        til.setKapasitet(info.getKapasitet());
        til.setLedigSykler(status.getLedigSykler());
        til.setTilgjengeligeLaaser(status.getTilgjengeligeLaaser());

        return til;
    }
}
