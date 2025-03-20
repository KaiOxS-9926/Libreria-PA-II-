package org.example.repository.interfaces;

import org.example.db.Author;
import org.apache.deltaspike.data.api.EntityRepository;
import org.apache.deltaspike.data.api.Repository;

@Repository
public interface AuthorRepository extends EntityRepository<Author, Integer> {
}
