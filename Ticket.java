/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.w2006939_planemanagement;

/**
 *
 * @author runningsalad
 */
public class Ticket {
    private String row;
    private int seat;
    private int price;
    private Person person;
    
    public Ticket (String row, int seat, int price, Person person){
        this.row = row;
        this.seat = seat;
        this.price = price;
        this.person = person;
    }
    
    public String getRow(){
        return this.row;
    }
    
    public void setRow(String row){
        this.row = row;
    }
    
    public int getSeat(){
    return this.seat;
    }
    
    public void setSeat(int seat){
    this.seat = seat;
    }
    
    public int getPrice(){
    return this.price;
    }
    
    public void setPrice(int price){
    this.price = price;
    }
    
    public Person getPerson(){
        return this.person;
    }
    
    public void setPerson(Person person){
        this.person = person;
    }
    
    public String printTicketInfo(){
    return "Row:" + row + ", Seat: " + seat + ", Price: £" + price + ", Person Info: " + person;
    }
    
}
