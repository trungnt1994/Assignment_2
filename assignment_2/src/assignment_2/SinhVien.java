/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2;

/**
 *
 * @author HienTam68
 */
public class SinhVien {
    private String id;
    private String name;
    private int money;
    private String date;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public SinhVien(String id, String name, int money, String date) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.date = date;
    }

    @Override
    public  String toString() {            
        return id + "\t\t" + name + "\t\t" + money + "\t\t" + date ;
    }
    
    
}
