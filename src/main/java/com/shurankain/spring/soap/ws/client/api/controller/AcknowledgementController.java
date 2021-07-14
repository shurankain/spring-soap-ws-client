package com.shurankain.spring.soap.ws.client.api.controller;

import com.shurankain.spring.soap.ws.client.api.client.SoapClient;
import com.shurankain.spring.soap.ws.client.api.loaneligibility.Acknowledgement;
import com.shurankain.spring.soap.ws.client.api.loaneligibility.CustomerRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AcknowledgementController {

    private final SoapClient soapClient;

    @Autowired
    public AcknowledgementController(SoapClient soapClient) {
        this.soapClient = soapClient;
    }

    @PostMapping("/getLoanStatus")
    public Acknowledgement invokeSoapClientToGetLoanStatus(@RequestBody CustomerRequest customerRequest) {
        return soapClient.getLoanStatus(customerRequest);
    }
}
