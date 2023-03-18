package org.s3.individualassignment.backend.persistance;

import org.s3.individualassignment.backend.persistance.Entity.GroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface GroupsRepositoryJPA extends JpaRepository<GroupEntity, Long> {

    @Query(value="select g from GroupEntity as g join g.users u where u.user_id = :userId")
    List<GroupEntity> findGroupsByUser(Long userId);

}
