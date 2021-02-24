
import controller.Controller;
import data.IManager;
import data.Manager;
import entities.Medicine;
import repositories.IMedRepository;
import repositories.MedRepository;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        IManager iManager = new Manager();
        IMedRepository iMedRepository = new MedRepository(iManager);
        Controller controller = new Controller(iMedRepository);
        MyApplication myApplication = new MyApplication(controller);

        myApplication.Start();

    }
}
