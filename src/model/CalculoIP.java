package model;

public class CalculoIP {

	private int primeiroOcteto;
	private int segundoOcteto;
	private int terceiroOcteto;
	private int quartoOcteto;
	private int cidr;

	public void setOctetos (int primeiroOcteto, int segundoOcteto, int terceiroOcteto, int quartoOcteto) {
		this.primeiroOcteto = primeiroOcteto;
		this.segundoOcteto = segundoOcteto;
		this.terceiroOcteto = terceiroOcteto;
		this.quartoOcteto = quartoOcteto;
	}
	
	public void setCidr (int cidr) {
		this.cidr = cidr;
	}
	
	public String getIp () {
		return String.format("%d.%d.%d.%d/%d", primeiroOcteto, segundoOcteto, terceiroOcteto, quartoOcteto, cidr);
	}
	
	public String getClasse () {
		if (primeiroOcteto >= 0 && primeiroOcteto <= 127) {
			return "A";
		} else if (primeiroOcteto >= 128 && primeiroOcteto <= 191) {
			return "B";
		} else if (primeiroOcteto >= 192 && primeiroOcteto <= 223) {
			return "C";
		} else {
		return "O valor deve ser menor ou igual à 223!";
		}
	}
	
	public String getMascaraDec() {
		int mascara = 0xffffffff << (32 - cidr);
		return String.format("%d.%d.%d.%d", 
		(mascara >>> 24) & 0xff,
		(mascara >>> 16) & 0xff, 
		(mascara >>> 8) & 0xff, 
		  mascara & 0xff);
	}
		
		public String getMascaraBin() {
			int mascara = 0xffffffff << (32 - cidr);
			return String.format("%32s", Integer.toBinaryString(mascara)).replace(' ', '0').substring(0, 32);
	}
		
		public int getIpsDisponíveis() {
			if (cidr >= 32) {
				return 1;
			} else {
				return (int) Math.pow(2,32-cidr) - 2;
			}
		}
		
		public int getQtdSubRedes() {
		    int base;
		    switch (getClasse()) {
		        case "A": base = 8; break;
		        case "B": base = 16; break;
		        case "C": base = 24; break;
		        default: return 0;
		    }
		    
		    if (cidr <= base) return 1;
		    
		    return (int) Math.pow(2, cidr - base);
		}

		   public int calcSalto() {
		        int mascara = 0xFFFFFFFF << (32 - cidr);
		        int ultimoOctetoMascara = (mascara & 0xFF);
		        return 256 - ultimoOctetoMascara;
		    }

		    public String getPrimIpValido() {
				int ultimoOcteto = quartoOcteto;
				int primIpValido = ultimoOcteto + 1;

				if (primIpValido > 255) {
					primIpValido = 0;
					terceiroOcteto++;
					if (terceiroOcteto > 255) {
						terceiroOcteto = 0;
						segundoOcteto++;
						if (segundoOcteto > 255) {
							segundoOcteto = 0;
							primeiroOcteto++;
							if (primeiroOcteto > 255) {
								primeiroOcteto = 0;
							}
						}
					}
				}

				return String.format("%d.%d.%d.%d", primeiroOcteto, segundoOcteto, terceiroOcteto, primIpValido);
			}
		    
		    public String getUltimoIpValido() {
		        int ip = (primeiroOcteto << 24) | (segundoOcteto << 16) | (terceiroOcteto << 8) | quartoOcteto;
		        int rede = ip & (0xFFFFFFFF << (32 - cidr));
		        int broadcast = rede | ~(0xFFFFFFFF << (32 - cidr));
		        int ultimoIp = broadcast - 1;
		        return formatIp(ultimoIp);
		    }

		    public String getIpBroadcast() {
		        int ip = (primeiroOcteto << 24) | (segundoOcteto << 16) | (terceiroOcteto << 8) | quartoOcteto;
		        int rede = ip & (0xFFFFFFFF << (32 - cidr));
		        int broadcast = rede | ~(0xFFFFFFFF << (32 - cidr));
		        return formatIp(broadcast);
		    }

		    private String formatIp(int ip) {
		        return String.format("%d.%d.%d.%d",
		                (ip >>> 24) & 0xFF,
		                (ip >>> 16) & 0xFF,
		                (ip >>> 8) & 0xFF,
		                ip & 0xFF);
		    }
}
