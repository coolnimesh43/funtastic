package org.funtastic.config;

import java.util.List;

import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;


public class SpringSecurityAuditorAware implements AuditorAware<Long> {

	@SuppressWarnings("unchecked")
    public Long getCurrentAuditor() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        if (authentication != null) {
            List<GrantedAuthority> authorityList = (List<GrantedAuthority>) authentication.getAuthorities();
            if ("anonymousUser".equals(authentication.getPrincipal()) || "ROLE_ANONYMOUS".equals(authorityList.get(0).getAuthority())) {
                return 0L;
            } else {
//                return ((AuditUser) authentication.getPrincipal()).getId();
            	return 0L;
            }
        } else {
            return null;
        }
    }

}
