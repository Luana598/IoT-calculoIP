package gui;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import model.CalculoIP;

public class TelaIP {

	//campo de texto para inserir IP e CIDR
	private JLabel lblNumIp, lblCidr;
	private JPanel pnlOctetos;
	private JTextField txtPrimeiroOcteto, txtSegundoOcteto, txtTerceiroOcteto, txtQuartoOcteto, txtCidr;

	//painel de informações
	private JButton btnCalcular, btnLimpar;
	private JPanel pnlInfo;
	private JLabel lblIp, lblClasse, lblDecMask, lblBinMask, lblHosts, lblNumRedes, lblPrimeiroIpValido, lblUltimoIpValido, lblBroadcast;
	
	//resultados e mensagem de erro
	private JPanel pnlResult;
	private JLabel lblIpResult, lblClasseResult, lblDecMaskResult, lblBinMaskResult, lblHostsResult, lblNumRedesResult, lblPrimeiroIpValidoResult, lblUltimoIpValidoResult, lblBroadcastResult;
	private JLabel lblMsgErro;
	
			public void CriarTelaIp() {
				
				
				//características da tela
				JFrame tela = new JFrame();
				tela.setSize(500, 428);
				tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				tela.setTitle("Informações de IP");
				tela.setLayout(null);
				tela.setResizable(false);
				tela.setLocationRelativeTo(null);
				
				
				// inserção do IP
				lblNumIp = new JLabel();
				lblNumIp.setFont(new Font("Arial", Font.BOLD, 15));
				lblNumIp.setText("Número de Ip");
				lblNumIp.setBounds(37, 20, 220, 35);
				
				
				pnlOctetos = new JPanel (new GridLayout(1,4,5,0));
				pnlOctetos.setBounds(37, 60, 280, 30);
				
				
				txtPrimeiroOcteto = new JTextField();
				txtPrimeiroOcteto.setHorizontalAlignment(txtPrimeiroOcteto.CENTER);
				
				txtSegundoOcteto = new JTextField();
				txtSegundoOcteto.setHorizontalAlignment(txtSegundoOcteto.CENTER);
				
				
				txtTerceiroOcteto = new JTextField();
				txtTerceiroOcteto.setHorizontalAlignment(txtTerceiroOcteto.CENTER);
				
				
				txtQuartoOcteto = new JTextField();
				txtQuartoOcteto.setHorizontalAlignment(txtQuartoOcteto.CENTER);
				
				pnlOctetos.add(txtPrimeiroOcteto);
				pnlOctetos.add(txtSegundoOcteto);
				pnlOctetos.add(txtTerceiroOcteto);
				pnlOctetos.add(txtQuartoOcteto);
				
				lblCidr = new JLabel();
				lblCidr.setBounds(380,20,100,35);
				lblCidr.setText("CIDR:");
				lblCidr.setFont(new Font("Arial", Font.BOLD, 15));
				
				txtCidr = new JTextField();
				txtCidr.setBounds(380,60,66,30);
				txtCidr.setHorizontalAlignment(txtCidr.CENTER);
				
				btnCalcular = new JButton();
				btnCalcular.setText("Calcular");
				btnCalcular.setBounds(37, 105, 200, 35);
				btnCalcular.setFont(new Font("Arial", Font.BOLD, 14));
				btnCalcular.addActionListener(new ActionListener() {
					
						@Override
					public void actionPerformed(ActionEvent e) {
							
						try {
							int primeiroOcteto = Integer.parseInt(txtPrimeiroOcteto.getText());
							int segundoOcteto = Integer.parseInt(txtSegundoOcteto.getText());
							int terceiroOcteto = Integer.parseInt(txtTerceiroOcteto.getText());
							int quartoOcteto = Integer.parseInt(txtQuartoOcteto.getText());
							int cidr = Integer.parseInt(txtCidr.getText());
							
							
							CalculoIP calculadora = new CalculoIP();
							calculadora.setOctetos(primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto);
							calculadora.setCidr(cidr);
							
							lblIpResult.setText(calculadora.getIp());
							lblClasseResult.setText(calculadora.getClasse());
							lblDecMaskResult.setText(calculadora.getMascaraDec());
							lblBinMaskResult.setText(calculadora.getMascaraBin());
							lblHostsResult.setText(String.valueOf(calculadora.getIpsDisponíveis()));
							lblNumRedesResult.setText(String.valueOf(calculadora.getQtdSubRedes()));
							lblPrimeiroIpValidoResult.setText(String.valueOf(calculadora.getPrimIpValido()));
							lblUltimoIpValidoResult.setText(String.valueOf(calculadora.getUltimoIpValido()));
							lblBroadcastResult.setText(String.valueOf(calculadora.getIpBroadcast()));
							
							
							 lblMsgErro.setText("");
							 
						} catch (NumberFormatException ex) {
							
							lblMsgErro.setText("<html>Impossível calcular. <br> por favor, digite apenas números válidos ");
							
						}
							
						}
					
				});
				
				btnLimpar = new JButton();
				btnLimpar.setText("Limpar");
				btnLimpar.setBounds(246, 105, 200, 35);
				btnLimpar.setFont(new Font("Arial", Font.BOLD, 15));
				
				btnLimpar.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed (ActionEvent e) {
						
							txtPrimeiroOcteto.setText("");
							txtSegundoOcteto.setText("");
							txtTerceiroOcteto.setText("");
							txtQuartoOcteto.setText("");
							txtCidr.setText("");
							
							lblIpResult.setText("");
							lblClasseResult.setText("");
							lblDecMaskResult.setText("");
							lblBinMaskResult.setText("");
							lblHostsResult.setText("");
							lblNumRedesResult.setText("");
							lblPrimeiroIpValidoResult.setText("");
							lblUltimoIpValidoResult.setText("");
							lblBroadcastResult.setText("");
							
							
							lblMsgErro.setText("");
						
					}

		
					
				});
				
				//informações
				pnlInfo = new JPanel(new GridLayout(9, 1, 0, 0));
				pnlInfo.setBounds(37, 160, 200, 207);
				
				lblIp = new JLabel();
				lblIp.setText("IP inserido: ");
				lblIp.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblIp);
				
				lblClasse = new JLabel();
				lblClasse.setText("Classe: ");
				lblClasse.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblClasse);
				
				lblDecMask = new JLabel();
				lblDecMask.setText("Máscara Decimal: ");
				lblDecMask.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblDecMask);
				
				lblBinMask = new JLabel();
				lblBinMask.setText("Máscara Binária: ");
				lblBinMask.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblBinMask);
				
				lblHosts = new JLabel();
				lblHosts.setText("IPs Disponíveis: ");
				lblHosts.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblHosts);
				
				lblNumRedes = new JLabel();
				lblNumRedes.setText("sub-redes: ");
				lblNumRedes.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblNumRedes);
				
				lblPrimeiroIpValido = new JLabel();
				lblPrimeiroIpValido.setText("Primeiro Ip Válido: ");
				lblPrimeiroIpValido.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblPrimeiroIpValido);
				
				lblUltimoIpValido = new JLabel();
				lblUltimoIpValido.setText("Último Ip Válido: ");
				lblUltimoIpValido.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblUltimoIpValido);
				

				lblBroadcast = new JLabel();
				lblBroadcast.setText("Ip de Broadcast: ");
				lblBroadcast.setFont(new Font("Arial", Font.BOLD, 15));
				pnlInfo.add(lblBroadcast);
				
				
				//resultados
				pnlResult = new JPanel(new GridLayout(9, 1, 0, 0));
				pnlResult.setBounds(160, 160, 287, 207);
				
				lblIpResult = new JLabel();
				lblIpResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblIpResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblIpResult);
				
				lblClasseResult = new JLabel();
				lblClasseResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblClasseResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblClasseResult);
				
				lblDecMaskResult = new JLabel();
				lblDecMaskResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblDecMaskResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblDecMaskResult);
				
				lblBinMaskResult = new JLabel();
				lblBinMaskResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblBinMaskResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblBinMaskResult);
				
				lblHostsResult = new JLabel();
				lblHostsResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblHostsResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblHostsResult);
				
				lblNumRedesResult = new JLabel();
				lblNumRedesResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblNumRedesResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblNumRedesResult);
				
				lblPrimeiroIpValidoResult = new JLabel();
				lblPrimeiroIpValidoResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblPrimeiroIpValidoResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblPrimeiroIpValidoResult);
				
				lblUltimoIpValidoResult = new JLabel();
				lblUltimoIpValidoResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblUltimoIpValidoResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblUltimoIpValidoResult);
				
				lblBroadcastResult = new JLabel();
				lblBroadcastResult.setFont(new Font("Arial", Font.BOLD, 15));
				lblBroadcastResult.setHorizontalAlignment(SwingConstants.RIGHT);
				pnlResult.add(lblBroadcastResult);
				
				
				lblMsgErro = new JLabel();
				lblMsgErro.setBounds(67,295,400,40);
				lblMsgErro.setForeground(Color.red);
				lblMsgErro.setFont(new Font("Arial", Font.BOLD, 15));
				
				tela.getContentPane().add(lblNumIp);
				tela.getContentPane().add(pnlOctetos);
				tela.getContentPane().add(lblCidr);
				tela.getContentPane().add(txtCidr);
				tela.getContentPane().add(btnCalcular);
				tela.getContentPane().add(btnLimpar);
				tela.getContentPane().add(pnlInfo);
				tela.getContentPane().add(pnlResult);
				tela.getContentPane().add(lblMsgErro);
				
				tela.setVisible(true);
			
			}
}
