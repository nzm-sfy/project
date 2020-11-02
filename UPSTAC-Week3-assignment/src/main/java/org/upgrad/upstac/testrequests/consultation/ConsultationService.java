package org.upgrad.upstac.testrequests.consultation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;
import org.upgrad.upstac.testrequests.TestRequest;
import org.upgrad.upstac.users.User;

import javax.transaction.Transactional;
import java.time.LocalDate;

@Service
@Validated
public class ConsultationService {

    @Autowired
    private ConsultationRepository consultationRepository;

    private static Logger logger = LoggerFactory.getLogger(ConsultationService.class);


    @Transactional
    public Consultation assignForConsultation( TestRequest testRequest, User doctor) {
        //Implement this method to assign the consultation service
        // create object of Consultation class and use the setter methods to set doctor and testRequest details
        // make use of save() method of consultationRepository to return the Consultation object

        // An object of Consultation class is created
        Consultation consultation = new Consultation();

        // Setter method is used to set the doctor of consultation object
        consultation.setDoctor(doctor);

        // Setter method is used to set the testRequest of consultation object
        consultation.setRequest(testRequest);

        // consultationRepository with consultation object is returned
        return consultationRepository.save(consultation);
    }

    public Consultation updateConsultation(TestRequest testRequest , CreateConsultationRequest createConsultationRequest) {
        //Implement this method to update the consultation
        // create an object of Consultation and make use of setters to set Suggestion, Comments, and UpdatedOn values
        // make use of save() method of consultationRepository to return the Consultation object

        // An object of Consultation class is created
        Consultation consultation = new Consultation();

        // Setter methods are used to set the values for different parameters of consultation object
        consultation.setSuggestion(createConsultationRequest.getSuggestion());
        consultation.setComments(createConsultationRequest.getComments());
        consultation.setUpdatedOn(LocalDate.now());

        // consultationRepository with consultation is returned
        return consultationRepository.save(consultation);
    }
}
