package br.gov.cesarschool.poo.bonusvendas.tela;



import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;
import org.eclipse.swt.widgets.Text;
import br.gov.cesarschool.poo.bonusvendas.negocio.*;
import br.gov.cesarschool.poo.bonusvendas.dao.*;
import br.gov.cesarschool.poo.bonusvendas.entidade.Vendedor;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Endereco;
import br.gov.cesarschool.poo.bonusvendas.entidade.geral.Sexo;

import org.eclipse.swt.widgets.Group;
import org.eclipse.swt.widgets.Button;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.custom.StyledText;
import org.eclipse.swt.widgets.Label;
public class TelaManutencaoVendedor {

	protected Shell shell;

	/**
	 * Launch the application.
	 * @param args
	 * 
	 */
	VendedorDAO vendedorDAO = new VendedorDAO();
	LancamentoBonusDAO lancamentoBonusDAO= new LancamentoBonusDAO();
	private VendedorMediator mediator = VendedorMediator.getInstancia();
	
	private Text cpf;
	private Text nome;
	private Text nascimento;
	private Text renda;
	private Text logradouro;
	private Text numero;
	private Text complemento;
	private Text CEP;
	private Text cidade;
	private Text estado;
	private Text txtNome;
	private Text txtCpf;
	private Button btnNewButton;
	private Text txtLogradouro;
	private Text txtDataDeNascimento;
	private Text txtRenda;
	private Text txtNumero;
	private Text txtComplemento;
	private Text txtCep;
	private Text txtCidade;
	private Text txtEstado;
	private Button btnNewButton_4;
	private Button btnNewButton_5;
	private Button btnNewButton_6;
	private Button btnNewButton_7;
		//private static final  Sexo MASCULINO = new Sexo("M");
	    //private static final  Sexo FEMININO = new Sexo("F");

	    private String descricao;
	    private Text txtPais;

	    private void Sexo(String descricao) {
	        this.descricao = descricao;
	    }

	    public String getDescricao() {
	        return descricao;
	    }

	    @Override
	    public String toString() {
	        return descricao;
	    }
	
	public static void main(String[] args) {
		try {
			TelaManutencaoVendedor window = new TelaManutencaoVendedor();
			window.open();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Open the window.
	 */
	public void open() {
		Display display = Display.getDefault();
		createContents();
		shell.open();
		shell.layout();
		while (!shell.isDisposed()) {
			if (!display.readAndDispatch()) {
				display.sleep();
			}
		}
	}

	/**
	 * Create contents of the window.
	 */
	protected void createContents() {
		shell = new Shell();
		shell.setSize(943, 671);
		shell.setText("SWT Application");
		shell.setLayout(null);
		
		Button btnLimpada = new Button(shell, SWT.NONE);
		btnLimpada.setTouchEnabled(true);
		btnLimpada.setBounds(342, 513, 105, 35);
		btnLimpada.setText("Limpada");
		
		
		Button btnButao = new Button(shell, SWT.NONE);
		btnButao.setTouchEnabled(true);
		btnButao.setBounds(303, 59, 144, 31);
		btnButao.setText("butao");
		btnButao.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // Coloque o código que deseja executar quando o botão "butao" for clicado aqui.
		        // Por exemplo, exibir uma mensagem.
		        System.out.println("Botão 'butao' foi clicado!");
		    }
		});
		
		Button btnOtoButao = new Button(shell, SWT.NONE);
		btnOtoButao.setTouchEnabled(true);
		btnOtoButao.setBounds(303, 99, 144, 25);
		btnOtoButao.setText("oto butao");
		
		txtNome = new Text(shell, SWT.BORDER);
		txtNome.setText("NOME:");
		txtNome.setTouchEnabled(true);
		txtNome.setEnabled(true);
		txtNome.setBounds(112, 59, 189, 31);
		txtCpf = new Text(shell, SWT.BORDER);
		txtCpf.setText("cpf:");
		txtCpf.setBounds(112, 96, 189, 31);
		btnNewButton = new Button(shell, SWT.NONE);
		btnNewButton.setTouchEnabled(true);
		btnNewButton.setBounds(303, 141, 144, 25);
		btnNewButton.setText("New Button");
		
		txtLogradouro = new Text(shell, SWT.BORDER);
		txtLogradouro.setText("Logradouro:");
		txtLogradouro.setBounds(112, 210, 189, 31);
		
		Button btnM = new Button(shell, SWT.RADIO);
		btnM.setBounds(180, 487, 133, 25);
		btnM.setText("M");
		
		txtDataDeNascimento = new Text(shell, SWT.BORDER);
		txtDataDeNascimento.setText("Data de nascimento:");
		txtDataDeNascimento.setBounds(112, 138, 189, 31);
		
		txtRenda = new Text(shell, SWT.BORDER);
		txtRenda.setText("Renda:");
		txtRenda.setBounds(112, 173, 189, 31);
		
		txtNumero = new Text(shell, SWT.BORDER);
		txtNumero.setText("Numero:");
		txtNumero.setBounds(112, 246, 189, 31);
		
		txtComplemento = new Text(shell, SWT.BORDER);
		txtComplemento.setText("Complemento:");
		txtComplemento.setBounds(112, 283, 189, 31);
		
		txtCep = new Text(shell, SWT.BORDER);
		txtCep.setText("CEP:");
		txtCep.setBounds(112, 320, 189, 31);
		
