package se.iths.flightplanning.security;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import se.iths.flightplanning.entity.RoleEntity;
import se.iths.flightplanning.entity.UserEntity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Set;

public class LoppisUserPrincipal implements UserDetails {

    private final UserEntity userEntity;

    public LoppisUserPrincipal(UserEntity userEntity) {
        super();
        this.userEntity = userEntity;
    }

    //Omvandlar RoleEntity till något som Sprinig Security förstår, dvs SimpleGrantedAuthority
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        Set<RoleEntity> roles = userEntity.getRoles();
        Collection<GrantedAuthority> grantedAuthorities = new ArrayList<>(roles.size());
        for (RoleEntity role : roles) {
            grantedAuthorities.add(new SimpleGrantedAuthority(role.getRole().toUpperCase()));
        }
        return grantedAuthorities;
    }

    @Override
    public String getPassword() {
        return this.userEntity.getPassword();
    }

    @Override
    public String getUsername() {
        return this.userEntity.getUsername();
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
