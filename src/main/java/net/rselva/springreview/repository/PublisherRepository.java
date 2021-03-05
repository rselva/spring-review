package net.rselva.springreview.repository;

import net.rselva.springreview.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
