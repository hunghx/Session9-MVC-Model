package ra.academy.service.impl;

import ra.academy.model.Customer;
import ra.academy.service.IGenericService;

import java.util.ArrayList;
import java.util.List;

public class CustomerService implements IGenericService<Customer,Long> {
    private List<Customer> customers;

    public CustomerService() {
        customers = new ArrayList<>();
        customers.add(new Customer(1L,"Hunghx",24,true,"3219840.png"));
        customers.add(new Customer(2L,"Minhtt",20,true,"3219840.png"));
    }

    @Override
    public List<Customer> findAll() {
        return customers;
    }

    @Override
    public Customer findById(Long id) {
        for (Customer c:customers
             ) {
            if(c.getId()==id){
                return c;
            }
        }
        return null;
    }

    @Override
    public void save(Customer customer) {
        if(customer.getId()==null){
            // tạo id mới
            customer.setId(getNewId());
//            thêm mới
            customers.add(customer);
        }else {
            // cập nhật
            customers.set(customers.indexOf(findById(customer.getId())),customer);
        }
    }

    @Override
    public void delete(Long id) {
        customers.remove(findById(id));
    }
    public Long getNewId (){
        Long max = 0L;
        for (Customer c:customers
             ) {
            if(max<c.getId()){
                max = c.getId();
            }
        }
        return (max+1);
    }
}
