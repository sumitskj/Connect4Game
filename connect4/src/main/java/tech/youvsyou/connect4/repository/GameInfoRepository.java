package tech.youvsyou.connect4.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tech.youvsyou.connect4.entity.GameInfo;

public interface GameInfoRepository extends JpaRepository<GameInfo, String> {

}
