package manipalcse.pdc.dto;

import java.util.List;

public class LoginResponse {

    private String jwtToken;
    private Long id;
    private List<String> roles;

    public LoginResponse(String jwtToken, Long id, List<String> roles) {
        this.jwtToken = jwtToken;
        this.id = id;
        this.roles = roles;
    }

    public String getJwtToken() {
        return jwtToken;
    }

    public void setJwtToken(String jwtToken) {
        this.jwtToken = jwtToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }   

    public List<String> getRoles() {
        return roles;
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

   
}