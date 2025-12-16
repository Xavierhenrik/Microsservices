package com.xavier.payroll.services;

import com.xavier.payroll.entities.Payment;
import com.xavier.payroll.entities.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PaymentService {

    @Value("${hr.service.url}")
    private String workerHost;

    @Autowired
    private RestTemplate restTemplate;

    public Payment getPayment(Long workerId, int days) {
        Worker worker = restTemplate.getForObject(workerHost + "/workers/{id}", Worker.class, workerId);
        return new Payment(worker.getName(), worker.getDailyIncome(), days);
    }

}
