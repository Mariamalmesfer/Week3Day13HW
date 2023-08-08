package com.example.bankmanagementsystemhw.Controller;


import com.example.bankmanagementsystemhw.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bankmanagementsystem")
public class BankManagementSystemController {


    ArrayList<Customers> CustomersArrayList = new ArrayList<>();

//    Get all the customers

    @GetMapping("/get")
    public ArrayList<Customers> getCustomersArrayList(){
        return CustomersArrayList;
    }


//    Add new customers

    @PostMapping("/add")
    public String addCustomers(@RequestBody Customers customer) {
        CustomersArrayList.add(customer);
        return"added successfully";
    }

//    Update customers

    @PutMapping("/update/{index}") // must be the same name
    public String updateCustomers(@PathVariable int index,@RequestBody Customers customers ){
        CustomersArrayList.set(index,customers);
        return"Updated successfully";
    }


//    Delete customers

    @DeleteMapping("/delete/{index}")
    public String deleteCustomers(@PathVariable int index){
        CustomersArrayList.remove(index);
        return "deleted successfully" ;

    }

//    Deposit money to customer

    @PutMapping("/deposit/{index}/{balence}") // must be the same name
    public String Deposit(@PathVariable int index,@PathVariable int balence){
        Customers customers= CustomersArrayList.get(index);
        int now = CustomersArrayList.get(index).getBalence();
        customers.setBalence(now + balence);
        return"The balance has  Deposit successfully" ;
    }


//    Withdraw money from customers


    @PutMapping("/withdraw/{index}/{balence}") // must be the same name
    public String Withdraw(@PathVariable int index,@PathVariable int balence){
        Customers customers= CustomersArrayList.get(index);
        int now = CustomersArrayList.get(index).getBalence();
        customers.setBalence(now - balence);
        return"The balance has  Withdraw successfully" ;
    }


}
