package org.itstep.msk.app.service.impl;

import org.itstep.msk.app.entity.Contract;
import org.itstep.msk.app.repository.ContractRepository;
import org.itstep.msk.app.service.ContractService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContractServiceImpl implements ContractService {

    @Autowired
    private ContractRepository repository;

    @Override
    public Contract getContractById(Long id) {
        return repository.findById(id).orElse(null);
    }

    @Override
    public void saveContract(Contract contract) {
        repository.saveAndFlush(contract);
    }

    @Override
    public void updateContract(Contract contract) {
        Contract current = repository.getOne(contract.getId());
        current.setContract(contract.getContract());
        repository.saveAndFlush(current);
    }

    @Override
    public void deleteContract(Long id) {
        repository.deleteById(id);
        repository.flush();
    }

    @Override
    public List<Contract> findAll() {
        return repository.findAll();
    }
}
