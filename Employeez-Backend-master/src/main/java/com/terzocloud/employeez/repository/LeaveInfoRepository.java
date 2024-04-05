package com.terzocloud.employeez.repository;

import com.terzocloud.employeez.entity.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveInfoRepository extends JpaRepository<LeaveInfo,Long> {
}
