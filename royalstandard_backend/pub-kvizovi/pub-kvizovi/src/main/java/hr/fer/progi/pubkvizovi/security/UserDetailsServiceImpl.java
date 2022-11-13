package hr.fer.progi.pubkvizovi.security;

import hr.fer.progi.pubkvizovi.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.security.core.authority.AuthorityUtils.commaSeparatedStringToAuthorityList;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        hr.fer.progi.pubkvizovi.domain.User user = userService.findByNickname(username).orElseThrow(
                () -> new UsernameNotFoundException("No user '" + username + "'")
        );
        Set<String> roles = user.getRoles().stream().map(r -> r.getName()).collect(Collectors.toSet());

        //System.out.println(user.getNickname() + " " + roles);
        List<GrantedAuthority> userAuthorities = authorities(roles);
        return new User(user.getNickname(), user.getPassword(), userAuthorities);
    }

    private List<GrantedAuthority> authorities(Set<String> roles) {
        if (roles.contains("ADMIN"))
            return commaSeparatedStringToAuthorityList("ROLE_ADMIN");
        else if (roles.contains("PLAYER") && roles.contains("QUIZMASTER"))
            return commaSeparatedStringToAuthorityList("ROLE_PLAYER, ROLE_QUIZMASTER");
        else if (roles.contains("PLAYER"))
            return commaSeparatedStringToAuthorityList("ROLE_PLAYER");
        else
            return commaSeparatedStringToAuthorityList("ROLE_QUIZMASTER");
    }
}
