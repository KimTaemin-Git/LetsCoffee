package com.graduate2.project.controller;

import com.graduate2.project.domain.*;
import com.graduate2.project.service.CafeService;
import com.graduate2.project.service.MenuService;
import com.graduate2.project.service.PromotionService;
import com.graduate2.project.service.SeleniumCrawlService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
import java.util.Iterator;
import java.util.List;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MainController {
    private final PromotionService promotionService;

    @RequestMapping("/")

    public String main(Model model) {
        for (CafeId id : CafeId.values()) {
            String idStr = id.toString().toLowerCase();
            String name = idStr + "PromotionList"; //Ex) starbucksPromotionList
            List<Promotion> cafePromotionList = promotionService.findByCafeId(id);
            model.addAttribute(name, cafePromotionList);
        }

        return "main";
    }

    @PostMapping("/mypage")
    public String mypage(){
        return "mypage";
    }

}
