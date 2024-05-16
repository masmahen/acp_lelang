package com.acp.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "peserta_lelang")
public class PesertaLelangEntity {
	
	@Id
	@Column(name = "ktp", nullable = false, unique = true)
	private Long ktp;
	
	@Column(name = "nama", nullable = false)
	private String nama;
	
	@Column(name = "alamat")
	private String alamat;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "nomor_telepon", nullable = false)
	private Long nomorTelepon;
	
	@OneToOne
	@JoinColumn(name = "roleID", insertable = false, updatable = false)
	private RoleEntity role;

	public Long getKtp() {
		return ktp;
	}

	public void setKtp(Long ktp) {
		this.ktp = ktp;
	}

	public String getNama() {
		return nama;
	}

	public void setNama(String nama) {
		this.nama = nama;
	}

	public String getAlamat() {
		return alamat;
	}

	public void setAlamat(String alamat) {
		this.alamat = alamat;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getNomorTelepon() {
		return nomorTelepon;
	}

	public void setNomorTelepon(Long nomorTelepon) {
		this.nomorTelepon = nomorTelepon;
	}

	public RoleEntity getRole() {
		return role;
	}

	public void setRole(RoleEntity role) {
		this.role = role;
	}
	
	

}
