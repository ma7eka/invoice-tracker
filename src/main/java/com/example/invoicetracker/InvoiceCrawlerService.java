package com.example.invoicetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import java.util.Random;

@Service
public class InvoiceCrawlerService {

    @Autowired
    private InvoiceRepository invoiceRepository;

    private String[] stores = {"星巴克", "便利商店", "全聯福利中心", "加油站", "麥當勞"};

    // 每 10 秒執行一次 (10000 毫秒)
    @Scheduled(fixedRate = 10000)
    public void mockFetchInvoice() {
        Random random = new Random();

        Invoice invoice = new Invoice();
        // 隨機產生發票號碼 (例如: ZZ-12345678)
        invoice.setInvNum("ZZ-" + (random.nextInt(90000000) + 10000000));
        // 隨機選一個商家
        invoice.setSellerName(stores[random.nextInt(stores.length)]);
        // 隨機金額 10 ~ 1000
        invoice.setAmount(random.nextInt(990) + 10);

        invoiceRepository.save(invoice);

        System.out.println("偵測到新雲端發票！已自動存入：" + invoice.getSellerName() + "，金額：" + invoice.getAmount());
    }
}