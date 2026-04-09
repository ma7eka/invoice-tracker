package com.example.invoicetracker;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    // 這裡什麼都不用寫，JpaRepository 會幫你搞定存檔和讀取
}