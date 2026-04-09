package com.example.invoicetracker;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;

@Entity
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 🔥 新增：收支類型 (收入 或 支出)
    private String type;

    // 🔥 新增：消費日期 (YYYY-MM-DD)
    private String date;

    private String category;
    private String sellerName;
    private Integer amount;

    // --- 以下是 Getter 與 Setter (請務必補上) ---
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getCategory() { return category; }
    public void setCategory(String category) { this.category = category; }

    public String getSellerName() { return sellerName; }
    public void setSellerName(String sellerName) { this.sellerName = sellerName; }

    public Integer getAmount() { return amount; }
    public void setAmount(Integer amount) { this.amount = amount; }
}