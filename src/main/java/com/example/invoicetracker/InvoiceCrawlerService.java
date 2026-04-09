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

        Invoice invoice = new Invoice(); // 這裡你定義的是 invoice

        // 產生真實格式號碼
        String[] letters = {"AB", "GH", "XY", "JS", "KL", "EM"};
        String prefix = letters[random.nextInt(letters.length)];
        int suffix = random.nextInt(90000000) + 10000000;
        String realStyleNum = prefix + "-" + suffix;

        // 修正這裡：把 sample 改成 invoice
        invoice.setInvNum(realStyleNum);

        invoice.setSellerName(stores[random.nextInt(stores.length)]);
        invoice.setAmount(random.nextInt(990) + 10);

        invoiceRepository.save(invoice);

        System.out.println("偵測到新雲端發票！號碼：" + realStyleNum + "，店名：" + invoice.getSellerName());

    }
}