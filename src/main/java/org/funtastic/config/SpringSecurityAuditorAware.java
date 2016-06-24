package org.funtastic.config;

import java.util.List;

import org.funtastic.entity.User;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@Component
public class SpringSecurityAuditorAware implements AuditorAware<Long> {

	@SuppressWarnings("unchecked")
    public Long getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            List<GrantedAuthority> authorityList = (List<GrantedAuthority>) authentication.getAuthorities();
            if ("anonymousUser".equals(authentication.getPrincipal()) || "ROLE_ANONYMOUS".equals(authorityList.get(0).getAuthority())) {
                return 0L;
            } else {
                return ((User) authentication.getPrincipal()).getId();
            }
        } else {
            return null;
        }
    }

}
