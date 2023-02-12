# Microservice for E-Commerce project

## Introduction

This document describes the design and implementation of microservices for an e-commerce project. The goal is to break down the project's functionalities and create individual microservices that follow the principles of microservice architecture

## Microservices

this is one of the microservices for this E-commerce project

## Cart Service

The Cart Service is responsible for managing the user's shopping cart and handling the following functionalities:

## functionalities


- **postCart** create new cart item
- **getAllCart** show all the cart information it can be use for administrative purpose also this will be use to display all available cart item in the e-commerce app
- **getCartByUserId** show all specific cart item that is related to the user id .
- **updateCartItemById** update cart item details that match the user id this functionalities is exclusively for buyer
- **deleteCartItemById** delete cart item that match the user id this functionalities is exclusively for buyer
- **getClientUserByRole**  this function help to determine whether the user role is buyer or seller this function is vital because this determines what functionalities will be for the buyer and for the  seller


This functionality is isolated from other services as it deals with the user's personal shopping data and needs to be managed independently to ensure security and performance.