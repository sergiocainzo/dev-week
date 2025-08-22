package br.com.dio.dev_week.service;

import br.com.dio.dev_week.domain.model.User;

public interface UserService {

    User findById(Long id);

    User create(User user);
}
