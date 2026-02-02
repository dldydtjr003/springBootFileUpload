package com.zeus.controller;

import java.io.File;
import java.util.List;
import java.util.UUID;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Item;
import com.zeus.service.ItemService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@MapperScan(basePackages = "com.zeus.mapper")
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	// application.properties 에서 upload.path에 저장된 값 주입한다.
	@Value("${upload.path}")
	private String uploadPath;

	@GetMapping("/createForm")
	public String itemCreateForm() {
		log.info("createForm");
		return "item/createForm";
	}

	@PostMapping("/create")
	public String itemCreate(Model model, Item item) throws Exception {
		log.info("create item =" + item.toString());
		// 1. 파일 업로드한 것을 가져오기
		MultipartFile file = item.getPicture();
		// 2. 잘 가지고 왔는지 파일정보를 로그파일에 기록한다.
		log.info("originalName: " + file.getOriginalFilename());
		log.info("size: " + file.getSize());
		log.info("contentType: " + file.getContentType());
		// 3. 파일을 외장하드에 저장하기
		String createdFileName = uploadFile(file.getOriginalFilename(), file.getBytes());
		// file.getOriginalFilename() -> originalName, file.getBytes() -> fileData로 들어간다.
		// 4. 새로 생성된 파일명을 item domain에 저장
		item.setUrl(createdFileName);
		// 5. DB 테이블에 상품화면 정보를 저장
		int count = itemService.create(item);
		
		if(count > 0) {
			model.addAttribute("message","%s 상품 등록이 성공되었습니다.".formatted(file.getOriginalFilename()));
			return "item/success";
		}
		model.addAttribute("message","%s 상품 등록이 실패되었습니다.".formatted(file.getOriginalFilename()));
		return "item/failed";
	}

	private String uploadFile(String originalName, byte[] fileData) throws Exception {
		// randomUUID 절대 중복이 일어나지 않는다. (이름이 같아도 상관없음) UUID = 0ee131f0-77c3-48d5-b5f4-86a0a215a1dd
		UUID uid = UUID.randomUUID();
		// 0ee131f0-77c3-48d5-b5f4-86a0a215a1dd_123.jpg
		String createdFileName = uid.toString() + "_" + originalName;
		// new File("D:.upload", 0ee131f0-77c3-48d5-b5f4-86a0a215a1dd_123.jpg)
		// D:/upload/0ee131f0-77c3-48d5-b5f4-86a0a215a1dd_123.jpg 내용이 없는 파일명만 생성
		File target = new File(uploadPath, createdFileName);
		// byte[] fileData = 파일 내용값이 있는 이미지를 D:/upload/0ee131f0-77c3-48d5-b5f4-86a0a215a1dd_123.jpg 여기에 복사 진행 
		FileCopyUtils.copy(fileData, target);
		// return값은 DB에 넣는다.
		return createdFileName;
	}
	@GetMapping("/itemList")
	public String list(Model model,Item item) throws Exception { 
		log.info("list item =" + item.toString());
		List<Item> itemList = itemService.list(); 
		model.addAttribute("itemList", itemList);
		return "item/itemList";
		} 
	
	@GetMapping("/detail")
	public String itemDetail(Item i, Model model) throws Exception { 
		log.info("itemDetail item =" + i.toString());
		Item item = itemService.detail
		return "item/itemList";
	} 
	
	
}
