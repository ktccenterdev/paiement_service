package net.ktc.paiement.services;

import java.util.List;

public interface GeneralService<RequestDTO, ResponseDTO> {
    ResponseDTO getOne(String id);
    List<ResponseDTO> getAll();
    ResponseDTO save(RequestDTO requestDTO);
    ResponseDTO update(RequestDTO requestDTO);
    List<ResponseDTO> ModePaiementByCustomerId(String customerId);
    void delete(String id);
}
