package com.acp.demo.restcontroller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
	public List<PesertaLelangEntity> getAllPesertaLelang() {
		return pesertaRepo.findAll();
	}

	@PostMapping("/upload-dokumen")
	private DokumenEntity uploadDokumen(@RequestParam("file") MultipartFile file, @RequestParam("ktp") Long ktp) throws Exception {
		PesertaLelangEntity pesertaLelang = pesertaRepo.findById(ktp).orElse(null);
		
		if(pesertaLelang != null) {
			String namaFile = file.getOriginalFilename();
			String tipeFile = file.getContentType();
			String pathFile = saveFile(file);

			DokumenEntity dokumenEntity = new DokumenEntity();
			dokumenEntity.setNamaFile(namaFile);
			dokumenEntity.setTipeFile(tipeFile);
			dokumenEntity.setPathFile(pathFile);
			dokumenEntity.setPesertaLelang(pesertaLelang);
			return dokumenRepo.save(dokumenEntity);
		} else {
			throw new Exception("KTP " + ktp + "tidak ditemukan!");
		}
		
	}

	private String saveFile(MultipartFile file) throws IOException {
		String fileName = UUID.randomUUID().toString()+"."+file.getOriginalFilename().split("\\.")[1];
		String filePath = "path/to/storage"+fileName;
		File dest = new File(filePath);
		file.transferTo(dest);
		
		return filePath;
		
	}
	// fitur login nggo admin karo pesertane durung
}
