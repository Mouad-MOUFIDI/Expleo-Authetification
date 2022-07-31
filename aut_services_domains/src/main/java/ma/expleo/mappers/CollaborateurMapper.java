package ma.expleo.mappers;

import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.CollaborateurRequestDTO;
import ma.expleo.dto.CollaborateurResponseDTO;

public interface CollaborateurMapper {
    CollaborateurResponseDTO collaborateurToCollaborateurResponseDTO(Collaborateur collaborateur);
    Collaborateur collaborateurRequestDTOToCollaborateur(CollaborateurRequestDTO collaborateurRequestDTO);
}
