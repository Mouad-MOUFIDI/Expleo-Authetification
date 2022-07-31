package ma.expleo.exporters;

import ma.expleo.api.CollaborateurService;
import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.CollaborateurRequestDTO;
import ma.expleo.dto.CollaborateurResponseDTO;
import ma.expleo.mappers.CollaborateurMapper;
import ma.expleo.repositories.CollaborateurRepository;
import org.springframework.stereotype.Service;

@Service
public class CollaborateurAdresseServiceImpl implements CollaborateurService {
    CollaborateurRepository collaborateurRepository;
    CollaborateurMapper collaborateurMapper;

    public CollaborateurAdresseServiceImpl(CollaborateurRepository collaborateurRepository,CollaborateurMapper collaborateurMapper){
        this.collaborateurRepository=collaborateurRepository;
        this.collaborateurMapper=collaborateurMapper;
    }

    @Override
    public CollaborateurResponseDTO saveCollaborateur(CollaborateurRequestDTO collaborateurRequestDTO) {
        Collaborateur collaborateur = collaborateurMapper.collaborateurRequestDTOToCollaborateur(collaborateurRequestDTO);
        return collaborateurMapper.collaborateurToCollaborateurResponseDTO(collaborateurRepository.save(collaborateur));
    }

    @Override
    public CollaborateurResponseDTO loadCollaborateurByRegistrationNumber(String registrationNumber) {
        return collaborateurMapper.collaborateurToCollaborateurResponseDTO(collaborateurRepository.findByRegistrationNumber(registrationNumber));
    }
}
