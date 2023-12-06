package com.demp.service;

import java.util.Optional;

public interface UserService<T>{

    public T loadUser(String username);

    public T saveUser(T user);

}
