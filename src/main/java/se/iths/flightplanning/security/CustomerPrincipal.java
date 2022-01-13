package se.iths.flightplanning.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.iths.flightplanning.entity.CustomerEntity;
import se.iths.flightplanning.entity.RoleEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class CustomerPrincipal implements UserDetails {

    private final CustomerEntity customerDto;

    public CustomerPrincipal(CustomerEntity userDto) {
        super();
        this.customerDto = userDto;
    }

    //Omvandlar RoleEntity till något som Sprinig Security förstår, dvs SimpleGrantedAuthority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roles = customerDto.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());
        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.customerDto.getPassword();
    }

    @Override
    public String getUsername() {
        return this.customerDto.getUsername();
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
