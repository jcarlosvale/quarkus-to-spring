package com.learning.marcianosQuarkusToSpring.service;

import com.learning.marcianosQuarkusToSpring.dto.UserRequest;
import com.learning.marcianosQuarkusToSpring.dto.UserResponse;
import com.learning.marcianosQuarkusToSpring.model.Conta;
import com.learning.marcianosQuarkusToSpring.model.User;
import com.learning.marcianosQuarkusToSpring.repository.ContaRepository;
import com.learning.marcianosQuarkusToSpring.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository repository;

    private final ContaRepository contaRepository;


    public List<User> getAll() {
        return repository.findAll();
    }

    public UserResponse save(UserRequest dto) {
        User user = new User();
        user.setCpf(dto.getCpf());
        user.setEmail(dto.getEmail());
        user.setName(dto.getNome());

        repository.save(user);

        return toUserResponse(user);
    }

    private UserResponse toUserResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .nome(user.getName())
                .cpf(user.getCpf())
                .email(user.getEmail())
                .build();
    }

    public boolean delete(Long id) {

        Optional<User> user = repository.findById(id);

        if (user.isPresent()) {
            repository.delete(user.get());

            return true;
        } else {
            return false;
        }
    }

    public Optional<User> update(Long id, UserRequest dto) {
        Optional<User> optionalUser = repository.findById(id);

        if (optionalUser.isPresent()) {

            User user = optionalUser.get();
            user.setCpf(dto.getCpf());
            user.setEmail(dto.getEmail());
            user.setName(dto.getNome());
            repository.save(user);

            return Optional.of(user);
        } else {

            return Optional.empty();
        }
    }

    public List<Conta> getContas() {
        return contaRepository.findAll();
    }

    public Conta saveConta(Conta conta) {
        contaRepository.save(conta);
        return conta;
    }
}
