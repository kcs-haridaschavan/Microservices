package com.kcsitglobal.billing.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kcsitglobal.billing.model.Billing;

public interface BillingRepositroy extends JpaRepository<Billing, Long> {

}
