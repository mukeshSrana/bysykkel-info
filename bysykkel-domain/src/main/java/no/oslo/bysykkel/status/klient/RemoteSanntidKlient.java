package no.oslo.bysykkel.status.klient;

import java.util.Map;
import java.util.Set;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.web.client.RestTemplate;

import no.oslo.bysykkel.api.StasjonStatusInformasjon;
import no.oslo.bysykkel.status.StasjonInformasjon;
import no.oslo.bysykkel.status.mapper.StasjonsinformasjonMapper;

public class RemoteSanntidKlient implements SanntidKlient {

    private final RestTemplate restTemplate;
    private final String stasjonInfoUrl;
    private final String stasjonStatusUrl;
    private final StasjonsinformasjonMapper mapper;

    public RemoteSanntidKlient(RestTemplate restTemplate, String stasjonInfoUrl, String stasjonStatusUrl) {
        this.restTemplate = restTemplate;
        this.stasjonInfoUrl = stasjonInfoUrl;
        this.stasjonStatusUrl = stasjonStatusUrl;
        this.mapper = new StasjonsinformasjonMapper();
    }

    public Set<StasjonStatusInformasjon> oppslag() {
        Map<String, StasjonInformasjon> stasjonInformasjonMap =
            restTemplate.getForObject(stasjonInfoUrl, ResponseFraStasjonInformasjon.class)
                .getStasjonInformasjonData()
                .getStasjonInformasjon()
                .stream()
                .collect(Collectors.toMap(StasjonInformasjon::getStationId, Function.identity()));

        return restTemplate.getForObject(stasjonStatusUrl, ResponseFraStasjonStatus.class)
            .getStasjonStatusData()
            .getStasjonStatus()
            .stream()
            .map(stasjonStatus -> {
                StasjonInformasjon stasjonInformasjon = stasjonInformasjonMap.get(stasjonStatus.getStationId());
                return mapper.map(stasjonInformasjon, stasjonStatus);
            }).collect(Collectors.toSet());
    }
}
