/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;

public class FileReader {
    public static void main(String[] args) throws IOException {
        readFile();
        moneySummary();
    }
        
    public static void readFile() throws FileNotFoundException, IOException{
        try{                      
            BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("quylop.txt"), Charset.forName("UTF-8")));
            String line = br.readLine();           
            while (line != null) {      
                System.out.println(line);
                line = br.readLine();                                                         
            }                      
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }    
    public static void moneySummary() throws FileNotFoundException{ 
        ArrayList<SinhVien> listStudent = new ArrayList<SinhVien>();
        HashMap<String, SinhVien> mapStudent = new HashMap<String, SinhVien>();      
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(new FileInputStream("quylop.txt"),"UTF-8"));
            String str = in.readLine(); // bỏ dòng đầu tiên.            
            while ((str = in.readLine()) != null) {                             
                str = in.readLine();
                String[] arraySplit = str.split("\\t+");
                SinhVien sv = new SinhVien(
                    arraySplit[0].trim(),
                    arraySplit[1].trim(),
                    Integer.parseInt(arraySplit[2].trim()),
                    arraySplit[3].trim()
                );      
                if (mapStudent.containsKey(sv.getId())){
                    SinhVien temp = mapStudent.get(sv.getId());
                    sv.setMoney(temp.getMoney() + sv.getMoney());
                }
                mapStudent.put(sv.getId(), sv);                
           }
           in.close();
        } catch (UnsupportedEncodingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        }                         
        writeFile(mapStudent);                           
    }
    public static void writeFile(HashMap<String, SinhVien> map){        
    try{       
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(
        new FileOutputStream("quylop2.txt"), "UTF-8"));
        out.write("Mã sinh viên\tTên\t\t\tSố Tiền\t\tNgày tháng");
        out.newLine();
        for(String key : map.keySet() ){                        
            out.write(map.get(key).toString());
            out.newLine();
        }
        out.close();        
    } catch(Exception e){
        e.printStackTrace();
    }
   }  
 
}
