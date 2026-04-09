package com.example.invoicetracker;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Data // 這一行就是魔法來源
@Entity//魔法1：告訴 Spring，這不再只是一般的類別，這是一張「資料庫表格」
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String sellerName;
    private String invNum; // 小寫開頭
    private Integer amount;
}