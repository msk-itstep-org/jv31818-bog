package org.itstep.msk.app.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import javax.sql.DataSource;

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
    @Autowired
    @Qualifier("passwordEncoder")
    private PasswordEncoder passwordEncoder;

    @Autowired
    private DataSource dataSource;

    // Настройка БД для security
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Запрос пользователя для аутентификации
        String usersQuery = "SELECT username, password, 1 as active FROM users WHERE username = ?";
        // Запрос ролей пользователя для авторизации
        String authoritiesQuery =
                "SELECT u.username, r.role "
                        + "FROM users u "
                        + "INNER JOIN user_roles ur ON ur.user_id = u.id "
                        + "INNER JOIN roles r ON r.id = ur.role_id "
                        + "WHERE u.username = ?";

        // Настраиваем аутентификацию и авторизацию через БД (JDBC)
        auth.jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(authoritiesQuery)
                .dataSource(dataSource)
                .passwordEncoder(passwordEncoder);
    }

    // Настройка урлов
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/").permitAll() // Разрешить доступ всем
                .antMatchers("/login").permitAll() // Разрешить доступ всем
                .antMatchers("/registration").permitAll() // Разрешить доступ всем
//                .antMatchers("/username").permitAll()
                .antMatchers("/admin/**").hasAnyAuthority("ROLE_ADMIN") // Разрешить доступ только пользователям с ролью ADMIN
                .anyRequest().authenticated(); // По остальным урлам разрешить доступ только залогиненным пользователям

        http.csrf().disable();

        http.formLogin()
                .loginPage("/login")
                .failureUrl("/login?error=true")
                .defaultSuccessUrl("/username")
                .usernameParameter("username")
                .passwordParameter("password");

        http.logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
                .logoutSuccessUrl("/");

        http.exceptionHandling()
                .accessDeniedPage("/access-denied");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        // Игнорируем следующие урлы
        // То есть по таким урлам не будет проверок доступа
        web.ignoring()
                .antMatchers("/css/**")
                .antMatchers("/js/**")
                .antMatchers("/images/**");
    }
}
