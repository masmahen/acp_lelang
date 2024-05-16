package com.acp.demo.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.acp.demo.entity.DokumenEntity;
import com.acp.demo.entity.PesertaLelangEntity;
import com.acp.demo.repository.DokumenRepository;
import com.acp.demo.repository.PesertaLelangRepository;

@RestController
@RequestMapping("/peserta-lelang")
public class PesertaLelangController {

	@Autowired
	private PesertaLelangRepository pesertaRepo;
	
	@Autowired
	private DokumenRepository dokumenRepo;
	
	@PostMapping
	public PesertaLelangEntity daftarPesertaLelang(@RequestBody PesertaLelangEntity pesertaLelang) {
		return pesertaRepo.save(pesertaLelang);
	}
	
	@GetMapping
	public List<PesertaLelangEntity> getAllPesertaLelang(){
		return pesertaRepo.findAll();
	}
	
	//post mapping karo get mapping nggo dokumen e durung
	//fitur login nggo admin karo pesertane durung
}
