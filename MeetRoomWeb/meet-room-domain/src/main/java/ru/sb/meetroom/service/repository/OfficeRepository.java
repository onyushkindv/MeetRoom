package ru.sb.meetroom.service.repository;

import org.springframework.data.repository.CrudRepository;
import ru.sb.meetroom.model.Office;
import ru.sb.meetroom.service.extend.ExtendOfficeRepository;

public interface OfficeRepository extends CrudRepository<Office, Long>, ExtendOfficeRepository {
}
