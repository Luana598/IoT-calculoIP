package gui;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class TelaIP {

	private JLabel lblNumIp, lblCidr;
	private JPanel pnlOctetos;
	private JTextField txtPrimeiroOcteto, txtSegundoOcteto, txtTerceiroOcteto, txtQuartoOcteto, txtCidr;

	private JButton btnCalcular, btnLimpar;
	private JPanel pnlInfo;
	private JLabel lblIp, lblClasse, lblDecMask, lblBinMask, lblHosts;
	
	private JPanel pnlResult;
	private JLabel lblIpResult, lblClasseResult, lblDecMaskResult, lblBinMaskResult, lblHostsResult, lblNumRedes;
	private JLabel lblMsgErro;
	
			public void CriarTelaIp() {
				
				
				//características da tela
				JFrame tela = new JFrame();
				tela.setSize(500, 405);
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tela.setTitle("Informações de IP");
				tela.setLayout(null);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				
				
				
				lblNumIp = new JLabel();
				lblNumIp.setText("Número de Ip");
				lblNumIp.setBounds(37, 20, 220, 35);
				
				
			}
}
