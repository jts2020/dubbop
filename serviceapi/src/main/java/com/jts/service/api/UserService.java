package com.jts.service.api;

import javax.naming.NamingException;

public interface UserService {
    String getUser();

    String get() throws NamingException;
}
