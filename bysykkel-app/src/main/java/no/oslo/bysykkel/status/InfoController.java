package no.oslo.bysykkel.status;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import no.oslo.bysykkel.api.StasjonStatusInformasjon;
import no.oslo.bysykkel.status.klient.RemoteSanntidKlient;

@RestController
@RequestMapping("/sanntid")
public class InfoController {

    @Autowired
    RestTemplate restTemplate;

    @Value("${stasjonInfoUrl}")
    private String stasjonInfoUrl;

    @Value("${stasjonStatusUrl}")
    private String stasjonStatusUrl;

    @GetMapping(path="/stasjonsinformasjon", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Set<StasjonStatusInformasjon> getStasjonsinformasjon() {

        RemoteSanntidKlient klient =
            new RemoteSanntidKlient(restTemplate, stasjonInfoUrl, stasjonStatusUrl);

        return klient.oppslag();
    }

}
