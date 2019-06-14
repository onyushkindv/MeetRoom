package ru.sb.meetroom.repository.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.Office;
import ru.sb.meetroom.repository.extend.ExtendOfficeRepository;

public interface OfficeRepository extends CrudRepository<Office, Long>, ExtendOfficeRepository {
}
