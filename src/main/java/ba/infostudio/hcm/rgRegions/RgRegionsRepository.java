package ba.infostudio.hcm.rgRegions;


import org.springframework.data.repository.CrudRepository;


public interface RgRegionsRepository extends CrudRepository<RgRegionsModel, Long> {
    Iterable<RgRegionsModel> findByIdType_name(String name);
}
