package materias;

import java.util.ArrayList;
import javax.swing.JOptionPane;
public class Principal {

	

	public static void main(String[] args) {
		
		ArrayList<LecionarA> instancias = new ArrayList<LecionarA>();
		
		String op;
		
		do{
			op = JOptionPane.showInputDialog(null,"Informe a operação: \n [1] cadastrar professor e alunos \n [2] cadastrar aluno \n [3] mostrar professor \n [4] mostrar aluno \n [5] fim\n");
			if(op.charAt(0) == '1') //opção para cadastrar professores aos seus alunos
			{	
				LecionarA inst = new LecionarA();
				Professores prof = new Professores();
				Alunos alu = new Alunos();
				
				prof.setNome(JOptionPane.showInputDialog(null,"informe o nome do professor:")); //recbe do usuário o nome do professor
				prof.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe matricula do professor:"))); //recebe do usuario a matricula do professor
				alu.setNome(JOptionPane.showInputDialog(null,"Informe nome do aluno:")); //recebe do usuário o nome de um aluno
				alu.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe matricula:"))); //recebe do usuário a matricula de um aluno
				inst.setProfessores(prof);
				inst.setAlunos(alu);
				instancias.add(inst);
				
				int aux = 0 ; //variavel usada como flag
				while(aux != 1){	
					String cadastrar = JOptionPane.showInputDialog(null,"cadastrar mais um aluno? [y] ou [n] "); //verifica se o usuário quer cadastrar mais um aluno , levando em consideração que todo professor tem pelo menos 1 aluno 
					
						if(cadastrar.charAt(0)=='y'){ //se for "Y" ele cadastrar mais um aluno
							LecionarA inst_aux = new LecionarA();
							Alunos alu_aux = new Alunos();
							alu_aux.setNome(JOptionPane.showInputDialog(null,"Informe nome do aluno:")); //recebe do usuário o nome de um aluno
							alu_aux.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe matricula:"))); //recebe do usuário a matricula de um aluno
							inst_aux.setProfessores(prof);
							inst_aux.setAlunos(alu_aux);
							instancias.add(inst_aux); //adiciona profe. e alunos na lista
					
						}else if(cadastrar.charAt(0)=='n'){ //se for "N" ele sai do while e da opção
							aux = 1;
							System.out.println("alunos cadastrados!");
						}
				}
				System.out.println("professores e alunos cadastrados");
			} 
			if(op.charAt(0) == '2'){ //cadastra aluno a professor
				LecionarA inst_aux1 = new LecionarA();
				Alunos alu_aux1 = new Alunos();
				Professores prof_aux = new Professores();
				
				alu_aux1.setNome(JOptionPane.showInputDialog(null,"Informe nome do aluno:")); //recebe do usuário o nome de um aluno
				alu_aux1.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe matricula:"))); //recebe do usuário a matricula de um aluno
				prof_aux.setNome(JOptionPane.showInputDialog(null,"informe o nome do professor:")); //recbe do usuário o nome do professor
				prof_aux.setMatricula(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe matricula do professor:"))); //recebe do usuario a matricula do professor
				inst_aux1.setAlunos(alu_aux1);
				inst_aux1.setProfessores(prof_aux);
				instancias.add(inst_aux1);
				
				System.out.println("aluno cadastrado!");
			}
			if(op.charAt(0) == '3'){ //mostra a lista dos alunos de um professor a partir de uma busca pelo nome do professor
				
				String prof_busca = JOptionPane.showInputDialog(null,"nome do professor para mostrar sua lista de alunos: ");
				String busca = "";
				for(int i=0;i<instancias.size();i++){
					if(prof_busca.equals(instancias.get(i).getProfessores().getNome())){
						busca += instancias.get(i).getAlunos().getNome() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, "Alunos: \n"+busca);
				System.out.println("Alunos: \n"+busca);
			}
			
			if(op.charAt(0) == '4'){
				String alu_busca = JOptionPane.showInputDialog(null,"nome do aluno para mostrar a sua lista de professores:");
				String busca_alu = "";
				for(int i=0;i<instancias.size();i++){
					if(alu_busca.equals(instancias.get(i).getAlunos().getNome())){
						busca_alu += instancias.get(i).getProfessores().getNome() + "\n";
					}
				}
				JOptionPane.showMessageDialog(null, "Professores: \n"+busca_alu);
				System.out.println("Alunos: \n"+busca_alu);
			}
			
			
		}while(op.charAt(0)!= '5');
		System.exit(0);
		

	}

}
