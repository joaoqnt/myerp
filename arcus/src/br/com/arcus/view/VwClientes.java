package br.com.arcus.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import br.com.arcus.controller.ClienteCt;
import br.com.arcus.model.Cliente;
import br.com.arcus.model.Endereco;
import br.com.arcus.model.Usuario;
import br.com.arcus.utils.Cep;
import br.com.arcus.utils.MaskCampos;
import br.com.arcus.utils.Singleton;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class VwClientes extends JFrame {

	private JPanel contentPane;
	private JTextField txtId;
	private JTextField txtNome;
	private JTextField txtEmail;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCep;
	private JFormattedTextField txtCelular;
	private JFormattedTextField txtCnpj;
	private JTable tbDados;
	private JTextField txtBairro;
	private JTextField txtEndereco;
	private JTextField txtInsEst;
	private JRadioButton rdbtnF;
	private JRadioButton rdbtnJ;
	private JButton btnEditar;
	private JButton btnLimpar;
	private JButton btnExcluir;
	private JButton btnSalvar;
	private JButton btnCadastrar;
	private JTextField txtUf;
	private JTextField txtCidade;
	private JTextField txtNumero;
	private JTextField txtBusca;

	private void carregaTabela() {
		DefaultTableModel modelo = (DefaultTableModel) tbDados.getModel();
		modelo.setRowCount(0);
		ClienteCt ct = new ClienteCt();
		for(Cliente cli : ct.listagem()) {
			//Collections.sort(ct.listagem());
			modelo.addRow(new Object[] {
					cli.getId_cliente(),
					cli.getNome_cliente(),
					cli.getCpf_cliente(),
					cli.getEmail_cliente(),
					cli.getInsc_cliente(),
					cli.getCel_cliente(),
					cli.getEstado_cliente()
			});	
			//Collections.sort(ct.listagem());
		}
	}

	private void fechaEdicao() {
		txtCelular.setEnabled(false);
		txtCpf.setEnabled(false);
		txtCnpj.setEnabled(false);
		txtEmail.setEnabled(false);
		txtNome.setEnabled(false);
		txtBairro.setEnabled(false);
		txtEmail.setEnabled(false);
		txtEndereco.setEnabled(false);
		txtInsEst.setEnabled(false);
		txtNumero.setEnabled(false);
		txtCep.setEnabled(false);
		rdbtnF.setEnabled(false);
		rdbtnJ.setEnabled(false);
	}
	private String tiraCaracter(JFormattedTextField texto) {
		return texto.getText().replace(".", "").replace("-", "").replace("_","").replace("(", "").replace(")", "").replace("/", "");
	}
	private boolean validaCadastro() {
		boolean valido = true;
		if(
				(rdbtnF.isSelected() && (tiraCaracter(txtCpf).equals("") || tiraCaracter(txtCpf).length() != 11)) || 
				(rdbtnJ.isSelected() && (tiraCaracter(txtCnpj).equals("") || tiraCaracter(txtCnpj).length() != 14)) || 
				tiraCaracter(txtCelular).equals("") ||
				tiraCaracter(txtCelular).length() != 11 ||
				txtNome.getText().equals("") ||
				!txtEmail.getText().contains("@") || 
				tiraCaracter(txtCep).equals("") || tiraCaracter(txtCep).length() != 8) {
			
			valido = false;
		}
		return valido;
	}
	private void limpaTxt() {
		txtBairro.setText("");
		txtCelular.setText("");
		txtCep.setText("");
		txtCidade.setText("");
		txtCnpj.setText("");
		txtCpf.setText("");
		txtEmail.setText("");
		txtEndereco.setText("");
		txtId.setText("");
		txtInsEst.setText("");
		txtNome.setText("");
		txtNumero.setText("");
		txtUf.setText("");
		rdbtnF.setSelected(false);
		rdbtnJ.setSelected(false);
	}
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VwClientes frame = new VwClientes();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VwClientes() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("ERP - Cadastro de Cliente");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 525);
		ImageIcon arcusLogo = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/estrela_logo_arcus.png"));
		arcusLogo.setImage(arcusLogo.getImage().getScaledInstance(25, 40, 100));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ImageIcon logoPequena = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/estrela_logo_arcus_pequeno.png"));
		logoPequena.setImage(logoPequena.getImage().getScaledInstance(45, 45, 100));
		
		JMenu mnInicio = new JMenu("Início");
		menuBar.add(mnInicio);
		
		JMenu mnCadastro = new JMenu("Cadastro");
		menuBar.add(mnCadastro);
		
		JMenuItem mntmNewCliente = new JMenuItem("Cliente");
		mnCadastro.add(mntmNewCliente);
		
		JMenu mnClientes = new JMenu("Clientes");
		menuBar.add(mnClientes);
		
		JMenu mnDashboards = new JMenu("Dashboards");
		menuBar.add(mnDashboards);
		
		JMenu mnPedidos = new JMenu("Pedidos");
		menuBar.add(mnPedidos);
		
		JMenu mnProdutos = new JMenu("Produtos");
		menuBar.add(mnProdutos);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new TitledBorder(null, "Cliente", TitledBorder.LEADING, TitledBorder.TOP, null, null));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblId = new JLabel("ID:");
		lblId.setBounds(10, 34, 36, 14);
		contentPane.add(lblId);
		
		txtId = new JTextField();
		txtId.setEditable(false);
		txtId.setBounds(63, 31, 58, 20);
		contentPane.add(txtId);
		txtId.setColumns(10);
		
		JLabel lblNome = new JLabel("Nome:");
		lblNome.setBounds(10, 64, 36, 14);
		contentPane.add(lblNome);
		
		txtNome = new JTextField();
		txtNome.setEnabled(false);
		txtNome.setBounds(63, 61, 284, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(10, 94, 36, 14);
		contentPane.add(lblEmail);
		
		txtEmail = new JTextField();
		txtEmail.setEnabled(false);
		txtEmail.setBounds(63, 91, 284, 20);
		contentPane.add(txtEmail);
		txtEmail.setColumns(10);
		
		JLabel lblPessoa = new JLabel("Pessoa:");
		lblPessoa.setBounds(10, 124, 58, 14);
		contentPane.add(lblPessoa);

		rdbtnF = new JRadioButton("F");
		rdbtnF.setEnabled(false);
		rdbtnJ = new JRadioButton("J");
		rdbtnJ.setEnabled(false);
		
		rdbtnF.setBackground(new Color(255, 255, 255));
		rdbtnF.setBounds(66, 121, 36, 20);
		contentPane.add(rdbtnF);
		
		rdbtnJ.setBackground(new Color(255, 255, 255));
		
		rdbtnJ.setBounds(104, 121, 36, 20);
		contentPane.add(rdbtnJ);
		
		JLabel lblCPF = new JLabel("Cpf:");
		lblCPF.setBounds(10, 154, 36, 14);
		contentPane.add(lblCPF);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtCpf = new JFormattedTextField(mask.maskCpf(txtCpf));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtCpf.setBounds(63, 151, 86, 20);
		txtCpf.setEnabled(false);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
	
		
		JLabel lblCidade = new JLabel("Cidade:");
		lblCidade.setBounds(10, 334, 46, 14);
		contentPane.add(lblCidade);
		
		JLabel lblCep = new JLabel("Cep:");
		lblCep.setBounds(10, 274, 36, 14);
		contentPane.add(lblCep);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtCep = new JFormattedTextField(mask.maskCep(txtCep));
			txtCep.addKeyListener(new KeyAdapter() {
				@Override
				public void keyReleased(KeyEvent e) {
					if(tiraCaracter(txtCep).length() == 8) {
						Cep c = new Cep();
						c.buscarCep(tiraCaracter(txtCep));
						Endereco ed = Singleton.getInstance().getEndereco();
						txtUf.setText(ed.getUf());
						txtCidade.setText(ed.getCidade());
						txtBairro.setText(ed.getBairro());
						txtEndereco.setText(ed.getLogradouro());
						if(!txtEndereco.getText().equals("")) {
							txtEndereco.setEnabled(false);
							txtBairro.setEnabled(false);	
							System.out.println(ed.getIbge());
							txtNumero.setEnabled(true);
						}
					}
					else {
						txtUf.setText("");
						txtCidade.setText("");
						txtBairro.setText("");
						txtEndereco.setText("");
					}
				}
			});
			txtCep.setEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtCep.setColumns(10);
		txtCep.setBounds(63, 271, 75, 20);
		contentPane.add(txtCep);
		
		JLabel lblCelular = new JLabel("Celular:");
		lblCelular.setBounds(10, 244, 46, 14);
		contentPane.add(lblCelular);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtCelular = new JFormattedTextField(mask.maskCel(txtCelular));
			txtCelular.setEnabled(false);
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtCelular.setBounds(63, 241, 86, 20);
		contentPane.add(txtCelular);
		txtCelular.setColumns(10);
		
		JLabel lblCnpj = new JLabel("Cnpj:");
		lblCnpj.setBounds(10, 184, 36, 14);
		contentPane.add(lblCnpj);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtCnpj = new JFormattedTextField(mask.maskCnpj(txtCnpj));

			
		} catch (Exception e) {
			e.printStackTrace();
		}
		txtCnpj.setEnabled(false);
		txtCnpj.setColumns(10);
		txtCnpj.setBounds(63, 181, 112, 20);
		contentPane.add(txtCnpj);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(388, 64, 917, 317);
		contentPane.add(scrollPane);
		
		tbDados = new JTable();
		tbDados.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Id", "Nome", "Documento", "Email", "Insc_Estad", "Celular", "UF"
			}
		));
		tbDados.getColumnModel().getColumn(0).setPreferredWidth(20);
		tbDados.getColumnModel().getColumn(1).setPreferredWidth(200);
		tbDados.getColumnModel().getColumn(2).setPreferredWidth(75);
		tbDados.getColumnModel().getColumn(3).setPreferredWidth(210);
		tbDados.getColumnModel().getColumn(4).setPreferredWidth(75);
		tbDados.getColumnModel().getColumn(5).setPreferredWidth(81);
		tbDados.getColumnModel().getColumn(6).setPreferredWidth(10);
		scrollPane.setViewportView(tbDados);
		carregaTabela();
		
		JLabel lblBairro = new JLabel("Bairro:");
		lblBairro.setBounds(10, 364, 46, 14);
		contentPane.add(lblBairro);
		
		txtBairro = new JTextField();
		txtBairro.setEnabled(false);
		txtBairro.setBounds(63, 361, 153, 20);
		contentPane.add(txtBairro);
		txtBairro.setColumns(10);
		
		JSeparator separator = new JSeparator();
		separator.setOrientation(SwingConstants.VERTICAL);
		separator.setBounds(361, 25, 2, 417);
		contentPane.add(separator);
		
		JLabel lblLograd = new JLabel("Lograd:");
		lblLograd.setBounds(10, 394, 46, 14);
		contentPane.add(lblLograd);
		
		txtEndereco = new JTextField();
		txtEndereco.setEnabled(false);
		txtEndereco.setBounds(63, 391, 153, 20);
		contentPane.add(txtEndereco);
		txtEndereco.setColumns(10);
		
		JLabel lblUF = new JLabel("Uf:");
		lblUF.setBounds(10, 304, 36, 14);
		contentPane.add(lblUF);
		
		JLabel lblInsEst = new JLabel("Ins. Est:");
		lblInsEst.setBounds(10, 214, 46, 14);
		contentPane.add(lblInsEst);
		
		txtInsEst = new JTextField();
		txtInsEst.setEnabled(false);
		txtInsEst.setBounds(63, 211, 112, 20);
		contentPane.add(txtInsEst);
		txtInsEst.setColumns(10);
		
		btnCadastrar = new JButton("");
		btnCadastrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				Singleton.getInstance().setOp("I");
				limpaTxt();
				txtNome.setEnabled(true);
				txtNome.setEditable(true);
				txtInsEst.setEnabled(false);
				txtEndereco.setEnabled(true);
				txtEmail.setEnabled(true);
				txtCpf.setEnabled(false);
				txtCnpj.setEnabled(false);
				txtCep.setEnabled(true);
				txtCelular.setEnabled(true);
				txtBairro.setEnabled(true);
				btnSalvar.setEnabled(true);
				rdbtnF.setEnabled(true);
				rdbtnJ.setEnabled(true);
			}
		});
		btnEditar = new JButton("");
		btnExcluir = new JButton("");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Cliente c = Singleton.getInstance().getCli();
				ClienteCt ct = new ClienteCt();
				ct.delete(c);
				carregaTabela();
				limpaTxt();
				fechaEdicao();
			}
		});
		btnLimpar = new JButton("");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalvar.setEnabled(false);
				btnEditar.setEnabled(false);
				btnExcluir.setEnabled(false);
				limpaTxt();
			}
		});
		btnSalvar = new JButton("");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String op = Singleton.getInstance().getOp();
				System.out.println(op);
				switch (op) {
				case "I": {
					ClienteCt ct = new ClienteCt();
					Cliente c = new Cliente();
					c.setNome_cliente(txtNome.getText());
					c.setEmail_cliente(txtEmail.getText());
					if(rdbtnF.isSelected()) {
						c.setTipo_cliente("S");
						c.setCpf_cliente(tiraCaracter(txtCpf));
					}else {
						c.setTipo_cliente("N");
						c.setCpf_cliente(tiraCaracter(txtCnpj));
					}
					c.setInsc_cliente(txtInsEst.getText());
					c.setCel_cliente(tiraCaracter(txtCelular));
					c.setCep_cliente(tiraCaracter(txtCep));
					c.setEstado_cliente(txtUf.getText());
					c.setCidade_cliente(txtCidade.getText());
					c.setBairro_cliente(txtBairro.getText());
					c.setLogradouro_cliente(txtEndereco.getText());
					c.setNumero_cliente(Integer.parseInt(txtNumero.getText()));
					if(validaCadastro()) {
						ct.insert(c);							
						carregaTabela();
						limpaTxt();
						fechaEdicao();
						btnCadastrar.setEnabled(true);
					} else {
						
					}
					break;
				}
				case "U":{
					ClienteCt ct = new ClienteCt();
					Cliente c = Singleton.getInstance().getCli();
					Usuario u = Singleton.getInstance().getUser();
					c.setId_cliente(txtId.getText());
					c.setInsc_cliente(txtInsEst.getText());
					c.setCel_cliente(tiraCaracter(txtCelular));
					if(rdbtnF.isSelected()) {
						c.setTipo_cliente("S");
						c.setCpf_cliente(tiraCaracter(txtCpf));
					}else {
						c.setTipo_cliente("N");
						c.setCpf_cliente(tiraCaracter(txtCnpj));
					}
					c.setEmail_cliente(txtEmail.getText());
					c.setUsuario_cliente(u.getId_usuario());
					c.setCep_cliente(tiraCaracter(txtCep));
					c.setNome_cliente(txtNome.getText());
					c.setEstado_cliente(txtUf.getText());
					c.setCidade_cliente(txtCidade.getText());						
					c.setBairro_cliente(txtBairro.getText());						
					c.setLogradouro_cliente(txtEndereco.getText());		
					c.setNumero_cliente(Integer.parseInt(txtNumero.getText()));
					if(validaCadastro()){
						ct.update(c);
						fechaEdicao();
						carregaTabela();
						limpaTxt();
						btnSalvar.setEnabled(false);
						btnCadastrar.setEnabled(true);
					}else {
						JOptionPane.showMessageDialog(null, "Dados incorretos");
					}
					break;
				}
				
				}
			}
		});
		
		
		ImageIcon imageCadastrar = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/registro.png.png"));
		btnCadastrar.setIcon(imageCadastrar);
		imageCadastrar.setImage(imageCadastrar.getImage().getScaledInstance(25, 27, 100));
		btnCadastrar.setBounds(388, 394, 36, 23);
		contentPane.add(btnCadastrar);
		
		
		btnEditar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				txtCep.setEnabled(true);
				if(rdbtnF.isSelected()) {
					txtCpf.setEnabled(true);
					txtCnpj.setEnabled(false);
					rdbtnJ.setSelected(false);
				}
				if(rdbtnJ.isSelected()) {
					txtCnpj.setEnabled(true);
					txtCpf.setEnabled(false);
					rdbtnF.setSelected(false);
				}
				txtNome.setEnabled(true);
				txtEmail.setEnabled(true);
				txtInsEst.setEnabled(false);
				txtCelular.setEnabled(true);
				txtNumero.setEnabled(true);

				btnCadastrar.setEnabled(false);
				btnExcluir.setEnabled(false);
				btnSalvar.setEnabled(true);
				btnLimpar.setEnabled(false);
				rdbtnF.setEnabled(true);
				rdbtnJ.setEnabled(true);
				btnEditar.setEnabled(false);
				btnEditar.setSelected(false);
				
				Singleton.getInstance().setOp("U");
			}
		});
		btnEditar.setEnabled(false);
		ImageIcon imageEditar = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/edit.png.png"));
		btnEditar.setIcon(imageEditar);
		imageEditar.setImage(imageEditar.getImage().getScaledInstance(25, 27, 100));
		btnEditar.setBounds(458, 394, 36, 23);
		contentPane.add(btnEditar);
		
		
		btnExcluir.setEnabled(false);
		ImageIcon imageExcluir = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/delete.png.png"));
		btnExcluir.setIcon(imageExcluir);
		imageExcluir.setImage(imageExcluir.getImage().getScaledInstance(25, 27, 100));
		btnExcluir.setBounds(528, 394, 36, 23);
		contentPane.add(btnExcluir);
		
		JLabel lblCadastrar = new JLabel("Cadastrar");
		lblCadastrar.setBounds(384, 428, 58, 14);
		contentPane.add(lblCadastrar);
		
		JLabel lblEditar = new JLabel("Editar");
		lblEditar.setBounds(462, 428, 36, 14);
		contentPane.add(lblEditar);
		
		JLabel lblExcluir = new JLabel("Excluir");
		lblExcluir.setBounds(532, 428, 46, 14);
		contentPane.add(lblExcluir);
		
		
		ImageIcon imageLimpar = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/limpar.png.png"));
		btnLimpar.setIcon(imageLimpar);
		imageLimpar.setImage(imageLimpar.getImage().getScaledInstance(25, 27, 100));
		btnLimpar.setBounds(598, 394, 36, 23);
		contentPane.add(btnLimpar);
		
		JLabel lblLimpar = new JLabel("Limpar");
		lblLimpar.setBounds(602, 428, 36, 14);
		contentPane.add(lblLimpar);
		
		
		btnSalvar.setEnabled(false);
		ImageIcon imageSalvar = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/save.png.png"));
		btnSalvar.setIcon(imageSalvar);
		imageSalvar.setImage(imageSalvar.getImage().getScaledInstance(25, 27, 100));
		btnSalvar.setBounds(668, 394, 36, 23);
		contentPane.add(btnSalvar);
		
		JLabel lblSalvar = new JLabel("Salvar");
		lblSalvar.setBounds(672, 428, 36, 14);
		contentPane.add(lblSalvar);
		
		txtUf = new JTextField();
		txtUf.setEnabled(false);
		txtUf.setBounds(63, 301, 36, 20);
		contentPane.add(txtUf);
		txtUf.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setEnabled(false);
		txtCidade.setBounds(63, 331, 153, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblNumero = new JLabel("Numero:");
		lblNumero.setBounds(10, 424, 46, 14);
		contentPane.add(lblNumero);
		
		txtNumero = new JTextField();
		txtNumero.setEnabled(false);
		txtNumero.setBounds(63, 421, 58, 20);
		contentPane.add(txtNumero);
		txtNumero.setColumns(10);
		
		txtBusca = new JTextField();
		txtBusca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				if(txtBusca.getText().length() >= 3) {
					Singleton.getInstance().setBusca(txtBusca.getText());
					carregaTabela();
				}

				else {
					Singleton.getInstance().setBusca(null);
					carregaTabela();
				}
			}
		});
		txtBusca.setBounds(388, 31, 246, 20);
		contentPane.add(txtBusca);
		txtBusca.setColumns(10);
		
		JButton btnBusca = new JButton("");
		ImageIcon imageLupa = new ImageIcon(VwClientes.class.getResource("/br/com/arcus/images/search.png.png"));
		btnBusca.setIcon(imageLupa);
		imageLupa.setImage(imageLupa.getImage().getScaledInstance(25, 27, 100));
		btnBusca.setBounds(644, 31, 46, 20);
		contentPane.add(btnBusca);

		
		rdbtnJ.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnF.setSelected(false);
				txtCnpj.setEnabled(true);
				txtCnpj.setEditable(true);
				txtCpf.setEnabled(false);
				txtCpf.setEditable(false);
				txtInsEst.setEnabled(true);
			}
		});
		rdbtnF.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				rdbtnJ.setSelected(false);
				txtCnpj.setEnabled(false);
				txtCnpj.setEditable(false);
				txtCpf.setEnabled(true);
				txtCpf.setEditable(true);
				txtInsEst.setEnabled(false);
			}
		});
		tbDados.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				Cliente c = new Cliente();
				ClienteCt ct = new ClienteCt();
				
				Integer index = tbDados.getSelectedRow();
				c = ct.listagem().get(index);
				Singleton.getInstance().setCli(c);
				txtId.setText(c.getId_cliente());
				txtNome.setText(c.getNome_cliente());
				txtEmail.setText(c.getEmail_cliente());
				txtCelular.setText(c.getCel_cliente());
				if(c.getTipo_cliente().equals("N")) {
					rdbtnF.setSelected(false);
					rdbtnJ.setSelected(true);
					txtCnpj.setText(c.getCpf_cliente());
					txtCpf.setText("");;
				}
				if(c.getTipo_cliente().equals("S")) {
					rdbtnF.setSelected(true);
					rdbtnJ.setSelected(false);
					txtCpf.setText(c.getCpf_cliente());
					txtCnpj.setText("");;
					
				}
				txtBairro.setText(c.getBairro_cliente());
				txtCep.setText(c.getCep_cliente());
				txtUf.setText(c.getEstado_cliente());
				txtCidade.setText(c.getCidade_cliente());
				txtEndereco.setText(c.getLogradouro_cliente());
				txtInsEst.setText(c.getInsc_cliente());
				txtNumero.setText(Integer.toString(c.getNumero_cliente()));
				
				btnEditar.setEnabled(true);
				btnExcluir.setEnabled(true);
				btnCadastrar.setEnabled(true);
				fechaEdicao();
				//btnPedidos.setEnabled(true);
			}
		});
	}
}
