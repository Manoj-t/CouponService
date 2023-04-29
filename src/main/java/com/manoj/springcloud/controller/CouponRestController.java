package com.manoj.springcloud.controller;

import com.manoj.springcloud.dao.CouponRepo;
import com.manoj.springcloud.model.Coupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {

    private CouponRepo couponRepo;

    @Autowired
    public CouponRestController(CouponRepo couponRepo){
        this.couponRepo = couponRepo;
    }

    @PostMapping("/coupons")
    public Coupon createCoupon(@RequestBody Coupon coupon){
        return couponRepo.save(coupon);
    }


    @GetMapping("/coupons/{code}")
    public Coupon getCoupon(@PathVariable(name = "code") String code){

        return couponRepo.findByCode(code);
    }



}
