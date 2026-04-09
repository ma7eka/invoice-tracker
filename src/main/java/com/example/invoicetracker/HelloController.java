package com.example.invoicetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.*;

@RestController
public class HelloController {

    @Autowired
    private InvoiceRepository invoiceRepository; // 叫辦事員過來

    @GetMapping("/stats")
    public Map<String, Object> getStats() {
        Map<String, Object> stats = new HashMap<>();
        long count = invoiceRepository.count();

        // 取得總金額，如果沒資料就給 0
        List<Invoice> all = invoiceRepository.findAll();
        int totalAmount = all.stream().mapToInt(Invoice::getAmount).sum();

        stats.put("totalCount", count);
        stats.put("totalAmount", totalAmount);
        return stats;
    }

    @GetMapping("/test-save")
    public String testSave(){
        // 1. 建立一筆假資料
        Invoice sample = new Invoice();
        sample.setInvNum("ABC-12345");
        sample.setSellerName("淡水老街大屌燒");
        sample.setAmount(150);
        // 2. 叫辦事員存進去
        invoiceRepository.save(sample);

        return "資料已存進 H2 DB!";
    }


    @GetMapping("/show-all")
    public List<Invoice> showALL(){
        // 3. 叫辦事員把所有資料拿出來
        return invoiceRepository.findAll();
    }
}
