
package programa;
import controller.ClienteControler;
import controller.ContaPoupancaController;
import domain.repository.ClienteRepository;
import domain.repository.ContaPoupancaRepository;
import domain.repository.ContaRepository;
import domain.service.ClienteService;
import domain.service.ContaPoupancaService;

public class Programa {
    
    public static void main(String[] args) {
        
        ClienteRepository Crepo = new ClienteRepository ();
        ClienteService Cservice = new ClienteService (Crepo);
        ClienteControler Ccontrol = new ClienteControler (Cservice);
        ContaRepository repo =  new ContaPoupancaRepository ();
        ContaPoupancaService service = new ContaPoupancaService (repo, Crepo);
        ContaPoupancaController controller = new ContaPoupancaController (service);
        
        
        
    }   
}