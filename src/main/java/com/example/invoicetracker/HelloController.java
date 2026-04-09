package com.example.invoicetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


@RestController
public class HelloController {

    @Autowired
    private InvoiceRepository invoiceRepository; // 叫辦事員過來


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
