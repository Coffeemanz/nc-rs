package com.zhyshkevich.controllers.security;


import com.zhyshkevich.entitites.RolesEntity;
import com.zhyshkevich.entitites.ClientsEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;

/**
 * Created by Сергей on 01.06.2017.
 */
public class CustomClientDetails extends ClientsEntity implements UserDetails{

    private final String ROLE_PREFIX = "ROLE_";

    public CustomClientDetails(ClientsEntity clientsEntity) {
        super(clientsEntity);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> list = new ArrayList<>();

        RolesEntity rolesEntity = super.getRole_id();
        list.add(new SimpleGrantedAuthority(ROLE_PREFIX + rolesEntity.getName()));
        System.out.println("-----------");
        System.out.println(list);
        System.out.println("-----------");
        return list;
    }

    @Override
    public String getUsername() {
        return super.getClientName();
    }

    @Override
    public String getPassword() {
        return super.getClientPassword();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

}