		Button btnF = new Button(shell, SWT.RADIO);
		btnF.setBounds(180, 518, 133, 25);
		btnF.setText("F");
		
		txtCidade = new Text(shell, SWT.BORDER);
		txtCidade.setText("Cidade:");
		txtCidade.setBounds(112, 357, 189, 31);
		
		txtEstado = new Text(shell, SWT.BORDER);
		txtEstado.setText("Estado:");
		txtEstado.setBounds(112, 394, 189, 31);
		
		Button btnNewButton_1 = new Button(shell, SWT.NONE);
		btnNewButton_1.setBounds(303, 176, 144, 25);
		btnNewButton_1.setText("New Button");
		
		Button btnNewButton_2 = new Button(shell, SWT.NONE);
		btnNewButton_2.setBounds(303, 213, 144, 25);
		btnNewButton_2.setText("New Button");
		
		Button btnNewButton_3 = new Button(shell, SWT.NONE);
		btnNewButton_3.addSelectionListener(new SelectionAdapter() {
			@Override
			public void widgetSelected(SelectionEvent e) {
			}
		});
		btnNewButton_3.setBounds(303, 249, 144, 25);
		btnNewButton_3.setText("New Button");
		
		Button btnarmazenar = new Button(shell, SWT.NONE);
		btnarmazenar.setBounds(342, 482, 105, 35);
		btnarmazenar.setText("armazenar");
		
		btnNewButton_4 = new Button(shell, SWT.NONE);
		btnNewButton_4.setBounds(303, 286, 144, 25);
		btnNewButton_4.setText("New Button");
		
		btnNewButton_5 = new Button(shell, SWT.NONE);
		btnNewButton_5.setBounds(303, 320, 144, 25);
		btnNewButton_5.setText("New Button");
		
		btnNewButton_6 = new Button(shell, SWT.NONE);
		btnNewButton_6.setBounds(307, 360, 144, 25);
		btnNewButton_6.setText("New Button");
		
		btnNewButton_7 = new Button(shell, SWT.NONE);
		btnNewButton_7.setBounds(303, 397, 144, 25);
		btnNewButton_7.setText("New Button");
		
		txtPais = new Text(shell, SWT.BORDER);
		txtPais.setText("País:");
		txtPais.setBounds(111, 431, 190, 31);
		
		Button btnNewButton_8 = new Button(shell, SWT.NONE);
		btnNewButton_8.setBounds(313, 429, 134, 31);
		btnNewButton_8.setText("New Button");
		
		Label lblSexo = new Label(shell, SWT.NONE);
		lblSexo.setBounds(93, 487, 81, 25);
		lblSexo.setText("Sexo:");
		btnLimpada.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        // Lógica para limpar os campos de texto
		        txtCpf.setText("");
		        txtNome.setText("");
		        txtPais.setText("");
		        txtEstado.setText("");
		        txtCidade.setText("");
		        txtCep.setText("");
		        txtLogradouro.setText("");		        
				txtDataDeNascimento.setText("");								
				txtRenda.setText("");				
				txtNumero.setText("");			
				txtComplemento.setText("");
				btnM.setSelection(false);
		        btnF.setSelection(false);
		        // Limpe outros campos de texto, se necessário.
		    }
		});
		// ...
		btnarmazenar.addSelectionListener(new SelectionAdapter() {
		    @Override
		    public void widgetSelected(SelectionEvent e) {
		        String nome = txtNome.getText();
		        String cpf = txtCpf.getText();
		        
		        Sexo sexo = btnM.getSelection() ? Sexo.MASCULINO : Sexo.FEMININO;

		        String dataDeNascimentoStr = txtDataDeNascimento.getText();
		        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		        LocalDate dataDeNascimento = null;
		        try {
		            dataDeNascimento = LocalDate.parse(dataDeNascimentoStr, formatter);
		        } catch (DateTimeParseException excecao) {
		            System.err.println("Erro ao analisar a data: " + excecao.getMessage());
		        }
		        String renda = txtRenda.getText();
		        String logradouro = txtLogradouro.getText();
		        String numeroStr = txtNumero.getText();
		        int numero = 0; 
		        try {
		            numero = Integer.parseInt(numeroStr);
		        } catch (NumberFormatException excecao) {
		            System.err.println("Erro: Inteiro errado para 'numero'");
		        }
		        String complemento = txtComplemento.getText();
		        String cep = txtCep.getText();
		        String cidade = txtCidade.getText();
		        String estado = txtEstado.getText();
		        String pais = txtPais.getText();
		        Endereco endereco = new Endereco(logradouro, numero, complemento, cep, cidade, estado,pais);
		        Vendedor vendedor = new Vendedor(cpf, nome, sexo, dataDeNascimento, Double.parseDouble(renda), endereco);
		        boolean saved = vendedorDAO.incluir(vendedor);

		        if (saved) {
		            System.out.println("Vendedor salvo.");
		        } else {
		            System.out.println("Vendedor com mesmo CPF existe.");
		        }
		        // Call a method to save the vendedor in the database if needed
		        // vendedorDAO.salvarVendedor(vendedor);

		        // You can add more logic here, like displaying a confirmation message.
		        // include.salvadorVendedor(Vendedor prod)
		    }
		});
		// ...


	}
}
