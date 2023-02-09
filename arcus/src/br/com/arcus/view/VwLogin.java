package br.com.arcus.view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import br.com.arcus.controller.UsuarioCt;
import br.com.arcus.model.Usuario;
import br.com.arcus.utils.MaskCampos;
import br.com.arcus.utils.Singleton;

@SuppressWarnings("serial")
public class VwLogin extends JFrame {

	private JFrame frmTelaDeLogin;
	private JFormattedTextField txtCpf;
	private JTextField txtSenha;
	private JFormattedTextField txtEmpresa;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VwLogin window = new VwLogin();
					window.frmTelaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public VwLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.getContentPane().setBackground(new Color(255, 255, 255));
		frmTelaDeLogin.setForeground(new Color(255, 255, 255));
		frmTelaDeLogin.setIconImage(Toolkit.getDefaultToolkit().getImage(VwLogin.class.getResource("/br/com/arcus/images/estrela_logo_arcus.png")));
		frmTelaDeLogin.setResizable(false);
		frmTelaDeLogin.setTitle("Login");
		frmTelaDeLogin.setBounds(100, 100, 240, 341);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeLogin.getContentPane().setLayout(null);
		frmTelaDeLogin.setLocationRelativeTo(null);
		
		JLabel lblCpf = new JLabel("Cpf:");
		lblCpf.setBounds(26, 130, 53, 14);
		frmTelaDeLogin.getContentPane().add(lblCpf);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtCpf = new JFormattedTextField(mask.maskCpf(txtCpf));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		txtCpf.setBounds(26, 144, 169, 20);
		txtCpf.setText("10615409601");
		frmTelaDeLogin.getContentPane().add(txtCpf);
		txtCpf.setColumns(10);
		
		txtSenha = new JPasswordField();
		txtSenha.setText("777");
		txtSenha.setBounds(26, 188, 169, 20);
		frmTelaDeLogin.getContentPane().add(txtSenha);
		txtSenha.setColumns(10);
		
		JLabel lblSenha = new JLabel("Senha:");
		lblSenha.setBounds(26, 174, 55, 14);
		frmTelaDeLogin.getContentPane().add(lblSenha);
		
		JButton btnLogar = new JButton("Entrar");
		btnLogar.setAutoscrolls(true);
		ImageIcon chave = new ImageIcon(VwLogin.class.getResource("/br/com/arcus/images/key_FILL0_wght400_GRAD0_opsz48.png"));
		chave.setImage(chave.getImage().getScaledInstance(25, 27, 0));
		btnLogar.setIcon(null);
		btnLogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Usuario u = new Usuario();
				UsuarioCt ct = new UsuarioCt();
				
				u.setCpf_usuario(txtCpf.getText().replace(".","").replace("-", "").replace("_", ""));
				u.setSenha_usuario(txtSenha.getText());
				u.setCnpjEmp_usuario(txtEmpresa.getText().replace(".","").replace("-", "").replace("/", "").replace("_", ""));
				if(u.getCpf_usuario().length() != 11 || u.getCnpjEmp_usuario().length() != 14) {
					JOptionPane.showMessageDialog(null, "Dados nao preenchido corretamente", "Erro", 0);
				}else {
					Singleton.getInstance().setCnpj(u.getCnpjEmp_usuario());
					u = ct.select(u);
					Singleton.getInstance().setUser(u);
					
					//JOptionPane.showMessageDialog(null, u.getCpf_usuario());
					if( !u.getId_usuario().equals(null) || !u.getId_usuario().equals(0)) {
						//VwClientes vc = new VwClientes();
						//vc.setVisible(true);
						//vc.setExtendedState(JFrame.MAXIMIZED_BOTH);	
						frmTelaDeLogin.dispose();
						frmTelaDeLogin.setVisible(false);
						
						VwClientes frmTelaDeClientes = new VwClientes();
						frmTelaDeClientes.setVisible(true);
					} else {
						
					}
				}
			}
		});
		btnLogar.setBounds(26, 266, 169, 23);
		frmTelaDeLogin.getContentPane().add(btnLogar);
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		ImageIcon logo = new ImageIcon(VwLogin.class.getResource("/br/com/arcus/images/logo_arcus.png"));
		lblLogo.setIcon(logo);
		logo.setImage(logo.getImage().getScaledInstance(182, 84, 100));
		lblLogo.setIcon(logo);
		
		lblLogo.setBounds(26, 28, 169, 84);
		frmTelaDeLogin.getContentPane().add(lblLogo);
		
		try {
			MaskCampos mask = new MaskCampos();
			txtEmpresa = new JFormattedTextField(mask.maskCnpj(txtEmpresa));
	
		} catch (Exception e) {
			// TODO: handle exception
		}
		txtEmpresa.setBounds(26, 232, 169, 20);
		txtEmpresa.setText("25650383000174");
		frmTelaDeLogin.getContentPane().add(txtEmpresa);
		txtEmpresa.setColumns(10);
		
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(26, 218, 66, 14);
		frmTelaDeLogin.getContentPane().add(lblEmpresa);
		
	}
}
