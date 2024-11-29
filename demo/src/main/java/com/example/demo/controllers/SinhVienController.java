package com.example.demo.controllers;

import com.example.demo.models.TotNghiep;
import com.example.demo.service.SinhVienService;
import com.example.demo.models.SinhVien;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/sinh-vien")  // Base path for the controller
public class SinhVienController {

    @Autowired
    private SinhVienService sinhVienService;

    // Hiển thị tất cả sinh viên
    @GetMapping("/all")
    public String getAllSinhVien(Model model) {
        List<SinhVien> listSinhVien = sinhVienService.getAllSinhVien();
        model.addAttribute("listSinhVien", listSinhVien);
        return "listSinhVien";  // Return the view for listing all students
    }

    @GetMapping("/so-cmnd/{soCMND}")
    public String getSinhVienDetails(@PathVariable String soCMND, Model model) {
        // Lấy thông tin sinh viên từ service
        SinhVien sinhVien = sinhVienService.getSinhVienWithDetails(soCMND);

        if (sinhVien == null) {
            model.addAttribute("error", "Sinh viên không tìm thấy");
            return "error"; // Trả về trang lỗi nếu không tìm thấy sinh viên
        }

        // Nếu tìm thấy sinh viên, thêm đối tượng sinh viên vào model
        model.addAttribute("sinhVien", sinhVien);

        // Trả về trang hiển thị chi tiết sinh viên (ví dụ: sinhvien-details.html)
        return "sinhVienDetail";
    }


    @GetMapping("/create")
    public String createSinhVien(Model model) {
        SinhVien sinhVien = new SinhVien();
        model.addAttribute("sinhVien", sinhVien);
        return "createSinhVien";
    }
    @PostMapping("/save")
    public String saveSinhVien(@ModelAttribute SinhVien sinhVien, Model model) {
        try {
                sinhVienService.saveSinhVienAndTotNghiep(sinhVien);
        } catch (Exception e) {
            // In chi tiết lỗi ra console
            System.out.println("Có lỗi xảy ra khi lưu thông tin sinh viên: " + e.getMessage());
            e.printStackTrace();  // In chi tiết stack trace ra console
            model.addAttribute("error", "Có lỗi xảy ra khi lưu thông tin sinh viên!");
        }
        return "redirect:/sinh-vien/all";  // Quay lại trang danh sách sinh viên
    }




}
