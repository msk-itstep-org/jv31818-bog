package org.itstep.msk.app.service;

import org.itstep.msk.app.entity.Contract;

import java.util.List;

public interface ContractService {
    Contract getContractById(Long id);
    void saveContract(Contract contract);
    void updateContract(Contract contract);
    void deleteContract(Long id);
    List<Contract> findAll();
}
