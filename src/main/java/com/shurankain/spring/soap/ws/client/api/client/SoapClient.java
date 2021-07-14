package com.shurankain.spring.soap.ws.client.api.client;

import com.shurankain.spring.soap.ws.client.api.loaneligibility.Acknowledgement;
import com.shurankain.spring.soap.ws.client.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

@Service
public class SoapClient {

    private final Jaxb2Marshaller marshaller;

    @Autowired
    public SoapClient(Jaxb2Marshaller marshaller) {
        this.marshaller = marshaller;
    }

    public Acknowledgement getLoanStatus(CustomerRequest request) {
        WebServiceTemplate template = new WebServiceTemplate(marshaller);
        return (Acknowledgement) template.marshalSendAndReceive("http://localhost:9000/ws/", request);
    }
}
