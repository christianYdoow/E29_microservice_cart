package com.lazMalling.cart.service;


import com.lazMalling.cart.dto.UserDto;
import com.lazMalling.cart.model.Cart;
import com.lazMalling.cart.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private RestTemplate restTemplate;

    //-------------------------------------get client user role-----------------------------------
    public String getClientUserByRole(long userId){
        UserDto userDto=restTemplate.getForObject("http://localhost:8081/api/users/"+userId,UserDto.class);
        return userDto.getRole();
    }
    //-------------------------------------get client user id-------------------------------------
    public long getClientUserById(long userId){
        UserDto userDto=restTemplate.getForObject("http://localhost:8081/api/users"+userId,UserDto.class);
        return userDto.getUserId();
    }

    //-------------------------------------post new cart item-------------------------------------
    public ResponseEntity<HttpStatus> postCart(Cart cart){
        String userRole=getClientUserByRole(cart.getUserId());
        String regex="(?i)buyer";
        Pattern pattern=Pattern.compile(regex);
        Matcher match=pattern.matcher(userRole);
        if(match.matches()){
            cartRepository.save(cart);
            return  new ResponseEntity<>(HttpStatus.OK);
        }else {
            return  new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    //-------------------------------------get All cart-------------------------------------------------
    public List <Cart> getAllCart(){
        return cartRepository.findAll();
    }

    //-------------------------------------get cart list by userId--------------------------------------
    public List<Cart> getCartByUserId(@PathVariable long userId){
        List<Cart> carts=getAllCart();
        List<Cart> filteredCarts=new ArrayList<>();
        for(Cart cart : carts){
            if(cart.getUserId() == userId){
                String userRole=getClientUserByRole(cart.getUserId());
                String regex="(?i)buyer";
                Pattern pattern=Pattern.compile(regex);
                Matcher match=pattern.matcher(userRole);
                if(match.matches()){
                    filteredCarts.add(cart);
                }
            }
        }
        return filteredCarts;
    }
    //-------------------------------------update cart by id ----------------------------------------------------
    public ResponseEntity<HttpStatus> updateCartItemById(long cartId,Cart cart){
        String userRole=getClientUserByRole(cart.getUserId());
        String regex="(?i)buyer";
        Pattern pattern = Pattern.compile(regex);
        Matcher match= pattern.matcher(userRole);
        if(match.matches()){
            cart.setCartId(cartId);
            cartRepository.save(cart);
            return new  ResponseEntity<>(HttpStatus.OK);
        }else {
            return new  ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }
    //-------------------------------------delete cart  by id----------------------------------------------------
    public ResponseEntity<HttpStatus> deleteCartItemById(long cartId){
        cartRepository.deleteById(cartId);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
