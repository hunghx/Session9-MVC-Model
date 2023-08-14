package ra.academy.controller;

import ra.academy.model.Customer;
import ra.academy.service.impl.CustomerService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "CustomerController", value = "/CustomerController")
@MultipartConfig(
        maxFileSize = 1024*1024*5 ,// 5Mb
        maxRequestSize = 1024*1024*10 ,// 10Mb
        fileSizeThreshold = 1024*1024*1 // 1mb
)
public class CustomerController extends HttpServlet {
    protected CustomerService customerService;

    public CustomerController() {
        customerService = new CustomerService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action == null){
            // chuyển hướng đến trang danh sachs khách hàng
            List<Customer> customers = customerService.findAll();
            request.setAttribute("customers",customers);
            request.getRequestDispatcher("/WEB-INF/views/list.jsp").forward(request,response);
        }else {
            switch (action){
                case "ADD":
                    request.getRequestDispatcher("/WEB-INF/views/add.jsp").forward(request,response);
                    break;
                case "DETAIL":
                    Long id =Long.valueOf(request.getParameter("id"));
                    request.setAttribute("customer",customerService.findById(id));
                    request.getRequestDispatcher("/WEB-INF/views/detail.jsp").forward(request,response);
                    break;
                case "EDIT":
                    Long idEdit =Long.valueOf(request.getParameter("id"));
                    request.setAttribute("customer",customerService.findById(idEdit));
                    request.getRequestDispatcher("/WEB-INF/views/edit.jsp").forward(request,response);
                    break;
                case "DELETE":
                    Long idDel =Long.valueOf(request.getParameter("id"));
                    customerService.delete(idDel);
                    response.sendRedirect("/");
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action){
                case "ADD":
                 // thực hiện thêm mới
                    String fullName = request.getParameter("fullName");
                    int age = Integer.parseInt(request.getParameter("age"));
                    boolean sex = Boolean.parseBoolean(request.getParameter("sex"));
                    Collection<Part> parts = request.getParts();
                    String avatar = null;
                    List<String> images = new ArrayList<>();
                    // upload file vào thư mục image của webapp

                    String uploadPath  = "C:\\Users\\hung1\\Downloads\\CustomerManager\\src\\main\\webapp\\image";
                    for (Part part: parts
                         ) {
                        if (part.getName().equals("avatar")){
                            avatar = part.getSubmittedFileName();
                            part.write(uploadPath+ File.separator+part.getSubmittedFileName());
                        }else if (part.getName().equals("image")){
                            images.add(part.getSubmittedFileName());
                            part.write(uploadPath+ File.separator+part.getSubmittedFileName());
                        }

                    }
                    // C:\Users\hung1\Downloads\CustomerManager\src\main\webapp\image\3219840.png;

                    // tạo mới
                    Customer customer  =new Customer(null,fullName,age,sex,avatar);
                    customer.setImages(images);
                    customerService.save(customer);


                    break;
                case "UPDATE":
                    Long id = Long.valueOf(request.getParameter("id"));
                    String fullNameUpdate = request.getParameter("fullName");
                    int ageUpdate = Integer.parseInt(request.getParameter("age"));
                    boolean sexUpdate = Boolean.parseBoolean(request.getParameter("sex"));
                    Collection<Part> partsUpdate = request.getParts();
                    String avatarUpdate = null;
                    List<String> imagesUpdate = new ArrayList<>();
                    // upload file vào thư mục image của webapp

                    String uploadPathUpdate  = "C:\\Users\\hung1\\Downloads\\CustomerManager\\src\\main\\webapp\\image";
                    for (Part part: partsUpdate
                    ) {
                        if (part.getName().equals("avatar")){
                            avatar = part.getSubmittedFileName();
                            part.write(uploadPathUpdate+ File.separator+part.getSubmittedFileName());
                        }else if (part.getName().equals("image")){
                            imagesUpdate.add(part.getSubmittedFileName());
                            part.write(uploadPathUpdate+ File.separator+part.getSubmittedFileName());
                        }

                    }
                    // C:\Users\hung1\Downloads\CustomerManager\src\main\webapp\image\3219840.png;

                    // tạo mới
                    Customer customerUpdate  =new Customer(id,fullNameUpdate,ageUpdate,sexUpdate,avatarUpdate);
                    customerUpdate.setImages(imagesUpdate);
                    customerService.save(customerUpdate);

                    break;
            }
            response.sendRedirect("/");
        }
    }
}