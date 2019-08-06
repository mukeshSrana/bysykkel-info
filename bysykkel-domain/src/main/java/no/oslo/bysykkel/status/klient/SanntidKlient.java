package no.oslo.bysykkel.status.klient;

import java.util.Set;

import no.oslo.bysykkel.api.StasjonStatusInformasjon;

public interface SanntidKlient {
    Set<StasjonStatusInformasjon> oppslag();
}
