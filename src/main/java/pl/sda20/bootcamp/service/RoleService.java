package pl.sda20.bootcamp.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.sda20.bootcamp.model.Role;
import pl.sda20.bootcamp.repository.RoleRepository;



@Service
public class RoleService {

    @Autowired
    private RoleRepository roleRepository;

    public Role getRole(String role){
        return roleRepository.getByRole(role);
    }
}
