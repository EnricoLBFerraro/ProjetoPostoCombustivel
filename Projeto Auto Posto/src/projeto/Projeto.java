
package projeto;
import DAO.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class Projeto {


    public static void main(String[] args) throws SQLException, IOException {
        //FrentistaDAO fren = new FrentistaDAO();
        //ArrayList<Frentista> lista = fren.getLista();
        //EstoqueGasolinaDAO gasolina = new EstoqueGasolinaDAO();
        //EstoqueEtanolDAO etDao = new EstoqueEtanolDAO();
        //etDao.Abastecimento((float) 600.00);
        //ArrayList<EstoqueEtanol> lista1 = etDao.getLista();
        //for(EstoqueEtanol et: lista1){
        //    System.out.print(et.getQuantidade());
        //}
        //Venda venda1 = new Venda(5,1,1,1,500,LocalDate.of(2023,5,10));
        //VendaDAO vendaDao = new VendaDAO();
        //vendaDao.venda(venda1);
        //Scanner input = new Scanner(System.in);
        //System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
        //int opcao = input.nextInt();
    /**
    while(opcao !=7){
        switch (opcao) {
            case 1:
                FrentistaDAO addFren = new FrentistaDAO();
                System.out.println("ID: ");
                int id = input.nextInt();
                System.out.println("Nome: ");
                String nome = input.next();
                Frentista func = new Frentista(id,nome);
                addFren.adiciona(func);
                System.out.print("Frentista "+ nome+ " Adcionado.\n");
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
                break;
            case 2:
                FrentistaDAO revFren = new FrentistaDAO();
                System.out.println("Id do frentista: ");
                int RevId = input.nextInt();
                revFren.deleta(RevId);
                System.out.print("Frentista cod = " + RevId + " Removido\n");
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
                break;
            case 3:
                System.out.println("Qual combustivel? 1-Etanol 2-Gasolina");
                int tipoGas = input.nextInt();
                System.out.println("Litros : ");
                float litros = input.nextFloat();
                if(tipoGas ==1){
                    EstoqueEtanolDAO estE = new EstoqueEtanolDAO();
                    estE.Abastecimento(litros);
                    System.out.print("Abastecimento de "+litros+" de Etano\n");
                } else {
                    EstoqueGasolinaDAO estG = new EstoqueGasolinaDAO();
                    estG.Abastecimento(litros);
                    System.out.print("Abastecimento de "+litros+" de Gasolina\n");
                }
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");;
                opcao = input.nextInt();
                break;
            case 4:
                System.out.println("Id de venda: ");
                int idVenda = input.nextInt();
                System.out.println("IdCliente: ");
                int idCliente = input.nextInt();
                System.out.println("IdFrentista: ");
                int idFrentista = input.nextInt();
                System.out.println("IdCombustivel (1-Etanol, 2-Gasolina)");
                int IdCombustivel = input.nextInt();
                System.out.print("Litros: ");
                float QntLitros = input.nextFloat();
                System.out.println("Data (yyyy-mm-dd) : ");
                String datavenda = input.next();
                String datavenda1 = "2023-05-15";

                Venda venda = new Venda(idVenda,idCliente,idFrentista,IdCombustivel,QntLitros,datavenda,100);
                VendaDAO vendaDao = new VendaDAO();
                vendaDao.venda(venda);
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
            case 5:
                System.out.println("ID do cliente: ");
                int IDCliente = input.nextInt();
                System.out.println("Nome: ");
                String nomeCliente = input.next();
                System.out.println("Telefone: ");
                int telefone = input.nextInt();
                ClienteDAO clientes = new ClienteDAO();
                Cliente cliente = new Cliente(IDCliente,nomeCliente,telefone);
                clientes.adiciona(cliente);
                System.out.println("Cliente adicionado\n");
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
            case 6:
                RelatorioDAO relatorio = new RelatorioDAO();
                ArrayList<VendaRelatorio> relVenda = new ArrayList<VendaRelatorio>();
                relVenda = relatorio.relatorioData("1999-05-10", "2025-05-11");
                String combustivel;
                for(VendaRelatorio caso6Venda : relVenda){
                   if(caso6Venda.getIDCombustivel()==1){
                       combustivel = "Etanol";
                   } else {
                       combustivel = "Gasolina";
                   }
                   System.out.println("Venda de "+ combustivel + " com quantidade "+ caso6Venda.getQuantidade()+ " na data "+ caso6Venda.getData() );
               }
/**
               RelatorioDAO relatorio = new RelatorioDAO();
               int idFrent = input.nextInt();
               ArrayList<VendaRelatorio> relVenda = new ArrayList<VendaRelatorio>();
               relVenda = relatorio.relatorioVenda(idFrent);
               String combustivel;
               
               for(VendaRelatorio caso6Venda : relVenda){
                   if(caso6Venda.getIDCombustivel()==1){
                       combustivel = "Etanol";
                   } else {
                       combustivel = "Gasolina";
                   }
                   System.out.println("Venda de "+ combustivel + " com quantidade "+ caso6Venda.getQuantidade()+ " na data "+ caso6Venda.getData() );
               }

               
               //System.out.println("Total de vendas do funcionario com id = "+idTotalFrent+ "= "+ relatorio.TotalDoFrentista(idTotalFrent));
               System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
            case 8:
                FrentistaDAO funcDao = new FrentistaDAO();
                ArrayList<Frentista> ListaFrentistas = new ArrayList<>();
                ListaFrentistas = funcDao.getLista();
                for(Frentista frent: ListaFrentistas){
                    System.out.println("Funcionario "+ frent.getNome() + " ID = "+ frent.getId());
                }
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
                
            case 9:
                ClienteDAO cliDao = new ClienteDAO();
                ArrayList<Cliente> listaCliente = cliDao.getLista();
                for(Cliente cli: listaCliente){
                    System.out.println("Cliente: "+ cli.getNome()+ " Telefone: "+ cli.getTelefone());
                }
                System.out.println("Menu \n 1-Adicionar Funcionario \n 2-RemoveFuncionario \n 3-Abastecimento \n 4-Realiza Venda \n 5-Cadastra Cliente \n 6-Gera Relatorio \n 7-sair \n 8-ListaDeFuncionario, \n 9-ListaDeClientes ");
                opcao = input.nextInt();
                break;
                
        }
    }
**/
    }

        
        
}
    

