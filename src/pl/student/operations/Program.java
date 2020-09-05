package pl.student.operations;

import pl.student.Credentials;
import pl.student.repository.ClassesRepository;
import pl.student.repository.CredentialsRepository;
import pl.student.repository.Repository;

import java.util.List;

public class Program {



    public static void main(String[] args) {


        Repository<Classes> classesRepository = new ClassesRepository();
        List<Classes> classesList = classesRepository.getAll();
        ClassesLogic classesLogic = new ClassesLogic(classesList);
        ClassesPanel classesPanel = new ClassesPanel(classesList);


        Repository<Credentials> credentialsRepository = new CredentialsRepository();
        List<Credentials> credentialsList = credentialsRepository.getAll();
        CredentialsLogic credentialsLogic = new CredentialsLogic(credentialsList);
        CredentialsPanel credentialsPanel = new CredentialsPanel(credentialsLogic);


        AdminPanel adminPanel = new AdminPanel(credentialsLogic);
        //ClassesLogic classesLogic = new ClassesLogic(credentialsList);


        boolean loopStatus = true;
        int panel = 1;

        while (loopStatus) {

            switch (panel)

            {
                case 1: // logowanie
                    panel = credentialsPanel.getPanel(credentialsList);
                    break;
                case 2: // admin functions
                    panel = adminPanel.getPanel(credentialsList);
                    break;
                case 3: // admin functions
                    panel = professorPanel.getPanel(credentialsList);
                    break;
                case 99: // admin functions
                    loopStatus = false;
                    break;

            }

        }


    }

}