package io.githgub.nicoladaniello.books.data.suppliers;

import io.githgub.nicoladaniello.books.data.BaseRepository;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends BaseRepository<Supplier, Long> {

    Optional<Supplier> findByName(String name);

    List<Supplier> findByNameContainingIgnoreCase(String name);
}
