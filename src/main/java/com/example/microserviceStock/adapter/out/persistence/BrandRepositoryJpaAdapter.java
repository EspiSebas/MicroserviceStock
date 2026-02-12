package com.example.microserviceStock.adapter.out.persistence;

import com.example.microserviceStock.domain.exception.NameException;
import com.example.microserviceStock.domain.model.Brand;
import com.example.microserviceStock.domain.port.out.BrandRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrandRepositoryJpaAdapter implements BrandRepository {
    private final JpaBrandRepository jpaBrandRepository;


    public BrandRepositoryJpaAdapter(JpaBrandRepository jpaBrandRepository) {
        this.jpaBrandRepository = jpaBrandRepository;
    }


    @Override
    public Brand saveBrand(Brand brand) {
       if(jpaBrandRepository.findByName(brand.getName()).isPresent()){
           throw new NameException("The name is repited");
       }

       BrandEntity brandEntity = new BrandEntity();
       brandEntity.setName(brand.getName());
       brandEntity.setDescription(brand.getDescription());

       BrandEntity saved = jpaBrandRepository.save(brandEntity);
       return new Brand(
               saved.getName(),
               saved.getDescription()
       );


    }

    @Override
    public Page<Brand> getAllBrand(Pageable pageable) {
        return jpaBrandRepository.findAll(pageable)
                .map(p-> new Brand(
                        p.getName(),
                        p.getDescription()
                ));
    }
}
