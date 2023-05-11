package com.Spring.Spring.Service;

import com.Spring.Spring.Entity.CoronaPatInfo;
import com.Spring.Spring.Repository.CoronaPatInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.List;

@Service
public class CoronaPatInfoService {
    private  final CoronaPatInfoRepo coronaPatInfoRepo;

    @Autowired
    public CoronaPatInfoService(CoronaPatInfoRepo coronaPatInfoRepo){
        this.coronaPatInfoRepo = coronaPatInfoRepo;
    }

    public CoronaPatInfo saveDetails(CoronaPatInfo coronaPatInfo) throws SQLIntegrityConstraintViolationException {
        if(coronaPatInfoRepo.existsById(coronaPatInfo.getId()))
            throw new SQLIntegrityConstraintViolationException();
        return coronaPatInfoRepo.save(coronaPatInfo);
    }

    public List<CoronaPatInfo> getCoronaPatDetails() {
        return coronaPatInfoRepo.findAll();
    }

    public CoronaPatInfo getCoronaInfoById(long id){
        return coronaPatInfoRepo.findById(id).get();
    }
}
