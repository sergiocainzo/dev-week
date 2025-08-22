package br.com.dio.dev_week.service.imp;

import br.com.dio.dev_week.domain.model.User;
import br.com.dio.dev_week.domain.repository.UserRepository;
import br.com.dio.dev_week.service.UserService;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository repository;

    public UserServiceImp(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public User findById(Long id) {
        return repository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User user) {
        if (repository.existsByAccountNumber(user.getAccount().getNumber())) {
            throw new IllegalArgumentException(
                    "Este numero de Conta: " + user.getAccount().getNumber() + ", já existe.");
        }

        return repository.save(user);
    }




}
