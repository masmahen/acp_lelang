package com.acp.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "dokumen")
public class DokumenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "nama_file", nullable = false)
	private String namaFile;
	
	@Column(name = "tipe_file", nullable = false)
	private String tipeFile;
	
	@Column(name = "pathFile", nullable = false)
	private String pathFile;
	
	@OneToOne
	@JoinColumn(name = "ktp", insertable = false, updatable = false)
	private PesertaLelangEntity pesertaLelang;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNamaFile() {
		return namaFile;
	}

	public void setNamaFile(String namaFile) {
		this.namaFile = namaFile;
	}

	public String getTipeFile() {
		return tipeFile;
	}

	public void setTipeFile(String tipeFile) {
		this.tipeFile = tipeFile;
	}

	public String getPathFile() {
		return pathFile;
	}

	public void setPathFile(String pathFile) {
		this.pathFile = pathFile;
	}

	public PesertaLelangEntity getPesertaLelang() {
		return pesertaLelang;
	}

	public void setPesertaLelang(PesertaLelangEntity pesertaLelang) {
		this.pesertaLelang = pesertaLelang;
	}
	
	
	
}
