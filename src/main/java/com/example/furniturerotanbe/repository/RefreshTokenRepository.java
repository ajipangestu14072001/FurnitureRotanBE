package com.example.furniturerotanbe.repository;

import com.example.furniturerotanbe.models.RefreshToken;
import com.example.furniturerotanbe.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.Optional;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    @Override
    Optional<RefreshToken> findById(Long id);
    Optional<RefreshToken> findByToken(String token);
    @Modifying
    int deleteByUser(User user);
}
