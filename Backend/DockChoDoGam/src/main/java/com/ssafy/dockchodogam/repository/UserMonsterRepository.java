package com.ssafy.dockchodogam.repository;

import com.ssafy.dockchodogam.domain.Monster;
import com.ssafy.dockchodogam.domain.UserMonster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserMonsterRepository extends JpaRepository<UserMonster, Long> {

    Optional<UserMonster> findUserMonsterByMonsterMonsterIdAndUserUserId(Long monsterId, Long userId);
    Page<UserMonster> findUserMonsterByUserUserId(Long userId, Pageable pageable);

}
