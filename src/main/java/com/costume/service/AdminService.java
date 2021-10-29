package com.costume.service;

import com.costume.model.Admin;
import com.costume.repository.AdminRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//Servicio clase admin
@Service
public class AdminService {
    @Autowired
    private AdminRepository adminRepository;
 
    public List<Admin> getAll(){
       return adminRepository.getAll();
    }

    public Optional<Admin> getAdmin(int id){
       return adminRepository.getAdmin(id);
    }
    
    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return adminRepository.save(admin);
        } else {
            Optional<Admin> admin1 = adminRepository.getAdmin(admin.getIdAdmin());
            if (admin1.isEmpty()) {
                return adminRepository.save(admin);
            } else {
                return admin;
            }
        }
    }

    public Admin updateAdmin(Admin admin){
        if (admin.getIdAdmin() != null){
            Optional<Admin>  admin_bd = adminRepository.getAdmin(admin.getIdAdmin());
            if (!admin_bd.isEmpty()){
                if (admin.getEmail() != null){
                    admin_bd.get().setEmail(admin.getEmail());
                }

                if (admin.getPassword() != null){
                    admin_bd.get().setPassword(admin.getPassword());
                }

                if (admin.getName()!=null){
                    admin_bd.get().setName(admin.getName());
                }
                return adminRepository.save(admin);
            }
        }

        return admin;

    }

    public boolean deleteAdmin(int id){
        Optional<Admin>  admin = adminRepository.getAdmin(id);
        if (admin.isEmpty()){
            return  false;
        }else {
            adminRepository.delete(admin.get());
            return  true;
        }
    }
}
