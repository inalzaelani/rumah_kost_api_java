package com.inaal.rumahkost_api.services;

import com.inaal.rumahkost_api.exception.NotFoundException;
import com.inaal.rumahkost_api.models.entity.Kost;
import com.inaal.rumahkost_api.repositories.IRepositories;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class KostService implements IServices<Kost>{
    private IRepositories<Kost> kostRepository;

    @Autowired
    public KostService(IRepositories<Kost> kostRepository) {
        this.kostRepository = kostRepository;
    }

    @Override
    public List<Kost> getAllService()
    {
        List<Kost> kosts = kostRepository.findAll();
        return kosts.stream()
                .findFirst()
                .map(k -> kosts)
                .orElseThrow(() -> new NotFoundException("KOST NOT FOUND"));
    }

    @Override
    public Kost getByIdService(Long id) throws Exception {
        try {
            try {
              return kostRepository.findById(id);
            } catch (Exception e) {
                throw new NotFoundException("KOST NOT FOUND");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void saveService(Kost kost) {
        try{
            kostRepository.save(kost);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteService(Kost kost) throws Exception {
        try {
                try {
                   Kost find = kostRepository.findById(kost.getId());
                    kostRepository.delete(find);
                } catch (Exception e) {
                    throw new NotFoundException("KOST NOT FOUND");
                }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public void updateService(Kost kost) throws Exception {
      try {
          try {
              Kost find  = kostRepository.findById(kost.getId());
              kostRepository.update(find);
            } catch (Exception e) {
                throw new NotFoundException("KOST NOT FOUND");
          }

        } catch (Exception e){
            throw new RuntimeException(e);
      }

    }
}
