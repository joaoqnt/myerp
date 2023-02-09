package br.com.arcus.view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JMenuBar;
import java.awt.Color;

import javax.swing.JMenu;
import javax.swing.JMenuItem;

import javax.swing.ImageIcon;
import java.awt.Frame;


@SuppressWarnings("serial")
public class VwInicio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VwInicio frame = new VwInicio();
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
	public VwInicio() {
		setExtendedState(Frame.MAXIMIZED_BOTH);
		setTitle("ERP - Home");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1108, 525);
		ImageIcon arcusLogo = new ImageIcon(VwInicio.class.getResource("/br/com/arcus/images/estrela_logo_arcus.png"));
		arcusLogo.setImage(arcusLogo.getImage().getScaledInstance(25, 40, 100));
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		ImageIcon logoPequena = new ImageIcon(VwInicio.class.getResource("/br/com/arcus/images/estrela_logo_arcus_pequeno.png"));
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
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		//ImageIcon HambMenu = new ImageIcon(VwInicio.class.getResource("/br/com/arcus/images/menu_hamburguer.png"));
	}
}
