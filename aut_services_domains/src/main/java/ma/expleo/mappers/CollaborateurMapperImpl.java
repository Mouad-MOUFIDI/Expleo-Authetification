package ma.expleo.mappers;

import ma.expleo.domain.Collaborateur;
import ma.expleo.dto.CollaborateurRequestDTO;
import ma.expleo.dto.CollaborateurResponseDTO;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.stereotype.Component;

@Component
public class CollaborateurMapperImpl implements CollaborateurMapper {
    private final BeanFactory beanFactory;

    public CollaborateurMapperImpl(BeanFactory beanFactory) {
        this.beanFactory = beanFactory;
    }

    @Override
    public CollaborateurResponseDTO collaborateurToCollaborateurResponseDTO(Collaborateur collaborateur) {
        CollaborateurResponseDTO collaborateurResponseDTO=beanFactory.getBean(CollaborateurResponseDTO.class);
        collaborateurResponseDTO.setId(collaborateur.getId());
        collaborateurResponseDTO.setColName(collaborateur.getColName());
        collaborateurResponseDTO.setColFirstName(collaborateur.getColFirstName());
        collaborateurResponseDTO.setColDateOfBirth(collaborateur.getColDateOfBirth());
        collaborateurResponseDTO.setDateOfEntryService(collaborateur.getDateOfEntryService());
        collaborateurResponseDTO.setDateOfReleaseService(collaborateur.getDateOfReleaseService());
        collaborateurResponseDTO.setRegistrationNumber(collaborateur.getRegistrationNumber());
        collaborateurResponseDTO.setMotifReleaseService(collaborateur.getMotifReleaseService());
        return collaborateurResponseDTO;
    }

    @Override
    public Collaborateur collaborateurRequestDTOToCollaborateur(CollaborateurRequestDTO collaborateurRequestDTO) {
        Collaborateur collaborateur=beanFactory.getBean(Collaborateur.class);
        collaborateur.setColName(collaborateurRequestDTO.getColName());
        collaborateur.setColFirstName(collaborateurRequestDTO.getColFirstName());
        collaborateur.setColDateOfBirth(collaborateurRequestDTO.getColDateOfBirth());
        collaborateur.setDateOfEntryService(collaborateurRequestDTO.getDateOfEntryService());
        collaborateur.setDateOfReleaseService(collaborateurRequestDTO.getDateOfReleaseService());
        collaborateur.setRegistrationNumber(collaborateurRequestDTO.getRegistrationNumber());
        collaborateur.setMotifReleaseService(collaborateurRequestDTO.getMotifReleaseService());
        return collaborateur;
    }
}
