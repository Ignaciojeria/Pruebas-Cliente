package com.fbfagostousa.domain.users;

public enum Role {
    ADMIN, MANAGER, OPERATOR, CUSTOMER, ANONYMOUS, AUTHENTICATED;

    public String roleName() {
        return "ROLE_" + this.toString();
    }
}
