package org.s3.individualassignment.backend.persistance;

import org.s3.individualassignment.backend.persistance.Entity.ExpenseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ExpensesRepositoryJPA extends JpaRepository<ExpenseEntity, Long> {
    @Query(value = "SELECT e FROM ExpenseEntity as e where cast(e.group_id as string ) like :groupId")
    public List<ExpenseEntity> getGroupExpensesByGroupId(@Param("groupId") String groupId);

    @Query(value = "select e from ExpenseEntity as e where cast(e.user.user_id as string ) like :userId ")
    public List<ExpenseEntity> getUsersExpenses(@Param("userId") String userId);

    @Modifying
    @Query(value = "INSERT IGNORE INTO `group_user` (`group_id`, `user_id`) VALUES (:groupId, :userId)", nativeQuery = true)
    public void createGroupUserRecord(Long groupId, Long userId);
}


