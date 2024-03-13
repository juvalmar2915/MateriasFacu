package misservlets;
import javax.persistence.*;
@Entity
public class Presupuesto {
	 @Id @GeneratedValue
	 @Column(name="Presupuesto_ID")
	 private Long id;

	private int cantAsist;
	private String salon;
    private boolean catering;
    private boolean vino;
    private boolean champagne;
    private boolean torta;
    private boolean animacionydj;
    private boolean flores;
    private boolean decoracion;
    private boolean sillas;
    private boolean alfombras;
    private boolean mesa;
    private boolean invitaciones;
    private boolean alianzas;
    private boolean videoyFotografia;
    private String nombre;
    private String mail;
    private int total;
    public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public Presupuesto(){ }
	public int getCantAsist() {
		return cantAsist;
	}
	public void setCantAsist(int cantAsist) {
		this.cantAsist = cantAsist;
	}
	public String getSalon() {
		return salon;
	}
	public void setSalon(String salon) {
		this.salon = salon;
	}
	public boolean isCatering() {
		return catering;
	}
	public void setCatering(boolean catering) {
		this.catering = catering;
	}
	public boolean isVino() {
		return vino;
	}
	public void setVino(boolean vino) {
		this.vino = vino;
	}
	public boolean isChampagne() {
		return champagne;
	}
	public void setChampagne(boolean champagne) {
		this.champagne = champagne;
	}
	public boolean isTorta() {
		return torta;
	}
	public void setTorta(boolean torta) {
		this.torta = torta;
	}
	public boolean isAnimacionydj() {
		return animacionydj;
	}
	public void setAnimacionydj(boolean animacionydj) {
		this.animacionydj = animacionydj;
	}
	public boolean isFlores() {
		return flores;
	}
	public void setFlores(boolean flores) {
		this.flores = flores;
	}
	public boolean isDecoracion() {
		return decoracion;
	}
	public void setDecoracion(boolean decoracion) {
		this.decoracion = decoracion;
	}
	public boolean isSillas() {
		return sillas;
	}
	public void setSillas(boolean sillas) {
		this.sillas = sillas;
	}
	public boolean isAlfombras() {
		return alfombras;
	}
	public void setAlfombras(boolean alfombras) {
		this.alfombras = alfombras;
	}
	public boolean isMesa() {
		return mesa;
	}
	public void setMesa(boolean mesa) {
		this.mesa = mesa;
	}
	public boolean isInvitaciones() {
		return invitaciones;
	}
	public void setInvitaciones(boolean invitaciones) {
		this.invitaciones = invitaciones;
	}
	public boolean isAlianzas() {
		return alianzas;
	}
	public void setAlianzas(boolean alianzas) {
		this.alianzas = alianzas;
	}
	public boolean isVideoyFotografia() {
		return videoyFotografia;
	}
	public void setVideoyFotografia(boolean videoyFotografia) {
		this.videoyFotografia = videoyFotografia;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
    
    
}
