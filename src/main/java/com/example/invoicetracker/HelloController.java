package com.example.invoicetracker; // 注意你的 package 名稱

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Collectors;

@RestController
public class HelloController {

    @Autowired
    private InvoiceRepository invoiceRepository;

    // 1. 取得所有發票
    @GetMapping("/show-all")
    public List<Invoice> getAllInvoices() {
        return invoiceRepository.findAll();
    }

    // 2. 手動新增記帳
    // 2. 手動新增記帳
    @PostMapping("/add")
    public Invoice addManual(@RequestBody Invoice invoice) {

        return invoiceRepository.save(invoice);
    }

    // 圓餅圖專用：只統計「支出」的分類
    // 修改圓餅圖 API：加入月份過濾
    @GetMapping("/stats/category")
    public Map<String, Integer> getCategoryStats(@RequestParam(required = false) String month) {
        return invoiceRepository.findAll().stream()
                .filter(inv -> "支出".equals(inv.getType()))
                // 🔥 加入月份過濾：如果前端有傳 month (格式 YYYY-MM)，就過濾日期
                .filter(inv -> month == null || month.isEmpty() || (inv.getDate() != null && inv.getDate().startsWith(month)))
                .collect(Collectors.groupingBy(
                        inv -> inv.getCategory() == null ? "未分類" : inv.getCategory(),
                        Collectors.summingInt(Invoice::getAmount)
                ));
    }

    // 4. 清空資料庫
    @DeleteMapping("/clear-all")
    public String clearAll() {
        invoiceRepository.deleteAll();
        return "Cleared";
    }
}