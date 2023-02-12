package com.lazMalling.cart.controller;


import com.lazMalling.cart.model.Cart;
import com.lazMalling.cart.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class CartController {

    @Autowired
    private CartService cartService;

    @PostMapping("/cart")
    public @ResponseBody ResponseEntity<HttpStatus>postCart(@RequestBody Cart cart){
        return cartService.postCart(cart);
    }

    @GetMapping("getAllCart")
    public   List<Cart> getAllCart(){
        return cartService.getAllCart();
    }

    @GetMapping("/getCartByUserId/{userId}")
    public List<Cart> getCartByUserId(@PathVariable long userId){
        return cartService.getCartByUserId(userId);
    }
    @PutMapping("/updateCartItemById/{cartId}")
    public ResponseEntity<HttpStatus> updateCartItemById(@PathVariable long cartId,@RequestBody Cart cart){
        return cartService.updateCartItemById(cartId,cart);
    }
    @DeleteMapping("/deleteCartItemById/{cartId}")
    public ResponseEntity<HttpStatus> deleteCartItemById(@PathVariable long cartId){
        return cartService.deleteCartItemById(cartId);
    }
}
