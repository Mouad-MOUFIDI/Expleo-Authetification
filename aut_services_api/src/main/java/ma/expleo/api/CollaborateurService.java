package ma.expleo.api;

import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.CollaborateurRequestDTO;
import ma.expleo.dto.CollaborateurResponseDTO;

public interface CollaborateurService {
    CollaborateurResponseDTO saveCollaborateur(CollaborateurRequestDTO collaborateurRequestDTO);
    CollaborateurResponseDTO loadCollaborateurByRegistrationNumber(String registrationNumber);
}
